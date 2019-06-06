package com.android.annotation.runtime;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/06 13:09
 */

@Target(ElementType.FIELD)
// RetentionPolicy.RUNTIME：表明这是一个运行时的注解，如果是编译时注解，则应该是 RetentionPolicy.CLASS
@Retention(RetentionPolicy.RUNTIME)
public @interface RuntimeBind {
    int value();
}
