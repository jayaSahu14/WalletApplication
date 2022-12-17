package com.validation;

public class Validation {
	
	public boolean validateName(String str) {
		return str.matches("[a-zA-Z]+");
	}
	public boolean validateEmail(String str) {
		return str.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
	}
	public boolean validateContact(String str) {
		return str.matches("[6789]\\d{9}");
	}
	public boolean validatePassword(String str) {
		return str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$");
	}
	public boolean validatePincode(String str) {
		return str.matches("[0-9]{6}");
	}
	
	public boolean ValidateOpeningBalance(double b) {
		double minBalance=1000;
		if(b<minBalance) {
			return false;
		}
		return true;
	}

}
