package fanglab.framework.ioc.factory;

import java.io.Serializable;

import fanglab.framework.ioc.data.IDataContext;
import fanglab.framework.ioc.entity.BeanEntity;
import fanglab.framework.ioc.handler.HandlerDecorator;

public abstract class AbstractBeanFactory implements IBeanFactory, Serializable {
	

	private static final long serialVersionUID = 1L;
	protected IDataContext beanDefinitionContext;//����������Ϣ�Ĵ洢��
    protected IDataContext beanCacheContext; //�����ṩ��ʵ���Ļ�����
    protected HandlerDecorator handlerDecorator;//ת������Ԫ���ݵ�����������Ϣ��

    //���÷���������Ϣ�Ĵ洢��
    public abstract void setBeanDefinitionContext(String beanDefinitionContextName, String resource);

    //���÷����ṩ��ʵ���Ļ�����
    public abstract void setBeanCacheContext(String beanCacheContextName);

    //����ת������Ԫ���ݵ�����������Ϣ��
    public abstract void setHandler(String defaultHandler, String handlerName);

    @Override
    //ģ�巽��
    //ע������������ʼ������������Ϣ
    public final void registerBeanDefinition(String resource, String cacheContext, String definitionContext, String defaultHandler, String customHandler) {

        this.setHandler(defaultHandler, customHandler);
        this.setBeanCacheContext(cacheContext);
        this.setBeanDefinitionContext(definitionContext, resource);
    }

    //----------�����ʼ��----------end-----


    //----------�����ṩ�ߵ���������-----begin--------

    //��ȡĳ�������ṩ�ߵķ���������Ϣ
    public abstract BeanEntity getBeanDefinition(String name);

    //���÷����ṩ�ߵ�ʵ���Ƿ��л���
    public abstract boolean containsBeanCache(String name);

    //�ӻ����л�ȡ�����ṩ�ߵ�ʵ��
    public abstract Object getBeanCache(String name);

    //���������ṩ��
    public abstract Object creatBean(BeanEntity beanEntity);

    //�������ṩ��ʵ��ע�ᵽ����
    public abstract Object regiterBeanCache(String name, Object obj);

    //----------�����ṩ�ߵ���������-----end--------

    @Override
    //ģ�巽��
    //��ȡ�����ṩ��ʵ��
    public final Object getBean(String name) {

        //��ȡĳ��Bean�Ķ���
        BeanEntity beanEntity = getBeanDefinition(name);

        //�ж����Bean�Ƿ��Ѿ����ص����棬����У�ֱ�ӷ���
        if (containsBeanCache(name)) {
            return getBeanCache(name);
        }

        //����bean��ʵ��
        Object beanObject = this.creatBean(beanEntity);

        //ע�ᵽ����
        regiterBeanCache(name, beanObject);

        //����bean��ʵ��
        return beanObject;
    }

    //��ȡ���еķ���������Ϣ
    public abstract IDataContext getBeanDefinitionContext();

    //��ȡ���еķ���ʵ��������Ϣ
    public abstract IDataContext getBeanCacheContext();


}
