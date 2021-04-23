package com.abc.xyz.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVUtil {
	
	public static void writeDataToCsv() {
		File file = new File("Employee.csv");
	    try {
	        // create FileWriter object with file as parameter
	        FileWriter outputfile = new FileWriter(file);
	  
	        // create CSVWriter object filewriter object as parameter
	        CSVWriter writer = new CSVWriter(outputfile);
	        
	        String[] data1 = new String[2];
	        
	        for(int i = 0; i < 1000000; i++) {
	        	data1[0] = "name" + i;
	        	data1[1] = "20";
		        writer.writeNext(data1);
	        }
	        // closing writer connection
	        writer.close();
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
//	public static void main(String[] args) {
//		writeDataToCsv();
//	}
	
}
