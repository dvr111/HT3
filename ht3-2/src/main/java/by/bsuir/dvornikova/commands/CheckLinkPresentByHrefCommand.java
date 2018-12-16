package by.bsuir.dvornikova.commands;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

@AllArgsConstructor
public class CheckLinkPresentByHrefCommand implements TestCommand {

    private WebDriver driver;
    private String href;

    @Override
    public void execute() throws AssertionError {
        Collection<WebElement> webElements = driver.findElements(By.xpath(String.format("//a[@href='%s']", href)));

        if (webElements.isEmpty()) {
            String message = String.format("The link are not present (href: %s)", href);
            throw new AssertionError(message);
        }
    }

    @Override
    public String toString() {
        return String.format("[checkLinkPresentByHref \"%s\"]", href);
    }

}
