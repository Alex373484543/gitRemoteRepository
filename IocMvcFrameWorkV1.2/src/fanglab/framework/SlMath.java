package fanglab.framework;

import javax.script.*;

/*
 * ��ѧ
 */
public class SlMath {
	/*
	 * ������ʽ
	 * 
	 * @param String expression�����ʽ
	 * 
	 * @return double,���
	 */
	public static double eval(String expression) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager
				.getEngineByName("JavaScript");
		try {
			return (double) (scriptEngine.eval(expression));
		} catch (ScriptException e) {
			return 0;
		}
	}
}
