package br.sample.school.domain.student;

import java.util.List;

public interface IStudentRepository {
	
	void Effectivate(Student student);
	Student GetByRegistration(Registration registration);
	List<Student> GetAll();
}
