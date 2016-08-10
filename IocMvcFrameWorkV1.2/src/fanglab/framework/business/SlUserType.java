package fanglab.framework.business;

/*
 * 用户类型
 */
public enum SlUserType {
	/*
	 * 普通用户
	 */
	General(1),

	/*
	 * 通行证
	 */
	Passport(2),

	/*
	 * 搜房帮
	 */
	Agent(4),

	/*
	 * 搜房卡
	 */
	Card(8),

	/*
	 * 内部员工
	 */
	Soufun(16);

	private int value;

	private SlUserType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
