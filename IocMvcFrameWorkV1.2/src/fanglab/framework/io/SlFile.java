package fanglab.framework.io;

import java.io.*;
import java.util.zip.*;


public class SlFile {
	/*
	 * д����־
	 * 
	 * @param String filePath���ļ�·�����ļ�������ʱ���Զ�����������ʱ��׷����Ϣ
	 * 
	 * @param String message��д������
	 * 
	 * @param String isNewline���Ƿ��Զ�����
	 * 
	 * @param String append���Ƿ��ڵ�ǰ�ı��󸽼�,�滻
	 * 
	 * @param String encoding�����뷽ʽ
	 */
	public static void write(String filePath, String message,
			boolean isNewline, String encoding, boolean append) {
		try {
			File file = new File(filePath);
			file.getParentFile().mkdirs();
		} catch (Exception err) {
		}
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		try {
			fileOutputStream = new FileOutputStream(new File(filePath), append);
			outputStreamWriter = new OutputStreamWriter(fileOutputStream,
					encoding);

			if (isNewline) {
				outputStreamWriter.write(message);
				outputStreamWriter.write(System.getProperty("line.separator"));
			} else {
				outputStreamWriter.write(message);
			}
			outputStreamWriter.flush();
		} catch (Exception err) {
		} finally {
			try {
				outputStreamWriter.close();
			} catch (IOException e) {

			}
			try {
				fileOutputStream.close();
			} catch (IOException e) {

			}
		}
	}

	/*
	 * д����־
	 * 
	 * @param String filePath���ļ�·�����ļ�������ʱ���Զ�����������ʱ��׷����Ϣ
	 * 
	 * @param String message��д������
	 * 
	 * @param String isNewline���Ƿ��Զ�����
	 * 
	 * @param String append���Ƿ��ڵ�ǰ�ı��󸽼�,�滻
	 * 
	 * @param String encoding�����뷽ʽ
	 */
	public static void write(String filePath, String message,
			boolean isNewline, String encoding) {
		write(filePath, message, isNewline, encoding, true);
	}

	/*
	 * д����־
	 * 
	 * @param String filePath���ļ�·�����ļ�������ʱ���Զ�����������ʱ��׷����Ϣ
	 * 
	 * @param String message��д������
	 * 
	 * @param String isNewline���Ƿ��Զ�����
	 * 
	 * @param String append���Ƿ��ڵ�ǰ�ı��󸽼�,�滻
	 * 
	 * @param String encoding�����뷽ʽ
	 */
	public static void write(String filePath, String message, boolean isNewline) {
		write(filePath, message, isNewline, "utf8", true);
	}

	/*
	 * д����־
	 * 
	 * @param String filePath���ļ�·�����ļ�������ʱ���Զ�����������ʱ��׷����Ϣ
	 * 
	 * @param String message��д������
	 * 
	 * @param String isNewline���Ƿ��Զ�����
	 * 
	 * @param String append���Ƿ��ڵ�ǰ�ı��󸽼�,�滻
	 * 
	 * @param String encoding�����뷽ʽ
	 */
	public static void write(String filePath, String message) {
		write(filePath, message, true, "utf8", true);
	}

	/*
	 * ��ö�ȡ��
	 * 
	 * @param String path��·��
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @param String fileEncoding���ļ�����
	 * 
	 * @return�����
	 */
	public static InputStreamReader getStreamReader(String path,
			SlFileType fileType, String fileEncoding) {

		try {
			FileInputStream fileInputStream = new FileInputStream(
					new File(path));
			if (fileType == SlFileType.GZip) {
				GZIPInputStream gzipInputStream = new GZIPInputStream(
						fileInputStream);
				return new InputStreamReader(gzipInputStream, fileEncoding);
			} else {
				return new InputStreamReader(fileInputStream, fileEncoding);
			}
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * ��ö�ȡ��
	 * 
	 * @param String path��·��
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @param String fileEncoding���ļ�����
	 * 
	 * @return�����
	 */
	public static InputStreamReader getStreamReader(String path,
			SlFileType fileType) {
		return getStreamReader(path, fileType, "utf8");
	}

	/*
	 * ��ö�ȡ��
	 * 
	 * @param String path��·��
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @param String fileEncoding���ļ�����
	 * 
	 * @return�����
	 */
	public static InputStreamReader getStreamReader(String path) {
		return getStreamReader(path, SlFileType.Text);
	}

	/*
	 * ���д����
	 * 
	 * @param String path��·��
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @param String fileEncoding���ļ�����
	 * 
	 * @return�����
	 */
	public static OutputStreamWriter getStreamWriter(String path,
			SlFileType fileType, String fileEncoding) {

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					path));
			if (fileType == SlFileType.GZip) {
				GZIPOutputStream gzipOutputStream = new GZIPOutputStream(
						fileOutputStream);
				return new OutputStreamWriter(gzipOutputStream, fileEncoding);
			} else {
				return new OutputStreamWriter(fileOutputStream, fileEncoding);
			}
		} catch (Exception e) {

		}
		return null;
	}

	/*
	 * ���д����
	 * 
	 * @param String path��·��
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @param String fileEncoding���ļ�����
	 * 
	 * @return�����
	 */
	public static OutputStreamWriter getStreamWriter(String path,
			SlFileType fileType) {
		return getStreamWriter(path, fileType, "utf8");
	}

	/*
	 * ���д����
	 * 
	 * @param String path��·��
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @param String fileEncoding���ļ�����
	 * 
	 * @return�����
	 */
	public static OutputStreamWriter getStreamWriter(String path) {
		return getStreamWriter(path, SlFileType.Text);
	}

	/*
	 * ������ת�ɶ������ļ��洢����Ӧ��Ŀ¼
	 * 
	 * @param Object obj������
	 * 
	 * @param String path���ļ���ַ
	 * 
	 * @param SlFileType fileType���ļ�����
	 */
	public static void binaryWrite(Object obj, String path, SlFileType fileType) {
		File file = new File(path);
		ObjectOutputStream objectOutputStream = null;
		try {
			if (fileType == SlFileType.Text) {
				objectOutputStream = new ObjectOutputStream(
						new FileOutputStream(file));
			} else {
				objectOutputStream = new ObjectOutputStream(
						new GZIPOutputStream(new FileOutputStream(file)));
			}
			objectOutputStream.writeObject(obj);
		} catch (Exception err) {
		} finally {
			try {
				objectOutputStream.close();
			} catch (Exception err) {

			}
		}
	}

	/*
	 * ������ת�ɶ������ļ��洢����Ӧ��Ŀ¼
	 * 
	 * @param Object obj������
	 * 
	 * @param String path���ļ���ַ
	 * 
	 * @param SlFileType fileType���ļ�����
	 */
	public static void binaryWrite(Object obj, String path) {
		binaryWrite(obj, path, SlFileType.Text);
	}

	/*
	 * ���������ļ�ת�ɶ��󲢷���
	 * 
	 * @param String path���ļ���ַ
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @return������
	 */
	@SuppressWarnings("unchecked")
	public static <T> T binaryRead(String path, SlFileType fileType) {
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}
		ObjectInputStream objectInputStream = null;
		try {
			if (fileType == SlFileType.Text) {
				objectInputStream = new ObjectInputStream(new FileInputStream(
						file));
				Object obj = objectInputStream.readObject();
				return (T) obj;
			} else {
				objectInputStream = new ObjectInputStream(new GZIPInputStream(
						new FileInputStream(file)));
				Object obj = objectInputStream.readObject();
				return (T) obj;
			}
		} catch (Exception err) {
		} finally {
			try {
				objectInputStream.close();
			} catch (Exception err) {

			}
		}
		return null;
	}

	/*
	 * ���������ļ�ת�ɶ��󲢷���
	 * 
	 * @param String path���ļ���ַ
	 * 
	 * @param SlFileType fileType���ļ�����
	 * 
	 * @return������
	 */
	public static <T> T binaryRead(String path) {
		return binaryRead(path, SlFileType.Text);
	}

	/*
	 * ɾ������
	 * 
	 * @param File file���ļ�
	 */
	public static void deleteAll(File file) {
		if (file.isDirectory()) {
			String fileList[] = file.list();
			if (fileList.length == 0) {
				file.delete();
			} else {
				int size = fileList.length;
				for (int i = 0; i < size; i++) {
					String fileName = fileList[i];
					String fullPath = file.getPath() + File.separator
							+ fileName;
					File fileOrFolder = new File(fullPath);
					deleteAll(fileOrFolder);
				}
				file.delete();
			}
		} else {
			file.delete();
		}
	}

	/**
	 * ��ȡ�����ı�
	 * 
	 * @param path��·��
	 * @param fileEncoding������
	 * @return�����
	 */
	public static String readAllText(String path, String fileEncoding) {

		try (FileInputStream fileInputStream = new FileInputStream(new File(
				path));
				InputStreamReader inputStreamReader = new InputStreamReader(
						fileInputStream, fileEncoding);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader)) {
			String line = null;
			StringBuilder lines = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				lines.append(line + System.getProperty("line.separator"));
			}
			return lines.toString();
		} catch (Exception err) {
			throw new RuntimeException(err);
		}
	}
}
