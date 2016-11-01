package com.pr.gfce.util;

import java.util.Set;
import org.reflections.Reflections;

/**
 *
 * @author Oscar Blancarte
 */
public class ReflectionUtil {
    
    public static Set<Class<?>> getAllAnotateClass(Class clazz){
        Reflections reflections = new Reflections();
        return reflections.getTypesAnnotatedWith(clazz);
        
    }
}
