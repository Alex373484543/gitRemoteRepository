package fanglab.framework;

import java.util.*;

;

/*
 * �Ƚ�
 */
public class SlCompare {
	/*
	 * Equal
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean equal(String field, String pattern) {
		return pattern.equals(field);
	}

	/*
	 * NotEqual
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean notEqual(String field, String pattern) {
		return !equal(field, field);
	}

	/*
	 * Contains
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean contains(String field, String pattern) {
		if (field == null || field.trim().isEmpty()) {
			return false;
		}
		return field.indexOf(pattern) >= 0;
	}

	/*
	 * NotContains
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean notContains(String field, String pattern) {
		return contains(field, pattern);
	}

	/*
	 * StartsWith
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean startsWith(String field, String pattern) {
		return field.startsWith(pattern);
	}

	/*
	 * NotStartsWith
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean notStartsWith(String field, String pattern) {
		return !startsWith(field, pattern);
	}

	/*
	 * EndsWith
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean endsWith(String field, String pattern) {
		return field.endsWith(pattern);
	}

	/*
	 * NotEndsWith
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean notEndsWith(String field, String pattern) {
		return !endsWith(field, pattern);
	}

	/*
	 * RegexMatch
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean regexMatch(String field, String pattern) {
		if (field == null || field.trim().isEmpty()) {
			return false;
		}
		return field.matches(pattern);
	}

	/*
	 * NotRegexMatch
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String pattern��ģʽ
	 * 
	 * @return boolean�����
	 */
	public static boolean notRegexMatch(String field, String pattern) {
		return !regexMatch(field, pattern);
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String start����ʼ
	 * 
	 * @param String end������
	 * 
	 * @return boolean�����
	 */
	public static boolean inScope(String field, String start, String end) {
		if (field == null || field.trim().isEmpty()) {
			return false;
		}

		if (field.length() != start.length() || field.length() != end.length()
				|| start.length() != end.length()) {
			return false;
		}
		return field.compareTo(start) >= 0 && field.compareTo(end) <= 0;
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param String start����ʼ
	 * 
	 * @param String end������
	 * 
	 * @return boolean�����
	 */
	public static boolean notInScope(String field, String start, String end) {
		return !inScope(field, start, end);
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param int field���ֶ�
	 * 
	 * @param int start����ʼ
	 * 
	 * @param int end������
	 * 
	 * @return boolean�����
	 */
	public static boolean inScope(int field, int start, int end) {
		return field >= start && field <= end;
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param int field���ֶ�
	 * 
	 * @param int start����ʼ
	 * 
	 * @param int end������
	 * 
	 * @return boolean�����
	 */
	public static boolean notInScope(int field, int start, int end) {
		return !inScope(field, start, end);
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ�ڣ���һ�����䷶Χ�ڼ�Ϊ�棩
	 * 
	 * @param ArrayList<String> fields���ֶ�
	 * 
	 * @param String start����ʼ
	 * 
	 * @param String end������
	 * 
	 * @return boolean�����
	 */
	public static boolean inScope(ArrayList<String> fields, String start,
			String end) {
		if (fields == null || fields.size() == 0) {
			return false;
		}
		if (start.length() != end.length()) {
			return false;
		}
		int size = fields.size();
		for (int i = 0; i < size; i++) {
			String field = fields.get(i);
			if (field.length() == start.length()
					&& field.length() == end.length()) {
				if (field.compareTo(start) >= 0 && field.compareTo(end) <= 0) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ�ڣ���һ�����䷶Χ�ڼ�Ϊ�棩
	 * 
	 * @param ArrayList<String> fields���ֶ�
	 * 
	 * @param String start����ʼ
	 * 
	 * @param String end������
	 * 
	 * @return boolean�����
	 */
	public static boolean notInScope(ArrayList<String> fields, String start,
			String end) {
		return !inScope(fields, start, end);
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param ArrayList<String> fields���ֶ�
	 * 
	 * @return boolean�����
	 */
	public static boolean inScope(String field, ArrayList<String> fields) {
		if (field == null || field.trim().isEmpty()) {
			return false;
		}

		if (fields == null || fields.size() == 0) {
			return false;
		}

		for (String item : fields) {
			if (item.equals(field)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param String field���ֶ�
	 * 
	 * @param ArrayList<String> fields���ֶ�
	 * 
	 * @return boolean�����
	 */
	public static boolean notInScope(String field, ArrayList<String> fields) {
		return !inScope(field, fields);
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param int field���ֶ�
	 * 
	 * @param ArrayList<Integer> fields���ֶ�
	 * 
	 * @return boolean�����
	 */
	public static boolean inScope(int field, ArrayList<Integer> fields) {
		if (fields == null || fields.size() == 0) {
			return false;
		}

		for (Integer item : fields) {
			if ((int) item == field) {
				return true;
			}
		}

		return false;
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ��
	 * 
	 * @param int field���ֶ�
	 * 
	 * @param ArrayList<Integer> fields���ֶ�
	 * 
	 * @return boolean�����
	 */
	public static boolean notInScope(int field, ArrayList<Integer> fields) {
		return !inScope(field, fields);
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ�ڣ���һ�����䷶Χ�ڼ�Ϊ�棩
	 * 
	 * @param ArrayList<Integer> fields���ֶ�
	 * 
	 * @param String start����ʼ
	 * 
	 * @param String end������
	 * 
	 * @return boolean�����
	 */
	public static boolean inScope(ArrayList<Integer> fields, int start, int end) {
		if (fields == null || fields.size() == 0) {
			return false;
		}
		for (int i = 0; i < fields.size(); i++) {
			int field = fields.get(i);
			if (field >= start && field <= end) {
				return true;
			}
		}
		return false;
	}

	/*
	 * �ж�һ��ֵ�Ƿ���һ��ֵ��Χ�ڣ���һ�����䷶Χ�ڼ�Ϊ�棩
	 * 
	 * @param ArrayList<Integer> fields���ֶ�
	 * 
	 * @param int start����ʼ
	 * 
	 * @param int end������
	 * 
	 * @return boolean�����
	 */
	public static boolean notInScope(ArrayList<Integer> fields, int start,
			int end) {
		return !inScope(fields, start, end);
	}

	/*
	 * �ж����������Ƿ��н���
	 * 
	 * @param ArrayList<Object> array1������1
	 * 
	 * @param ArrayList<Object> array2������2
	 * 
	 * @return boolean�����
	 */
	public static boolean intersect(ArrayList<Object> array1,
			ArrayList<Object> array2) {
		if (array1 == null || array2 == null || array1.size() == 0
				|| array2.size() == 0) {
			return false;
		}

		ArrayList<Object> array1Temp = new ArrayList<Object>(array1);

		ArrayList<Object> array2Temp = new ArrayList<Object>(array2);

		array1Temp.retainAll(array2Temp);

		return array1Temp.size() > 0;
	}

	/*
	 * �ж����������Ƿ��޽���
	 * 
	 * @param ArrayList<Object> array1������1
	 * 
	 * @param ArrayList<Object> array2������2
	 * 
	 * @return boolean�����
	 */
	public static boolean notIntersect(ArrayList<Object> array1,
			ArrayList<Object> array2) {
		return intersect(array1, array2);
	}
}
