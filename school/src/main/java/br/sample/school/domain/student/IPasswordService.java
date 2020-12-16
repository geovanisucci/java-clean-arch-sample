package br.sample.school.domain.student;

public interface IPasswordService {
	
	String Cript(String password);
	boolean IsValidCriptedPassword(String criptedPassword, String password);

}
