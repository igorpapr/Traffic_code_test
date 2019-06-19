package exceptions;

public class EmptySelectedAnswerException extends Exception {

    //This exception can be thrown when the selected answer doesn't have any text

    public EmptySelectedAnswerException() {
    }

    EmptySelectedAnswerException(String msg){
        super(msg);
    }
}
