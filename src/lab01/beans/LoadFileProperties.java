package lab01.beans;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.Properties;

public class LoadFileProperties {

	public static void main(String[] args) {
		Properties connectionProps = new Properties();
		try {
			connectionProps.load(new FileReader("files/properties/config.properties"));
			System.out.println("userName = " + connectionProps.getProperty("userName"));
			System.out.println("password = " + connectionProps.getProperty("password"));

			Enumeration<Object> keys = connectionProps.keys();
			while (keys.hasMoreElements()) {
				Object key = keys.nextElement();
				System.out.println(key + " = " + connectionProps.get(key));
			}
//			p.setProperty("cuatro", "4");
//			p.store(new FileWriter("target/out.properties"), "Some comment");
		} catch (Exception e) {
			System.err.println("Error reading file " + e.getMessage());
		}
	}
}
