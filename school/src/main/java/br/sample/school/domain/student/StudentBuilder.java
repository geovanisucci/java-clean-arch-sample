package br.sample.school.domain.student;

public class StudentBuilder {
	
	private Student student;
	
	public Student createWithNameRegistrationEmail(String name, String registrationNumber, String email) {
		
		this.student = new Student(new Registration(registrationNumber), name, new Email(email));
		
		return this.student;
	}
	
	public StudentBuilder addPhoneNumber(String code, String number) {
		
		this.student.addPhone(code, number);

		return this;
	}
}