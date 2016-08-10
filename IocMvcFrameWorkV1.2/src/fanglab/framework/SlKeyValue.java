package fanglab.framework;

/*
 * 键值
 */
public class SlKeyValue<TKey, TValue> {
	/*
	 * 键
	 */
	public TKey Key;

	/*
	 * 值
	 */
	public TValue Value;

	/*
	 * 重写Equals
	 * 
	 * @param Object obj，对象
	 * 
	 * @return boolean，结果
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public boolean equals(Object obj) {
		if (!(obj instanceof SlKeyValue<?, ?>)) {
			return false;
		}
		SlKeyValue<TKey, TValue> other = (SlKeyValue<TKey, TValue>) obj;
		if (other != null) {
			return this.Key.equals(other.Key);
		}
		return false;
	}

	/*
	 * 重写
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.Key.hashCode();
	}
}
