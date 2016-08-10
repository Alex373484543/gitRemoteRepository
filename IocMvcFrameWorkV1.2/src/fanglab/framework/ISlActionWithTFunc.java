package fanglab.framework;

/**
 * ISlActionWithTFunc
 *
 * @param <T>，类型
 */
public interface ISlActionWithTFunc<T> {
	/**
	 * 运行
	 */
	void invoke(T param1);
}
