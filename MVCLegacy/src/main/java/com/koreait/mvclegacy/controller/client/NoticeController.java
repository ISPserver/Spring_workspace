package com.koreait.mvclegacy.controller.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.mvclegacy.exception.DMLException;
import com.koreait.mvclegacy.model.domain.Notice;
import com.koreait.mvclegacy.model.notice.NoticeService;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	//�۾��� �� ��û
	@RequestMapping("/notice/registform")
	public String getRegistForm() {
		return "notice/regist_form";
	}
	
	//�۵�� ��û ó��
	@RequestMapping(value="/notice/regist", method = RequestMethod.POST)
	//������������ vo�� ��������� html�Ķ���͸� ������ �ڵ� vo�� ������ ����
	public String regist(Notice notice) {
		noticeService.insert(notice);
		return "redirect:/client/notice/list";
	}
	
	//��� �� �������� ��û
	@RequestMapping(value="/notice/list", method = RequestMethod.GET)
	public ModelAndView selectAll() {
		logger.debug("�۸�� �޼��� ȣ��");
		ModelAndView mav = new ModelAndView();
		List noticeList = noticeService.selectAll();
		mav.addObject("noticeList",noticeList);
		mav.setViewName("notice/list");
		return mav;
	}
	
	//�Ѱ� ��������
	@RequestMapping(value="/notice/detail", method=RequestMethod.GET)
	public ModelAndView select(int notice_id) {
		Notice notice = noticeService.select(notice_id);
		
		ModelAndView mav = new ModelAndView("notice/detail");
		mav.addObject("notice",notice);
		return mav;
	}
	
	//���� ��û ó��
	@RequestMapping(value="/notice/edit", method=RequestMethod.POST)
	public ModelAndView update(Notice notice) {
		ModelAndView mav = new ModelAndView();		
		try {
			noticeService.update(notice);
			//mav.addObject("msg","��� ����");
			mav.setViewName("redirect:/client/notice/detail?notice_id="+notice.getNotice_id());
		} catch (DMLException e) {
			mav.addObject("msg",e.getMessage());
			mav.setViewName("message/result");
			e.printStackTrace();
		}
		return mav; 
	}
	
	//���� ��û ó��
	@RequestMapping(value="/notice/del", method=RequestMethod.POST)
	public String delete(int notice_id) {
		noticeService.delete(notice_id);					
		return "redirect:/client/notice/list";
	}
}