/**
 * Created by tenpines on 23/10/15.
 */
public class VampireNumberException extends RuntimeException {
  public VampireNumberException(String message) {
    super(message);
  }

  public VampireNumberException(String message, Throwable cause) {
    super(message, cause);
  }

  public VampireNumberException(Throwable cause) {
    super(cause);
  }
}
