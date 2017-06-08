/**
 * 
 */
package fr.arvind.iamcore.service.dao;

import fr.arvind.iamcore.exception.DAOInitializationException;

/**
 * @author arvind
 *
 */
public class IdentityDAOFactory {
	
	
	public static IdentityDAOInterface getIdentityDAO() throws DAOInitializationException{
		return IdentityJDBCDAO.getInstance();
	}

}
