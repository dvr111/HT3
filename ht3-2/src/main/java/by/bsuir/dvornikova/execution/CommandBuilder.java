package by.bsuir.dvornikova.execution;

import by.bsuir.dvornikova.commands.TestCommand;
import org.openqa.selenium.WebDriver;

public interface CommandBuilder {

    TestCommand build(WebDriver driver, String params[]);

}
