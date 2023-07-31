package GPA;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class GPACalculator {
	static ArrayList<String> classes = new ArrayList<String>();
	static ArrayList<Double> credits = new ArrayList<Double>();
	static ArrayList<String> grades = new ArrayList<String>();

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int x = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
		do {
			
			String str = reader.readLine();
			while(str != null) {
				classes.add(str);
				credits.add(Double.parseDouble(reader.readLine()));
				grades.add(reader.readLine());
				System.out.println("GPA: " + calculate());
				str = reader.readLine();
			
			}
			
			//repeat?
			String input = new String();
			do {
				System.out.print("Add another class? ");
				input = s.next().toLowerCase();
				s.nextLine();
				if(input.equals("y") || input.equals("n") || input.equals("yes") || input.equals("no")){
					break;
				}
				System.out.println("ERROR: Invalid input enter Y/N");
			}while(true);
			if(input.equals("n") || input.equals("no")) {
				break;
			}
						
			System.out.println();

		}while(true);
		System.out.println("\n\n\n\n\n");
		
		for(int i = 0; i < classes.size(); i++) {
			writer.write(classes.get(i));
		}
		reader.close();
		writer.close();
		
		System.out.println("GPA: " + calculate());
		

		
		} catch (IOException e) {
			e.printStackTrace();
		};	
	}
	
	
	static double calculate() {
		double gradePoints = 0, totalCredits = 0;
		for(int i = 0; i < classes.size(); i++) {
			totalCredits += credits.get(i);
			gradePoints += weightByGrade(grades.get(i)) * credits.get(i);
		}
		return gradePoints/totalCredits;
	}
	
	static double weightByGrade(String grade){
		if(grade.equals("A")) {
			return 4.0;
		}else if(grade.equals("B+")) {
			return 3.5;
		}else if(grade.equals("B")) {
			return 3.0;
		}else if(grade.equals("C+")) {
			return 2.5;
		}else if(grade.equals("C")) {
			return 2.0;
		}else if(grade.equals("D")) {
			return 1.0;
		}else if(grade.equals("F")) {
			return 0.0;
		}else {
			System.out.println("ERROR: Invalid grade");
			return -100000000.0;
		}
	}
}
