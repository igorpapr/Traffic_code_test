package exceptions;

public class NoSelectedAnswerException extends Exception {

    public NoSelectedAnswerException() {
    }

    public NoSelectedAnswerException(String message) {
        super(message);
    }
}
