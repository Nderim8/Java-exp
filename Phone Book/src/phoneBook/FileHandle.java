package phoneBook;

import java.io.InputStream;
import java.util.logging.FileHandler;

public class FileHandle {
	
	public static InputStream inputStreamFromFile(String path){
		
		try{
			
			InputStream inputStream = FileHandler.class.getResourceAsStream(path);
			return inputStream;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return null;
		
	}

}
