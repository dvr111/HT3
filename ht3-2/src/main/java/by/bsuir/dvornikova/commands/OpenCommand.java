package by.bsuir.dvornikova.commands;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class OpenCommand implements TestCommand {

    private WebDriver driver;
    private String address;
    private int timeout;

    public void execute() {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.navigate().to(address);
    }

    @Override
    public String toString() {
        return String.format("[open \"%s\" \"%d\"]", address, timeout);
    }
}
