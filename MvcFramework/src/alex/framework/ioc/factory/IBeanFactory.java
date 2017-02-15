package alex.framework.ioc.factory;

public interface IBeanFactory {
	
	 /**
     * ���ݷ����ṩ�ߵ����ֻ�ȡ�����ṩ�ߵ�ʵ��
     * @param name �����ṩ�ߵ�����
     * @return �����ṩ�ߵ�ʵ��
     */
    public  Object getBean(String name);
    
    
    /**
     * ��ʼ��������ע�����
     * @param resource  Ĭ��Ԫ���ݵ�λ�ã�ʵ����һ������·�����������Զ���
     * @param definitionContext Ĭ�Ϸ���������Ϣ�Ĵ洢��������Jndi���������Զ���
     * @param defaultHandler Ĭ�ϴ����������𽫡�Ԫ���ݡ�ת��Ϊ������������Ϣ�������ܱ��滻����������ǰ�ۼ��Զ��崦����
     * @param customHandler  �Զ��崦��������ʹ��Ĭ�ϴ���������Ԫ���ݣ�Ȼ����ʹ���Զ��崦����
     */

    public  void registerBeanDefinition(String resource, String cacheContext,  String definitionContext, String defaultHandler, String customHandler);

}
