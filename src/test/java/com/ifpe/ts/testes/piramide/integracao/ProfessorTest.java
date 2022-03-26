package com.ifpe.ts.testes.piramide.integracao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.facade.Facade;
import com.ifpe.professor.Professor;

public class ProfessorTest {

	Facade facade;
	Professor professor;

	@Before
	public void init() {
		this.facade = new Facade();
		this.professor = new Professor();
	}

	@Test
	public void insertProfessorTest() {
		this.professor.setNome("Mario da silva");
		this.professor.setSiape("1234567");
		this.professor.setTelefone("87981325692");
		int status = this.facade.inserirProfessor(this.professor);
		this.facade.removerProfessor("1234567");
		assertTrue(status != 0);
	}

	@Test
	public void removerProfesorTest() {
		this.professor.setNome("Joao da siva");
		this.professor.setSiape("5639316");
		this.professor.setTelefone("87963136452");
		this.facade.inserirProfessor(professor);
		int status = this.facade.removerProfessor("5639316");
		assertTrue(status != 0);
	}
	
	@Test(expected = SQLException.class)
	public void SQLExceptionTest() throws TelefoneInvalidoException, SiapeInvalidoException, SQLException  {
		this.professor.setNome("Joana xirlei");
		this.professor.setSiape("8963156");
		this.professor.setTelefone("87988963264");
		this.facade.inserirProfessor(professor);
		this.facade.inserirProfessor(professor);
        assertTrue(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
	}

}
