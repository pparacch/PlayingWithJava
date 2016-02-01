package com.apress.isf.ch0601.spring.views;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;


@Component("menu")
public class ResourceLoaderMenu {
	@Autowired
	private ResourceLoader resourceLoader;
	
	public void printMenu(String menuFile){
		try {
			InputStream is = resourceLoader.getResource(menuFile).getInputStream();
			Scanner sc = new Scanner(is);
			
			while(sc.hasNext()){
				System.out.println(sc.nextLine());
			}
			
			sc.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
