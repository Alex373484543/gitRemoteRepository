package fanglab.framework.ioc.factory;

import java.io.Serializable;

import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;
import fanglab.framework.ioc.handler.HandlerDecorator;

public abstract class AbstractBeanFactory implements IBeanFactory, Serializable {
	

	private static final long serialVersionUID = 1L;
	protected IDataContext beanDefinitionContext;//服务描述信息的存储区
    protected IDataContext beanCacheContext; //服务提供者实例的缓存区
    protected HandlerDecorator handlerDecorator;//转换器（元数据到服务描述信息）

    //设置服务描述信息的存储区
    public abstract void setBeanDefinitionContext(String beanDefinitionContextName, String resource);

    //设置服务提供者实例的缓存区
    public abstract void setBeanCacheContext(String beanCacheContextName);

    //设置转换器（元数据到服务描述信息）
    public abstract void setHandler(String defaultHandler, String handlerName);

    @Override
    //模板方法
    //注册服务组件，初始化服务描述信息
    public final void registerBeanDefinition(String resource, String cacheContext, String definitionContext, String defaultHandler, String customHandler) {

        this.setHandler(defaultHandler, customHandler);
        this.setBeanCacheContext(cacheContext);
        this.setBeanDefinitionContext(definitionContext, resource);
    }

    //----------组件初始化----------end-----


    //----------服务提供者的生命周期-----begin--------

    //获取某个服务提供者的服务描述信息
    public abstract BeanEntity getBeanDefinition(String name);

    //检查该服务提供者的实例是否有缓存
    public abstract boolean containsBeanCache(String name);

    //从缓存中获取服务提供者的实例
    public abstract Object getBeanCache(String name);

    //创建服务提供者
    public abstract Object creatBean(BeanEntity beanEntity);

    //将服务提供者实例注册到缓存
    public abstract Object regiterBeanCache(String name, Object obj);

    //----------服务提供者的生命周期-----end--------

    @Override
    //模板方法
    //获取服务提供者实例
    public final Object getBean(String name) {

        //获取某个Bean的定义
        BeanEntity beanEntity = getBeanDefinition(name);

        //判断这个Bean是否已经加载到缓存，如果有，直接返回
        if (containsBeanCache(name)) {
            return getBeanCache(name);
        }

        //创建bean的实例
        Object beanObject = this.creatBean(beanEntity);

        //注册到缓存
        regiterBeanCache(name, beanObject);

        //返回bean的实例
        return beanObject;
    }

    //获取所有的服务描述信息
    public abstract IDataContext getBeanDefinitionContext();

    //获取所有的服务实例缓存信息
    public abstract IDataContext getBeanCacheContext();


}
