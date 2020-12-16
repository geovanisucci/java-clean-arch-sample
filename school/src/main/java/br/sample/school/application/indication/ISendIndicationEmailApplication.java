package br.sample.school.application.indication;

import br.sample.school.domain.student.Student;

public interface ISendIndicationEmailApplication {
	
	void sendTo(Student indicated);

}
