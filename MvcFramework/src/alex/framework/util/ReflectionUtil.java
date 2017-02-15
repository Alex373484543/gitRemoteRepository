package alex.framework.util;

public class ReflectionUtil {

	
	public static Object getInstance(String className)
	{
		
		try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
