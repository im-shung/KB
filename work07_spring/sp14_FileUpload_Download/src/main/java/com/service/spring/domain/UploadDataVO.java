package com.service.spring.domain;

import org.springframework.web.multipart.MultipartFile;

/*
 * ���� Ž��â���� ������ ������ ������ �����ϴ� VO Ŭ����...
 */
public class UploadDataVO {
	// �ʵ����
	// Form�� �ڵ����ε�
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
