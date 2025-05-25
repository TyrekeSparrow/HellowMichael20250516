package com.michael.hellomichael.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
//    public static final String TYPE_TEXT = "text";
//    public static final String TYPE_IMAGE = "image";
//    public static final String TYPE_BEAN = "bean";

//    String type();
//    String tag();
//    Class beanClass();


//    int[] ids() default {};
    String[] fields() default {};
    String[] tags() default {};




}
