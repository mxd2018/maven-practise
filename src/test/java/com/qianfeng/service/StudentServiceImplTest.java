package com.qianfeng.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qianfeng.iservice.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class StudentServiceImplTest {
	@Autowired
	private IStudentService ist;
	
	@Test
	public void TestsaveStudent(){
		ist.saveStudent(2, "快点完成回家");
	}
	
}
