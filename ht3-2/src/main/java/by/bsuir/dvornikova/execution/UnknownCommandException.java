package by.bsuir.dvornikova.execution;

public class UnknownCommandException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Unknown command found";
    }

}
