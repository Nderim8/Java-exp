package phoneBook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONObject;



public class JSONUtils {
	
	// return a string that is a JSON
	public static String getJSONStringFromFile(String path){
		Scanner scanner;
		
		InputStream in = (InputStream) FileHandle.inputStreamFromFile(path);
		scanner = new Scanner(in);
		String json = scanner.useDelimiter("\\z").next();
		scanner.close();
		
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;

	}
	
	// generate an object using the string from the file 
	public static JSONObject getJSONObjectFromFile(String path){
		
		return new JSONObject();
		
	}
	
	public static boolean objectExists(JSONObject jsonObject, String key){
		
		Object o;
		
		try{
			
			o = jsonObject.get(key);
		}catch(Exception e){
			
			return false;
		}
		
		return o != null;
	}

	
	
	
	
	
	
	
	
}
