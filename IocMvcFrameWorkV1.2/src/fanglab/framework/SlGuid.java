package fanglab.framework;

import java.util.*;

/*
 * Guid处理类
 */
public class SlGuid {
	/*
	 * 产生Guid
	 * 
	 * @return String，结果
	 */
	public static String newGuid() {
		String guid = UUID.randomUUID().toString();
		return guid.replace("-", "");
	}
}