package af.cmr.indyli.akademia.business.exception;

public class AkdemiaBusinessException extends Exception {
	public AkdemiaBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public AkdemiaBusinessException(String message) {

		super(message);
	}
}
