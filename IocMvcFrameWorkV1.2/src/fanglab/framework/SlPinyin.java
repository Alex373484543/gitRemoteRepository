package fanglab.framework;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/*
 * ºº×Ö×ªÆ´Òô
 */
public class SlPinyin {
	/*
	 * ºº×Ö×ª»¯ÎªÆ´Òô
	 * 
	 * @param String str£¬ºº×Ö
	 * 
	 * @return String£¬È«Æ´
	 */
	public static String getPinyin(String str) {
		char[] t1 = null;
		t1 = str.toCharArray();
		String[] t2 = new String[t1.length];
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// ÅÐ¶ÏÊÇ·ñÎªºº×Ö×Ö·û
				if (java.lang.Character.toString(t1[i]).matches(
						"[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
					t4 += t2[0];
				} else {
					t4 += java.lang.Character.toString(t1[i]);
				}
			}
			return t4;
		} catch (BadHanyuPinyinOutputFormatCombination e1) {
			e1.printStackTrace();
		}
		return t4;
	}

	/*
	 * ºº×Ö×ª»¯ÎªÆ´ÒôÊ××ÖÄ¸
	 * 
	 * @param String str£¬ºº×Ö
	 * 
	 * @return String£¬Ê××ÖÄ¸
	 */
	public static String getFirstPinyin(String str) {
		String r = "";
		char[] chars = str.toCharArray();

		for (char obj : chars) {
			try {
				String t = getPinyin(String.valueOf(obj));
				r += t.substring(0, 1);
			} catch (Exception exception) {
				r += String.valueOf(obj);
			}
		}
		return r;
	}
}
