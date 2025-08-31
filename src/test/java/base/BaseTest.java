package base;

import com.payrails.helpers.ConfigHelper;
import com.payrails.helpers.api.clients.SearchApiClient;
import com.payrails.models.Configs;
import com.payrails.models.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    protected static final ThreadLocal<Logger> logger = new ThreadLocal<>();
    protected static final ThreadLocal<Configs> configs = new ThreadLocal<>();
    protected static final ThreadLocal<ConfigHelper> configHelper = new ThreadLocal<>();
    protected static final ThreadLocal<TestData> defaultTestData = new ThreadLocal<>();

    protected static final ThreadLocal<SearchApiClient> searchApiClient = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestResult result, Method method) {
        logger.set(LoggerFactory.getLogger("BaseTest.class"));
        logger.get().info("Setup process for test: {} has started...", method.getName());
        MDC.put("testCase", method.getName());
        MDC.put("threadId", String.valueOf(Thread.currentThread().threadId()));

        configs.set(new Configs());
        configHelper.set(new ConfigHelper());
        configs.set(configHelper.get().readConfigs(configs.get()));
        defaultTestData.set(new TestData());

        searchApiClient.set(new SearchApiClient(configs.get()));
        logger.get().info("Setup process for test: {} has completed.", method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result, Method method) {
        if (result.isSuccess())
            logger.get().info("✅ Test {} has passed.", method.getName());
        else
            logger.get().info("❌ Test {} has failed.", method.getName());

        logger.get().info("Teardown process for test: {} is starting...", method.getName());

        MDC.clear();
        logger.remove();
        configs.remove();
        configHelper.remove();
        defaultTestData.remove();
        searchApiClient.remove();
    }
}
