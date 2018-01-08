package com.qianfeng.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.idao.IStudentDao;
import com.qianfeng.iservice.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao iStudentDao;
	
	@Override
	public void saveStudent(int id,String name){
		iStudentDao.saveStudent(id, name);
	}
	
}
