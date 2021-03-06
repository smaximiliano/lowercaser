package com.max.lowercaser;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import com.max.lowercaser.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'maxi' at '05/06/15 09:34' with Gradle 2.4
 *
 * @author maxi, @date 05/06/15 09:34
 */

public class FileManagerTest {
private FileManager fileManager;
	@Before public void prepare(){
		fileManager = new FileManager();
	}

	/*
	 * 
	 * Testing open file method
	 * 
	 */

    @Test public void testOpenFileThatExist() {
	    try{
	    fileManager.openFile("test.txt");
	    }catch(FileNotFoundException fnfe){}
    }

    @Test(expected=FileNotFoundException.class)
    public void testOpenFileThatNotExist() throws FileNotFoundException{
   	fileManager.openFile("inotexist"); 
    } 

    @Test public void testOpenFileThatExistWhitBlankSpaces() throws FileNotFoundException{
	  fileManager.openFile(" test.txt ");
    }

	/*
	 * 
	 * Testing read line method
	 * 
	 */

    @Test public void testReadLineZero() throws FileNotFoundException, IOException{
	    	int line = 0;
		fileManager.openFile("test.txt");
		assertEquals("Testing read line method","Linea 0", fileManager.readLine(line)); 
    }

    @Test public void testReadLineFive() throws FileNotFoundException, IOException{
	    	int line = 5;
		fileManager.openFile("test.txt");
		assertEquals("Testing read line method","Linea 5", fileManager.readLine(line)); 
    }

    @Test(expected=IOException.class)
    public void testReadLineThatNotExist() throws FileNotFoundException, IOException{
	    int line = 999;
	    fileManager.openFile("test.txt");
	    fileManager.readLine(line); 
    }

}
