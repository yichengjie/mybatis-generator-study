package com.yicj.mybatis.mapper;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yicj.mybatis.pojo.Dept;
import com.yicj.mybatis.pojo.DeptExample;
import com.yicj.mybatis.util.SessionFactoryUtil;

public class TestDeptMapper {
	SqlSession session = null ;
	
	@Before
	public void before() throws IOException {
		session = SessionFactoryUtil.getSession();
	}
	
	@After
	public void after() {
		if(session != null) {
			session.close();
		}
	}
	
	@Test
	public void testSelectByExample() {
		DeptMapper mapper = session.getMapper(DeptMapper.class) ;
		List<Dept> depts = mapper.selectByExample(null);
		System.out.println(depts);
	}
	
	@Test
	public void testCountByExample() {
		DeptExample example = new DeptExample() ;
		DeptMapper mapper = session.getMapper(DeptMapper.class) ;
		int count = mapper.countByExample(example);
		System.out.println("count : " +count);
		
	}
	
	@Test
	public void testInsert() {
		Dept record = new Dept("部门7") ;
		DeptMapper mapper = session.getMapper(DeptMapper.class) ;
		mapper.insert(record) ;
		session.commit();
	}

}
