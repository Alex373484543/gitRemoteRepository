package fanglab.framework;

/*
 * 行为
 */
public class SlAction {
	/*
	 * 尝试
	 * 
	 * @param Action action，行为
	 * 
	 * @param int maxTryCount，最大尝试次数
	 * 
	 * @param int interval，间隔（毫秒）
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
				throw new RuntimeException("尝试执行失败！");
			}
		}
	}

	/*
	 * 尝试
	 * 
	 * @param Action action，行为
	 * 
	 * @param int maxTryCount，最大尝试次数
	 * 
	 * @param int interval，间隔（毫秒）
	 */
	public static void tryMore(ISlAction action, int maxTryCount) {
		tryMore(action, maxTryCount, 60 * 1000);
	}

	/*
	 * 尝试
	 * 
	 * @param Action action，行为
	 * 
	 * @param int maxTryCount，最大尝试次数
	 * 
	 * @param int interval，间隔（毫秒）
	 */
	public static void tryMore(ISlAction action) {
		tryMore(action, 10, 60 * 1000);
	}
}