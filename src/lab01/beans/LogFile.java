/**
 * 
 */
package lab01.beans;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Willians
 * 
 */
public class LogFile {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;

		try {
			// Estas lineas configuran el logger con handler and formatter
			fh = new FileHandler("D:/logs/MyLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// La siguiente sentencia es usada para registrar algunos mensajes
			logger.info("My first log");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Se terminó de ejecutar!");

	}

}
