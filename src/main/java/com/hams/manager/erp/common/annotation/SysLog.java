package com.hams.manager.erp.common.annotation;

import java.lang.annotation.*;


/**
 * 功能说明: 系统日志注解<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author lh<br>
 * 开发时间: 2020/4/12<br>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
