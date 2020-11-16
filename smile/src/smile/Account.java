package smile;

import java.util.Scanner;

public class Account {
	//make Variables
	int balance;
	int previoustransaction;
	String customername;
	String customerid;
	
	//make constructors
	Account(String cname,String cid){
		customername = cname;
		customerid = cid;

	}
	//Function for depositing Money
	void deposit(int amount) {
		if (amount!=0) {
			balance = balance + amount;
			previoustransaction = amount;
			
		}
	}
    //Function for withdrawal the money
	void withdrawal(int amount) {
		balance = balance - amount;
		previoustransaction = -amount;
		
	}
	//Function for previous transaction
	void getprevtransaction() {
		if( previoustransaction > 0) {
			System.out.println("Deposited :"+ previoustransaction);
		}else if (previoustransaction <0) {
			System.out.println("withdrawan :" + Math.abs(previoustransaction));
		}else {
			System.out.println("NO TRANSACTION OCCURED");
		}
	}
	//Function for calculating the interest 
	void calculateinterest(int years) {
		double interestrate = 0.185;
		double newbalance = (balance * interestrate * years) + balance ;
		System.out.println("the current interest is" + (100 * interestrate));
		System.out.println("After " + years + " Your balance will be : " + newbalance);
		
	}
	//Function for the main menu
	void showMenu() {
		char option ='\0';
		Scanner scanner =new Scanner(System.in);
		System.out.println("Welcome a" + customername +" !");
		System.out.println();
		System.out.println("What you want to do?");
		System.out.println();
		System.out.println("A : Check your balance");
		System.out.println("B : Make a deposit");
		System.out.println("C : Make a withdrawal");
		System.out.println("D : Check Previous Transaction");
		System.out.println("E : Calculate your interest");
		System.out.println("F : Exit");
		
		do {
			System.out.println();
			System.out.println("Enter your option :");
			char option1 = scanner.next().charAt(0); //so that if the user entered an entire 
			//word the system gonna take only the first letter
	        option = Character.toUpperCase(option1); //we made two options because we want to
	        //give the user an opportunityanswer either in upper or lowercase,LAZY
	        System.out.println();
	        
	        switch(option) {
	        //Case 'A' allows the user to Check money into their account
	        case 'A' :
	        	System.out.println("********************************************");
	        	System.out.println("Balance is =$ " + balance);
	        	System.out.println("********************************************");
	        	System.out.println();
	        	break;
	        	
	        //Case 'B' allows the user to deposit money into their account
	        case 'B':
	        	System.out.println("Enter the amount to deposit : ");
	        	int amount = scanner.nextInt();//created this becuz the user will an amount so we created it with
	        	// a scanner nextint and the integer value is amount i.e. a variable
	        	deposit(amount);
	        	System.out.println();
	        	break;
	         
	        //Case 'C' helps the user to withdraw the money from their account 
	        case 'C' :
	        	System.out.println("Enter the amount you want to withdraw :");
	        	int amount1 =scanner.nextInt();
	        	withdrawal(amount1);
	        	System.out.println();
	        	break;
			
	        	
	        //Case 'D' helps the user to check the previous transaction he/she made
	        case 'D' :
	        	System.out.println("*********************************************");
	        	getprevtransaction();
	        	System.out.println("**********************************************");
	        	System.out.println();
	        	break;
	        	
	        //Case 'E' helps the user to find the interest
	        case 'E' :
	        	System.out.println("Enter how many years of accrued interest you want to know : ");
	        	int years = scanner.nextInt();
	        	calculateinterest(years);
	        	break;
	        	
	        //Case 'F' is for Exit
	        case 'F' :
	        	System.out.println("*********************************************");
	        	break;
	        
	        //default case for letting the user know that he entered invalid option
	        default:
	        	System.out.println("ERROR :invalid option.Please enter Valid Option :A, B, C,D,E,F  ");
	        	break;
	        	
	        }
	}while(option != 'F');
		System.out.println("THANKYOU FOR BANKING WITH US! :)");
}
}
