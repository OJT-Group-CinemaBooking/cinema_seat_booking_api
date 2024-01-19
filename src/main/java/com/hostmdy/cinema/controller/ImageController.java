package com.hostmdy.cinema.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
@CrossOrigin("http://localhost:3000")
public class ImageController {
	
	private final Environment env;
	
	@PostMapping("/upload/{pathName}/{imageName}")// give pathName from frontend (movie or crew)
	public ResponseEntity<String> imageUpload(@PathParam("file") MultipartFile file,@PathVariable String pathName,@PathVariable String imageName) {
		
		String uploadPath = env.getProperty(pathName+"_upload_path");
		
		String fileName = imageName+".jpg";
		
		Path filePath = Path.of(uploadPath+fileName);
		
		try {
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok("image uploaded");
	}
	
	@GetMapping("/{pathName}/{imageName}")// give pathName from frontend (movie or crew)
	public ResponseEntity<byte[]> getImage(@PathVariable String pathName,@PathVariable String imageName) throws IOException {
		ClassPathResource resource = new ClassPathResource("static/images/"+pathName+"/"+imageName);
		byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}

}
