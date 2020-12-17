package br.sample.school;

import br.sample.school.domain.student.IStudentRepository;
import br.sample.school.domain.student.Student;
import br.sample.school.domain.student.StudentBuilder;
import br.sample.school.domain.student.usecases.RegisterStudent;
import br.sample.school.domain.student.usecases.RegisterStudentDTO;
import br.sample.school.infra.student.StudentRepository;

public class RegisterStudentConsole {
	
	public static void main(String[] args) {
		
		
		String name = "Fulano";
		String registrationNumber = "123.456.789-00";
		String email = "fulano@gmail.com";
		
		RegisterStudent useCase = new RegisterStudent(new StudentRepository(null));
		
		useCase.Register(new RegisterStudentDTO(name, registrationNumber, email));
		
	}

}
