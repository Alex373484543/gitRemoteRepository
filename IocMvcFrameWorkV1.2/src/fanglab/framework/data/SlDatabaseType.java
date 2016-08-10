package fanglab.framework.data;

/*
 * ���ݿ�����ö��
 */
public enum SlDatabaseType {
	/*
	 * OleDb���ݿ�
	 */
	OleDb(1),
	/*
	 * SqlServer���ݿ�
	 */
	SqlServer(2),
	/*
	 * SQLite���ݿ�
	 */
	SQLite(3),
	/*
	 * MySql���ݿ�
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
