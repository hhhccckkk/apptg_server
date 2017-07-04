package com.hck.apptg.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartTimer implements ServletContextListener  {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 
	/**  private Timer timer = null;  
	  public void contextInitialized(ServletContextEvent event)  
	  
	  { 
		  System.out.println("启动成功");
		  Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.HOUR_OF_DAY, 14); // 控制时
      calendar.set(Calendar.MINUTE, 33);       // 控制分
      calendar.set(Calendar.SECOND, 0);       // 控制秒

      Date time = calendar.getTime();         // 得出执行任务的时间,此处为今天的12：00：00

      Timer timer = new Timer();
      
      timer.scheduleAtFixedRate(new TimerTask() {
          public void run() {
              System.out.println("定时器开始开始开始");
          }
      }, time, 1000 * 60 );// 这里设定将延时每天固定执行
	  }

	  public void contextDestroyed(ServletContextEvent event)  
	  {//在这里关闭监听器，所以在这里销毁定时器。  
	      timer.cancel();  
	     
	  }  

	**/


}
