package by.bsuir.dvornikova.commands;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

@AllArgsConstructor
public class CheckLinkPresentByNameCommand implements TestCommand {

    private WebDriver driver;
    private String name;

    @Override
    public void execute() throws AssertionError {
        Collection<WebElement> webElements = driver.findElements(By.xpath(String.format("//*[text()='%s']", name)));

        if (webElements.isEmpty()) {
            String message = String.format("The link are not present (name: %s)", name);
            throw new AssertionError(message);
        }
    }

    @Override
    public String toString() {
        return String.format("[checkLinkPresentByName \"%s\"]", name);
    }

}
