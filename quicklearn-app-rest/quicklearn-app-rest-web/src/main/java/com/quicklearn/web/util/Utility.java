package com.quicklearn.web.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	public Utility() {
	}

	public Date formatDate(String s) throws ParseException {
		if (s != null)
			return (new SimpleDateFormat("dd/MM/yyyy").parse(s));
		else
			return (new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2019"));
	}
	
//	public void createDataFile() {
//		 { try {
//		        File file = new File("filename.txt");       
//		        if(file.createNewFile())System.out.println("Success!");
//		        else System.out.println ("Error, file already exists.");
//		     }
//		     catch(IOException ioe) {
//		        ioe.printStackTrace();
//		     }		
//				
//			}
//	}

//	public boolean crateFile(String filename) {
//		try {
//			File file = new File("repertoiree.xml");
////			if (file.exists())
////				return true;
////			else {
//				if (file.createNewFile()) {
//					System.out.println("Success!");
//					return true;
//				} else {
//					System.out.println("Error, file already exists.");
//					return false;
//				}
////			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//		return false;
//	}
}
