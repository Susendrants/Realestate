package com.realestate.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtils {
	/**
	 * This method is used to read data from property file
	 * @author SUSEE
	 * @param key
	 * @return
	 * @throws Throwable
	 */
           public String readDataFromPropertyFile(String key) throws Throwable
           {
        	  FileInputStream fis = new FileInputStream(IpathConstants.Filepath);
        	  Properties pLib =new Properties();
        	  pLib.load(fis);
        	  String value=pLib.getProperty(key);
        	  return value;
           }
}
