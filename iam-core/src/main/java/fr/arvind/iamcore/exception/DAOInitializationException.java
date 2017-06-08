/**
 * 
 */
package fr.arvind.iamcore.exception;

/**
 * @author arvind
 *
 */
public class DAOInitializationException extends Exception {
	

	
	private String initializationFault;
	
	private DAOExceptionsMessages message;
	
	public DAOInitializationException(String message) {
		this.initializationFault =  message;
	}
	
	public DAOInitializationException(DAOExceptionsMessages message) {
		this.message =  message;
	}

	public String getInitializationFault() {
		return initializationFault;
	}

	
	
}
