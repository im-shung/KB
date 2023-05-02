package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {
    private Log log = LogFactory.getLog(getClass());

    public void logPush(ProceedingJoinPoint pjp) throws Throwable {
        log.info("check...before....logging");
        pjp.proceed(); // target으로 위빙되는 시점
        log.info("check...after....logging");

        Object ret = pjp.proceed();
        System.out.println("target method return " + ret);

        log.info("\ncheck.....after...login....");
    }
}