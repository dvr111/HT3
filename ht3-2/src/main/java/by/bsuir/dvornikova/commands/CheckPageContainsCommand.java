package by.bsuir.dvornikova.commands;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class CheckPageContainsCommand implements TestCommand {

    private WebDriver driver;
    private String contains;

    @Override
    public void execute() throws AssertionError {
        if (!driver.getPageSource().contains(contains)) {
            String message = String.format("The page does not contain the given string (string: %s).", contains);
            throw new AssertionError(message);
        }
    }

    @Override
    public String toString() {
        return String.format("[checkPageContains \"%s\"]", contains);
    }

}
