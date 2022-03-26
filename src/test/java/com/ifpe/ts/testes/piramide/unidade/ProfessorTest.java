package com.ifpe.ts.testes.piramide.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.professor.Professor;

public class ProfessorTest {
	
	Professor professor;

	@Before
	public void init() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.professor = new Professor("Mario da silva", "87981325692", "1234567");
	}
	
	@Test(expected=TelefoneInvalidoException.class )
	public void telefoneInvalidoExceptionTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.professor = new Professor("Mario da silva", "ABC81236589", "1234567");
	}
	
	@Test(expected=SiapeInvalidoException.class )
	public void siapeInvalidoExceptionTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.professor = new Professor("Mario da silva", "87981236589", "123");
	}
	
	@Test
	public void construtorTest() {
		Professor prof = new Professor();
		assertTrue(prof != null);
	}
	
	@Test
	public void setNomeTest() {
		this.professor.setNome("Carlos Andrade da silva");
		assertTrue(this.professor.getNome().equals("Carlos Andrade da silva"));
	}
	
	@Test
	public void setTelefoneTest() {
		this.professor.setTelefone("87999563269");
		assertTrue(this.professor.getTelefone().equals("87999563269"));
	}
	
	@Test
	public void setsiapeTest() {
		this.professor.setSiape("ABCDEFG");
		assertTrue(this.professor.getSiape().equals("ABCDEFG"));
	}
	
	
}
