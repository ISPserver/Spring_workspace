package com.koreait.fashionshop.model.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koreait.fashionshop.model.bank.repository.HardwareDAO;

@Service
public class HardwareServiceImpl  implements HardwareService{
	@Autowired
	private HardwareDAO hardwareDAO;
	
	@Override
	public List selectAll() {		
		return hardwareDAO.selectAll();
	}

}
