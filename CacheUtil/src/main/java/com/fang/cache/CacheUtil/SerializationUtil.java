package com.fang.cache.CacheUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {

	/**
	 * ���л���list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> byte[] writeObject(List<T> list){
		
			    if (list == null)
			      throw new NullPointerException("Can't serialize null");
			    
			    byte[] results = null;
			    ByteArrayOutputStream bos = null;
			    ObjectOutputStream os = null;
			    try {
			      bos = new ByteArrayOutputStream();
			      os = new ObjectOutputStream(bos);
			      for (T t : list) {
			        os.writeObject(t);
			      }
			      // os.writeObject(null);
			      os.close();
			      bos.close();
			      results = bos.toByteArray();
			    } catch (IOException e) {
			      throw new IllegalArgumentException("Non-serializable object", e);
			    } finally {
			      close(os);
			      close(bos);
			    }
			    
			    return results;
			  }
		
	/**
	 * @param �����л���list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> List<T> deserialize(byte[] in) {
	    List<T> list = new ArrayList<T>();
	    ByteArrayInputStream bis = null;
	    ObjectInputStream is = null;
	    try {
	      if (in != null) {
	        bis = new ByteArrayInputStream(in);
	        is = new ObjectInputStream(bis);
	        while (true) {
	          T m = (T)is.readObject();
	          if (m == null) {
	            break;
	          }
	          
	          list.add(m);
	          
	        }
	        is.close();
	        bis.close();
	      }
	    } catch (IOException e) {  
	    	
	  } catch (ClassNotFoundException e) {  
		  
	  }  finally {
	      close(is);
	      close(bis);
	    }
	    
	    return  list;
	  }
	
	/**
	 * 
	 * @param <T>
	 * @param ���л����� �Ǽ���
	 */
	public static  <T> byte[] writeObjectNonSet(T t){
		
	    if (t == null)
	      throw new NullPointerException("Can't serialize null");
	    
	    byte[] results = null;
	    ByteArrayOutputStream bos = null;
	    ObjectOutputStream os = null;
	    try {
	      bos = new ByteArrayOutputStream();
	      os = new ObjectOutputStream(bos);
	        os.writeObject(t);
	      // os.writeObject(null);
	      os.close();
	      bos.close();
	      results = bos.toByteArray();
	    } catch (IOException e) {
	      throw new IllegalArgumentException("Non-serializable object", e);
	    } finally {
	      close(os);
	      close(bos);
	    }
	    
	    return results;
	  }
	
	/**
	 * 
	 *  @param <T>�����л�  �Ǽ���
	 * @return 
	 * @return 
	 * 
	 */
	
	public static <T>  Object deserializeNonSet(byte[] in) {
	    ByteArrayInputStream bis = null;
	    ObjectInputStream is = null;
	    T m = null;
	    try {
	      if (in != null) {
	        bis = new ByteArrayInputStream(in);
	        is = new ObjectInputStream(bis);
	        while (true) {
	           m = (T)is.readObject();
	          if (m == null) {
	            break;
	          }
	          
	        }
	        is.close();
	        bis.close();
	      }
	    } catch (IOException e) {  
	    	
	  } catch (ClassNotFoundException e) {  
		  
	  }  finally {
	      close(is);
	      close(bis);
	    }
	    if(m == null){
	    	return null;
	    }
	    return  m;
	  }
	
	
	  	public static void close(Closeable closeable) {
		    if (closeable != null) {
		      try {
		        closeable.close();
		      } catch (Exception e) {
		    	  
		      }
		      
		    }
		 }
}
