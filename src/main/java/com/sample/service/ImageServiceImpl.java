package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.sample.dao.ImageDao;
import com.sample.model.Image;

@Service("imageService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveImage(Image image) {
		try{
			
		} catch (Exception e){
			
		}
		getImageDao().saveImage(image);
	}
	
	public List<Image> listImages() {
		return getImageDao().listImages();
	}

	public Image getImage(int imgid) {
		return getImageDao().getImage(imgid);
	}
	
	
	protected void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
	
	private ImageDao getImageDao(){
		if(imageDao == null) {
			BeanFactory beanfactory = new ClassPathXmlApplicationContext("sdnext-servlet.xml");
			imageDao = (ImageDao) beanfactory.getBean("imageDao");
		}
		return imageDao;
	}
}
