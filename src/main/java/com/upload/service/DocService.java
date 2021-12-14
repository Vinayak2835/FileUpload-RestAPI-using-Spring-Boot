package com.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upload.model.Doc;
import com.upload.repository.DocRepository;

@Service
public class DocService {

	@Autowired
	private DocRepository docRepository;

	public Doc saveDocument(MultipartFile multipartFile) {

		String fileName = multipartFile.getOriginalFilename();

		try {

			Doc doc = new Doc(fileName, multipartFile.getContentType(), multipartFile.getBytes());
			docRepository.save(doc);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Doc findFileById(int id) {

		Doc doc = docRepository.findById(id).get();
		return doc;

	}

	public List<Doc> getAllFiles() {
		// TODO Auto-generated method stub
		List<Doc> allFiles = docRepository.findAll();
		return allFiles;
	}

}
