package com.upload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Doc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String docName;

	private String docType;

	@Lob
	private byte[] data;

	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doc(String docName, String docType, byte[] data) {
		super();
		//this.id = id;
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}

	public String getDocName() {
		return docName;
	}

	public String getDocType() {
		return docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
