package com.fang.cache.CacheUtil;


import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Inherited;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
@Documented //文档  
@Retention(RetentionPolicy.RUNTIME) //在运行时可以获取  
@Target({ ElementType.TYPE, ElementType.METHOD}) //作用到类，方法，接口上等  
@Inherited //子类会继承  
public @interface Cacheable {  
      
    public String type() default ""; //使用的时候 @EncableCache(type="xxx")  
    public String key() default ""; //使用的时候 @EncableCache(key="xxx")
//    public String time() default "";//过期时间，木有想好该怎么使用，ehcache是写到配置文件里面的,redis也可以把整个key的配置写到配置文件里面，然后通过读配置文件实现
  
}