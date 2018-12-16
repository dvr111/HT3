package by.bsuir.dvornikova.commands;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class CheckPageTitleCommand implements TestCommand {

    private WebDriver driver;
    private String expectedTitle;

    @Override
    public void execute() throws AssertionError {
        String actualTitle = driver.getTitle();

        if (!actualTitle.equals(expectedTitle)) {
            String message = String.format("Expected title does not equals actual one (actual: %s, expected: %s).", actualTitle, expectedTitle);
            throw new AssertionError(message);
        }
    }

    @Override
    public String toString() {
        return String.format("[checkPageTitle \"%s\"]", expectedTitle);
    }
}
