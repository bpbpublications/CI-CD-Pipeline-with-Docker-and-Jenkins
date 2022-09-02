package com.sample.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.model.Image;


@Repository("imageDao")
public class  ImageDaoImpl implements ImageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveImage(Image image) {
		getSessionFactory().getCurrentSession().saveOrUpdate(image);
	}

	@SuppressWarnings("unchecked")
	public List<Image> listImages() {
		return (List<Image>) getSessionFactory().getCurrentSession().createCriteria(Image.class).list();
	}

	public Image getImage(int imgid) {
		return (Image) getSessionFactory().getCurrentSession().get(Image.class, imgid);
	}

    private SessionFactory getSessionFactory() {
    	
    	return sessionFactory;
    }
}
