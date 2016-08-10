package fanglab.framework.business;

/*
 * 来源类型
 */
public enum SlRefererType {
	/*
	 * 直接输入
	 */
	Input(1),
	/*
	 * 站内引荐
	 */
	Inner(2),
	/*
	 * 站外引荐
	 */
	Outer(3),
	/*
	 * 搜索引流
	 */
	Search(4);

	private int value;

	private SlRefererType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
