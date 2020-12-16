package br.sample.school;

import br.sample.school.domain.student.IStudentRepository;
import br.sample.school.domain.student.Student;
import br.sample.school.domain.student.StudentBuilder;
import br.sample.school.infra.student.StudentRepository;

public class RegisterStudent {
	
	public static void main(String[] args) {
		
		
		
		StudentBuilder sb = new StudentBuilder();
		Student s = sb.createWithNameRegistrationEmail("Fulano", "", "fulano@gmail.com");
		
		IStudentRepository repo = new StudentRepository(null); //TODO make connection.
		
		repo.Effectivate(s);
	}

}
