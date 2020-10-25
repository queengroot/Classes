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

public class Summer {
	//Declare variables
	
		//size is going to be 75
		//final int SIZE = 75;
		 
		//empty array declaration

		ArrayList<Integer> summerArray = new ArrayList<Integer>();
		
		//Scanner scanner = new Scanner(System.in);
		
		public void driverThree()
		
		{
			
			//open first file
			File fileSummer = openFileSummer();
			
			readFile(fileSummer);
			//open second file
			//File fileSpring = openFileSpring();
			
			//open third file
			//File fileSummer = openFileSummer();
			
			
			
		}
		
		
		//***************************************** Methods and Functions ***********************************************
		
		//Input files
		
		//open the first file
			 public File openFileSummer()
			{
				//open first file 
						File summerIn = new File("Summer2020Analytics.txt");
						

						return summerIn;		
			}
			 
		//************************ End File Management***********************************
			 
		public void readFile(File summerIn) 
		{
				
			
			//helpful site on reading files into arrayList:
			//https://stackabuse.com/java-read-a-file-into-an-arraylist/
			
			try (Scanner summerFile = new Scanner(new File("Summer2020Analytics.txt"))) {
			    
				//while the file is not at the end read in the next integer value
				while(summerFile.hasNext())
				{
					//read in the int
					int a = summerFile.nextInt();
			
					//add the int to the array
					summerArray.add(a);
					
					//testing purposes
					//System.out.println(a);
					
					
				}
				
				//close the file
				close(summerFile);
			}
			
			catch (FileNotFoundException e) {
				
				//handle

				//handle
				System.out.println("Summer2019Analytics.txt not found");
				
				System.exit(0);	
			}
						 
			//int len = summerArray.size();
			
			 //System.out.println(len);	
						  
			//testing purposes
				//System.out.println(Arrays.toString(summerArray.toArray()));
						}
						
						//using for loop
		
		//this way another class can access this array
		public ArrayList<Integer> getSummer()
		{
			return summerArray;
		}
		
		//close the file
		 public void close(Scanner file)
		 {
			 file.close();
		 }
}
