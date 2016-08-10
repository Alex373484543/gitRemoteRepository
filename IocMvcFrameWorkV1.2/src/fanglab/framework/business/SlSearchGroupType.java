package fanglab.framework.business;

/*
 * 搜索组类型
 */
public enum SlSearchGroupType {
	/*
	 * 非搜索
	 */
	Not(0),

	/*
	 * 百度
	 */
	Baidu(1),

	/*
	 * 谷歌
	 */
	Google(2),

	/*
	 * 搜狗
	 */
	Sogou(3),

	/*
	 * 搜搜
	 */
	Soso(4),

	/*
	 * 必应
	 */
	Bing(5),

	/*
	 * 有道
	 */
	Youdao(6),

	/*
	 * 雅虎
	 */
	Yahoo(7),

	/*
	 * 360
	 */
	So360(9),

	/*
	 * 宜搜
	 */
	Easou(10),

	/*
	 * 易查
	 */
	Yicha(11),

	/*
	 * 儒豹
	 */
	Roboo(12);

	private int value;

	private SlSearchGroupType(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
