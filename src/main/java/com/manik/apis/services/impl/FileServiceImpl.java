package com.manik.apis.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manik.apis.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// get file original name
		String fileName = file.getOriginalFilename();

		// abc.png --> get full file path

		// create a random file Name
		String randomId = UUID.randomUUID().toString();
		String fileName1 = randomId.concat(fileName.substring(fileName.lastIndexOf(".")));

		// full path
		String fullPath = path + File.separator + fileName1;

		// check if file exists or not
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();

		}

		// copy the files
		Files.copy(file.getInputStream(), Paths.get(fullPath));

		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fullPath = path+File.separator+fileName;
		InputStream iS = new FileInputStream(fullPath);
		return iS;
	}

}
