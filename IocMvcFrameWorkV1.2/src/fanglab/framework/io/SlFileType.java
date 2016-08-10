package fanglab.framework.io;

/*
 * 文件类型
 */
public enum SlFileType {
	// 文本文件
	Text(1),
	// 压缩文件
	GZip(2);

	private int value;

	private SlFileType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
