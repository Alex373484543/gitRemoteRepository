package fanglab.framework;

import java.util.*;

;

/*
 * 比较
 */
public class SlCompare {
	/*
	 * Equal
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean equal(String field, String pattern) {
		return pattern.equals(field);
	}

	/*
	 * NotEqual
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean notEqual(String field, String pattern) {
		return !equal(field, field);
	}

	/*
	 * Contains
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
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
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean notContains(String field, String pattern) {
		return contains(field, pattern);
	}

	/*
	 * StartsWith
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean startsWith(String field, String pattern) {
		return field.startsWith(pattern);
	}

	/*
	 * NotStartsWith
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean notStartsWith(String field, String pattern) {
		return !startsWith(field, pattern);
	}

	/*
	 * EndsWith
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean endsWith(String field, String pattern) {
		return field.endsWith(pattern);
	}

	/*
	 * NotEndsWith
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean notEndsWith(String field, String pattern) {
		return !endsWith(field, pattern);
	}

	/*
	 * RegexMatch
	 * 
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
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
	 * @param String field，字段
	 * 
	 * @param String pattern，模式
	 * 
	 * @return boolean，结果
	 */
	public static boolean notRegexMatch(String field, String pattern) {
		return !regexMatch(field, pattern);
	}

	/*
	 * 判断一个值是否在一个值范围内
	 * 
	 * @param String field，字段
	 * 
	 * @param String start，开始
	 * 
	 * @param String end，结束
	 * 
	 * @return boolean，结果
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
	 * 判断一个值是否不在一个值范围内
	 * 
	 * @param String field，字段
	 * 
	 * @param String start，开始
	 * 
	 * @param String end，结束
	 * 
	 * @return boolean，结果
	 */
	public static boolean notInScope(String field, String start, String end) {
		return !inScope(field, start, end);
	}

	/*
	 * 判断一个值是否在一个值范围内
	 * 
	 * @param int field，字段
	 * 
	 * @param int start，开始
	 * 
	 * @param int end，结束
	 * 
	 * @return boolean，结果
	 */
	public static boolean inScope(int field, int start, int end) {
		return field >= start && field <= end;
	}

	/*
	 * 判断一个值是否不在一个值范围内
	 * 
	 * @param int field，字段
	 * 
	 * @param int start，开始
	 * 
	 * @param int end，结束
	 * 
	 * @return boolean，结果
	 */
	public static boolean notInScope(int field, int start, int end) {
		return !inScope(field, start, end);
	}

	/*
	 * 判断一个值是否在一个值范围内（有一个在其范围内即为真）
	 * 
	 * @param ArrayList<String> fields，字段
	 * 
	 * @param String start，开始
	 * 
	 * @param String end，结束
	 * 
	 * @return boolean，结果
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
	 * 判断一个值是否不在一个值范围内（有一个在其范围内即为真）
	 * 
	 * @param ArrayList<String> fields，字段
	 * 
	 * @param String start，开始
	 * 
	 * @param String end，结束
	 * 
	 * @return boolean，结果
	 */
	public static boolean notInScope(ArrayList<String> fields, String start,
			String end) {
		return !inScope(fields, start, end);
	}

	/*
	 * 判断一个值是否在一个值范围内
	 * 
	 * @param String field，字段
	 * 
	 * @param ArrayList<String> fields，字段
	 * 
	 * @return boolean，结果
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
	 * 判断一个值是否在一个值范围内
	 * 
	 * @param String field，字段
	 * 
	 * @param ArrayList<String> fields，字段
	 * 
	 * @return boolean，结果
	 */
	public static boolean notInScope(String field, ArrayList<String> fields) {
		return !inScope(field, fields);
	}

	/*
	 * 判断一个值是否在一个值范围内
	 * 
	 * @param int field，字段
	 * 
	 * @param ArrayList<Integer> fields，字段
	 * 
	 * @return boolean，结果
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
	 * 判断一个值是否在一个值范围内
	 * 
	 * @param int field，字段
	 * 
	 * @param ArrayList<Integer> fields，字段
	 * 
	 * @return boolean，结果
	 */
	public static boolean notInScope(int field, ArrayList<Integer> fields) {
		return !inScope(field, fields);
	}

	/*
	 * 判断一个值是否在一个值范围内（有一个在其范围内即为真）
	 * 
	 * @param ArrayList<Integer> fields，字段
	 * 
	 * @param String start，开始
	 * 
	 * @param String end，结束
	 * 
	 * @return boolean，结果
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
	 * 判断一个值是否不在一个值范围内（有一个在其范围内即为真）
	 * 
	 * @param ArrayList<Integer> fields，字段
	 * 
	 * @param int start，开始
	 * 
	 * @param int end，结束
	 * 
	 * @return boolean，结果
	 */
	public static boolean notInScope(ArrayList<Integer> fields, int start,
			int end) {
		return !inScope(fields, start, end);
	}

	/*
	 * 判断两个数组是否有交集
	 * 
	 * @param ArrayList<Object> array1，数组1
	 * 
	 * @param ArrayList<Object> array2，数组2
	 * 
	 * @return boolean，结果
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
	 * 判断两个数组是否无交集
	 * 
	 * @param ArrayList<Object> array1，数组1
	 * 
	 * @param ArrayList<Object> array2，数组2
	 * 
	 * @return boolean，结果
	 */
	public static boolean notIntersect(ArrayList<Object> array1,
			ArrayList<Object> array2) {
		return intersect(array1, array2);
	}
}
