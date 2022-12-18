package com.javahouse.dbrouter.annotation;

import java.lang.annotation.*;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 08:59
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouter {

    String key() default "";

}
