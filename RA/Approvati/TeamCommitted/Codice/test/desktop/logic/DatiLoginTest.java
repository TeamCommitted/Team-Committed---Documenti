/*
 * Name: DatiLoginTest.java
 * Package: com.safetygame.desktop.logic
 * Author: Alessandro Cornaglia
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120613 | Alessandro Cornaglia| + getPasswordTest
 * |          |                     | + getUsernameTest
 * +----------+---------------------|---------------------
 * | 20120612 | Alessandro Cornaglia| + getLoginTest
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;
import com.safetyGame.desktop.condivisi.*;
import org.junit.Test;

public class DatiLoginTest {

	private Login l;
	private DatiLogin datiLogin;
	
	private void init() {
	  datiLogin = new DatiLogin("nick","pass");
	}

	@Test
	public void getUsernameTest() {
	//test per verificare che lo username ritornato sia corretto
	  init();
	  assertTrue("il campo nick non e` corretto",datiLogin.getLogin().getUsername().equals("nick"));
	}
	
	@Test
	public void getPasswordTest() {
	//test per verificare che lo username ritornato sia corretto
	  init();
	  assertTrue("il campo pass non e` corretto",datiLogin.getLogin().getPassword().equals("pass"));
	}
	
	@Test
	public void getLoginTest() {
	//test per verificare che lo username ritornato sia corretto
	  init();
	  l = new Login("nick","pass");
	  assertTrue("l'oggetto Login non e` corretto",(datiLogin.getLogin().getUsername().equals("nick")) && (datiLogin.getLogin().getPassword().equals("pass")));
	}

}
