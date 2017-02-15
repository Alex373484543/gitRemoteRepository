package alex.framework.ioc.factory;

import alex.framework.ioc.data.IDataContext;
import alex.framework.ioc.entity.BeanEntity;

public abstract class AbstractBeanFactory implements IBeanFactory {
	
	protected IDataContext beanDefinitionContext;//����������Ϣ�Ĵ洢��
    protected IDataContext beanCacheContext; //�����ṩ��ʵ���Ļ�����
   
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
    

    //���÷���������Ϣ�Ĵ洢��
    public abstract void setBeanDefinitionContext(String beanDefinitionContextName, String resource);
    
    //���÷����ṩ��ʵ���Ļ�����
    public abstract void setBeanCacheContext(String beanCacheContextName);

    //����ת������Ԫ���ݵ�����������Ϣ��
    public abstract void setHandler(String defaultHandler, String handlerName);
    

	@Override
	public Object getBean(String name) {
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

	@Override
	public void registerBeanDefinition(String resource, String cacheContext, 
			String definitionContext, String defaultHandler,
			String customHandler) {
		  this.setHandler(defaultHandler, customHandler);
	        this.setBeanCacheContext(cacheContext);
	        this.setBeanDefinitionContext(definitionContext, resource);
	}

}
