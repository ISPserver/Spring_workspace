package com.koreait.fashionshop.model.product.service;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.excel.ProductConverter;
import com.koreait.fashionshop.model.product.repository.ProductDAO;

@Service
public class DumpServiceImpl implements DumpService{
	private static final Logger logger = LoggerFactory.getLogger(DumpServiceImpl.class);
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void regist(String path) {
		//���� �о �����ͷ� �ֱ�
		List<Product> productList =  productConverter.convertFromFile(path);
		logger.debug("productList",productList.size());
		
		for(int i=0; i<productList.size(); i++) {
			Product product = productList.get(i);
			productDAO.insert(product);
			//insert ���� ���� �� �������ʹ� product vo�� �̹� pk���� ä���� �ִ� ����
			
		}
		
	}

}
