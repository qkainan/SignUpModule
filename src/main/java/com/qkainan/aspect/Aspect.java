package com.qkainan.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("execution(* com.qkainan.service.*.*(..))")
    public void pt01(){

    }

    @Pointcut("execution(* com.qkainan.service.*.*(..))")
    public void pt02(){

    }

    //    用Pointcut注解中的属性来指定对哪些方法进行增强
    @Pointcut("@annotation(com.qkainan.aspect.InvokeLog)")
    public void pt03(){

    }

//    @Before("pt01()")
//    public void methodBefore(){
//        System.out.println("Method is called");
//    }
//
//    @AfterReturning(value = "pt03()", returning = "ret")
//    public void toOKJSP(JoinPoint joinPoint, Object ret){
//
//    }


//    @Around(value = "pt03()")
//    public Object around(ProceedingJoinPoint pjp) {
//        Object[] args = pjp.getArgs();//方法调用时传入的参数
//        Object target = pjp.getTarget();//被代理对象
//        MethodSignature signature = (MethodSignature) pjp.getSignature();//获取被被增强方法签名封装的对象
//        Object ret = null;
//        try {
//            ret = pjp.proceed();//ret就是目标方法执行后的返回值
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();//throwable就是出现异常时的异常对象
//        }
//        return ret;
//    }
    @RequestMapping("/success")
    @AfterReturning("pt03()")
    public String toSuccess(){
        return "redirect:/success.jsp";
    }

}
