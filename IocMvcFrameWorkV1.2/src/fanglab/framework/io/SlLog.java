package fanglab.framework.io;

import java.text.*;

import fanglab.framework.*;
import fanglab.framework.diagnostics.*;

/**
 * 日志处理（因为日志操作一般均是对同一个文件的处理，因此实现为线程安全）
 *
 */
public class SlLog {

	private static final Object syncObject = new Object();

	/**
	 * 写日志
	 * 
	 * @param traceType
	 *            ，跟踪类型
	 * @param message
	 *            ，消息
	 */
	public static void write(SlTraceType traceType, String message) {
		if (traceType == SlTraceType.Log) {
			synchronized (syncObject) {
				SlFile.write(SlAppContext.LogFilePath, message);
			}
		} else {
			System.out.println(message);
		}
	}

	/**
	 * 新行
	 * 
	 * @param traceType
	 *            ，跟踪类型
	 */
	public static void newLine(SlTraceType traceType) {
		write(traceType, "");
	}

	/**
	 * 追踪
	 * 
	 * @param traceType，跟踪类型
	 * @param action，动作
	 * @param title，标题
	 * @param divide，分割线
	 */
	public static void track(SlTraceType traceType, ISlAction action,
			String title, String divide) {
		StringBuilder messages = new StringBuilder();
		messages.append(divide + System.getProperty("line.separator"));
		messages.append(String.format("%s：", title)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     StartTime：%s", SlDateTime.now())
				+ System.getProperty("line.separator"));

		double time = (double) SlStopwatch.execute(action)
				/ (double) 1000000000;

		messages.append(String.format("     EndTime：%s", SlDateTime.now())
				+ System.getProperty("line.separator"));
		messages.append(String.format("     TotalSeconds：%s",
				new DecimalFormat("#.########").format(time)));

		write(traceType, messages.toString());
	}
	
    /**
	 * 追踪
	 * 
	 * @param traceType，跟踪类型
	 * @param action，动作
	 * @param title，标题
	 * @param divide，分割线
     * @param startTime，开始时间
     * @param endTime，结束时间
     * @param time，耗时
     */
    public static void track(SlTraceType traceType, String title, String divide, String startTime, String endTime, double time)
    {
    	StringBuilder messages = new StringBuilder();
		messages.append(divide + System.getProperty("line.separator"));
		messages.append(String.format("%s：", title)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     StartTime：%s", startTime)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     EndTime：%s", endTime)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     TotalSeconds：%s",
				new DecimalFormat("#.########").format(time)));

        write(traceType, messages.toString());
    }
}
