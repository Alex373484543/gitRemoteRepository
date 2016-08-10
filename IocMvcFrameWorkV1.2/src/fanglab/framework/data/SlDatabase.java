package fanglab.framework.data;

import java.sql.*;
import java.text.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import java.util.Map.Entry;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/*
 * ���ݿ����
 */
public class SlDatabase {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS");

	/*
	 * ִ��INSERT��UPDATE��DELETE�Լ����������ݼ��Ĵ洢����
	 * 
	 * @param String connectionString��SQL����洢������
	 * 
	 * @param String sentence��SQL����洢������
	 * 
	 * @param HashMap<String, Object> parameters����������
	 * 
	 * @return int��Ӱ�������
	 */
	public static int executeNonQuery(String connectionString, String sentence,
			HashMap<String, Object> parameters) throws Exception {
		Connection connection = null;
		SlNamedParameterStatement namedParameterStatement = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			namedParameterStatement = new SlNamedParameterStatement(connection,
					sentence);
			if (parameters != null) {
				Iterator<Entry<String, Object>> iterator = parameters
						.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = iterator.next();
					String name = entry.getKey();
					Object value = entry.getValue();

					if (value instanceof Long) {
						namedParameterStatement.setLong(name, (Long) value);
					} else if (value instanceof Integer) {
						namedParameterStatement.setInt(name, (Integer) value);
					} else if (value instanceof String) {
						namedParameterStatement.setString(name, (String) value);
					} else if (value instanceof Date) {
						namedParameterStatement.setString(name,
								simpleDateFormat.format((Date) value));
					} else {
						namedParameterStatement.setObject(name, value);
					}
				}
			}
			return namedParameterStatement.executeUpdate();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	/*
	 * ִ��INSERT��UPDATE��DELETE�Լ����������ݼ��Ĵ洢����
	 * 
	 * @param String connectionString��SQL����洢������
	 * 
	 * @param String sentence��SQL����洢������
	 * 
	 * @param HashMap<String, Object> parameters����������
	 * 
	 * @return int��Ӱ�������
	 */
	public static int executeNonQuery(String connectionString, String sentence)
			throws Exception {
		return executeNonQuery(connectionString, sentence, null);
	}

	/*
	 * �������ݼ��ĵ�һ�е�һ�С����ݿ���ΪNull��գ�������Null
	 * 
	 * @param String connectionString��SQL����洢������
	 * 
	 * @param String sentence��SQL����洢������
	 * 
	 * @param HashMap<String, Object> parameters����������
	 * 
	 * @return Object�����ݼ��ĵ�һ�е�һ��
	 */
	public static Object executeScalar(String connectionString,
			String sentence, HashMap<String, Object> parameters)
			throws Exception {
		Connection connection = null;
		SlNamedParameterStatement namedParameterStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			namedParameterStatement = new SlNamedParameterStatement(connection,
					sentence);
			if (parameters != null) {
				Iterator<Entry<String, Object>> iterator = parameters
						.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = iterator.next();
					String name = entry.getKey();
					Object value = entry.getValue();

					if (value instanceof Long) {
						namedParameterStatement.setLong(name, (Long) value);
					} else if (value instanceof Integer) {
						namedParameterStatement.setInt(name, (Integer) value);
					} else if (value instanceof String) {
						namedParameterStatement.setString(name, (String) value);
					} else if (value instanceof Date) {
						namedParameterStatement.setString(name,
								simpleDateFormat.format((Date) value));
					} else {
						namedParameterStatement.setObject(name, value);
					}
				}
			}
			resultSet = namedParameterStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getObject(1);
			} else {
				return null;
			}
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	/*
	 * �������ݼ��ĵ�һ�е�һ�С����ݿ���ΪNull��գ�������Null
	 * 
	 * @param String connectionString��SQL����洢������
	 * 
	 * @param String sentence��SQL����洢������
	 * 
	 * @param HashMap<String, Object> parameters����������
	 * 
	 * @return Object�����ݼ��ĵ�һ�е�һ��
	 */
	public static Object executeScalar(String connectionString, String sentence)
			throws Exception {
		return executeScalar(connectionString, sentence, null);
	}

	/*
	 * ������ݼ�
	 * 
	 * @param String connectionString��SQL����洢������
	 * 
	 * @param String sentence��SQL����洢������
	 * 
	 * 
	 * @param HashMap<String, Object> parameters����������
	 */
	public static CachedRowSet fill(String connectionString, String sentence,
			HashMap<String, Object> parameters) throws Exception {
		Connection connection = null;
		SlNamedParameterStatement namedParameterStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			namedParameterStatement = new SlNamedParameterStatement(connection,
					sentence);
			if (parameters != null) {
				Iterator<Entry<String, Object>> iterator = parameters
						.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = iterator.next();
					String name = entry.getKey();
					Object value = entry.getValue();

					if (value instanceof Long) {
						namedParameterStatement.setLong(name, (Long) value);
					} else if (value instanceof Integer) {
						namedParameterStatement.setInt(name, (Integer) value);
					} else if (value instanceof String) {
						namedParameterStatement.setString(name, (String) value);
					} else if (value instanceof Date) {
						namedParameterStatement.setString(name,
								simpleDateFormat.format((Date) value));
					} else {
						namedParameterStatement.setObject(name, value);
					}
				}
			}
			resultSet = namedParameterStatement.executeQuery();
			CachedRowSet cachedRowSet = RowSetProvider.newFactory()
					.createCachedRowSet();
			cachedRowSet.populate(resultSet);
			return cachedRowSet;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	/*
	 * ������ݼ�
	 * 
	 * @param String connectionString��SQL����洢������
	 * 
	 * @param String sentence��SQL����洢������
	 * 
	 * 
	 * @param HashMap<String, Object> parameters����������
	 */
	public static CachedRowSet fill(String connectionString, String sentence)
			throws Exception {
		return fill(connectionString, sentence, null);
	}

	/*
	 * ����������
	 */
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance();
		} catch (Exception e) {
		}
	}

	@SuppressWarnings("unused")
	private static final String sqlCommandKeywords = "and|exec|execute|insert|select|delete|update|count|chr|mid|master|"
			+ "char|declare|sitename|net user|xp_cmdshell|or|create|drop|table|from|grant|use|group_concat|column_name|"
			+ "information_schema.columns|table_schema|union|where|select|delete|update|orderhaving|having|by|count|*|truncate|like";

	private static final String sqlSeparatKeywords = "'|;|--|\'|\"|/*|%|#";

	private static final ArrayList<String> sqlKeywordsArray = new ArrayList<String>();

	/*
	 * ��̬���캯��
	 */
	static {
		String[] sqlSeparatKeywordsArray = sqlSeparatKeywords.split("\\|");
		for (String sqlSeparatKeyword : sqlSeparatKeywordsArray) {
			sqlKeywordsArray.add(sqlSeparatKeyword);
			sqlKeywordsArray.add(sqlSeparatKeyword + " ");
			sqlKeywordsArray.add(" " + sqlSeparatKeyword);
		}
	}

	/*
	 * �Ƿ�ȫ
	 * 
	 * @param String input������
	 * 
	 * @return boolean������
	 */
	@SuppressWarnings("deprecation")
	public static boolean isSafetySql(String input) {
		if (input == null || input.trim().isEmpty()) {
			return true;
		}
		input = URLDecoder.decode(input).toLowerCase();

		for (String sqlKeyword : sqlKeywordsArray) {
			if (input.indexOf(sqlKeyword) >= 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * ���ذ�ȫ�ַ���
	 * 
	 * @param String input������
	 * 
	 * @return boolean������
	 */
	@SuppressWarnings("deprecation")
	public static String getSafetySql(String input) {
		if (input == null || input.trim().isEmpty()) {
			return "";
		}
		if (isSafetySql(input)) {
			return input;
		}
		input = URLDecoder.decode(input).toLowerCase();

		for (String sqlKeyword : sqlKeywordsArray) {
			if (input.indexOf(sqlKeyword) >= 0) {
				input = input.replace(sqlKeyword, "");
			}
		}
		return input;
	}
}
