package br.sample.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private Registration registrationNumber;
	private String name;
	private Email email;
	private List<Phone> phones = new ArrayList<Phone>();
	
	public Student(Registration registrationNumber, String name, Email email) {		
		this.registrationNumber = registrationNumber;
		this.name = name;
		this.email = email;
	}
	
	

	public Student() {
	}



	public void addPhone(String code, String number) {
		this.phones.add(new Phone(code, number));
	}
	
	public String getRegistrationNumber() {
		return registrationNumber.getNumber();
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email.getAddress();
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
}