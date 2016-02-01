package com.apress.isf.ch0601.spring.views;

import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import org.springframework.core.io.Resource;

public class Menu {
	
	private Resource menuFile = null;
	
	public Resource getMenuFile(){
		return this.menuFile;
	}
	
	public void setMenuFile(Resource theMenuFile){
		this.menuFile = theMenuFile;
	}
	
	public void printMenu(){
		try {
			InputStream iStream = getMenuFile().getInputStream();
			Scanner scannner = new Scanner(iStream);
			while(scannner.hasNext()){
				System.out.println(scannner.nextLine());
			}
			scannner.close();
			iStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
