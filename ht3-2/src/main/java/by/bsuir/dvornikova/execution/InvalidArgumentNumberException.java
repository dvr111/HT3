package by.bsuir.dvornikova.execution;

public class InvalidArgumentNumberException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Invalid number of command arguments received";
    }

}
