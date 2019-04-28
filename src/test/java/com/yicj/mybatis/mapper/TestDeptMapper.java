package com.yicj.mybatis.mapper;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.yicj.mybatis.pojo.DeptExample;
import com.yicj.mybatis.util.SessionFactoryUtil;

public class TestDeptMapper {
	SqlSession session = null ;
	
	@Before
	public void before() throws IOException {
		session = SessionFactoryUtil.getSession();
	}
	
	@Test
	public void testCountByExample() {
		DeptExample example = new DeptExample() ;
		DeptMapper mapper = session.getMapper(DeptMapper.class) ;
		int count = mapper.countByExample(example);
		System.out.println("count : " +count);
	}

}
