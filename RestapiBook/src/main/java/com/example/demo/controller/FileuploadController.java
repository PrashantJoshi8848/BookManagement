package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.helper.FileUploadHelper;
 
@RestController
public class FileuploadController {
	@Autowired
	FileUploadHelper fileUploadHelper;
	@RequestMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile icon ){
		if(icon.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must contein file");
		}
		
		if(icon.getContentType().equals("image/jpeg")&& icon.getContentType().equals("image/jpg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only jpeg are allowded");
		}
	
		try {
			if(fileUploadHelper.isUpload(icon)) {				
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(icon.getOriginalFilename()).toUriString());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	
}
