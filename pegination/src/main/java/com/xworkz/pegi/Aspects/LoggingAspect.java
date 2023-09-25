package com.xworkz.pegi.Aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

	// Join Point
	@Before("execution(* com.xworkz.pegi.controller.**.**(..))")
	// @Before("execution(* com.xworkz.pegi.service.CarserviceImpli.findAll(..))")
	// @Repeatable("execution(* com.xworkz.pegi.service"))
	public void logBefore(JoinPoint joinPoint) {
		log.info("Running in before loging 1");
		log.info("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
	}

	@Before("execution(* com.xworkz.pegi.service.CarserviceImpli.onsave(..))")
	public void logerBefore(JoinPoint joinPoint) {
		log.info("Running in before loging in service 2 ");
		log.info("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

	}

	@After("execution(* com.xworkz.pegi.controller.CarController.onSave(..))")
	public void logafter(JoinPoint joinPoint) {
		log.info("Running in After loging");
		log.info("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

	}

	@AfterReturning(pointcut = "execution(* com.xworkz.pegi.controller.CarController.onSave(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		log.info("Running  AfterReturn loging");
		System.err.println("Hi Suhas");
		log.info("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

	}

}
