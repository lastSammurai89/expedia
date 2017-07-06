package com.expedia.listener;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.expedia.util.InfoProps;




public class StartupListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ServletContext context = arg0.getServletContext();
		String url= context.getRealPath("/");
		String fullUrl= null;		
        fullUrl = url.concat("WEB-INF/props/info.properties");
		File f = new File(fullUrl);
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(f);
			
			try {
				props.load(fis);
			    InfoProps.getInstance().loadProps(props);

			   

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}

