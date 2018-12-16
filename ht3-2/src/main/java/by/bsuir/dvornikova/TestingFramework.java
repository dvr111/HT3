package by.bsuir.dvornikova;

import by.bsuir.dvornikova.commands.TestCommand;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO add support of work with set of test scenarios
public class TestingFramework {

    private TestCaseReporter reporter;
    private CommandResolver resolver;

    private WebDriver driver;

    private File testScenarioFilePath;

    public TestingFramework(File testScenarioFilePath, File logFilePath) {
        this.testScenarioFilePath = testScenarioFilePath;

        reporter = new TestCaseReporter(logFilePath);
        resolver = new CommandResolver();
        driver = new HtmlUnitDriver(true);
    }

    public static void main(String args[]) throws FileNotFoundException {
        String testScenarioFilePath = args[0];
        String logFilePath = args[1];

        File testScenarioFile = new File(testScenarioFilePath);
        File logFile = new File(logFilePath);

        TestingFramework f = new TestingFramework(testScenarioFile, logFile);
        f.perform();
    }

    public void perform() throws FileNotFoundException {
        TestCase testCase = new TestCase(testScenarioFilePath);

        for (String instruction : testCase) {
            List<String> operands = Stream.of(instruction.split("\"")).map(String::trim).filter(it -> !it.isEmpty() && !it.equals(" ")).collect(Collectors.toList());
            String command = operands.get(0);
            String[] params = operands.subList(1, operands.size()).toArray(new String[]{});
            TestCommand testCommand = resolver.resolve(driver, command, params);
            reporter.add(testCommand);
        }

        reporter.report();
        driver.quit();
    }

}
