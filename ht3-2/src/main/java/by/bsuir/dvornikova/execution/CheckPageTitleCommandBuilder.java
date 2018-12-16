package by.bsuir.dvornikova.execution;

import by.bsuir.dvornikova.commands.CheckPageTitleCommand;
import by.bsuir.dvornikova.commands.TestCommand;
import org.openqa.selenium.WebDriver;

public class CheckPageTitleCommandBuilder implements by.bsuir.dvornikova.execution.CommandBuilder {

    @Override
    public TestCommand build(WebDriver driver, String[] params) {
        if (params.length < 1) throw new InvalidArgumentNumberException();
        return new CheckPageTitleCommand(driver, params[0]);
    }

}
