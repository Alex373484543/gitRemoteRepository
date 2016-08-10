package fanglab.framework.data;

/*
 * 数据库类型映射
 */
public class SlDbTypeMap {
	/*
	 * 映射 /*@param String dbType，数据库类型 /*@return String，.NET类型
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
