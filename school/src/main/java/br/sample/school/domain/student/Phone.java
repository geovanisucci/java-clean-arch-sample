package br.sample.school.domain.student;

public class Phone {
	
	private String code;
	private String number;
	
	public Phone(String code, String number) {
		this.code = code;
		this.number = number;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getNumber() {
		return number;
	}

}
