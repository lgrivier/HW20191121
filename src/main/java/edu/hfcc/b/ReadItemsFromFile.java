package edu.hfcc.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import edu.hfcc.b.PathCreator;

public class ReadItemsFromFile {
	
	
	public List<String> createList(String readFromFile) {
		Path readFile = new PathCreator().createPathToFile(readFromFile, "input");
		InputStream input = null;
		List<String> items = new ArrayList();
		try {
			input = Files.newInputStream(readFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			try {
				String line = reader.readLine();
				while (line != null){
					items.add(line);
					line = reader.readLine();
				}
			} finally {
				reader.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}
