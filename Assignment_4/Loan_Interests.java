package Session_4;
import java.util.*;

class Bank{
	String bank_name;
	double rate;
	void displayWithInterest(int amount) {
			double Interest_Rate_Amount = ((double)amount*rate/100);
			System.out.format("\nBank name : %s\nLoan Amount : %d\nInterest rate : %.2f\nLoan Interest Amount : %.2f\nTotal payable amount %.2f\n",bank_name,amount,rate ,Interest_Rate_Amount , (amount+Interest_Rate_Amount));
			System.out.println("-------------------------------------");
		}
}
	

class Axis extends Bank{
	Axis(){
		bank_name = "Axis";
		rate=8;
	}
}

class SBI extends Bank{
	SBI(){
		bank_name = "SBI";
		rate=7;
	}
}

class ICICI extends Bank{
	ICICI(){
		bank_name = "ICICI";
		rate=9;
	}
}



public class Loan_Interests {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter loan amount");
		int loan_amount = sc.nextInt();
		sc.close();
		
		Axis axis = new Axis();
		SBI sbi = new SBI();
		ICICI icici = new ICICI();
		
		axis.displayWithInterest(loan_amount);
		sbi.displayWithInterest(loan_amount);
		icici.displayWithInterest(loan_amount);
						
		
	}
	
}
