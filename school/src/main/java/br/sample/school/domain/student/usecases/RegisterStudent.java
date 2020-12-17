package br.sample.school.domain.student.usecases;

import br.sample.school.domain.student.IStudentRepository;

public class RegisterStudent {
	
	private final IStudentRepository repository;

	public RegisterStudent(IStudentRepository repository) {	
		this.repository = repository;
	}
	
	public void Register(RegisterStudentDTO data)
	{
		repository.Effectivate(data.Parse());
	}

}
