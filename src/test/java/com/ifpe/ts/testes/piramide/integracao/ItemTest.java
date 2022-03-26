package com.ifpe.ts.testes.piramide.integracao;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.facade.Facade;
import com.ifpe.item.Item;

public class ItemTest {
	
	Facade facade;
	Item item;
	
	@Before
	public void init(){
		this.facade = new Facade();
	}
	
	
	@Test
	public void insertItemTest() {
		int status = this.facade.inserirItem(this.item = new Item("063594", "Computador"));
		this.facade.removerItem("063594");
		assertTrue(status != 0);
	}
	
	@Test
	public void removerProfesorTest() {
		this.facade.inserirItem(this.item = new Item("36895306", "Mesa"));
		int status = this.facade.removerItem("36895306");
		assertTrue(status != 0);
	}
	
	@Test(expected = SQLException.class)
	public void SQLExceptionTest() throws SQLException  {
		this.facade.inserirItem(this.item = new Item("539861", "Ventilador"));
		this.facade.inserirItem(this.item = new Item("539861", "Ventilador"));
        assertTrue(throwException());
	}
	
	private boolean throwException() throws SQLException{
        throw new SQLException();
	}

}
