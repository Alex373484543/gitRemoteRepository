package alex.framework.ioc.data;

import java.util.Map;



public class DefaultBeanDefinitionContext implements IDataContext {
	
	
	private  Map<String,Object> beanDefinitionMap=null;

	@Override
	public void initData(Map<String, Object> map) {
		
		beanDefinitionMap=map;
		
	}

	@Override
	public void set(String name, Object obj) {
	
		beanDefinitionMap.put(name, obj);
	}

	@Override
	public Object get(String name) {
		
		return beanDefinitionMap.get(name);
	}

	@Override
	public Map<String, Object> getAll() {
	
		return beanDefinitionMap;
	}

}
