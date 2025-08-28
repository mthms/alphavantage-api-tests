package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    private static final ThreadLocal<Logger> logger = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestResult result, Method method) {
        Reporter.log("Setup process for test: " + method.getName() + " has started...", true);
        MDC.put("testCase", method.getName());
        MDC.put("threadId", String.valueOf(Thread.currentThread().threadId()));
        logger.set(LoggerFactory.getLogger("BaseTest.class"));

    }
}
