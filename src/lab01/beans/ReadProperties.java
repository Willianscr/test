package lab01.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties connectionProps = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("d:/config.properties");
			// load a properties file
			connectionProps.load(input);

			// get the property value and print it out
			System.out.println(connectionProps.getProperty("database"));
			System.out.println(connectionProps.getProperty("dbuser"));
			System.out.println(connectionProps.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
