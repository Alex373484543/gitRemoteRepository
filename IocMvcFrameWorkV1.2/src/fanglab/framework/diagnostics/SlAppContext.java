package fanglab.framework.diagnostics;

import java.text.*;
import java.util.*;

/*
 * App上下文
 */
public class SlAppContext {
	/*
	 * 启动时间
	 */
	public final static Date StartupTime = new Date();

	/*
	 * 程序所在目录（有斜线结尾）
	 */
	public final static String Directory = System.getProperty("user.dir")
			+ System.getProperty("file.separator");

	
	/*
	 * 程序集日志文件的路径
	 */
	public static String LogFilePath = Directory
			+ (new SimpleDateFormat("yyyyMMddHHmmss")).format(StartupTime)
			+ ".log";
}
