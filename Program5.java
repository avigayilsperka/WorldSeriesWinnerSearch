/*Avigayil Marcus
 * Program 5
 * 05/11/22
 */

import java.io.*;
import java.util.*;

public class Program5 {
	public static void main (String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
	
		try {
			//connect file and scanner
			File winsFile = new File("WorldSeriesWinners.txt");
			Scanner scanFile = new Scanner(winsFile);
			
			String[]array = new String[104];
			
			//read file and assign to array	
			try {
				for (int x=0; x<array.length; x++) {
					array [x]= scanFile.nextLine();	
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Error: Array index out of bounds.");
			}
			scanFile.close();
		
			//title 
			System.out.println("Winning Teams from 1903 - 2009:\n");
			System.out.println("Type 1 to enter a team name or 0 to quit:");
			String key =input.nextLine();
		
			while (key.equals("1")){
			
				//collect search team
				String teamName = teamName(input);
			
				//search team passing array team and array
				int ctr = teamSearch(array, teamName);
			
				//print results
				System.out.println(teamName + " had "+ ctr+ " wins.");
			
				//option to loop
				System.out.println("\nType \"1\" to search again or \"0\" to quit:");
				key= input.nextLine();	
			}
		
			System.out.println("Thank you for using this program. Goodbye.");
		}
		catch(FileNotFoundException e) {
			System.out.println("Error! File not found.");
			System.exit(1);
		}
	}
	
	
	public static String teamName(Scanner input) {
		//collect team name
		System.out.println("Enter the name of the team you would like to search for:");
		return input.nextLine();
	}
	
	public static int teamSearch(String[] wins, String teamName) {
		int ctr=0;
		
		//search for team with counter
		for (int x = 0; x< wins.length;x++) {
			if (wins[x].equalsIgnoreCase(teamName))
				ctr++; 
		}
		return ctr;
	}

}
