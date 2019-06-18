package exceptions;

public class EmptySelectedAnswerException extends Exception {

    public EmptySelectedAnswerException() {
    }

    EmptySelectedAnswerException(String msg){
        super(msg);
    }
}
