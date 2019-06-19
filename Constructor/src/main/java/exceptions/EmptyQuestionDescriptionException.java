package exceptions;

public class EmptyQuestionDescriptionException extends Exception{

    //This exception can be thrown when the question description isn't specified

    public EmptyQuestionDescriptionException() {
    }

    public EmptyQuestionDescriptionException(String message) {
        super(message);
    }
}
