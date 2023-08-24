package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class properties {
	  public String readdata(String key) throws FileNotFoundException {

	        FileInputStream fis = new FileInputStream(ConstantsUtility.PropertyFilePath);

	        Properties pObj = new Properties();

	        try {

	            

	            pObj.load(fis);

	            

	        } catch (IOException e) {

	            

	            e.printStackTrace();

	        }

	        String value = pObj.getProperty(key);

	        return value;

	}
}
