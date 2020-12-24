package com.study.springfinal.controller.gallery;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.springfinal.common.FileManager;
import com.study.springfinal.domain.Gallery;
import com.study.springfinal.model.dao.GalleryDAO;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	//ǥ�ø� ���״�, ���� �־�޶�� ��û
	@Autowired
	private GalleryDAO galleryDAO;
	
	
	//������ �����ӿ�ũ�� ���ε� ������Ʈ��, apache fileupload�� �����
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(Gallery gallery, HttpServletRequest request) {
		
		//������ ����
		MultipartFile photo = gallery.getPhoto();
	
		//���ϸ� ���� �����, �����ϱ�
		String newName = Long.toString(System.currentTimeMillis());
		String ext = FileManager.getExtend(photo.getOriginalFilename());
		String filename = newName+"."+ext;
		gallery.setFilename(filename);//vo�� ����
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath("/data");
		//��Ŭ���� ���� ��Ĺ�� ���, ���� ��οʹ� Ʋ�� ��ο� �����. ���߽� �� ��θ� ������ 
		//����غ�����

		try {
			photo.transferTo(new File(realPath+"/"+filename));//������ ����
			
			int result = galleryDAO.insert(gallery);
			System.out.println(result);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/gallery/list";
	}
	
	//��� ��������
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView selectAll() {
		//3�ܰ�
		List galleryList = galleryDAO.selectAll();
		
		//4�ܰ�:����
		ModelAndView mav = new ModelAndView();
		mav.addObject("galleryList", galleryList);
		mav.setViewName("gallery/list");

		return mav;
	}
	
	//�󼼺��� ��û ó��
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView select(int gallery_id) {
		//3�ܰ�
		Gallery gallery = galleryDAO.select(gallery_id);
		
		//4�ܰ�:����
		ModelAndView mav = new ModelAndView();
		mav.addObject("gallery", gallery);
		mav.setViewName("gallery/detail");

		return mav;
	}
	
	//�� ���� ��û ó��
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(Gallery gallery) {
		//3�ܰ�: �� ��Ű��
		galleryDAO.update(gallery);
		
		//4�ܰ�: �����Ұ� ���� why? ��û ���� ���� �����Ұű� ����		
		return "redirect:/gallery/detail?gallery_id="+gallery.getGallery_id();
	}
	
	//�� ���� ��û ó��
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int gallery_id) {
		//3�ܰ�: �� ��Ű��
		galleryDAO.delete(gallery_id);
		
		//4�ܰ�: �����Ұ� ���� why? ��û ���� ���� �����Ұű� ����		
		return "redirect:/gallery/list";
	}

}
	