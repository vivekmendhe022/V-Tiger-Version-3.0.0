package generic.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Vivek M This class will read data from property file.
 */
public class PropertyFileUtility {

	/**
	 * This method will read data from property file.
	 * 
	 * @author Vivek M
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.PROPERTYFILEPATH);
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}
}
