package fanglab.framework.office;

import java.lang.reflect.*;
import java.util.*;

public class SlCsv {
	/*
	 * 转换为Csv
	 * 
	 * @param ArrayList<?> rows，列表
	 * 
	 * @return String，结果
	 */
	public static String ToCsv(ArrayList<?> rows) {
		try {
			StringBuilder result = new StringBuilder();

			if (rows == null || rows.size() == 0) {
				return "";
			}
			Object firstRow = rows.get(0);
			Field[] properties = firstRow.getClass().getDeclaredFields();

			for (int i = 0; i < properties.length; i++) {
				Field property = properties[i];

				if (i == properties.length - 1) {
					result.append("\"" + property.getName() + "\"" + "\r\n");
				} else {
					result.append("\"" + property.getName() + "\"" + ",");
				}
			}

			int j = 0;

			for (Object item : rows) {
				j++;
				for (int i = 0; i < properties.length; i++) {
					Field property = properties[i];
					property.setAccessible(true);
					if (i == properties.length - 1) {
						if (j == rows.size()) {
							result.append("\""
									+ property.get(item).toString()
											.replace("\"", "\"\"") + "\"");
						} else {
							result.append("\""
									+ property.get(item).toString()
											.replace("\"", "\"\"") + "\""
									+ "\r\n");
						}
					} else {
						result.append("\""
								+ property.get(item).toString()
										.replace("\"", "\"\"") + "\"" + ",");
					}
				}
			}

			return result.toString();
		} catch (Exception err) {
			throw new RuntimeException(err.getMessage());
		}
	}
}
