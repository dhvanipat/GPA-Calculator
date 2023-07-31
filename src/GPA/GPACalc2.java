package GPA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GPACalc2 {
	static ArrayList<Course> myClasses = new ArrayList<Course>();
	
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));


		String name = reader.readLine();
		while(name != null) {
			double credits = Double.parseDouble(reader.readLine());
			String grade = reader.readLine();
			myClasses.add(new Course(name, credits, grade));
			name = reader.readLine();
		}
	
		print();
		printGPA();
		
		for(int i = 0; i < myClasses.size(); i++) {
			writer.write(myClasses.get(i).getName() + "\n" + myClasses.get(i).getCredits() + "\n" + myClasses.get(i).getGrade() + "\n");
		}
		System.out.println("QUIT");
		writer.close();
		reader.close();
		
		
	}
	
	static void print() {
		for(int i = 0; i < myClasses.size(); i++) {
			System.out.println(myClasses.get(i).getName() + "\t\t" + myClasses.get(i).getCredits() + "\t\t" + myClasses.get(i).getGrade());
		}
	}
	
	static void printGPA() {
		double totalCredits = 0, gradepoints = 0, gpa = 0;
		for(int i = 0; i < myClasses.size(); i++) {
			totalCredits += myClasses.get(i).getCredits();
			gradepoints += weightByGrade(myClasses.get(i).getGrade()) * myClasses.get(i).getCredits();
		}
		gpa = gradepoints/totalCredits;
		System.out.println(gpa);
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