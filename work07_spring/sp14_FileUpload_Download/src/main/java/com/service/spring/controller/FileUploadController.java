package com.service.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.UploadDataVO;

@Controller
public class FileUploadController {

	@RequestMapping("fileupload.do")
	public String fileupload(UploadDataVO vo, HttpServletRequest request, Model model) throws Exception {
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile.." + mFile);
		
		// 1. MultipartFile�� �ֿ� ���
		if (mFile.isEmpty() != true) { // ���ε�� ������ �ִٸ�
			System.out.println("������ �뷮: " + mFile.getSize());
			System.out.println("���ε��� ���ϸ�: " + mFile.getOriginalFilename());
			System.out.println("mFile.getName(): " + mFile.getName()); // <input type="file" name="uploadFile">�� name���� ���´�.
		}
		
		// 2. ���ε��� ������ Tomcat ��ο� ����
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root :: " + root);
		
		String path = root + "upload\\";
		
		// 3. ���ε��� ������ ī�Ǻ��� �ش� ��ο� ����
		File copyFile = new File(path + mFile.getOriginalFilename());
		mFile.transferTo(copyFile); // �̶� Tomcat ������ �̵�, �����
		
		model.addAttribute("uploadfile", mFile.getOriginalFilename());
		
		return "upload_result";
	}
	
	@RequestMapping("filedown.do")
	public ModelAndView filedown(String filename, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "upload\\";
		
		HashMap<String, String> map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView",map);
		
	}
}
