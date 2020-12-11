package br.sample.school.student;

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

	public void addPhone(String code, String number) {
		this.phones.add(new Phone(code, number));
	}
}