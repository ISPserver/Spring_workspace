package com.koreait.fashionshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.bank.service.HardwareService;
import com.koreait.fashionshop.model.domain.HardWare;

@Controller
public class HardwareController {
	@Autowired
	private HardwareService hardwareService;
	
	@RequestMapping(value="/hardware/list", method=RequestMethod.GET)	
	public  ModelAndView getHardWareList() {
		List<HardWare> hardWareList = hardwareService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("hardWareList",hardWareList);
		mav.setViewName("list");
		return mav;
	}
}
