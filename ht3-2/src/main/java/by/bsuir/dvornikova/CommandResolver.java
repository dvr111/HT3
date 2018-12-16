package by.bsuir.dvornikova;

import by.bsuir.dvornikova.commands.TestCommand;
import by.bsuir.dvornikova.execution.*;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommandResolver {

    private HashMap<String, CommandBuilder> builders;

    public CommandResolver() {
        builders = new LinkedHashMap<>();

        builders.put("open", new OpenCommandBuilder());
        builders.put("checkpagetitle", new CheckPageTitleCommandBuilder());
        builders.put("checkpagecontains", new CheckPageContainsCommandBuilder());
        builders.put("checklinkpresentbyhref", new CheckLinkPresentByHrefCommandBuilder());
        builders.put("checklinkpresentbyname", new CheckLinkPresentByNameCommandBuilder());
    }

    public TestCommand resolve(WebDriver driver, String instruction, String... params) {
        instruction = instruction.toLowerCase();
        if (!builders.containsKey(instruction)) throw new UnknownCommandException();
        return builders.get(instruction).build(driver, params);
    }

}
