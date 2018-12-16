package by.bsuir.dvornikova;

import lombok.Getter;

public class ExecutionReport {

    @Getter
    private long executionTimeInMillis;

    @Getter
    private boolean failed;

    public ExecutionReport(long executionTimeInMillis, boolean failed) {
        this.executionTimeInMillis = executionTimeInMillis;
        this.failed = failed;
    }

}
