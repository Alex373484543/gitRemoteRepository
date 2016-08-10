package fanglab.framework;

/*
 * ��Ϊ
 */
public class SlAction {
	/*
	 * ����
	 * 
	 * @param Action action����Ϊ
	 * 
	 * @param int maxTryCount������Դ���
	 * 
	 * @param int interval����������룩
	 */
	public static void tryMore(ISlAction action, int maxTryCount, int interval) {
		boolean isSuccess = false;
		int tryCount = 0;
		Exception outException = null;

		while (tryCount < maxTryCount) {
			try {
				action.invoke();
				isSuccess = true;
				break;
			} catch (Exception exception) {
				outException = exception;
				tryCount++;
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {

				}
			}
		}

		if (!isSuccess) {
			if (outException != null) {
				throw new RuntimeException(outException.getMessage());
			} else {
				throw new RuntimeException("����ִ��ʧ�ܣ�");
			}
		}
	}

	/*
	 * ����
	 * 
	 * @param Action action����Ϊ
	 * 
	 * @param int maxTryCount������Դ���
	 * 
	 * @param int interval����������룩
	 */
	public static void tryMore(ISlAction action, int maxTryCount) {
		tryMore(action, maxTryCount, 60 * 1000);
	}

	/*
	 * ����
	 * 
	 * @param Action action����Ϊ
	 * 
	 * @param int maxTryCount������Դ���
	 * 
	 * @param int interval����������룩
	 */
	public static void tryMore(ISlAction action) {
		tryMore(action, 10, 60 * 1000);
	}
}