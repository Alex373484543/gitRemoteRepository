package fanglab.framework.diagnostics;

import fanglab.framework.*;

/*
 * ���
 */
public class SlStopwatch {
	/*
	 * ����
	 * 
	 * @param ISlAction action����Ϊ
	 * 
	 * @return long����������룩
	 */
	public static long execute(ISlAction action) {
		long start = System.nanoTime();
		action.invoke();
		long end = System.nanoTime();
		return end - start;
	}
}
