package fanglab.framework.data;

import fanglab.framework.*;

/*
 * �ֶ�����
 */
public class SlFieldDescription {
	/*
	 * ���ݿ�����
	 */
	private String dbType;

	public String getDbType() {
		return this.dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/*
	 * ����
	 */
	private int length;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	/*
	 * �Ƿ��ΪNull
	 */
	private boolean isNullable;

	public boolean getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(boolean isNullable) {
		this.isNullable = isNullable;
	}

	/*
	 * ����
	 */
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * �ֶ���
	 */
	private String name;

	public String getName() {
		name = name.toLowerCase().startsWith("id") ? "ID" + name.substring(2)
				: name;
		name = name.toLowerCase().endsWith("id") ? name.substring(0,
				name.length() - 2)
				+ "ID" : name;
		return SlConvert.toTitleCase(name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
