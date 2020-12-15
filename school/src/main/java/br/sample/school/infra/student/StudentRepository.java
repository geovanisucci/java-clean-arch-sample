package br.sample.school.infra.student;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.sample.school.domain.student.Email;
import br.sample.school.domain.student.IStudentRepository;
import br.sample.school.domain.student.Phone;
import br.sample.school.domain.student.Registration;
import br.sample.school.domain.student.Student;


public class StudentRepository implements IStudentRepository {
	
	private final Connection connection;

	public StudentRepository(Connection connection) {
		this.connection = connection;
	}

	public void Effectivate(Student student) {
		
		try {
			
			String sql = "INSERT INTO ALUNO VALUES(?,?,?)";
			
			PreparedStatement ps =  connection.prepareStatement(sql);
			
			ps.setString(1, student.getRegistrationNumber());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?,?)";
			ps = connection.prepareStatement(sql);
			
			for (Phone phone : student.getPhones()) {
				ps.setString(1, phone.getCode());
				ps.setString(2, phone.getNumber());	
				ps.execute();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	

	}

	public Student GetByRegistration(Registration registration) {
		// TODO Auto-generated method stub
		Student student = null;
		
		try {
			String sql = "SELECT * FROM ALUNO WHERE CPF = ?";
			PreparedStatement ps =  connection.prepareStatement(sql);
			ps.setString(1, registration.getNumber());
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("nome");
				String registrationNumber = rs.getString("cpf");
				String email = rs.getString("email");
				
				student = new Student(new Registration(registrationNumber), name, new Email(email));
				
				sql = "SELECT * FROM TELEFONE WHERE ALUNO_ID = ?";
				
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				
				ResultSet telefoneResultSet = ps.executeQuery();
				
				while (telefoneResultSet.next()) {
					
					String code = telefoneResultSet.getString("ddd");
					String number = telefoneResultSet.getString("telefone");
					
					student.addPhone(code, number);
					
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return student;
	}

	public List<Student> GetAll() {
		
		List<Student> lstStudent = new ArrayList<Student>();
		
		try {
			
			String sql = "SELECT * FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("nome");
				String registrationNumber = rs.getString("cpf");
				String email = rs.getString("email");
				
				Student student = new Student(new Registration(registrationNumber), name, new Email(email));
				
				sql = "SELECT * FROM TELEFONE WHERE ALUNO_ID = ?";
				
				ps = connection.prepareStatement(sql);
				ps.setString(1, id);
				
				ResultSet telefoneResultSet = ps.executeQuery();
				
				while (telefoneResultSet.next()) {
					
					String code = telefoneResultSet.getString("ddd");
					String number = telefoneResultSet.getString("telefone");
					
					student.addPhone(code, number);
					
				}
				
				lstStudent.add(student);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return lstStudent;
	}

}
