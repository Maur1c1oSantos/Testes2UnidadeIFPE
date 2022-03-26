package com.ifpe.ts.testes.piramide.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.emprestimo.Emprestimo;

public class EmprestimoTest {

	Emprestimo emprestimo;
	
	@Before
	public void init() {
		this.emprestimo = new Emprestimo("1234ABC", "00005", "21/03/2022");
	}
	
	@Test
	public void setsiapeTest() {
		this.emprestimo.setSiapeProf("ABCD123");
		assertTrue(this.emprestimo.getSiapeProf().equals("ABCD123"));
	}
	
	@Test
	public void setCodigoTest() {
		this.emprestimo.setCodItem("00009");
		assertTrue(this.emprestimo.getCodItem().equals("00009"));
	}
	
	@Test
	public void setDataTest() {
		this.emprestimo.setData("15/02/2022");
		assertTrue(this.emprestimo.getData().equals("15/02/2022"));
	}
}
