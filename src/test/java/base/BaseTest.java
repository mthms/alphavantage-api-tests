package base;

import com.payrails.helpers.ConfigHelper;
import com.payrails.models.Configs;
import com.payrails.models.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    private static final ThreadLocal<Logger> logger = new ThreadLocal<>();
    protected static final ThreadLocal<Configs> configs = new ThreadLocal<>();
    protected static final ThreadLocal<ConfigHelper> configHelper = new ThreadLocal<>();
    protected static final ThreadLocal<TestData> defaultTestData = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestResult result, Method method) {
        Reporter.log("Setup process for test: " + method.getName() + " has started...", true);
        MDC.put("testCase", method.getName());
        MDC.put("threadId", String.valueOf(Thread.currentThread().threadId()));
        logger.set(LoggerFactory.getLogger("BaseTest.class"));

        configs.set(new Configs());
        configHelper.set(new ConfigHelper());
        configs.set(configHelper.get().readConfigs(configs.get()));
        defaultTestData.set(new TestData());
    }
}
