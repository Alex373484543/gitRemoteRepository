package fanglab.framework.business;

/*
 * ����������
 */
public enum SlSearchGroupType {
	/*
	 * ������
	 */
	Not(0),

	/*
	 * �ٶ�
	 */
	Baidu(1),

	/*
	 * �ȸ�
	 */
	Google(2),

	/*
	 * �ѹ�
	 */
	Sogou(3),

	/*
	 * ����
	 */
	Soso(4),

	/*
	 * ��Ӧ
	 */
	Bing(5),

	/*
	 * �е�
	 */
	Youdao(6),

	/*
	 * �Ż�
	 */
	Yahoo(7),

	/*
	 * 360
	 */
	So360(9),

	/*
	 * ����
	 */
	Easou(10),

	/*
	 * �ײ�
	 */
	Yicha(11),

	/*
	 * �屪
	 */
	Roboo(12);

	private int value;

	private SlSearchGroupType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
