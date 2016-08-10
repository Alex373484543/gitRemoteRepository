package fanglab.framework.diagnostics;

/*
 * ׷������
 */
public enum SlTraceType {
	/*
	 * ������
	 */
	Console(1),

	/*
	 * ��־
	 */
	Log(2);

	private int value;

	private SlTraceType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
