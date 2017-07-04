package com.hck.apptg.util;

import com.opensymphony.xwork2.ActionContext;

public class FenYe {
	
	public static int getMaxnum(String string)
	{
		String string2=ActionContext.getContext().getSession().get(string).toString();
		int num=0;
		 if (string2!=null) {
			 num=Integer.parseInt(string2);
		}
		 return num;
	}
	public static int getnum(String string,int num)
	{
		int maxNum=0;
		int pagenum=0;
		maxNum=getMaxnum(string);
		pagenum=(maxNum%num)==0?(maxNum/num):(maxNum/num)+1;
		return pagenum;
	}
	public static int getFlag(String string)
	{
		int flag=1;
		Object flagsString=ActionContext.getContext().getSession().get(string);
		
	    if(flagsString!=null)
	    	{
	    	
	    	flag=Integer.parseInt(flagsString.toString());
	    	}
	    if(flag<1)
	    	{
	          flag=1;
	    	}
	   
	    return flag;
	}

}
