import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Arrays;

//Kate Blunt
//COP 2552
//October 8th, 2020
//First read in file
//read the file successfully into an array
//I chose to do an array and not an arrayList because
//each file has the same amount of numbers in it, 75.
//an arrayList is used when you are not sure how long the array is
//because its size is automatically adjusted to accommodate the number of items being stored in it


public class Fall {
	
	
	//Declare variables
	
	//size is going to be 75
	//final int SIZE = 75;
	 
	//empty array declaration

	ArrayList<Integer> fallArray = new ArrayList<Integer>();
	
	//Scanner scanner = new Scanner(System.in);
	
	public void driver()
	
	{
		
		//open first file
		File fileFall = openFileFall();
		
		//read the first file
		readFile(fileFall);
		
		
		
		
		
	}
	
	
	//***************************************** Methods and Functions ***********************************************
	
	//Input files
	
	//open the first file
		 public File openFileFall()
		{
			//open first file 
					File fallIn = new File("Fall2019Analytics.txt");
					

					return fallIn;		
		}
		 
	//************************ End File Management***********************************
		 
	public void readFile(File fallIn) 
	{
			
		
		//helpful site on reading files into arrayList:
		//https://stackabuse.com/java-read-a-file-into-an-arraylist/
		
		try (Scanner fallFile = new Scanner(new File("Fall2019Analytics.txt"))) {
		    
			//while the file is not at the end read in the next integer value
			while(fallFile.hasNext())
			{
				//read in the int
				int a = fallFile.nextInt();
		
				//add the int to the array
				fallArray.add(a);
				
				//testing purposes
				//System.out.println(a);
				
				
			}
			
			//close the file
			close(fallFile);
		}
		
		catch (FileNotFoundException e) {
			
			//handle
			System.out.println("Fall2019Analytics.txt not found");
			
			System.exit(0);	
		}
					 
		//int len = fallArray.size();
		
		 //System.out.println(len);	
					  
		//testing purposes
			//System.out.println(Arrays.toString(fallArray.toArray()));
			
			
	}
					
					//using for loop

		//this way another class can access this array	
		public ArrayList<Integer> getFall()
		{
			return fallArray;
		}
		
		//close the file
		 public void close(Scanner file)
		 {
			 file.close();
		 }
	
		 

}
