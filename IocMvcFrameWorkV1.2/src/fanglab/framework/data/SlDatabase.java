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
 * 数据库操作
 */
public class SlDatabase {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS");

	/*
	 * 执行INSERT、UPDATE、DELETE以及不返回数据集的存储过程
	 * 
	 * @param String connectionString，SQL语句或存储过程名
	 * 
	 * @param String sentence，SQL语句或存储过程名
	 * 
	 * @param HashMap<String, Object> parameters，参数数组
	 * 
	 * @return int，影响的行数
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
	 * 执行INSERT、UPDATE、DELETE以及不返回数据集的存储过程
	 * 
	 * @param String connectionString，SQL语句或存储过程名
	 * 
	 * @param String sentence，SQL语句或存储过程名
	 * 
	 * @param HashMap<String, Object> parameters，参数数组
	 * 
	 * @return int，影响的行数
	 */
	public static int executeNonQuery(String connectionString, String sentence)
			throws Exception {
		return executeNonQuery(connectionString, sentence, null);
	}

	/*
	 * 返回数据集的第一行第一列。数据库中为Null或空，都返回Null
	 * 
	 * @param String connectionString，SQL语句或存储过程名
	 * 
	 * @param String sentence，SQL语句或存储过程名
	 * 
	 * @param HashMap<String, Object> parameters，参数数组
	 * 
	 * @return Object，数据集的第一行第一列
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
	 * 返回数据集的第一行第一列。数据库中为Null或空，都返回Null
	 * 
	 * @param String connectionString，SQL语句或存储过程名
	 * 
	 * @param String sentence，SQL语句或存储过程名
	 * 
	 * @param HashMap<String, Object> parameters，参数数组
	 * 
	 * @return Object，数据集的第一行第一列
	 */
	public static Object executeScalar(String connectionString, String sentence)
			throws Exception {
		return executeScalar(connectionString, sentence, null);
	}

	/*
	 * 填充数据集
	 * 
	 * @param String connectionString，SQL语句或存储过程名
	 * 
	 * @param String sentence，SQL语句或存储过程名
	 * 
	 * 
	 * @param HashMap<String, Object> parameters，参数数组
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
	 * 填充数据集
	 * 
	 * @param String connectionString，SQL语句或存储过程名
	 * 
	 * @param String sentence，SQL语句或存储过程名
	 * 
	 * 
	 * @param HashMap<String, Object> parameters，参数数组
	 */
	public static CachedRowSet fill(String connectionString, String sentence)
			throws Exception {
		return fill(connectionString, sentence, null);
	}

	/*
	 * 加载驱动器
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
	 * 静态构造函数
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
	 * 是否安全
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，返回
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
	 * 返回安全字符串
	 * 
	 * @param String input，输入
	 * 
	 * @return boolean，返回
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
