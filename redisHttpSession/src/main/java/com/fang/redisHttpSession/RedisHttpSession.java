package com.fang.redisHttpSession;



import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.fang.redisHttpSession.redis.RedisConnection;

/**
 * Created by xhans on 2016/4/27.
 */
public class RedisHttpSession implements HttpSession{

    public static final int DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS = 1800;

    public static final String SESSION_PREFIX = "session:";
    private static final String SESSION_ATTR = "sessionAttr:";
    private static final String CREATION_TIME = "creationTime";
    private static final String LAST_ACCESSED_TIME = "lastAccessedTime";
    private static final String MAX_INACTIVE_INTERVAL = "maxInactiveInterval";

    private String key;
    private String id;
    private long creationTime;
    private long lastAccessedTime;
    private int maxInactiveInterval;

    private ServletContext servletContext;

    private RedisConnection redisConnection;

    private RedisHttpSession(){}


    private RedisHttpSession(ServletContext servletContext, RedisConnection redisConnection) {
        this.servletContext = servletContext;
        this.redisConnection = redisConnection;
        id = UUID.randomUUID().toString();
        key = SESSION_PREFIX + id;
        creationTime = System.currentTimeMillis();
        lastAccessedTime = creationTime;
        maxInactiveInterval = DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS;
        //save to redis
        saveSession();
    }

    public static RedisHttpSession createNew(ServletContext servletContext, RedisConnection redisConnection){
        return new RedisHttpSession(servletContext, redisConnection);
    }

    public static RedisHttpSession createWithExistSession(String token, ServletContext servletContext, RedisConnection redisConnection){
        RedisHttpSession redisHttpSession= new RedisHttpSession();
        redisHttpSession.setId(token);
        redisHttpSession.setKey(SESSION_PREFIX + token);
        redisHttpSession.setServletContext(servletContext);
        redisHttpSession.setRedisConnection(redisConnection);

        return redisHttpSession;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    
    public long getCreationTime() {
        return (Long) redisConnection.hget(key, CREATION_TIME);
    }

   
    public String getId() {
        return id;
    }

   
    public long getLastAccessedTime() {
        return (Long) redisConnection.hget(key, LAST_ACCESSED_TIME);
    }

    
    public ServletContext getServletContext() {
        return servletContext;
    }

   
    public void setMaxInactiveInterval(int interval) {
        redisConnection.hset(key, MAX_INACTIVE_INTERVAL, interval);
    }

   
    public int getMaxInactiveInterval() {
        return (Integer) redisConnection.hget(key, MAX_INACTIVE_INTERVAL);
    }

  
    public HttpSessionContext getSessionContext() {
        return null;
    }

   
    public Object getAttribute(String name) {
        return redisConnection.hget(key, SESSION_ATTR + name);
    }

   
    public Object getValue(String name) {
        return getAttribute(name);
    }

   
    public Enumeration<String> getAttributeNames() {
        return Collections.enumeration(getAttributeKeys());
    }

    private Set<String> getAttributeKeys(){
        Set<String> keys = redisConnection.hkeys(key);
        Set<String> attrNames = new HashSet<String>();
        for (String key : keys){
            if (key.startsWith(SESSION_ATTR)){
                attrNames.add(key.substring(SESSION_ATTR.length()));
            }
        }
        return attrNames;
    }


  
    public String[] getValueNames() {
        return getAttributeKeys().toArray(new String[0]);
    }

   
    public void setAttribute(String name, Object value) {
        redisConnection.hset(key, SESSION_ATTR + name, (Serializable) value);
    }

   
    public void putValue(String name, Object value) {
        setAttribute(name, value);
    }

   
    public void removeAttribute(String name) {
        redisConnection.hdel(key, name);
    }

   
    public void removeValue(String name) {
        removeAttribute(name);
    }

   
    public void invalidate() {
        redisConnection.del(key);
    }

   
    public boolean isNew() {
        return false;
    }

    private void saveSession(){
        redisConnection.hset(key, LAST_ACCESSED_TIME, lastAccessedTime);
        redisConnection.hset(key, CREATION_TIME, creationTime);
        redisConnection.hset(key, MAX_INACTIVE_INTERVAL, maxInactiveInterval);
        refresh();
    }

    /**
     * update expire time
     */
    public void refresh(){
        redisConnection.expire(key, getMaxInactiveInterval());
    }

    public RedisConnection getRedisConnection() {
        return redisConnection;
    }

    public void setRedisConnection(RedisConnection redisConnection) {
        this.redisConnection = redisConnection;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        redisConnection.hset(key, LAST_ACCESSED_TIME, lastAccessedTime);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isInvalidated() {
        return !redisConnection.exists(key);
    }

}
