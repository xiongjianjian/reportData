package com.sapdata.admin.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * @Author: wuhonghui
 * @Description:通过AOP实现对数据源的自动切换，AOP是Spring的核心。通过AspectJ框架实现对AOP的操作
 * @Date: 2019/11/9 14:32
 * @Modified: wuhonghui
 **/
@Component
@Aspect
public class OracleServiceAspect {
    /**
     * @Author: wuhonghui
     * @Description: 进入切点方法之前（切点是专业术语，在本文中就是你要切换数据源的的方法
     * 切换数据源，当一个工程中两个数据源时可以对不常用的数据源写死，因为工程中必定有一个主数据源，当超过两个以上的数据源时可以通过传参的形式到该方法中
     * @Date: 2019/11/9 15:27
     * @Modified: wuhonghui
     **/
    @Before("execution(* com.sapdata.admin.oracleService.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        DynamicDataSource.setCustomerDBType(DynamicDataSource.oracleDataSource);
    }
    /**
     * @Author: wuhonghui
     * @Description: 当退出切点方法之后，关闭所切换额数据源
     * @Date: 2019/11/9 15:27
     * @Modified: wuhonghui
     **/
    @After("execution(* com.sapdata.admin.oracleService.impl.*.*(..))")
    public void after(JoinPoint joinPoint) {
        DynamicDataSource.clearCustomerDBType();
    }
    /**
     * @Author: wuhonghui
     * @Description: 针对当前拦截的切点方法中出现异常时所做的处理
     * @Date: 2019/11/9 15:27
     * @Modified: wuhonghui
     **/
    @AfterThrowing(pointcut = "execution(* com.sapdata.admin.oracleService.impl.*.*(..))", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        DynamicDataSource.clearCustomerDBType();
    }

}
