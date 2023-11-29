package com.realestate.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	public int getRandomNo()
	{
		Random ran=new Random();
		int random =ran.nextInt(1000);
		return random;
	}
	public String systemDate()
	{
		Date date = new Date();
		String systemdate=date.toString();
		return systemdate;
	}
	
	public String systemDateFormate()
	{
		SimpleDateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date =new Date();
		String systemDateInFormat = dateformate.format(date);
		return systemDateInFormat;
	}
}
