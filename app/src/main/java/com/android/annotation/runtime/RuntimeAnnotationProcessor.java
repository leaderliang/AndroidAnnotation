package com.android.annotation.runtime;

import android.app.Activity;

import java.lang.reflect.Field;

/**
 * TODO 自定义注解处理器
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/06/06 13:13
 */
public class RuntimeAnnotationProcessor {

    /**
     *
     * 通过反射获取到当前 Activity 都有哪些字段，然后再判断每个字段是不是在使用 RuntimeBind 注解，
     * 如果使用了，则获取该注解的值，同时将该注解的值赋值给对应的字段就可以了
     * @param activity
     */
    public static void bindView(Activity activity) {
        if (activity == null) {
            return;
        }
        Field[] fields = activity.getClass().getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return;
        }
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(RuntimeBind.class)) {
                int resId = fields[i].getAnnotation(RuntimeBind.class).value();
                fields[i].setAccessible(true);
                try {
                    fields[i].set(activity, activity.findViewById(resId));
                    fields[i].setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    fields[i].setAccessible(false);
                }
            }
        }
    }
}