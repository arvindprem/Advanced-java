/**
 * 
 */
package fr.arvind.junit.tests;

import org.junit.Test;

import fr.arvind.iam.log.IAMLogger;
import fr.arvind.iam.log.impl.IAMLogManager;

/**
 * @author arvind
 *
 */
public class TestIAMLogger {
	
	private static final IAMLogger logger = IAMLogManager.getIAMLogger(TestIAMLogger.class);
	
	
	@Test
	public void testIamLogger(){
		logger.info("test");
	}

}
