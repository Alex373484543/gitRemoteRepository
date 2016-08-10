package fanglab.framework.diagnostics;

import fanglab.framework.*;

/*
 * 秒表
 */
public class SlStopwatch {
	/*
	 * 运行
	 * 
	 * @param ISlAction action，行为
	 * 
	 * @return long，结果（纳秒）
	 */
	public static long execute(ISlAction action) {
		long start = System.nanoTime();
		action.invoke();
		long end = System.nanoTime();
		return end - start;
	}
}
