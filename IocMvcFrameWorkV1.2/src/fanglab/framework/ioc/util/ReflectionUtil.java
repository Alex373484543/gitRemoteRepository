package fanglab.framework.ioc.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class ReflectionUtil {

    private ReflectionUtil() {
    }

    public static Object getInstance(String type){
        Object o=null;
        try {
            o=Class.forName(type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static Field[] getFields(Object obj){
        Field[] fields=obj.getClass().getDeclaredFields();

        return fields;
    }

    public static Method[] getMethods(Object obj){
        Method[] methods=obj.getClass().getDeclaredMethods();
        return methods;
    }

    public static Method getMethod(Object obj,String methodName){
        Method[] methods=obj.getClass().getDeclaredMethods();
        Method result=null;
        for(int i=0;i<methods.length;i++)
        {
            if(methodName.equals(methods[i].getName())){
                result=methods[i];
                break;
            }
        }

        return result;
    }

    /**
     * 执行某个方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invoke(Object obj,Method method,Object... args){
        Object result=null;

        try {
            result= method.invoke(obj,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }


}
