package fanglab.framework.ioc.container;

import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;


public interface IContainer{

    //��ȡ������ĳ�������ṩ��ʵ��
    public Object getBean(String name);

    //��ȡ�������з���������Ϣ
    public IDataContext getBeanDefinitionContext();

    //��ȡ������ĳ�������ṩ�ߵ�������Ϣ
    public BeanEntity getBeanDefinition(String name);

    //��ȡ���������з����ṩ��ʵ���Ļ���
    public IDataContext getBeanCacheContext();

   

}
