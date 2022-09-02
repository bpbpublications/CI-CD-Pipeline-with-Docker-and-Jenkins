package com.sample.service;

import java.util.List;

import com.sample.model.Image;


public interface ImageService {
	
	public void saveImage(Image image);

	public List<Image> listImages();
	
	public Image getImage(int imgid);
	
}
