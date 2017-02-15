package alex.framework.ioc.entity;

public class BeanEntity {
	
	private String name; // 服务提供者名
	private String type; // 服务提供者实例的类型
	private Object value; // 服务提供者实例

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
