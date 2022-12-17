package com.view;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import com.dao.AccountDao;
import com.dao.CustomerDao;
import com.exceptions.InvalidChoiceexception;
import com.exceptions.InvalidInputException;
import com.exceptions.PasswordNotMatchException;
import com.model.Account;
import com.model.AccountType;
import com.model.Address;
import com.model.Customer;
import com.model.Gender;
import com.validation.Validation;

public class UserInterface {
	public static long customerId=1;
	public static int addressId=1;
	public AtomicLong accountTd = new AtomicLong(1019888);
	Scanner sc = new Scanner(System.in);
	CustomerDao cd = new CustomerDao();
	AccountDao ad = new AccountDao();
	Validation v = new Validation();
	Customer currentCustomer = new Customer();
	public void mainMenu() {
		System.out.println("\n******************Menu***************\n");
		System.out.println("1. Sign In /Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit\n");
	}
	public void subMenu() {
		System.out.println("\n*********************Sub Menu*****************\n");
		System.out.println("1. Create Account");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Fund Transfer");
		System.out.println("5. Find account");
		System.out.println("6. List all Account");
		System.out.println("7. Transcation Summary");
		System.out.println("8. LogOut\n");
	}
	
	public void registerUser() throws InvalidChoiceexception, PasswordNotMatchException, InvalidInputException {
		Customer c = new Customer();
		Address a = new Address();
		c.setCustomerId(customerId);
		customerId= customerId+1;
		System.out.println("Enter first Name:");
		String firstName = sc.next();
		if(v.validateName(firstName)) {
			c.setFirstName(firstName);
		}
		else {
			throw new InvalidInputException("First name should be Alphabetic");
		}
		System.out.println("Enter Last Name: ");
		String lastName = sc.next();
		if(v.validateName(lastName)) {
			c.setLastName(lastName);
		}
		else {
			throw new InvalidInputException("Last name should be Alphabetic");
		}
		
		System.out.println("Enter email Id: ");
		String email = sc.next();
		if(v.validateEmail(email)) {
			c.setEmailId(email);
		}
		else {
			throw new InvalidInputException("Email should be in format ex: abcd@gamil.com");
		}
		
		System.out.println("Enter contact No :");
		String contact = sc.next();
		if(v.validateContact(contact)) {
			c.setContactNo(contact);
		}
		else {
			throw new InvalidInputException("Invalid contact no.");
		}
		
		System.out.println("Select Gender");
		System.out.println("1. Male");
		System.out.println("2. Female");
		int i= sc.nextInt();
		if(i==1) {
			c.setGender(Gender.MALE);
		}
		else if (i==2) {
			c.setGender(Gender.FEMALE);
		}
		else {
			throw new InvalidChoiceexception("Invalid choice");
		}
		System.out.println("Enter Password: ");
		String password = sc.next();
		if(v.validatePassword(password)) {
			System.out.println("confirm Password: ");
			String cpassword = sc.next();
			if(password.equals(cpassword)) {
				c.setPassword(password);
			}
			else {
				throw new PasswordNotMatchException("Password doesn't match");
			}
		}
		else {
			throw new InvalidInputException("Password should be atleast 8 character long "
					+ "should contain 1 upper case 1 Lowercase 1 special character 1 numeric");
		}
		
		
		c.setRegistrationDate(LocalDate.now());
		a.setAddressId(addressId);
		addressId=addressId+1;
		System.out.println("Enter AddressLine 1: ");
		a.setAddressLine1(sc.next());
		System.out.println("Enter AddressLine 2: ");
		a.setAddressLine2(sc.next());
		System.out.println("Enter city: ");
		a.setCity(sc.next());
		System.out.println("Enter State: ");
		a.setState(sc.next());
		System.out.println("Enter pincode: ");
		String pincode = sc.next();
		if(v.validatePincode(pincode)) {
			a.setPincode(pincode);
		}
		else {
			throw new InvalidInputException("pincode should be 6 digit");
		}
		
		c.setAddress(a);
		cd.registerCustomer(c);
		System.out.println("Registration successfull");
		
		
		
		
	}
	
	public boolean login() {
		System.out.println("Enter Email id:");
		String emailId=sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		boolean f = cd.validateCustomer(emailId, password);
		if(f) {
			for(Customer c:cd.customerList) {
				if(c.getEmailId().equals(emailId)) {
					this.currentCustomer=c;
				}
			}
		}
		return f;
	}
	
	public void createAccount() throws InvalidChoiceexception, InvalidInputException {
		Account a = new Account();
		a.setAccountNumber(accountTd.incrementAndGet());
		a.setCustomer(currentCustomer);
		System.out.println("Select Account Type:"
				+ " 1.Saving"
				+ " 2.Current"
				+ " 3.Salary"
				+ " 4.FD"
				+ " 5.RD"
				+ " 6.Loan");
		System.out.println("Enter choice:");
		int ch = sc.nextInt();
		switch(ch) {
		
		case 1:a.setAccountType(AccountType.SAVING);
				break;
		case 2:a.setAccountType(AccountType.CURRENT);
		break;
		case 3:a.setAccountType(AccountType.SALARY);
		break;
		case 4:a.setAccountType(AccountType.FD);
		break;
		case 5:a.setAccountType(AccountType.RD);
		break;
		case 6:a.setAccountType(AccountType.LOAN);
		break;
		default:
			throw new InvalidChoiceexception("Invalid choice");
		}
		System.out.println("Enter Opening Balance:");
		double balance = sc.nextDouble();
		if(v.ValidateOpeningBalance(balance)) {
			a.setOpeningBalance(balance);
		}
		else {
			throw new InvalidInputException("opening Balance Must be atleast 1000rs");
		}
		a.setOpeningDate(LocalDate.now());
		System.out.println("Enter Description: ");
		sc.nextLine();
		a.setDescription(sc.nextLine());
		
		
		System.out.println(ad.addAccount(currentCustomer, a));
		System.out.println("Account Created successfully");
		
		
		
		
	}
	public void ListAccounts() {
		if(currentCustomer.getAccount().isEmpty()) {
			System.out.println("\nNo Account Found");
		}
		else {
			int i=1;
			for(Account a : currentCustomer.getAccount()) {
				System.out.println("\nAccount "+i);
				i=i+1;
				System.out.println("Account Number: "+a.getAccountNumber());
				System.out.println("Account Type: "+a.getAccountType());
				System.out.println("Balance : "+a.getOpeningBalance());
				System.out.println("Opening date: "+a.getOpeningDate());
				System.out.println("Description: "+a.getDescription());
			}
		}
	}
	
	

}
