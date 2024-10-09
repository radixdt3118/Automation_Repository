package Get_Data_From_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Get_From_Properties extends CRUD_From_Excel{

	//Get XPath from properties file
	public static String getXPath(String key,File file) throws IOException {
		
		String xpath_value = null;
		FileInputStream file_i = new FileInputStream(file);	
		Properties obj = new Properties();
		obj.load(file_i);
		xpath_value = obj.getProperty(key);	
		return xpath_value;
	}
	
}
