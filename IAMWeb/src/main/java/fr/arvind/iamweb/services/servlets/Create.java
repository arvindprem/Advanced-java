package fr.arvind.iamweb.services.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.arvind.iamcore.datamodel.Identity;
import fr.arvind.iamcore.logger.LogManager;
import fr.arvind.iamcore.services.dao.impl.IdentityHibernateDAO;


/**
 * Servlet implementation class for Creating new Identity
 * @author arvind
 * @version 1.0
 */
@SuppressWarnings("serial")
@WebServlet("/Create")
public class Create extends GeneralServlet {
	

	@Autowired
	@Qualifier("hibernateDAO")
	private IdentityHibernateDAO hibernateDAO;
	
	/**
	 * setting IdentityHibernateDAO
	 * @param hibernateDAO - IdentityHibernateDAO
	 */
	public void setHibernateDAO(IdentityHibernateDAO hibernateDAO) {
		this.hibernateDAO = hibernateDAO;
	}

	/**
     * Default constructor. 
     */
    public Create() {
    	super();
    	 // The explicit constructor is here, so that it is possible to provide Javadoc.
    }

	/**
	 * @see Create#doGet(HttpServletRequest request, 
	 * HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// currently not implementing the GET method
	}

	/**
	 * @see Create#doPost(HttpServletRequest request,
	 *  HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		String resString ="Identity Succesfully Created";
		try
		{
			StringBuffer buffReq = new StringBuffer();
			String line = null;
			BufferedReader reader = request.getReader();
			//Read Identity details from Http request and parse to object
			while ((line = reader.readLine()) != null)
				buffReq.append(line);
			
			final Identity idObj = new ObjectMapper().readValue(buffReq.toString(), Identity.class);
			HttpSession session = request.getSession();
			final Object loginSts = session.getAttribute("logon.isDone");
			final boolean bloginSts = loginSts == null? false:(boolean)loginSts;
			if( bloginSts )
			{
				hibernateDAO.write(idObj);
			}
			else
			{
				resString ="Error : Unauthorized access. Please login with valid credentail to create an Identity";
				LogManager.log("Unauthorized access. Please login with valid credentail to create an Identity", this.getClass(), Level.ERROR);
			}
			

		}
		catch(Exception exp )
		{
			resString = "Error while creating Identity Please contact Administator";
			LogManager.log(exp.getMessage() , this.getClass(), Level.ERROR);
		}
		finally
		{
			out.write(resString);
			out.flush();
			out.close();
		}
	}
}
