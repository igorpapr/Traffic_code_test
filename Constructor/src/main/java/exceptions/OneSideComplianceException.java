package exceptions;

public class OneSideComplianceException extends Exception {

    //This exception can be thrown when only one half of compliance is specified
    //or both are empty

    public OneSideComplianceException() {
    }

    public OneSideComplianceException(String message) {
        super(message);
    }
}
