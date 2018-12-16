package by.bsuir.dvornikova.execution;

import by.bsuir.dvornikova.commands.OpenCommand;
import by.bsuir.dvornikova.commands.TestCommand;
import org.openqa.selenium.WebDriver;

public class OpenCommandBuilder implements by.bsuir.dvornikova.execution.CommandBuilder {

    @Override
    public TestCommand build(WebDriver driver, String[] params) {
        if (params.length < 2) throw new InvalidArgumentNumberException();
        return new OpenCommand(driver, params[0], Integer.parseInt(params[1]));
    }

}
