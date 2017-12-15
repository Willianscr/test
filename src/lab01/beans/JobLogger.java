package lab01.beans;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class JobLogger {

	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;
	private boolean initialized; //No se usa este atributo
	private static Map dbParams; //No lo considero en el desarrollo del codigo
	private static Logger logger;

	public JobLogger(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
			boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {
		logger = Logger.getLogger("MyLog");  
		logError = logErrorParam;
		logMessage = logMessageParam;
		logWarning = logWarningParam;
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = dbParamsMap;
	}
	

	public static void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
		messageText.trim();
		if (messageText == null || messageText.length() == 0) {
			return;
		}
		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new Exception("Invalid configuration");
		}
		if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
			throw new Exception("Error or Warning or Message must be specified");
		}

		Connection connection = null;
		Properties connectionProps = new Properties();
		
		// Leyendo datos del properties
		try {
			connectionProps.load(new FileReader("files/properties/config.properties"));
			System.out.println("userName = " + connectionProps.getProperty("userName"));
			System.out.println("password = " + connectionProps.getProperty("password"));

			Enumeration<Object> keys = connectionProps.keys();
			while (keys.hasMoreElements()) {
				Object key = keys.nextElement();
				System.out.println(key + " = " + connectionProps.get(key));
			}
		} catch (Exception e) {
			System.err.println("Error reading file " + e.getMessage());
		}
		// Leyendo datos del properties
		
//		connectionProps.put("user", dbParams.get("userName"));
//		connectionProps.put("password", dbParams.get("password"));

		/*connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
				+ ":" + dbParams.get("portNumber") + "/", connectionProps);*/
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + connectionProps.getProperty("serverName")
					+ ":" + connectionProps.getProperty("portNumber") + "/", 
					connectionProps.getProperty("userName"), connectionProps.getProperty("password"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		int t = 0;
		if (message && logMessage) {
			t = 1;
		}

		if (error && logError) {
			t = 2;
		}

		if (warning && logWarning) {
			t = 3;
		}

		Statement stmt = connection.createStatement();

		String l = null;
		File logFile = new File(connectionProps.getProperty("logFileFolder") + "/logFile.txt");
		if (!logFile.exists()) {
			logFile.createNewFile();
		}
		
		FileHandler fh = new FileHandler(connectionProps.getProperty("logFileFolder") + "/logFile.txt");
		ConsoleHandler ch = new ConsoleHandler();
		
		if (error && logError) {
			l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}

		if (warning && logWarning) {
			l = l + "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}

		if (message && logMessage) {
			l = l + "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
		}
		
		if(logToFile) {
			logger.addHandler(fh);
			// Fecha y hora de la excepción
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.log(Level.INFO, messageText);
		}
		
		if(logToConsole) {
			logger.addHandler(ch);
			logger.log(Level.INFO, messageText);
		}
		
		if(logToDatabase) {
			stmt.executeUpdate("insert into Log_Values('" + message + "', " + String.valueOf(t) + ")");
		}
	}

	
}
