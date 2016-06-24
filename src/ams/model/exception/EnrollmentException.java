/**
 * 
 */
package ams.model.exception;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class EnrollmentException extends AMSException {
	
	/**
	 * 
	 */
	public EnrollmentException() {
		super("Default Enrollment Exception");
	}
	
	/**
	 * 
	 * @param message
	 */
	public EnrollmentException(String message) {
		super(message);
	}
}
