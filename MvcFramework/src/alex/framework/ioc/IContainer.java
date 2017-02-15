package alex.framework.ioc;

import alex.framework.ioc.data.IDataContext;


public interface IContainer {
	
	//获取容器的某个服务提供者实例
    public Object getBean(String name);
    
    //获取容器所有服务描述信息
    public IDataContext getBeanDefinitionContext();

}
