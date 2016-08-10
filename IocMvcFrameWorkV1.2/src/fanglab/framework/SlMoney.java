package fanglab.framework;

import java.util.*;

public class SlMoney {
	/*
	 * ������ת��Ϊ������
	 * 
	 * @param double yearRate��������
	 * 
	 * @result double�����
	 */
	public static double convertYearRateToMonthRate(double yearRate) {
		return yearRate / 12d;
	}

	public static class SlMatchingTheRepaymentItem {
		/*
		 * �·�
		 */
		private int month;

		/*
		 * �ܽ��
		 */
		private double total;

		/*
		 * ����
		 */
		private double principal;

		/*
		 * ��Ϣ
		 */
		private double interest;

		/*
		 * �������
		 */
		private double principalBalance;

		public double getPrincipalBalance() {
			return this.principalBalance;
		}

		public void setPrincipalBalance(double principalBalance) {
			this.principalBalance = principalBalance;
		}

		public double getInterest() {
			return this.interest;
		}

		public void setInterest(double interest) {
			this.interest = interest;
		}

		public double getPrincipal() {
			return this.principal;
		}

		public void setPrincipal(double principal) {
			this.principal = principal;
		}

		public double getTotal() {
			return this.total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public int getMonth() {
			return this.month;
		}

		public void setMonth(int month) {
			this.month = month;
		}
	}

	/*
	 * �ȶϢ�����ÿ�»���
	 * 
	 * @param double yearRate��������
	 * 
	 * @param double principal������
	 * 
	 * @param double month����������
	 * 
	 * @return double��ÿ�»����
	 */
	private static double totalByMatchingTheRepaymentOfPrincipalAndInterest(
			double yearRate, double principal, int month) {
		double monthRate = convertYearRateToMonthRate(yearRate);

		double result = principal
				* (monthRate * Math.pow(1d + monthRate, month))
				/ (Math.pow(1d + monthRate, month) - 1d);

		return result;
	}

	/*
	 * �ȶϢ�����ÿ�»�����б��𲿷֣�
	 * 
	 * @param double yearRate��������
	 * 
	 * @param double principal������
	 * 
	 * @param double month����������
	 * 
	 * @return double��ÿ�»�����б��𲿷�
	 */
	private static double principalByMatchingTheRepaymentOfPrincipalAndInterest(
			double yearRate, double principal, int month, int currentMonth) {
		double monthRate = convertYearRateToMonthRate(yearRate);

		double result = principal * monthRate
				* Math.pow(1d + monthRate, currentMonth - 1d)
				/ (Math.pow(1d + monthRate, month) - 1d);

		return result;
	}

	/*
	 * �ȶϢ���
	 * 
	 * @param double yearRate��������
	 * 
	 * @param double principal������
	 * 
	 * @param double month����������
	 * 
	 * @return ArrayList<SlMatchingTheRepaymentItem>��ÿ�»������
	 */
	public static ArrayList<SlMatchingTheRepaymentItem> matchingTheRepaymentOfPrincipalAndInterest(
			double yearRate, double principal, int month) {
		ArrayList<SlMatchingTheRepaymentItem> result = new ArrayList<SlMatchingTheRepaymentItem>();

		double principalAll = 0d;

		for (int i = 1; i <= month; i++) {
			double t = totalByMatchingTheRepaymentOfPrincipalAndInterest(
					yearRate, principal, month);
			double p = principalByMatchingTheRepaymentOfPrincipalAndInterest(
					yearRate, principal, month, i);
			// ��ȥ
			double e = t - p;// Convert.ToDecimal(Math.Floor(Convert.ToDouble((t
								// - p)) * 100d) / 100d);

			SlMatchingTheRepaymentItem item = new SlMatchingTheRepaymentItem();

			item.setInterest(e);
			item.setMonth(i);
			item.setPrincipal(p);
			item.setTotal(t);

			result.add(item);

			if (i == month) {
				// ���һ������ƽ��
				item.setPrincipal(principal - principalAll);
				item.setInterest(item.getTotal() - item.getPrincipal());
			}

			principalAll += item.getPrincipal();

			double sum = 0d;
			for (SlMatchingTheRepaymentItem one : result) {
				sum += one.getPrincipal();
			}

			item.setPrincipalBalance(principal - sum);
		}

		return result;
	}

	/*
	 * ���¸�Ϣ���ڻ�����
	 * 
	 * @param double yearRate��������
	 * 
	 * @param double principal������
	 * 
	 * @param double month����������
	 * 
	 * @return ArrayList<SlMatchingTheRepaymentItem>��ÿ�»������
	 */
	public static ArrayList<SlMatchingTheRepaymentItem> matchingTheRepaymentOfMonthInterestAndEndPrincipal(
			double yearRate, double principal, int month) {
		ArrayList<SlMatchingTheRepaymentItem> result = new ArrayList<SlMatchingTheRepaymentItem>();

		for (int i = 1; i <= month; i++) {
			double e = convertYearRateToMonthRate(yearRate) * principal;
			double t = e;
			double p = 0d;

			SlMatchingTheRepaymentItem item = new SlMatchingTheRepaymentItem();
			item.setInterest(e);
			item.setMonth(i);
			item.setPrincipal(p);
			item.setTotal(t);
			item.setPrincipalBalance(principal);

			if (i == month) {
				// ���һ������ƽ��
				item.setPrincipal(principal);
				item.setTotal(e + principal);
				item.setPrincipalBalance(0d);
			}

			result.add(item);
		}

		return result;
	}
}
