package fanglab.framework.ioc.container;

import fanglab.framework.SlContainer;
import fanglab.framework.diagnostics.SlTraceType;
import fanglab.framework.io.SlLog;
import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;
import fanglab.framework.ioc.factory.AbstractBeanFactory;
import fanglab.framework.ioc.util.ReflectionUtil;

public class DefaultContainer implements IContainer {
	private AbstractBeanFactory factory;
	
	private static final String DEFAULTBEANFACTORY="fanglab.framework.ioc.factory.DefaultBeanFactory";
	private static final String DEFAULTRESOURCE="fanglab.framework.ioc.bean";
	private static final String DEFAULTBEANCACHECONTEXT="fanglab.framework.ioc.data.DefaultBeanCacheContext";
	private static final String DEFAULTBEANDEFINITIONCONTEXT="fanglab.framework.ioc.data.DefaultBeanDefinitionContext";
	private static final String DEFAULTHANDLER="fanglab.framework.ioc.handler.DefaultAnnotationHandler";

	// 这个map中的值取自配置文件，因为可以加载不同的factory实现，同时定制factory的组件。
	public DefaultContainer() {
		SlLog.write(SlTraceType.Console, "开始初始化容器");
		SlLog.write(SlTraceType.Console,"开始初始化工厂" );
		factory = (AbstractBeanFactory) ReflectionUtil
				.getInstance(SlContainer.get("factory") == null ? DEFAULTBEANFACTORY
						: SlContainer.get("factory").toString());
		factory.registerBeanDefinition(
				SlContainer.get("resource") == null ? DEFAULTRESOURCE
						: SlContainer.get("resource").toString(),
						SlContainer.get("cacheContext") == null ? DEFAULTBEANCACHECONTEXT
						: SlContainer.get("cacheContext").toString(),
						SlContainer.get("definitionContext") == null ? DEFAULTBEANDEFINITIONCONTEXT
						: SlContainer.get("definitionContext").toString(),
						SlContainer.get("defaultHandler") == null ? DEFAULTHANDLER
						: SlContainer.get("defaultHandler").toString(),
						SlContainer.get("customHandler") == null ? null : SlContainer.get(
						"customHandler").toString());
		SlLog.write(SlTraceType.Console,"初始化工厂成功" );
		SlLog.write(SlTraceType.Console,"初始化容器成功" );
	}

	@Override
	// 这里使用外观模式，container即是factory的外观
	public Object getBean(String name) {
		return factory.getBean(name);
	}

	@Override
	public BeanEntity getBeanDefinition(String name) {
		return (BeanEntity) getBeanDefinitionContext().get(name);
	}

	@Override
	public IDataContext getBeanDefinitionContext() {
		return factory.getBeanDefinitionContext();
	}

	@Override
	public IDataContext getBeanCacheContext() {
		return factory.getBeanCacheContext();
	}

	
}
