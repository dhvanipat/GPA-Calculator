package GPA;

public class Course {
	String courseName;
	double credits;
	String grade;

	public Course(String courseName, double credits, String grade) {
		this.courseName = courseName;
		this.credits = credits;
		this.grade = grade;
	}
	
	public String getName() { return courseName; }
	public double getCredits() { return credits; }
	public String getGrade() { return grade; }
}
