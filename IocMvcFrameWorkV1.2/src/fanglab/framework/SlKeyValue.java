package fanglab.framework;

/*
 * ��ֵ
 */
public class SlKeyValue<TKey, TValue> {
	/*
	 * ��
	 */
	public TKey Key;

	/*
	 * ֵ
	 */
	public TValue Value;

	/*
	 * ��дEquals
	 * 
	 * @param Object obj������
	 * 
	 * @return boolean�����
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
	 * ��д
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.Key.hashCode();
	}
}
