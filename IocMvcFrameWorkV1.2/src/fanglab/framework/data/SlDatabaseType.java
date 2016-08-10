package fanglab.framework.data;

/*
 * 数据库类型枚举
 */
public enum SlDatabaseType {
	/*
	 * OleDb数据库
	 */
	OleDb(1),
	/*
	 * SqlServer数据库
	 */
	SqlServer(2),
	/*
	 * SQLite数据库
	 */
	SQLite(3),
	/*
	 * MySql数据库
	 */
	MySql(4);

	private int value;

	private SlDatabaseType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
