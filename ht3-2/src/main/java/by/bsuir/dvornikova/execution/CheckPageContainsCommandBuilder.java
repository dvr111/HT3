package by.bsuir.dvornikova.execution;

import by.bsuir.dvornikova.commands.CheckPageContainsCommand;
import by.bsuir.dvornikova.commands.TestCommand;
import org.openqa.selenium.WebDriver;

public class CheckPageContainsCommandBuilder implements by.bsuir.dvornikova.execution.CommandBuilder {

    @Override
    public TestCommand build(WebDriver driver, String[] params) {
        if (params.length < 1) throw new InvalidArgumentNumberException();
        return new CheckPageContainsCommand(driver, params[0]);
    }

}
