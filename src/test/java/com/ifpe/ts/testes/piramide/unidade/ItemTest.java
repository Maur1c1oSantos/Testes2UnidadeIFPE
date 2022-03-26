package com.ifpe.ts.testes.piramide.unidade;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.item.Item;

public class ItemTest {

	Item item;
	
	@Before
	public void init() {
		this.item = new Item("00001", "Livro");
	}
	
	@Test
	public void setCodigoTest() {
		this.item.setCodigoItem("00005");
		assertTrue(this.item.getCodigoItem().equals("00005"));
	}
	
	@Test
	public void setTipoItemTest() {
		this.item.setTipoItem("Mesa");
		assertTrue(this.item.getTipoItem().equals("Mesa"));
	}
}
