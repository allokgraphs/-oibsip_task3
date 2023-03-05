import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class transhist{
	void add(int amt,int choice,List<String> transhist1) {
		if(choice == 2) {
			String transaction = amt+" has been withdrawn";
			transhist1.add(transaction);
		}
		else {
			String transaction = amt+" deposited";
			transhist1.add(transaction);
		}
	}
	void add(int amt,String rec,List<String> transhist1) {
		String transaction = amt+" transferred to "+rec;
		transhist1.add(transaction);
	}
	void display(List<String> transhist1) {
		if(transhist1.size() == 0) {
			System.out.println("No Transactions yet!");
		}
		else {
			for(int i=1;i<=transhist1.size();i++) {
				System.out.println("Transaction "+i+" : "+transhist1.get(i-1));
			}
		}
	}
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.*;
class bankaccount{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name :");
        ATM.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter your Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Bad value! Enter again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class withdraw {
	int draw(int bal,int amt) {
		bal = bal - amt;
		return bal;
	}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance){
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wcash+"/-withdraw successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+dcash+"/- deposit successful!");
        System.out.println("---------------------------");
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiving body:");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiving body");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance){
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+tcash+"/- transferred successfully");
            System.out.println("---------------------------");
        }
        else{
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
    }
}
class deposit{
	int add(int bal,int amt) {
		bal = bal + amt;
		return bal;
	}
class check{
    static void checkbalance(){
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        ATM.showbalance();
        System.out.println("---------------------------");
        ATM.prompt();
    }
}
class transfer{
	int trans(int bal,int amt) {
		bal = bal - amt;
		return bal;
	}
class his{
    static void transactionhistory(){
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println("---------------------");
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM.prompt();
    }
}
public class ATM {
	public static void main(String args[]) {
		List<String> transhist1 = new ArrayList<>();
		String userid = "7218381521";
		int password = 7218;
		int balance = 100000;
		int amount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your User ID:");
		String id = sc.nextLine();
		System.out.println("Enter your password:");
		int pword = sc.nextInt();
		boolean leave=true;
		if(userid.equals(id) && password==pword) {
			System.out.println("Welcome! Your account balance is "+balance);
			do {
				System.out.println("\nPress the corresponding numbers:");
				System.out.println("1.Transaction History\n2.Deposit Money\n3.Withdraw Money\n4.Transfer Money\n5.Exit\n");
				int choice = sc.nextInt();
				transhist objx;
				switch(choice) {
				case 1: transhist obj = new transhist();
						obj.display(transhist1);
					    break;
				case 2: System.out.println("Enter amount to be deposited:");
                    amount = sc.nextInt();
                    deposit obj2 = new deposit();
                    balance = obj2.add(balance, amount);
                    objx = new transhist();
                    objx.add(amount,3,transhist1);
                    System.out.println("Successfully deposited!");
                    System.out.println("Current Balance: "+balance);
                    break;
				case 3: 
                        System.out.println("Enter amount to be withdrawn:");
						amount = sc.nextInt();
						if(amount > balance) {
							System.out.println("Amount greater than balance");
							break;
						}
						withdraw obj1 = new withdraw();
					    balance = obj1.draw(balance, amount);
					    objx = new transhist();
						objx.add(amount,2,transhist1);
					    System.out.println("Money is Successfully Withdrawn!");
					    System.out.println("Current Balance is: "+balance);
					    break;
				case 4: System.out.println("Enter amount to be transfered:");
						amount = sc.nextInt();
						if(amount > balance) {
							System.out.println("Amount is greater than balance");
							break;
						}
						System.out.println("Enter receipent Number:");
						String rec = sc.next();
						transfer obj3 = new transfer();
					    balance = obj3.trans(balance, amount);
					    objx = new transhist();
						objx.add(amount,rec,transhist1);
					    System.out.println("Successfully transferred to "+rec+"!");
					    System.out.println("Current Balance: "+balance);
					    break;
				case 5: leave = false;
					    break;
				default: System.out.println("Invalid Choice");

				}
			}while(leave);
		}
		else {
			System.out.println("Wrong Credentials");
		}
		sc.close();
	}
}
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash){
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void homepage(){
        System.out.println("\033[H\033[2J");
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1){
                bankaccount.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("select a value only from the given options :");
                homepage();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}
