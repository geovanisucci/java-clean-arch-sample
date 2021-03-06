package br.sample.school.domain.indication;

import java.time.LocalDateTime;

import br.sample.school.domain.student.*;

public class Indication {
	
	public Student getIndicated() {
		return indicated;
	}

	public Student getIndicator() {
		return indicator;
	}

	private Student indicated;
	private Student indicator;
	private LocalDateTime indicationDate;
	
	public Indication(Student indicated, Student indicator) {		
		this.indicated = indicated;
		this.indicator = indicator;
		this.indicationDate = LocalDateTime.now();
	}

}
