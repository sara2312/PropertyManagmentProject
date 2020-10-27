/**
 * 
 */
package org.com1027.question1;
import java.io.*;
/**
 * @author agossousara
 *
 */
public class Agency {
	//Fields declaration and initialisation
	private String name = null;
	private String phoneNumber = null;
	private static final String PHONE_NUMBER_REGEX = "[0-9]{5}\\s[0-9]{6}";
	private static final String NAME_REGEX = "[A-Z]{1}[a-z]*\\s[A-Z]{1}[a-z]*";
	
	/*
	 * parametrised constructor
	 * @param name
	 * @param phoneNumber
	 * @throws IllegalArgumentException
	 * */
	public Agency(String name, String phoneNumber) {
		
		super();
		
		if(name.matches(NAME_REGEX)) {
			this.name = name;
		}
		else {
			throw new IllegalArgumentException("The name is invalid");
		}
		if(phoneNumber.matches(PHONE_NUMBER_REGEX)) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new IllegalArgumentException("The phone number is invalid");
		}
		
	}
	
	//Methods declaration
	
	//returns the name of an agency
	
	public String getName() {
		
		return this.name;
	}
	
	//returns the phoneNumber of an agency
	
	public String getPhoneNumber() {
		
		return this.phoneNumber;
	}
	
	//returns the informations of an agency
	
	@Override
	public String toString() {
		
		StringBuffer agencyInformations = new StringBuffer();
		agencyInformations.append("Agency: ");
		agencyInformations.append(this.getName()+ ",");
		agencyInformations.append(" Phone Number: ");
		agencyInformations.append(this.getPhoneNumber());
		
		return agencyInformations.toString();
		
		
		
		}

}
