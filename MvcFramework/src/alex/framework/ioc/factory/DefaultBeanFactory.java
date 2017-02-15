package alex.framework.ioc.factory;

import alex.framework.ioc.entity.BeanEntity;

public class DefaultBeanFactory extends AbstractBeanFactory {

	@Override
	public BeanEntity getBeanDefinition(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsBeanCache(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getBeanCache(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object creatBean(BeanEntity beanEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object regiterBeanCache(String name, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBeanDefinitionContext(String beanDefinitionContextName,
			String resource) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBeanCacheContext(String beanCacheContextName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHandler(String defaultHandler, String handlerName) {
		// TODO Auto-generated method stub

	}

}
