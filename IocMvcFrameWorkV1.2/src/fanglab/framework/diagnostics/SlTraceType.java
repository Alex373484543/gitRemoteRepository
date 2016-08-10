package fanglab.framework.diagnostics;

/*
 * 追踪类型
 */
public enum SlTraceType {
	/*
	 * 命令行
	 */
	Console(1),

	/*
	 * 日志
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
