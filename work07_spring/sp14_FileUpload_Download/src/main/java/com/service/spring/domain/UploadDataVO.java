package com.service.spring.domain;

import org.springframework.web.multipart.MultipartFile;

/*
 * 파일 탐색창에서 선택한 파일의 정보를 저장하는 VO 클래스...
 */
public class UploadDataVO {
	// 필드명은
	// Form값 자동바인딩
	private String userName; // <input type="text" name="userName">
	private MultipartFile uploadFile; // <input type="file" name="uploadFile">

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

}
