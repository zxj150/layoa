package com.situ.layoa.upload.controller;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadFile implements Serializable {

	private static final long serialVersionUID = 1L;
	private CommonsMultipartFile file;
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

}
