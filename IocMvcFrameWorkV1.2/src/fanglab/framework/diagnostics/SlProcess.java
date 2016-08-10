package fanglab.framework.diagnostics;

import java.io.IOException;

/*
 * 进程处理
 */
public class SlProcess {
	/*
	 * 执行命令行
	 * 
	 * @param String command，命令
	 */
	@SuppressWarnings("unused")
	public static void executeCommand(String command) {
		if (!(command == null || command.trim().isEmpty())) {
			try {
				Process prcess = Runtime.getRuntime().exec(command);
			} catch (IOException e) {
			}
		}
	}
}
