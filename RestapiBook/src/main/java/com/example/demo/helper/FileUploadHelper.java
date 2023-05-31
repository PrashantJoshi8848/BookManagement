package com.example.demo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	FileUploadHelper()throws IOException{
		
	}
	
	
	public boolean isUpload(MultipartFile file) {
		boolean f=false;
		try {
		InputStream stream	=file.getInputStream();
		byte data[]=new byte[stream.available()];
		stream.read(data);
		
		FileOutputStream fileOutputStream=new FileOutputStream(UPLOAD_DIR + File.separator+file.getOriginalFilename());
		fileOutputStream.write(data);
		fileOutputStream.flush();
		fileOutputStream.close();
		f=true;
		
		} catch (Exception e) {
			// TODO: handle exception
		e.getStackTrace();
		}
		
		return f;
	}
	
	
}
