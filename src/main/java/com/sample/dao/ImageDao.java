package com.sample.dao;

import java.util.List;

import com.sample.model.Image;

public interface ImageDao {
	
	public void saveImage(Image image);

	public List<Image> listImages();
	
	public Image getImage(int imgid);
	
	
}
