package fanglab.framework.io;

/*
 * �ļ�����
 */
public enum SlFileType {
	// �ı��ļ�
	Text(1),
	// ѹ���ļ�
	GZip(2);

	private int value;

	private SlFileType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
