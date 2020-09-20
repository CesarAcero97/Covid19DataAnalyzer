package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

public class Utilities {

	
	public static Properties generateProperties( String pathFile ) throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream(pathFile);
		properties.load( input );
		return properties;
	}
	
	public static void saveProperties( Properties properties, String pathFile ) throws IOException{
		FileOutputStream output = new FileOutputStream(pathFile);
		properties.store(output, null);
		output.close();
	}

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}
}
