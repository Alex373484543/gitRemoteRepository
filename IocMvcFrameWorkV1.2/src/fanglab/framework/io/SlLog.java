package fanglab.framework.io;

import java.text.*;

import fanglab.framework.*;
import fanglab.framework.diagnostics.*;

/**
 * ��־������Ϊ��־����һ����Ƕ�ͬһ���ļ��Ĵ������ʵ��Ϊ�̰߳�ȫ��
 *
 */
public class SlLog {

	private static final Object syncObject = new Object();

	/**
	 * д��־
	 * 
	 * @param traceType
	 *            ����������
	 * @param message
	 *            ����Ϣ
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
	 * ����
	 * 
	 * @param traceType
	 *            ����������
	 */
	public static void newLine(SlTraceType traceType) {
		write(traceType, "");
	}

	/**
	 * ׷��
	 * 
	 * @param traceType����������
	 * @param action������
	 * @param title������
	 * @param divide���ָ���
	 */
	public static void track(SlTraceType traceType, ISlAction action,
			String title, String divide) {
		StringBuilder messages = new StringBuilder();
		messages.append(divide + System.getProperty("line.separator"));
		messages.append(String.format("%s��", title)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     StartTime��%s", SlDateTime.now())
				+ System.getProperty("line.separator"));

		double time = (double) SlStopwatch.execute(action)
				/ (double) 1000000000;

		messages.append(String.format("     EndTime��%s", SlDateTime.now())
				+ System.getProperty("line.separator"));
		messages.append(String.format("     TotalSeconds��%s",
				new DecimalFormat("#.########").format(time)));

		write(traceType, messages.toString());
	}
	
    /**
	 * ׷��
	 * 
	 * @param traceType����������
	 * @param action������
	 * @param title������
	 * @param divide���ָ���
     * @param startTime����ʼʱ��
     * @param endTime������ʱ��
     * @param time����ʱ
     */
    public static void track(SlTraceType traceType, String title, String divide, String startTime, String endTime, double time)
    {
    	StringBuilder messages = new StringBuilder();
		messages.append(divide + System.getProperty("line.separator"));
		messages.append(String.format("%s��", title)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     StartTime��%s", startTime)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     EndTime��%s", endTime)
				+ System.getProperty("line.separator"));
		messages.append(String.format("     TotalSeconds��%s",
				new DecimalFormat("#.########").format(time)));

        write(traceType, messages.toString());
    }
}
