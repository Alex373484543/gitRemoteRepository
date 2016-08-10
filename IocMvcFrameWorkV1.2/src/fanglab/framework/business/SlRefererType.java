package fanglab.framework.business;

/*
 * ��Դ����
 */
public enum SlRefererType {
	/*
	 * ֱ������
	 */
	Input(1),
	/*
	 * վ������
	 */
	Inner(2),
	/*
	 * վ������
	 */
	Outer(3),
	/*
	 * ��������
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
