package by.bsuir.dvornikova.execution;

import by.bsuir.dvornikova.commands.CheckLinkPresentByHrefCommand;
import by.bsuir.dvornikova.commands.TestCommand;
import org.openqa.selenium.WebDriver;

public class CheckLinkPresentByHrefCommandBuilder implements CommandBuilder {

    @Override
    public TestCommand build(WebDriver driver, String[] params) {
        if (params.length < 1) throw new InvalidArgumentNumberException();
        return new CheckLinkPresentByHrefCommand(driver, params[0]);
    }

}
