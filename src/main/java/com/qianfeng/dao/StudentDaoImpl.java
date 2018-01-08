package com.qianfeng.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.stereotype.Component;

import com.qianfeng.idao.IStudentDao;
import com.qianfeng.utils.C3P0Utils;

@Component
public class StudentDaoImpl implements IStudentDao{
	@Override
	public void saveStudent(int id,String name){
		QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql="insert into student values(?,?)";
		try {
			qRunner.update(sql,id,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
