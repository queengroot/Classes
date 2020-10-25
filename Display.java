import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//Kate Blunt
//COP 2552
//October 8th, 2020
//Display class
//This class is to calculate the results and display the message boxes and write to the output file
//Looking back i could have possibly divided this into two classes, one to do the message boxes,
//and one to do the output file

public class Display {
	
	
	public void displayDialogBox(){
		
		//Total number of students enrolled is number 2 in each array
		
				//decimal format
				DecimalFormat df = new DecimalFormat("##.0%");
				
				
				//must access arrays from all the different classes
		
				//fall array
				Fall array = new Fall();
				
				array.driver();
		
				ArrayList<Integer> fallArray = array.getFall();
				
				//spring array
				Spring arrayTwo = new Spring();
				
				arrayTwo.driverTwo();
				
				ArrayList<Integer> springArray = arrayTwo.getSpring();
				
				//summer array
				Summer arrayThree = new Summer();
				
				arrayThree.driverThree();
			
				ArrayList<Integer> summerArray = arrayThree.getSummer();
				
				//testing purposes
				//System.out.println(Arrays.toString(fallArray.toArray()));
				//System.out.println("Up above is the array accessed in another class");
		
		//first dialog box to be displayed
		JOptionPane.showMessageDialog(null,"Santa Fe College\n Academic Year 2019-2020\n Program Codes: 3624, 5651, and 6635\n\n"
				+ "Aggregate total number of student enrolled:                              " + getEnrolled(fallArray, springArray, summerArray) 
				+ "\n Aggregate total number of student completers:                       " + getCompleters(fallArray, springArray, summerArray)
				+ "\n\nAggregate percentage of students completing for the academic year: " 
				+ (df.format(getPercentCompleters(fallArray, springArray, summerArray)))
				+ "\n\nPercentage of students completing  Fall 2019:           " + (df.format(getFallCompleters(fallArray))) 
				+ "\nPercentage of students completing Spring 2020:      " + (df.format(getSpringCompleters(springArray)))
				+ "\nPercentage of students completing Summer 2020:  " + (df.format(getSummerCompleters(summerArray))));
		
		//second dialog box to be displayed
		JOptionPane.showMessageDialog(null,"Santa Fe College\n Academic Year 2019-2020\n Program Codes: 3624, 5651, and 6635\n\n"
				+ "Aggregate values for:\n\n"              
				+ "Female student completers:                  " + (df.format(getFemaleCompleters(fallArray, springArray, summerArray)))
				+ "\nMale student completers:                       " + (df.format(getMaleCompleters(fallArray, springArray, summerArray)))
				+ "\nUnknown/not reported completers:     " + (df.format(getUnknownCompleters(fallArray, springArray, summerArray)))
				+ "\n\nAsian completers:                                            " + (df.format(getAsianCompleters(fallArray, springArray, summerArray)))
				+ "\nBlack completers:                                            " + (df.format(getBlackCompleters(fallArray, springArray, summerArray)))
				+ "\nHispanic completers:                                      " + (df.format(getHispanicCompleters(fallArray, springArray, summerArray)))
				+ "\nMultiracial completers:                                   " + (df.format(getMultiracialCompleters(fallArray, springArray, summerArray)))
				+ "\nNative American completers:                        " + (df.format(getNativeAmCompleters(fallArray, springArray, summerArray)))
				+ "\nNative Hawaiian completers:                         " + (df.format(getHawaiianCompleters(fallArray, springArray, summerArray)))
				+ "\nUnknown/Not Reported completers:            " +  (df.format(getUnknownEthCompleters(fallArray, springArray, summerArray)))
				+ "\nWhite completers:                                            " + (df.format(getWhiteCompleters(fallArray, springArray, summerArray))));
		
		//write to file method to write to output file
		writeToFile(fallArray, springArray, summerArray, OutputFile());
		
	}
	
	//***********************************************First dialog box calculations*********************************************************
	
	//I used getters, but upon further research it was not the best way to return the values. Getters are usually used to access a private variable in 
	//another class, and since I am using the getter in the same class it is redundant. 
			
	//I could have used just normal return methods and not getters specifically. Or I could have separated this class into two classes and then used the 
	//getters to return values to the display class
			
	
	//this will get the aggregate number of students enrolled
	public int getEnrolled(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
	{
		
		//students enrolled is going to be the second element in the array
		//checked ****
		int totalEnrolled = fallArray.get(1) + fallArray.get(26) + fallArray.get(51) + springArray.get(1) 
		+ springArray.get(26) + springArray.get(51)+ summerArray.get(1) + summerArray.get(26) + summerArray.get(51) ;
		
		return totalEnrolled;
		
	}
	
	//this will get the aggregate number of student completers
		public int getCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
		{
			
			//students enrolled is going to be the second element in the array for each line
			//checked
			int totalCompleters = fallArray.get(2) + fallArray.get(27) + fallArray.get(52) + springArray.get(2) + springArray.get(27) 
			+ springArray.get(52) + summerArray.get(2) + summerArray.get(27) + summerArray.get(52);
			//System.out.println("*****************" + summerArray.get(52));
			return totalCompleters;
			
		}
		
		//this is going to divide the completers and the total enrolled to get the aggregate percentage
		public float getPercentCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
		{
			
			
			float completed = getCompleters(fallArray, springArray, summerArray);
			float enrolled = getEnrolled(fallArray, springArray, summerArray);
			//System.out.println("completed " + completed);
			//System.out.println("enrolled" + enrolled);
			float percentCompleters = completed/enrolled;
			
			//System.out.println("total" + percentCompleters);
			return percentCompleters;
			
		}
		
		//this will get fall completers which is the total fall completers/fall enrolled
		public float getFallCompleters(ArrayList<Integer> fallArray)
		
		{
			float fallCompleters = fallArray.get(2) + fallArray.get(27) + fallArray.get(52);
			float fallEnrolled = fallArray.get(1) + fallArray.get(26) + fallArray.get(51);
			float totalFallCompleters = fallCompleters/fallEnrolled;
			//System.out.println("total Fall" + totalFallCompleters);
			return totalFallCompleters;
			
			
			
		}
		
		//this will get the spring completers, which is the total spring completers/spring enrolled
		public float getSpringCompleters(ArrayList<Integer> springArray)
		
		{
			float springCompleters = springArray.get(2) + springArray.get(27) + springArray.get(52);
			float springEnrolled = springArray.get(1) + springArray.get(26) + springArray.get(51); 
			float totalSpringCompleters = springCompleters/springEnrolled;
			//System.out.println("total Spring" + totalSpringCompleters);
			return totalSpringCompleters;
			
			
			
		}
		
		//this will get the summer completers, which is the total summer completers/summer enrolled
		public float getSummerCompleters(ArrayList<Integer> summerArray)
		
		{
			float summerCompleters = summerArray.get(2) + summerArray.get(27) + summerArray.get(52);
			float summerEnrolled = summerArray.get(1) + summerArray.get(26) + summerArray.get(51);
			float totalSummerCompleters = summerCompleters/summerEnrolled;
			//System.out.println("total Summer" + totalSummerCompleters);
			return totalSummerCompleters;
			
			
			
		}
	
		//******************************************First Dialog box is done***************************************/
		
		
		
		//***********************************************Second dialog box calculations**********************************
		
		
		
		
		//getter to get female completers
		public float getFemaleCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
		{
			//get the total females enrolled (aggregate values)
			float enrolledFemale = fallArray.get(3) + fallArray.get(28) + fallArray.get(53) + springArray.get(3) + springArray.get(28)
				+ springArray.get(53) + summerArray.get(3) + summerArray.get(28) + summerArray.get(53);
	
			
			//get the total female completers
			float completersFemale = fallArray.get(6) + fallArray.get(31) + fallArray.get(56) + springArray.get(6) +  springArray.get(31)
			+ springArray.get(56) + summerArray.get(6) + summerArray.get(31) + summerArray.get(56);
			
			float totalFemaleCompleters = completersFemale/enrolledFemale;
			
			return totalFemaleCompleters;
				
			
			
		}
		
		//getter to get male completers
		public float getMaleCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
		{
			
			//get the total males enrolled (aggregate values)
			float enrolledMale = fallArray.get(4) + fallArray.get(29) + fallArray.get(54) + springArray.get(4) +  springArray.get(29)
			+ springArray.get(54) +  summerArray.get(4)  + summerArray.get(29) + summerArray.get(54);
			
			//get the total male completers
			float completersMale = fallArray.get(7) + fallArray.get(32) + fallArray.get(57) + springArray.get(7) + springArray.get(32)
			+ springArray.get(57) +  summerArray.get(7) + summerArray.get(32) + summerArray.get(57);
			
			float totalMaleCompleters = completersMale/enrolledMale;
			
			return totalMaleCompleters;
			
			
		}
		
		
		//getter to get unknown gender completers
		public float getUnknownCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
		{
			
			//get the total females enrolled (aggregate values)
			float enrolledUnknown = fallArray.get(5) + fallArray.get(30) + fallArray.get(55) + springArray.get(5) + springArray.get(30)
			+ springArray.get(55) + summerArray.get(5) + summerArray.get(30) + summerArray.get(55);
			
			//get the total female completers
			float completersUnknown = fallArray.get(8) +  fallArray.get(33) + fallArray.get(58) + springArray.get(8) + springArray.get(33)
			+ springArray.get(58) + summerArray.get(8) + summerArray.get(33) + summerArray.get(58);
			
			float totalUnknownCompleters = completersUnknown/enrolledUnknown;
			
			return totalUnknownCompleters;
			
			
		}
		
		//getter to get asian completers
				public float getAsianCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total females enrolled (aggregate values)
					float enrolledAsian = fallArray.get(9) + fallArray.get(34) + fallArray.get(59) + springArray.get(9) + springArray.get(34)
					+ springArray.get(59) + summerArray.get(9) + summerArray.get(34) + summerArray.get(59);
					
					//get the total female completers
					float completersAsian = fallArray.get(17) + fallArray.get(42) + fallArray.get(67) + springArray.get(17) + springArray.get(42)
					+ springArray.get(67) + summerArray.get(17) + summerArray.get(42) + summerArray.get(67);
					
					float totalAsianCompleters = completersAsian/enrolledAsian;
					
					return totalAsianCompleters;
					
					
				}
				
				public float getBlackCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total enrolled (aggregate values)
					float enrolledBlack = fallArray.get(10) + fallArray.get(35) +fallArray.get(60) + springArray.get(10) + springArray.get(35)
					+ springArray.get(60) + summerArray.get(10) + summerArray.get(35) + summerArray.get(60); 
					
					//get the total  completers
					float completersBlack = fallArray.get(18) + fallArray.get(43) + fallArray.get(68) + springArray.get(18) + springArray.get(43)
					+ springArray.get(68) + summerArray.get(18) + summerArray.get(43) + summerArray.get(68);
					
					float totalBlackCompleters = completersBlack/enrolledBlack;
					
					return totalBlackCompleters;
					
					
				}
				
				public float getHispanicCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total  enrolled (aggregate values)
					float enrolledHispanic = fallArray.get(11) + fallArray.get(36) + fallArray.get(61) +  springArray.get(11) + springArray.get(36)
					+ springArray.get(61) + summerArray.get(11) + summerArray.get(36) + summerArray.get(61);
					
					//get the total  completers
					float completersHispanic = fallArray.get(19) + fallArray.get(44) + fallArray.get(69) + springArray.get(19) + springArray.get(44)
					+ springArray.get(69) + summerArray.get(19) + summerArray.get(44) + summerArray.get(69);
					
					float totalHispanicCompleters = completersHispanic/enrolledHispanic;
					
					return totalHispanicCompleters;
					
					
				}

				
				public float getMultiracialCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total  enrolled (aggregate values)
					float enrolledMultiracial = fallArray.get(12) + fallArray.get(37) + fallArray.get(62) + springArray.get(12) + springArray.get(37)
					+ springArray.get(62) + summerArray.get(12) + summerArray.get(37) + summerArray.get(62);
					
					//get the total  completers
					float completersMultiracial = fallArray.get(20) + fallArray.get(45) + fallArray.get(70) + springArray.get(20) + springArray.get(45)
					+ springArray.get(70) + summerArray.get(20) + summerArray.get(45) + summerArray.get(70);
					
					float totalMultiracialCompleters = completersMultiracial/enrolledMultiracial;
					
					return totalMultiracialCompleters;
					
					
				}
				
				public float getNativeAmCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total  enrolled (aggregate values)
					float enrolledNativeAm = fallArray.get(13) + fallArray.get(38) + fallArray.get(63) + springArray.get(13) +  springArray.get(38)
					+  springArray.get(63) + summerArray.get(13) + summerArray.get(38) + summerArray.get(63); 
					
					//get the total  completers
					float completersNativeAm = fallArray.get(21) + fallArray.get(46) + fallArray.get(71) + springArray.get(21) + springArray.get(46)
					+ springArray.get(71) +  summerArray.get(21) + summerArray.get(46) + summerArray.get(71);
					
					float totalNativeAmCompleters = completersNativeAm/enrolledNativeAm;
					
					return totalNativeAmCompleters;
					
					
				}
				
				public float getHawaiianCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total  enrolled (aggregate values)
					float enrolledHawaiian = fallArray.get(14) + fallArray.get(39) + fallArray.get(64) +  springArray.get(14) + springArray.get(39)
					+ springArray.get(64) +  summerArray.get(14) + summerArray.get(39) + summerArray.get(64);
					
					//get the total completers
					float completersHawaiian = fallArray.get(22) +  fallArray.get(47) +  fallArray.get(72) + springArray.get(22) + springArray.get(47)
					+ springArray.get(72) + summerArray.get(22) + summerArray.get(47) + summerArray.get(72);
					
					float totalHawaiianCompleters = completersHawaiian/enrolledHawaiian;
					
					return totalHawaiianCompleters;
					
					
				}
				
				
				public float getUnknownEthCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total  enrolled (aggregate values)
					float enrolledUnknownEth = fallArray.get(15) + fallArray.get(40) + fallArray.get(65) + springArray.get(15) +  springArray.get(40)
					+  springArray.get(65) + summerArray.get(15) + summerArray.get(40) + summerArray.get(65);
					
					//get the total completers
					float completersUnknownEth = fallArray.get(23) + fallArray.get(48) + fallArray.get(73) + springArray.get(23) + springArray.get(48)
					+ springArray.get(73) + summerArray.get(23) + summerArray.get(48) + summerArray.get(73);
					
					float totalUnknownEthCompleters = completersUnknownEth/enrolledUnknownEth;
					
					return totalUnknownEthCompleters;
					
					
				}
				
				
				public float getWhiteCompleters(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray)
				{
					
					//get the total  enrolled (aggregate values)
					float enrolledWhite = fallArray.get(16) + fallArray.get(41) + fallArray.get(66) + springArray.get(16) + springArray.get(41) 
					+ springArray.get(66) +  summerArray.get(16) + summerArray.get(41) + summerArray.get(66);
					
					//get the total completers
					float completersWhite = fallArray.get(24) + fallArray.get(49) + fallArray.get(74) + springArray.get(24) + springArray.get(49)
					+ springArray.get(74) + summerArray.get(24) + summerArray.get(49) + summerArray.get(74);
					
					float totalWhiteCompleters = completersWhite/enrolledWhite;
					
					return totalWhiteCompleters;
					
					
				}
				
				//*******************************************Output file management*************************************************
				
				 public PrintWriter OutputFile()
				 {
					
							//open file you want to write to
							PrintWriter outputAnalytics = null;
							try {
								
								//one slash represents the beginning of an escape sequence, so you must do two slashes
								outputAnalytics = new PrintWriter("C:\\SFC\\COP2552\\Project4\\Analytics2019.txt");
								
							} 
							
							
							catch (FileNotFoundException e) {
								JOptionPane.showMessageDialog(null, "Analytics2019.txt not found");
								
								System.exit(0);	
							}	 
							
							return outputAnalytics;
				 }
				
				public void writeToFile(ArrayList<Integer> fallArray, ArrayList<Integer> springArray, ArrayList<Integer> summerArray, PrintWriter outputAnalytics)
				{
					//output the title of the file
					outputAnalytics.println("2019");
					
					int total = 0;
					int totalFirstProgram = 0;
					int totalSecondProgram = 0;
					int totalThirdProgram = 0;
					
					//aggregates of all three files, all programs added up
					//3624: 0-24, 5651: 25-49, 6635: 50-74 (program code and their information as related to the array)
					//First section is total aggregate of all of them. So add all corresponding indexes and increase by one to step through the whole file
					
					//different than the input files so have to adjust
					//total enrolled
					outputAnalytics.println(getEnrolled(fallArray, springArray, summerArray));
					
					//total completers
					outputAnalytics.println(getCompleters(fallArray, springArray, summerArray));
					
					//total female students enrolled 
					outputAnalytics.println(fallArray.get(3) + fallArray.get(28) + fallArray.get(53) + springArray.get(3) + springArray.get(28)
					+ springArray.get(53) + summerArray.get(3) + summerArray.get(28) + summerArray.get(53));
					
					//total female completers
					outputAnalytics.println(fallArray.get(6) + fallArray.get(31) + fallArray.get(56) + springArray.get(6) +  springArray.get(31)
					+ springArray.get(56) + summerArray.get(6) + summerArray.get(31) + summerArray.get(56));
					
					//total male enrolled
					outputAnalytics.println(fallArray.get(4) + fallArray.get(29) + fallArray.get(54) + springArray.get(4) +  springArray.get(29)
					+ springArray.get(54) +  summerArray.get(4)  + summerArray.get(29) + summerArray.get(54));
					
					//total male completers
					outputAnalytics.println(fallArray.get(7) + fallArray.get(32) + fallArray.get(57) + springArray.get(7) + springArray.get(32)
					+ springArray.get(57) +  summerArray.get(7) + summerArray.get(32) + summerArray.get(57));
					
					//total unknown enrolled
					outputAnalytics.println(fallArray.get(5) + fallArray.get(30) + fallArray.get(55) + springArray.get(5) + springArray.get(30)
					+ springArray.get(55) + summerArray.get(5) + summerArray.get(30) + summerArray.get(55));
					
					//total unknown completers
					outputAnalytics.println(fallArray.get(8) +  fallArray.get(33) + fallArray.get(58) + springArray.get(8) + springArray.get(33)
					+ springArray.get(58) + summerArray.get(8) + summerArray.get(33) + summerArray.get(58));
					
					for (int i = 0; i < 16; i++)
					{
						
					total = fallArray.get(9+i) + fallArray.get(34+i) + fallArray.get(59+i) + springArray.get(9+i) + springArray.get(34+i) 
					+ springArray.get(59+i) + summerArray.get(9+i) + summerArray.get(34+i) + summerArray.get(59+i);
					
					//Testing issues
					//System.out.println(springArray.get(1)  +  springArray.get(26) + springArray.get(51) + "This is what I am testing");
					
					outputAnalytics.println(total);
					total = 0;
					
					}
					
					//outputAnalytics.println("\n");
					
					//next print totals for program code 3624. This is elements numbers 1-24 in each array
					outputAnalytics.println("3624");
					for (int i = 0; i < 24; i++)
					{
						totalFirstProgram = fallArray.get(1 + i) + springArray.get(1 + i) + summerArray.get(1 + i);
						
						outputAnalytics.println(totalFirstProgram);
						
					}
				
					//outputAnalytics.println("\n");
					
					//next print totals of program code
					outputAnalytics.println("5651");
					for (int i = 0; i < 24; i++ )
					{
						totalSecondProgram = fallArray.get(26 + i) + springArray.get(26 + i) + summerArray.get(26 + i);
						
						outputAnalytics.println(totalSecondProgram);
						
					}
					
					//outputAnalytics.println("\n");
					
					//next print totals of program code
					outputAnalytics.println("6635");
					for (int i = 0; i < 24; i++ )
					{
						totalThirdProgram = fallArray.get(51 + i) + springArray.get(51 + i) + summerArray.get(51 + i);
						
						outputAnalytics.println(totalThirdProgram);
						
					}
					
					//close the output file
					close(outputAnalytics);
					
					
				
				}
				
				 //close the PrintWriter for the output file method
				 public void close(PrintWriter outputFile)
				 {
					 outputFile.close();
				 }
			
				
}

