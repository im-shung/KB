package spring.aop.anno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAdvice {
    private Log log = LogFactory.getLog(getClass());

    // target 메소드 리턴타입이 String이고 spring 패키지아래에 있는 모든 패키지 중에서
    // Product로 시작하는 클래스의 delete로 시작하는 메소드(인자값 1개 이상)에 JoinPoint
    @Around("execution(public String spring..Product*.delete*(..))")
    public void logPush(ProceedingJoinPoint pjp) throws Throwable {
        log.info("check...before....logging");

        Object ret = pjp.proceed();
        System.out.println("target method return " + ret);

        log.info("\ncheck.....after...login....");
    }
}