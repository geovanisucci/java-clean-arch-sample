package br.sample.school.infra.indication;

import br.sample.school.application.indication.ISendIndicationEmailApplication;
import br.sample.school.domain.student.Student;

public class SendIndicationEmailService implements ISendIndicationEmailApplication {

	public void sendTo(Student indicated) {
		
		//Send email
	}

}
