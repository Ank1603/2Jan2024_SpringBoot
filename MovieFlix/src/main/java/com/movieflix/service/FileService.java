package com.movieflix.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileService {

	@Value("${file.upload.path}")
	private String uploadPath;
	
	
	public String upload(MultipartFile poster) throws IOException
	{
		//1.create new folder using upload path to store files if it is not available
		File newFile = new File(uploadPath);
		if(!newFile.exists())
		{
			newFile.mkdir();
		}
		
		//2.get original file name to create store path
		String originalFilename = poster.getOriginalFilename();
		
		
		//3.create store path using upload path and
		String storePath = uploadPath + File.separator+originalFilename;
		
		//4.copy the bytes of the file into store path
		Files.copy(poster.getInputStream(), Paths.get(storePath));
		return originalFilename;
	}
}
