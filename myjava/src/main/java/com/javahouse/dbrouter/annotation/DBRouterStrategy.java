package com.javahouse.dbrouter.annotation;

import java.lang.annotation.*;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:02
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouterStrategy {

    boolean splitTable() default false;

}
