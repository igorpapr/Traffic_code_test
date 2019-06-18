package exceptions;

public class EmptyQuestionDescriptionException extends Exception{

    public EmptyQuestionDescriptionException() {
    }

    public EmptyQuestionDescriptionException(String message) {
        super(message);
    }
}
