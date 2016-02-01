/**
 * 
 */
package com.apress.isf.ch06.java.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static java.lang.System.out;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0601.java.service.Login;
import com.apress.isf.ch0601.spring.service.LoginService;


public class MyDocumentsWithLoginTest {
	private static final String EMAIL = "test@mydocuments.com";
	private static final String PASS = "test123";
	private static final String SUCCESS = "This user is authorized";
	private static final String FAILURE = "WARNING! This user is not authorized!";
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0601-mydocuments-login-context.xml");
	}
	
	@Test
	public void testLogin() {	
		LoginService login = (LoginService)context.getBean(Login.class);
		assertNotNull(login);
		Assert.assertEquals(EMAIL, login.getUsername());
		Assert.assertEquals(PASS, login.getPassword());
		if(login.isAuthorized(EMAIL, PASS)){
			out.println(SUCCESS);
		}else{
			out.println(FAILURE);
			fail();
		}
	}
}
