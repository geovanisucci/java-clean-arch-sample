package br.sample.school.infra.student;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.sample.school.domain.student.IPasswordService;

public class PasswordService implements IPasswordService {

	public String Cript(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("erro ao gerar hash da senha");
		}
		
	}

	public boolean IsValidCriptedPassword(String criptedPassword, String password) {
		return criptedPassword.equals(Cript(password));
	}

}
