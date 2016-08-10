package fanglab.framework.diagnostics;

import java.text.*;
import java.util.*;

/*
 * App������
 */
public class SlAppContext {
	/*
	 * ����ʱ��
	 */
	public final static Date StartupTime = new Date();

	/*
	 * ��������Ŀ¼����б�߽�β��
	 */
	public final static String Directory = System.getProperty("user.dir")
			+ System.getProperty("file.separator");

	
	/*
	 * ������־�ļ���·��
	 */
	public static String LogFilePath = Directory
			+ (new SimpleDateFormat("yyyyMMddHHmmss")).format(StartupTime)
			+ ".log";
}
