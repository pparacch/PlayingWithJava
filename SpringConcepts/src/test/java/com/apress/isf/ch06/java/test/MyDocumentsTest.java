package com.apress.isf.ch06.java.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;
import com.apress.isf.ch0501.spring.data.TypeDataRepository;

public class MyDocumentsTest {

	
	private final Logger log = Logger.getLogger("com.apress.isf.ch06.java.test");
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setup(){
		new TypeDataRepository();
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0501_mydocuments-context.xml");
	}
	
	@Test
	public void testMenu() {
		log.info("About to read the Resource file: menu.txt");
		
		Resource resource = context.getResource("META-INF/data/menu.txt");
		InputStream stream = null;
		Scanner scanner = null;
		try {
			stream = resource.getInputStream();
			scanner = new Scanner(stream);
			while(scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}
			
			scanner.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
