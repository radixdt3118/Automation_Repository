package Session_4;

import java.util.*;

abstract class Marks{
	
	abstract void getPercentage();
}

class Percentage extends Marks{
	void getPercentage(){
		
	}
}

class Student_A extends Marks{
	int[] marks;
	Student_A(int[] m) {
		this.marks = m;
	}
	
	void getPercentage() {
		int sum = 0;
		for (int i : marks) {
			sum+=i;
		}
		System.out.println("Percentage obtained for Student A : "+((double)sum/marks.length+"%"));
	}
}

class Student_B extends Marks{
	
	int[] marks;
	Student_B(int[] m) {
		this.marks = m;
	}
	
	void getPercentage() {
		int sum = 0;
		for (int i : marks) {
			sum+=i;
		}
		System.out.println("Percentage obtained for Student B : "+((double)sum/marks.length+"%"));
	}
}

public class Student_Percentage {

	public static void main(String[] args) {
		
		int[] marks_A = {70,80,90};
		Student_A Joy = new Student_A(marks_A);
		Joy.getPercentage();
		
		int[] marks_B = {80,85,90,95};
		Student_B James = new Student_B(marks_B);
		James.getPercentage();
		
	}
	
}