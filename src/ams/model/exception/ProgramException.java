/**
 * 
 */
package ams.model.exception;

/**
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class ProgramException extends AMSException {
	
	/**
	 * 
	 */
	public ProgramException() {
		super("Default Program Exception");
	}
	
	/**
	 * 
	 * @param message
	 */
	public ProgramException(String message) {
		super(message);
	}
}
