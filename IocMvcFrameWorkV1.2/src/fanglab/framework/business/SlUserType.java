package fanglab.framework.business;

/*
 * �û�����
 */
public enum SlUserType {
	/*
	 * ��ͨ�û�
	 */
	General(1),

	/*
	 * ͨ��֤
	 */
	Passport(2),

	/*
	 * �ѷ���
	 */
	Agent(4),

	/*
	 * �ѷ���
	 */
	Card(8),

	/*
	 * �ڲ�Ա��
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
