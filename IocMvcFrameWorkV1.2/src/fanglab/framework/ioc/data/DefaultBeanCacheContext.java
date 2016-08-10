package fanglab.framework.ioc.data;

import java.util.HashMap;
import java.util.Map;


public class DefaultBeanCacheContext implements IDataContext{
    private Map<String,Object> beanCacheMap;
    @Override
    public void initData(Map<String, Object> map) {
        beanCacheMap=new HashMap<String, Object>();
    }

    @Override
    public void set(String name, Object obj) {

        beanCacheMap.put(name,obj);
    }

    @Override
    public Object get(String name) {
        return beanCacheMap.get(name);
    }

    @Override
    public Map<String, Object> getAll() {
        return beanCacheMap;
    }
}
