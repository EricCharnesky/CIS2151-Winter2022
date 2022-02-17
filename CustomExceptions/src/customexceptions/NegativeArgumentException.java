
package customexceptions;

public class NegativeArgumentException extends IllegalArgumentException{

    public NegativeArgumentException() {
        // super() happens implicitly
    }

    public NegativeArgumentException(String message) {
        super(message);
    }

    public NegativeArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeArgumentException(Throwable cause) {
        super(cause);
    }
    
}
