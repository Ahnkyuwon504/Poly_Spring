package kr.ac.kopo20.perfect.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	//private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	// annotation이 실행 조건... return값 필요없고 메소드 값이 Aop로 끝나면 이 조건을 만족함.
	// 그럼 sysout되는 것..
	@Before("execution(* kr.ac.kopo20.perfect.board.service.*.*Aop(..))")
	public void onBeforeHandler(JoinPoint joinPoint) {
		System.out.println("================= onBeforeThing");
	}
	
	@After("execution(* kr.ac.kopo20.perfect.board.service.*.*Aop(..))")
	public void onAfterHandler(JoinPoint joinpoint) {
		System.out.println("================= onAfterHandler");
	}
	
	/*
	@Around("execution(* kr.ac.kopo20.perfect.board.service.*.*Aop(..))")
	public void onAroundHandler(JoinPoint joinpoint) {
		System.out.println("================= onAroundHandler");
		
	}
	
	*/
	/*
	@AfterReturning(pointcut = "execution(* kr.ac.kopo20.perfect.board.service.*.*Aop(..))")
	public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
		System.out.println("@AfterReturning : " + str);
		System.out.println("================= onAfterReturningHandler");
	}
	
	@Pointcut("execution(* kr.ac.kopo20.perfect.board.service.*.*Aop(..))")
	public void onPointcut(JoinPoint joinPoint) {
		System.out.println("================= onBeforeThing");
	}
	*/
	
	

}
