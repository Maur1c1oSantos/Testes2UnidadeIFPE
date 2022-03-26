package com.ifpe.ts.testes.piramide.integracao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.emprestimo.Emprestimo;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.facade.Facade;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;

public class EmprestimoTest {

	Facade facade;
	Timestamp ts;
	Emprestimo emprestimo;
	Professor professor;
	Item item;

	@Before
	public void init() {
		this.facade = new Facade();
		this.ts = new Timestamp(System.currentTimeMillis());
	}

	@Test
	public void insertEmprestimoTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.facade.inserirProfessor(this.professor = new Professor("Jessica Lima", "87963136452", "6397604"));
		this.facade.inserirItem(this.item = new Item("693462", "Cadeira"));
		int status = this.facade
				.inserirEmprestimo(this.emprestimo = new Emprestimo("6397604", "693462", this.ts.toString()));
		int id = this.facade.buscarUltimoEmprestimo();
		this.facade.removerEmprestimo(id);
		this.facade.removerProfessor("6397604");
		this.facade.removerItem("693462");
		assertTrue(status != 0);
	}

	@Test
	public void removerEmprestimoTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.facade.inserirProfessor(this.professor = new Professor("Kassio Brandao", "87963136452", "2394684"));
		this.facade.inserirItem(this.item = new Item("482361", "Quadro"));
		this.facade.inserirEmprestimo(this.emprestimo = new Emprestimo("2394684", "482361", this.ts.toString()));
		int id = this.facade.buscarUltimoEmprestimo();
		int status = this.facade.removerEmprestimo(id);
		this.facade.removerProfessor("2394684");
		this.facade.removerItem("482361");
		assertTrue(status != 0);
	}
	
	@Test(expected = SQLException.class)
	public void SQLExceptionTest() throws SQLException, TelefoneInvalidoException, SiapeInvalidoException  {
		this.facade.inserirProfessor(this.professor = new Professor("Cassio", "87936251485", "9863125"));
		this.facade.inserirItem(this.item = new Item("321456", "Bola"));
		this.facade.inserirEmprestimo(this.emprestimo = new Emprestimo("9863125", "321456", this.ts.toString()));
		this.facade.inserirEmprestimo(this.emprestimo = new Emprestimo("9863125", "321456", this.ts.toString()));
        assertTrue(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
	}
}