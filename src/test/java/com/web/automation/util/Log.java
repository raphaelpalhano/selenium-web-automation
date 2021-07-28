package com.web.automation.util;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import com.web.automation.enums.LogType;

public class Log {
  private static final Logger logger = Logger.getLogger("");
  
  /**
   * Receive and show all execution logs
   * 
   * @param message
   *          Log message
   * @param type
   *          Log type
   */
	public static void sendLog(String message, LogType type) {
  	if(System.getProperty("saveConsoleAsTxt")!= null && System.getProperty("saveConsoleAsTxt").equalsIgnoreCase("true")){
//  		System.out.println(new Timestamp(System.currentTimeMillis()) + " - " + message);
  	}
    switch (type) {
      case ERROR:
        logger.error(message);
        break;
      case INFO:
        logger.info(message);
        break;
      case WARN:
        logger.warn(message);
        break;
      case FATAL:
        logger.fatal(message);
        break;
      case DEBUG:
        logger.debug(message);
        break;
      case TRACE:
        logger.trace(message);
        break;
    }
  }
}