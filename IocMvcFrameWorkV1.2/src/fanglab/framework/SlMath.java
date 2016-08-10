package fanglab.framework;

import javax.script.*;

/*
 * 数学
 */
public class SlMath {
	/*
	 * 计算表达式
	 * 
	 * @param String expression，表达式
	 * 
	 * @return double,结果
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
