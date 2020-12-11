package br.sample.school.domain.student;

public class Registration {
	
	private String number;

	public Registration(String number) {
		
		if(number == null || !number.matches("/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/")) {
			throw new IllegalArgumentException("Invalid CPF number.");
		}
		
		this.number = number;
	}
}
