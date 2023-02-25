package mshantadze.solvd_laba_university.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mshantadze.solvd_laba_university.dao.mybatis.implementation.StudentsMyBatis;

public class MyBatis {
	private static final Logger LOGGER = LogManager.getLogger(MyBatis.class);
	protected SqlSessionFactory factory;
	
	public MyBatis() {
		Reader reader = null;
		try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        }catch(IOException e){
            LOGGER.error(e);
        }
		
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
}
