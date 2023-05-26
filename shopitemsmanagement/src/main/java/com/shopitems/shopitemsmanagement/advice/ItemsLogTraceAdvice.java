/*
package com.shopitems.shopitemsmanagement.advice;

import com.shopitems.shopitemsmanagement.message.ItemsLogTraceProducer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ItemsLogTraceAdvice {
    */
/*private ItemsLogTraceProducer itemsLogTraceProducer;

    @Autowired
    public void setItemsLogTraceProducer(ItemsLogTraceProducer itemsLogTraceProducer) {
        this.itemsLogTraceProducer = itemsLogTraceProducer;
    }*//*


   */
/* @Around(value = "execution(* com.shopitems.shopitemsmanagement..**(..))")
    public void logAPICallTrace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        *//*
*/
/*itemsLogTraceProducer.sendMessage("Call made to::{}" + proceedingJoinPoint.getSignature().getName() +
                " with parameter::{}" + proceedingJoinPoint.getArgs());*//*
*/
/*
        proceedingJoinPoint.proceed();

        *//*
*/
/*itemsLogTraceProducer.sendMessage("Call finished to::{}" + proceedingJoinPoint.getSignature().getName() +
                " with parameter::{}" + proceedingJoinPoint.getArgs());*//*
*/
/*
    }*//*



}
*/
