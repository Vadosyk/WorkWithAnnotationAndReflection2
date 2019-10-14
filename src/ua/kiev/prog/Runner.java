package ua.kiev.prog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public static String Run(Class<?>... cls) {

        StringBuffer sb = new StringBuffer();

        for (Class<?> cl : cls) {
            for (Method method : cl.getDeclaredMethods()) {
                if (method.getAnnotationsByType(AnnFolder.class) != null) {
                    try {
                        Object obj = cl.newInstance();
                        for (AnnFolder annotation : method.getAnnotationsByType(AnnFolder.class)) {
                            method.invoke(obj, annotation.paramFolder(), annotation.methodName());
                        }
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        sb.append("END PROGRAM");

        return sb.toString();
    }
}


