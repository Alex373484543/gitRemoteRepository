package alex.framework.ioc;

import alex.framework.ioc.data.IDataContext;


public interface IContainer {
	
	//��ȡ������ĳ�������ṩ��ʵ��
    public Object getBean(String name);
    
    //��ȡ�������з���������Ϣ
    public IDataContext getBeanDefinitionContext();

}
