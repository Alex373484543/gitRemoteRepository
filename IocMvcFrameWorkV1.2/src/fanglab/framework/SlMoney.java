package fanglab.framework;

import java.util.*;

public class SlMoney {
	/*
	 * 年利率转换为月利率
	 * 
	 * @param double yearRate，年利率
	 * 
	 * @result double，结果
	 */
	public static double convertYearRateToMonthRate(double yearRate) {
		return yearRate / 12d;
	}

	public static class SlMatchingTheRepaymentItem {
		/*
		 * 月份
		 */
		private int month;

		/*
		 * 总金额
		 */
		private double total;

		/*
		 * 本金
		 */
		private double principal;

		/*
		 * 利息
		 */
		private double interest;

		/*
		 * 本金余额
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
	 * 等额本息还款法（每月还款额）
	 * 
	 * @param double yearRate，年利率
	 * 
	 * @param double principal，本金
	 * 
	 * @param double month，还款月数
	 * 
	 * @return double，每月还款额
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
	 * 等额本息还款法（每月还款额中本金部分）
	 * 
	 * @param double yearRate，年利率
	 * 
	 * @param double principal，本金
	 * 
	 * @param double month，还款月数
	 * 
	 * @return double，每月还款额中本金部分
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
	 * 等额本息还款法
	 * 
	 * @param double yearRate，年利率
	 * 
	 * @param double principal，本金
	 * 
	 * @param double month，还款月数
	 * 
	 * @return ArrayList<SlMatchingTheRepaymentItem>，每月还款情况
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
			// 舍去
			double e = t - p;// Convert.ToDecimal(Math.Floor(Convert.ToDouble((t
								// - p)) * 100d) / 100d);

			SlMatchingTheRepaymentItem item = new SlMatchingTheRepaymentItem();

			item.setInterest(e);
			item.setMonth(i);
			item.setPrincipal(p);
			item.setTotal(t);

			result.add(item);

			if (i == month) {
				// 最后一个月做平衡
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
	 * 按月付息到期还本法
	 * 
	 * @param double yearRate，年利率
	 * 
	 * @param double principal，本金
	 * 
	 * @param double month，还款月数
	 * 
	 * @return ArrayList<SlMatchingTheRepaymentItem>，每月还款情况
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
				// 最后一个月做平衡
				item.setPrincipal(principal);
				item.setTotal(e + principal);
				item.setPrincipalBalance(0d);
			}

			result.add(item);
		}

		return result;
	}
}
