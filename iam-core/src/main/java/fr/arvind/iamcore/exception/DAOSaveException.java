package fr.arvind.iamcore.exception;

public class DAOSaveException extends Exception {

	private String saveFault;
	
	public DAOSaveException(String message) {
		this.saveFault = message;
	}

	public String getSaveFault() {
		return saveFault;
	}


}
