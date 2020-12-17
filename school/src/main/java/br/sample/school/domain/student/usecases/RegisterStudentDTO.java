package br.sample.school.domain.student.usecases;

import br.sample.school.domain.student.Student;
import br.sample.school.domain.student.StudentBuilder;

public class RegisterStudentDTO {
	
	private String name;
	private String registrationNumber;
	private String email;
	
	public RegisterStudentDTO(String name, String registrationNumber, String email) {
		
		this.name = name;
		this.registrationNumber = registrationNumber;
		this.email = email;
	}
	
	public Student Parse()
	{
		StudentBuilder sb = new StudentBuilder();
		Student s = sb.createWithNameRegistrationEmail(name, registrationNumber, email);
		
		return s;
	}

}
