package fanglab.framework;

import java.util.*;

/*
 * Guid������
 */
public class SlGuid {
	/*
	 * ����Guid
	 * 
	 * @return String�����
	 */
	public static String newGuid() {
		String guid = UUID.randomUUID().toString();
		return guid.replace("-", "");
	}
}