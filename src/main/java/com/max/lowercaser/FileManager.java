package com.max.lowercaser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManager {
	private FileReader fileReader;
        private Logger logger;

	public FileManager(){
		logger = LoggerFactory.getLogger(FileManager.class);
	}

	public void toLowerFile(String filename) {
	        String writing;

	            
	        // Open the reading file.
	        FileReader freader;
		try {
			freader = new FileReader(filename);
	        	BufferedReader inputFile = new BufferedReader(freader);
		        // open output file
	        	FileWriter fwriter = new FileWriter(filename+".lo");
		        PrintWriter outputFile = new PrintWriter(fwriter);
		        while ((writing = inputFile.readLine()) != null){      
		            String upper = writing.toLowerCase();
		            outputFile.println(upper);
		        }
		        outputFile.close();
		        inputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    }
	public void openFile(String fileToRead) throws FileNotFoundException{
		String fileToReadWithoutBlankSpaces = fileToRead.trim();
		try{
			fileReader = new FileReader(fileToReadWithoutBlankSpaces);
		}catch (FileNotFoundException e){
			String errorMsg = "Error at reading file {}. FileNotFoundException {}";
			logger.error(errorMsg,fileToRead,e);
			throw new FileNotFoundException(errorMsg);	
		}
	}

public String readLine(int line) throws IOException{
		String stringLine = null;
		int cont = 0;
		BufferedReader inputFile = new BufferedReader(fileReader);
		try{
		        while ((stringLine = inputFile.readLine()) != null){      
				if (cont == line) break;
				cont++;	
		        }
		        inputFile.close();
		//if cont != line then file has minus lines than line want to read
		if (cont != line) throw new IOException();
		}catch(IOException ioe){
			String errorMsg = "Error at reading line {} or closing input file {}. IOException {}";
			logger.error(errorMsg, cont, fileReader, ioe);
			throw new IOException(errorMsg);
		}
		return stringLine;
	}
}
