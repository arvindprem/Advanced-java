/**
 * 
 */
package fr.arvind.iamcore.service.dao;

import java.util.Collection;
import java.util.List;

import fr.arvind.iam.user.User;
import fr.arvind.iamcore.datamodel.Identity;
import fr.arvind.iamcore.exception.DAOSaveException;
import fr.arvind.iamcore.exception.DAOSearchException;
import fr.arvind.iamcore.exception.DAOUpdateException;

/**
 * @author arvind
 *
 */
public interface IdentityDAOInterface {
	
	/**
	 * This method is able to save an identity into a file
	 * 
	 * @param identity
	 * @throws DAOSaveException 
	 */
	public void save(Identity identity) throws DAOSaveException;

	public Collection<Identity> search(Identity criteria)  throws DAOSearchException ;

	public void update(Identity identityToUpdate)  throws  DAOUpdateException;

	public void delete(Identity identityToDelete)  throws DAODeleteException;

	public void create(User user) throws DAOSaveException;
	
	public void deluser(User user) throws DAODeleteException;
	
	public void updateuser(User user) throws DAOUpdateException;
	
	public List userExistsinDB(User user);
	
	public List userLogin(User user);
}
