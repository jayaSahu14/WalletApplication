package com.boot;

import java.util.Scanner;

import com.exceptions.InvalidChoiceexception;
import com.exceptions.InvalidInputException;
import com.exceptions.PasswordNotMatchException;
import com.view.UserInterface;

public class BootClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserInterface ui = new UserInterface();
		int i=0;
		while(i!=3) {
			ui.mainMenu();
			i=sc.nextInt();
			if(i==1) {
				if(ui.login()) {
					int j=0;
					while(j!=8) {
						ui.subMenu();
						j=sc.nextInt();
						
						switch(j) {
						case 1:try {
								ui.createAccount();
							} catch (InvalidChoiceexception | InvalidInputException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							break;
							
						case 2:
							break;
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						case 6: ui.ListAccounts();
							break;
						case 7:
							break;
						case 8:
							break;
						default:
							System.out.println("Invalid Choice");
						
						}
					}
				}
				else {
					System.out.println("Invalid User");
				}
			}
			else if(i==2) {
				try {
					ui.registerUser();
				} catch (InvalidChoiceexception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (PasswordNotMatchException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			else if(i==3) {
				System.out.println("Bye");
			}
			else {
				System.out.println("Invalid choice");
			}
			
		}
		
		
	}

}
