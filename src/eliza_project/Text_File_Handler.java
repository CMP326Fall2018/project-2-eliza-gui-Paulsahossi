package eliza_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Text_File_Handler implements Text_FIle_IOable{

	/**
	 * Create a New EMPTY file
	 */
	@Override
	public void createNewFile(String fileName) {
		PrintWriter outStream = null;
			try{
				outStream = new PrintWriter(fileName);
			}catch(FileNotFoundException e){
				System.out.println("Could not create the file "+fileName);
				e.printStackTrace();
			}
			finally{
				if(outStream != null){
					outStream.close();
				}
//				System.out.println("All done check your file system for "+ fileName);
			}
	}
	@Override
	public String readFile(String fileName) {
		Scanner inStream = null;
		String fileContents = "";
		
		try {
			File theFileObject =  new File(fileName) ;
			inStream = new Scanner(theFileObject);
			
			while( inStream.hasNextLine() ){ //use the Scanner Object's hasNextLine method to get Lines as long as the file has
				fileContents += inStream.nextLine() +"\n";//get a line from the file append to fileContent String
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
		}
		
		return fileContents;
	}


	@Override
	public void appendToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try{
//			outStream = new PrintWriter(fileName);//replace this line
			outStream = new PrintWriter(new FileOutputStream(fileName, true));//true means append to end of file
			outStream.println(text); //write the text to the file
			outStream.flush();
		}catch(FileNotFoundException e){
			System.out.println("Could not create the file "+fileName);
			e.printStackTrace();
		}
		finally{
			if(outStream != null){
				outStream.close();
			}
//			System.out.println("All done check your file system for "+ fileName);
		}
		
	}


	@Override
	public String longestWords(String fileName) {
		Scanner inStream = null;
		String fileContents = "";
		String longWords = "";
		
		try {
			File theFileObject =  new File(fileName) ;
			inStream = new Scanner(theFileObject);
			
			while( inStream.hasNext()){
				fileContents = inStream.next();
				for (int i=0; i<fileContents.length(); i++) {
					if(fileContents.length() > longWords.length()) {
					longWords = fileContents;	
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
		}
		
		return longWords;
	}

	@Override
	public String ShortesWords(String fileName) {
		Scanner inStream = null;
		String fileContents = "";
		String longWords = "";
		
		try {
			File theFileObject =  new File(fileName) ;
			inStream = new Scanner(theFileObject);
			
			while( inStream.hasNext()){
				fileContents = inStream.next();
				String [] tokens = fileContents.split(" ");
				
				for(int i=0; i<tokens.length; i++){
					if (fileContents.length()>tokens[i].length()) {
						longWords = tokens[i];
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
		}
		
		return longWords;
	}
	@Override
	public String readDelimetedFile(String fileName, String delimeter) {
		Scanner inStream = null;
		String token = "";
		String fileContent = "";
		try{
			File theFile = new File(fileName);
			if((theFile.exists()) && theFile.canRead()){
				inStream = new Scanner(theFile);
				while(inStream.hasNextLine()){
				String lineIn = inStream.nextLine();
				String [] tokens = lineIn.split(delimeter);
					for(int i=0; i<tokens.length; i++){
						if (tokens[i].length() > token.length()) {
							token = tokens[i];
						}
					}
					fileContent += token +"\n";
					token = "";
				}

			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		finally{
			if(inStream != null){
				inStream.close();
			}
		}
		return fileContent;
	}
	@Override
	public String alphaSort(String fileName, String delimeter) {
		Scanner inStream = null;
		String token = "";
		String fileContent = "";
		String alphaSort="";
		String output = "";
		try{
			File theFile = new File(fileName);
			if((theFile.exists()) && theFile.canRead()){
				inStream = new Scanner(theFile);
				while(inStream.hasNextLine()){
				String lineIn = inStream.nextLine();
				String [] tokens = lineIn.split(delimeter);
					for(int i=0; i<tokens.length; i++){
						if (tokens[i].length() > token.length()) {
							token = tokens[i];
						}
					}
					fileContent += token +"\n";
					token = "";
				}

			}
			alphaSort = fileContent;
			String [] arr = alphaSort.split("\n");
			Arrays.sort(arr);
			for (int i =0; i<arr.length; i++) {
				output += arr[i] + "\n";
				
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		finally{
			if(inStream != null){
				inStream.close();
			}
		}
		return output;
	}
	
	
}
