package utils;

import core.configuration.TestsConfig;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

public class LogHelper {
    private static Logger log = LogManager.getLogger("### "  + TestsConfig.getConfig().getProject());

    @Step("{0}")
    protected void logInfo(String comment) {
        log.info(comment + "\n");
    }

    @Step("{0}")
    protected static void logStep(String comment) {
        log.info("STEP: " + comment + "\n");
       // WebDriverFactory.saveAllureScreenshot();
    }
}
