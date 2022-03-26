package com.ifpe.ts.testes.piramide;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.ado.emprestimo.RepositorioEmprestimo;
import com.ifpe.emprestimo.Emprestimo;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.facade.Facade;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

public class DbUtilsTest {
	private static DbUtils dbUtils;

	@Before
	public void init() throws TelefoneInvalidoException, SiapeInvalidoException {
		this.dbUtils = new DbUtils();
	}

	@Test
	public void listarTest() {
		ResultSet rs = this.dbUtils.listar(this.dbUtils.selectProfessor());
		assertTrue(rs != null);
	}

	@Test
	public void buildTableModelTest() throws SQLException, Exception {
		ResultSet rs = this.dbUtils.listar(this.dbUtils.selectProfessor());
		DefaultTableModel dt = this.dbUtils.buildTableModel(rs);
		assertTrue(dt != null);
	}
	
	@Test
	public void selectEmprestimoTest() throws Exception {
		String status = this.dbUtils.selectEmprestimo();
		assertTrue(status != null);
	}

	@Test
	public void selectItemTest() throws Exception {
		String status = this.dbUtils.selectItem();
		assertTrue(status != null);
	}

	@Test
	public void selectProfessorTest() throws Exception {
		String status = this.dbUtils.selectProfessor();
		assertTrue(status != null);
	}
}