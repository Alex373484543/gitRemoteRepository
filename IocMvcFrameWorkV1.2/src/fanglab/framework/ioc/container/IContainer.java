package fanglab.framework.ioc.container;

import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;


public interface IContainer{

    //获取容器的某个服务提供者实例
    public Object getBean(String name);

    //获取容器所有服务描述信息
    public IDataContext getBeanDefinitionContext();

    //获取容器中某个服务提供者的描述信息
    public BeanEntity getBeanDefinition(String name);

    //获取容器中所有服务提供者实例的缓存
    public IDataContext getBeanCacheContext();

   

}
