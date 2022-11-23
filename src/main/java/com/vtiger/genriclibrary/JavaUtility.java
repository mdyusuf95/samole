package com.vtiger.genriclibrary;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class JavaUtility {
	/**
	 * it is retun the systemdate and time
	 * @return
	 */
	public String getSysytemDateAndTime()
	{
	
	Date SystmDate= new Date();
	String s=SystmDate.toString();
	String[] ss = s.split(" ");
	String dateAndTime=ss[2]+"-"+ss[1]+"-"+ss[5]+" "+ss[3];
	return dateAndTime;
	
	}
	/**
	 * it method use the get random number 
	 * @return
	 */
	
	public int getRanDomNum()
	{
		Random  ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}
	/**
	 * This method is used to get system date and time in format
	 * @return
	 */
	
	public String getSystemDateandTimeInFormat() 
	
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemdate = new Date();
		String getDateAndTime = dateformat.format(systemdate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":","-");
	}
	/**
	 * This method is used to get System date
	 * @return
	 */
	public String getSystemDate() throws Throwable
	{
		Date date = new Date();
		String SystemDate =date.toString();
		return SystemDate;
	}
	
	
	

}
