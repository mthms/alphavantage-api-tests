package com.payrails.helpers;

import org.testng.ITestResult;
import org.testng.Reporter;

public class ReporterUtil {
    public static void log(String message, ITestResult result) {
        String context = result.getTestClass().getRealClass().getSimpleName()
                + "." + result.getMethod().getMethodName();
        Reporter.log("[" + context + "] " + message, true);
    }
}
