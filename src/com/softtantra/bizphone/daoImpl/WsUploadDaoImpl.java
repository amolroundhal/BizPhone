package com.softtantra.bizphone.daoImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.commons.DateConversions;
import com.softtantra.bizphone.dao.WsUploadDao;
import com.softtantra.bizphone.ws.AjaxResponse;

public class WsUploadDaoImpl implements WsUploadDao {
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session initiateSession(){
		return sessionFactory.openSession();
	}
	
	private void destroySession(Session session) {
		if (session != null) {
			session.flush();
			session.close();
		}
	}
	
	static Properties fileProperties = new Properties();
	static{
		try {
			fileProperties.load(WsUploadDaoImpl.class.getClassLoader().getResourceAsStream("/imagepath.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties getPropertiesFile(String path)
	{
		try {
			fileProperties.load(WsUploadDaoImpl.class.getClassLoader().getResourceAsStream("/imagepath.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileProperties;
	}

	
	private String saveImage(byte[] image, String folder_name, int id) {
		// TODO Auto-generated method stub
		String path = "";
		try {
			if(image != null){
				
				Date d = DateConversions.getCurrentDate();
				String root = fileProperties.getProperty("realpath");
				BufferedImage src=ImageIO.read(new ByteArrayInputStream(image));  
				File destinstion = new File(root + "/" + "images" + "/" + folder_name + "/" + id + d.getTime() + ".png");
				System.out.println("path destination "+destinstion);
				destinstion.getParentFile().mkdirs();
				destinstion.createNewFile();
				ImageIO.write(src, "png", destinstion);

				path =  "/" + "images" + "/" + folder_name + "/" + id + d.getTime() + ".png";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
