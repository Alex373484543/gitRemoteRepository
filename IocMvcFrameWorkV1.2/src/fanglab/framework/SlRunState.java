package fanglab.framework;

public enum SlRunState {
	/*
	 * ����
	 */
	Develope(1),

	/*
	 * ����
	 */
	Publish(2);

	private int value = 0;

	private SlRunState(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
