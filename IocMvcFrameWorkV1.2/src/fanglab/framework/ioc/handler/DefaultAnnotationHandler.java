package fanglab.framework.ioc.handler;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import fanglab.framework.SlString;
import fanglab.framework.ioc.annotation.Action;
import fanglab.framework.ioc.entity.BeanEntity;
import fanglab.framework.ioc.util.ReflectionUtil;

public class DefaultAnnotationHandler extends HandlerDecorator {

	@Override
	public Map<String, Object> convert(String packName) {

		Map<String, Object> map = super.convert(packName);

		Map<String, Object> beanMap = new HashMap<String, Object>();
		String packageNames = packName;

		if (SlString.isNullOrEmpty(packageNames))
			return beanMap;

		String[] packageNameArr = packageNames.split(",");
		for (String packageName : packageNameArr) {

			String packageDirName = packageName.replace(".", "/");
			Enumeration<URL> dirs = null;
			try {
				dirs = Thread.currentThread().getContextClassLoader()
						.getResources(packageDirName);
				while (dirs.hasMoreElements()) {
					URL url = dirs.nextElement();
					File file = new File(url.getFile());

					String[] classes = file.list();

					for (String className : classes) {
						className = className.substring(0,
								className.length() - 6);

						String qName = packageName + "." + className;

						Object obj = ReflectionUtil.getInstance(qName);

						boolean actionFlag = obj.getClass()
								.isAnnotationPresent(Action.class);

						if (actionFlag) {
							Action bean = (Action) obj.getClass()
									.getAnnotation(Action.class);
							beanMap.put(bean.value(),
									new BeanEntity(bean.value(), qName, obj));
						}

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (map != null && map.size() != 0) {
				beanMap.putAll(map);
			}
		}
		return beanMap;

	}
}
