package fanglab.framework.diagnostics;

import java.io.IOException;

/*
 * ���̴���
 */
public class SlProcess {
	/*
	 * ִ��������
	 * 
	 * @param String command������
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
