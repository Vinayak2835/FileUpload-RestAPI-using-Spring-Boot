package com.upload.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload.model.Doc;
import com.upload.service.DocService;

@RestController
public class FileUploadController {

	@Autowired
	private DocService docService;

	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("files") MultipartFile file) {

		// To get the file information
		System.out.println("Original File Name:" + file.getOriginalFilename());
		System.out.println("File size:" + file.getSize());
		System.out.println("File Content type:" + file.getContentType());

		docService.saveDocument(file);

		return ResponseEntity.ok().body("single file uploaded Succssfully");

	}

	@PostMapping("/uploadFiles")
	public ResponseEntity<String> uploadFiles(@RequestParam("files") MultipartFile[] files) {

		for (MultipartFile multipartFile : files) {
			docService.saveDocument(multipartFile);
		}

		return ResponseEntity.ok().body("Multiple files uploaded successfully");
	}

	@GetMapping("/getFile/{id}")
	public ResponseEntity<Doc> getFileById(@PathVariable("id") int id) {

		Doc doc = null;

		try {
			doc = docService.findFileById(id);
			return ResponseEntity.of(Optional.of(doc));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@RequestMapping(value = "/getAllFiles", method = RequestMethod.GET)
	public ResponseEntity<List<Doc>> getAllFiles() {

		List<Doc> allfiles = docService.getAllFiles();

		if (allfiles.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(allfiles));
		}

	}
}
