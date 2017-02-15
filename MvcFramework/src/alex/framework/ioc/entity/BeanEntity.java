package alex.framework.ioc.entity;

public class BeanEntity {
	
	private String name; // �����ṩ����
	private String type; // �����ṩ��ʵ��������
	private Object value; // �����ṩ��ʵ��

	public BeanEntity() {
	}

	public BeanEntity(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public BeanEntity(String name, String type, Object value)
	{
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
