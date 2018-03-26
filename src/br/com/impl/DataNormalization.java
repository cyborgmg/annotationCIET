package br.com.impl;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.Validate;
import br.com.interfaces.Truncate;
import br.com.interfaces.UpperCase;

public class DataNormalization<T> {

    private T copy;
    //private T normalized;

    private DataNormalization(T object) {
        this.copy = (T) clone(object);
    }

    private T clone(T object)  {
        try {
            return (T) BeanUtils.cloneBean(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

    public static <T> DataNormalization<T> of(T object, Class<T> type) {
        Validate.notNull(object);
        Validate.notNull(type);
        return new DataNormalization<T>(object);
    }

    /**
     * @return return the normalized object.
     */
    public T value() {
        if (this.copy == null) {
            throw new IllegalStateException();
        }
        return this.copy;
    }

    /**
     * @return Execute the normalization according with the rules placed in the objects.
     */
    public DataNormalization<T> apply() {
        
    	final Class<?> classe = this.copy.getClass();
    	
    	final Field[] fields = classe.getDeclaredFields();
    	
    	for (final Field field : fields) {
    		
    		/******UPPERCASE****************************************************/
    		try {
    			if (field.isAnnotationPresent(UpperCase.class)) {    		
	    		
	    		    field.setAccessible(true);
	    		    final String valorDoAtributoUpper = (String) field.get(this.copy);
	    		    try {
	    		    	field.set(this.copy, valorDoAtributoUpper.toUpperCase());
	    		    } catch (final Exception e) {
	    		    	e.printStackTrace();
	    		    }
	    		
    	    	}
    		} catch (IllegalAccessException e) {
    		    e.printStackTrace();
    		}
    	    /*******************************************************************/
    		
    		/******TRUNC********************************************************/
    	    if (field.isAnnotationPresent(Truncate.class)) {
    			final Truncate annotation = field.getAnnotation(Truncate.class);
    			final int at = annotation.at();
    			try {
    			    field.setAccessible(true);
    			    final String valorDoAtributoTrunc = (String) field.get(this.copy);
    			    try {
    				field.set(this.copy, valorDoAtributoTrunc.substring(0, at));
    			    } catch (final Exception e) {
    			    	e.printStackTrace();
    			    }
    			} catch (IllegalAccessException e) {
    			    e.printStackTrace();
    			}
    		 }
    		/*******************************************************************/
    	    
    	}
        
        return this;
    }
}