package fanglab.framework.ioc.factory;

import java.util.HashMap;
import java.util.Map;

import fanglab.framework.diagnostics.SlTraceType;
import fanglab.framework.io.SlLog;
import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;
import fanglab.framework.ioc.handler.HandlerDecorator;
import fanglab.framework.ioc.util.ReflectionUtil;

public class DefaultBeanFactory extends AbstractBeanFactory{

    
	private static final long serialVersionUID = 1L;

	@Override
    public void setHandler(String defaultHandler,String handlerName){
    	
        SlLog.write(SlTraceType.Console, "注册处理元数据的Handler");
        handlerDecorator=(HandlerDecorator)ReflectionUtil.getInstance(defaultHandler);
        if(handlerName!=null){
            HandlerDecorator newHandler=(HandlerDecorator)ReflectionUtil.getInstance(handlerName);
            handlerDecorator.setHandler(newHandler);
        }
    }

    @Override
    public void setBeanDefinitionContext(String beanDefinitionContextName,String resource) {
        SlLog.write(SlTraceType.Console, "注册服务定义信息的存储区");
        beanDefinitionContext=(IDataContext)ReflectionUtil.getInstance(beanDefinitionContextName);
        SlLog.write(SlTraceType.Console, "将元数据转换为服务定义信息");
        Map<String,Object> BeanDataMap= handlerDecorator.convert(resource);
        beanDefinitionContext.initData(BeanDataMap);
    }

    @Override
    public void setBeanCacheContext(String beanCacheContextName) {
    	 SlLog.write(SlTraceType.Console, "设置缓冲区");
        beanCacheContext=(IDataContext)ReflectionUtil.getInstance(beanCacheContextName);
        beanCacheContext.initData(new HashMap<String, Object>());
    }

    @Override
    public BeanEntity getBeanDefinition(String name) {
    	SlLog.write(SlTraceType.Console, "获取"+name+"的信息");
        return (BeanEntity)beanDefinitionContext.get(name);
    }

    @Override
    public boolean containsBeanCache(String name) {
    	SlLog.write(SlTraceType.Console, name+"是否存在于缓存中");
        return beanCacheContext.get(name)!=null ? true : false;
    }

    @Override
    public Object getBeanCache(String name) {
        
        return beanCacheContext.get(name);
    }

    @Override
    //递归调用，获取注入Bean依赖的Bean
    public Object creatBean(BeanEntity beanEntity) {

        Object obj=ReflectionUtil.getInstance(beanEntity.getType());
        return obj;
    }

    @Override
    public Object regiterBeanCache(String name,Object obj) {
        beanCacheContext.set(name, obj);
        return null;
    }


    @Override
    public IDataContext getBeanDefinitionContext() {
        return beanDefinitionContext;
    }

    @Override
    public IDataContext getBeanCacheContext() {
        return beanCacheContext;
    }

	


}
