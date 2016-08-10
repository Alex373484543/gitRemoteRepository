package fanglab.framework.business;

/*
 * 打开方式
 */
public enum SlOpenPageType {
	/*
	 * 正常
	 */
	Normal(0),
	/*
	 * iframe
	 */
	Iframe(1),
	/*
	 * 框架页
	 */
	FrameSet(2),
	/*
	 * window.open方式
	 */
	WindowOpen(3);

	private int value;

	private SlOpenPageType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
