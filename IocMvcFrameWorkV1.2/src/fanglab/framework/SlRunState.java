package fanglab.framework;

public enum SlRunState {
	/*
	 * 开发
	 */
	Develope(1),

	/*
	 * 发布
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
