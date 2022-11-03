package com.te.springfrontbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springfrontbackend.entity.ImageData;

public interface StorageDao extends JpaRepository<ImageData, Integer>{

	ImageData findByName(String fileName);
}
