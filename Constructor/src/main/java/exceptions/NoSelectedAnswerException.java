package exceptions;

public class NoSelectedAnswerException extends Exception {

    //This exception can be thrown when there is no selected answers

    public NoSelectedAnswerException() {
    }

    public NoSelectedAnswerException(String message) {
        super(message);
    }
}
