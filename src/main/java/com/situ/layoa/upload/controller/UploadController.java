package com.situ.layoa.upload.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.situ.layoa.upload.domain.LayResult;
@Controller
public class UploadController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ResponseBody
	@RequestMapping("/upload")
	public LayResult doUploadFile(UploadFile uploadFile) {
		CommonsMultipartFile file=uploadFile.getFile();
		System.out.println(file);
		
		String src="layoafile/xxxx.png";
		return new LayResult(0,"",src);
	}
}
