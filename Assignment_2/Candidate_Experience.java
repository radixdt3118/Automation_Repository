package demo;
import java.time.*;
import java.util.*;

public class Candidate_Experience {

	public static void main(String[] args) {
		
		
		int current_year = Year.now().getValue();
		int current_month= YearMonth.now().getMonthValue();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter birth year & month (Press enter for month) of candidate");
		int birth_year = sc.nextInt();
		int birth_month = sc.nextInt();
		
		System.out.println("Enter year & month (Press enter for month) of job started");
		int job_year = sc.nextInt();
		int job_month = sc.nextInt();
		
		sc.close();
		
		
		//Condition 1 : Age <= 40
		double age = (current_year - birth_year) + (((double)current_month-(double)birth_month)/10);
		System.out.println("Candidate's age is : "+ age +" Years");
		boolean condition_1 = (age<=40);	
		
		
		//Condition 2 : Experience < 22 Years
		double experience = (current_year - job_year) + (((double)current_month-(double)job_month))/10;
		System.out.println("Candidate's working experience is : "+ experience + " Years");
		boolean condition_2 = (experience < 22);
		
		if(condition_1 & condition_2==true) {
			System.out.println("Candidate is eligible for the job");	
		}
		else {
			System.out.println("Eligibility criterias aren't matched for job");
		}
	

		
	}	
	
}
