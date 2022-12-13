package exercise;

// BEGIN
public class NegativeRadiusException extends Exception{
    private String errorCode;
    private String message;

    public NegativeRadiusException(String errorCode) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
// END
