package by.bsuir.dvornikova;

import by.bsuir.dvornikova.commands.TestCommand;
import lombok.Setter;

public class CommandInvoker {

    @Setter
    private TestCommand command;

    public ExecutionReport executeCommand() {
        long startTime = System.currentTimeMillis();
        boolean failed = false;

        try {
            command.execute();
        } catch (Throwable e) {
            e.printStackTrace();
            failed = true;
            //TODO add the fail reason
        }

        long endTime = System.currentTimeMillis();

        return new ExecutionReport(endTime - startTime, failed);
    }

}
