package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class BrowserTest {

	@Test
	public void apriTest() {
	//test per verificare l'apertura del browser
	  Browser.getInstance().apri("addTrofeo.jsp");
	  //se apre il browser predefinito all'url indicata è corretto
	}
	
	@Test
	public void leggiTest() {
	//test per verificare l'apertura del browser
	  char letto = Browser.getInstance().leggi("addTrofeo.jsp");
	  assertTrue("Fallimento di lettura",letto != 'e');
	  //se apre il browser predefinito all'url indicata è corretto
	}

}
