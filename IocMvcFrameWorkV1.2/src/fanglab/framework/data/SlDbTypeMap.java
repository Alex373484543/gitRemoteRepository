package fanglab.framework.data;

/*
 * ���ݿ�����ӳ��
 */
public class SlDbTypeMap {
	/*
	 * ӳ�� /*@param String dbType�����ݿ����� /*@return String��.NET����
	 */
	public static String map(String dbType) {
		switch (dbType) {
		case "bigint":
			return "long";
		case "int":
		case "tinyint":
			return "int";
		case "bit":
			return "byte";
		case "smalldatetime":
		case "date":
		case "datetime":
			return "Date";
		case "decimal":
		case "float":
			return "double";
		default:
			return "String";
		}
	}
}
