package com.te.springfrontbackend.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.te.springfrontbackend.ImageUtils;
import com.te.springfrontbackend.dao.StorageDao;
import com.te.springfrontbackend.entity.ImageData;

@Service
public class StorgeService {

	@Autowired
	private StorageDao dao;
	
	public String uploadImage(MultipartFile file) throws IOException {
		ImageData imageData = dao.save(ImageData.builder().name(file.getOriginalFilename()).type(file.getContentType()).imgData(ImageUtils.compressImage(file.getBytes())).build());
		
		if(imageData!=null) {
			return "file uploaded successfully :"+file.getOriginalFilename();
		}
		return null;
	}
	
	   public byte[] downloadImage(String fileName){
	        ImageData imageData = dao.findByName(fileName);
	        byte[] images=ImageUtils.decompressImage(imageData.getImgData());
	        return images;
	    }
}









