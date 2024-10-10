package Get_Data_From_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
	public static String[] getKEYS(File file) throws IOException {
		
		String xpath_value = null;
		FileInputStream file_i = new FileInputStream(file);	
		Properties obj = new Properties();
		obj.load(file_i);
		
		Object[] list_obj=obj.keySet().toArray();
		return Arrays.copyOf(list_obj, list_obj.length,String[].class);
	}
	
	public static void main(String[] args) throws IOException {
        HashMap<String, String> orderedKeys = new LinkedHashMap<String, String>();

		File file= new File("src/test/resources/xpaths_store.properties");
		
		String xpath_value = null;
		FileInputStream file_i = new FileInputStream(file);	
		Properties obj = new Properties();
		obj.load(file_i);
		
		Object[] list_obj=obj.keySet().toArray();
		for (Object key : obj.stringPropertyNames()) {
			System.out.println(key.toString());
		}
		
		
	}

	
}
