package edu.hfcc.b;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteItemsToFile {

	public void WriteToFile(String subOutput) {

		Path writeFile = new PathCreator().createPathToFile("subOutput.txt", "output");
		
		
		
		
		byte[] data = subOutput.getBytes();
		OutputStream output = null;
		BufferedWriter writer = null;
		try {
			output = new BufferedOutputStream(Files.newOutputStream(writeFile, StandardOpenOption.CREATE));
			output.write(data);
			output.flush();

		   
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}


	}
	

