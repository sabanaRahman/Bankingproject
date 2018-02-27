package utilities;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;



public class CaptureLogs {

	public static Logger autoLogs(String TestName) {

		Logger logger=Logger.getLogger(TestName);
		PropertyConfigurator.configure("Log4j.properties");
	
	
	return logger;
	
	}






}
