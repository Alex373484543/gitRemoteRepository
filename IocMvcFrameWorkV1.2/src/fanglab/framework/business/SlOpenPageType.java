package fanglab.framework.business;

/*
 * �򿪷�ʽ
 */
public enum SlOpenPageType {
	/*
	 * ����
	 */
	Normal(0),
	/*
	 * iframe
	 */
	Iframe(1),
	/*
	 * ���ҳ
	 */
	FrameSet(2),
	/*
	 * window.open��ʽ
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
