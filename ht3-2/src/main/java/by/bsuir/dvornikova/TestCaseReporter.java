package by.bsuir.dvornikova;

import by.bsuir.dvornikova.commands.TestCommand;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TestCaseReporter {

    private int total;
    private int passed;
    private int failed;

    private long totalExecutionTimeInMillis;

    private CommandInvoker commandInvoker;

    private List<String> reportLines;

    private File logFile;

    public TestCaseReporter(File logFile) {
        this.logFile = logFile;
        commandInvoker = new CommandInvoker();
        reportLines = new LinkedList<>();
    }

    public void add(TestCommand command) {
        commandInvoker.setCommand(command);
        ExecutionReport executionReport = commandInvoker.executeCommand();

        total++;
        totalExecutionTimeInMillis += executionReport.getExecutionTimeInMillis();
        if (!executionReport.isFailed()) {
            failed++;
        } else {
            passed++;
        }

        reportLines.add(buildReportLine(executionReport, command));
    }

    private String buildReportLine(ExecutionReport report, TestCommand command) {
        StringBuilder sb = new StringBuilder();

        if (!report.isFailed()) {
            sb.append("+ ");
        } else {
            sb.append("! ");
        }

        sb.append(command.toString());
        sb.append(" ");
        sb.append((double) report.getExecutionTimeInMillis() / 1000);

        return sb.toString();
    }

    public void report() {
        String testTotal = "Total tests: " + total;
        String passedAndFailed = "Passed/Failed: " + passed + "/" + failed;
        String totalExecutionTime = String.format("Total time: %.3f", (double) totalExecutionTimeInMillis / 1000);
        String averageExecutionTime = String.format("Average time: %.3f", ((double) totalExecutionTimeInMillis / 1000) / total);

        try (FileWriter fw = new FileWriter(logFile)) {
            for (String line : reportLines) {
                fw.write(line);
                fw.append('\n');
            }
            fw.write(testTotal);
            fw.append('\n');
            fw.write(passedAndFailed);
            fw.append('\n');
            fw.write(totalExecutionTime);
            fw.append('\n');
            fw.write(averageExecutionTime);
            fw.append('\n');
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        reportLines.forEach(System.out::println);
        System.out.println(testTotal);
        System.out.println(passedAndFailed);
        System.out.println(totalExecutionTime);
        System.out.println(averageExecutionTime);
    }

}
