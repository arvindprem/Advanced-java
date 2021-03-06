/**
 * 
 */
package fr.arvind.iam.log.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import fr.arvind.iam.log.IAMLogger;

/**
 * @author arvind
 *
 */
public class IAMLogManager {
	
	private static final Logger logger = LogManager.getLogger(IAMLogManager.class);
	
	

	public static IAMLogger getIAMLogger(Class<?> clazz){
		LoggerContext context = (LoggerContext) LogManager.getContext(clazz.getClassLoader(), false);
		return new IAMLoggerLog4j2Impl(context, clazz.getName(), logger.getMessageFactory());
	}

}
