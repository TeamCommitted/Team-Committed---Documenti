/*
 * Name: SqlDAOLoginTest.java
 * Package: com.safetygame.back.access
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120607 | Alessandro Cornaglia| + testLoginD
 * |          |                     | + testLoginA
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;

import static org.junit.Assert.*;

import org.junit.Test;

import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Login;

public class SqlDAOLoginTest {

	private DAOLogin daoLogin;
	private String indirizzoAz;
	private String utente;
	private String pass;
	private Indirizzo ind;
	
	private void init() {
	  indirizzoAz = "127.0.0.1/ingAz";//"monossido.ath.cx/teamcommitted1";//"aziendasafetygam.altervista.org";//"monossido.ath.cx";
	  utente = "root";//"teamcommitted";//"aziendasafetygam";//"teamcommitted";
	  pass = "root";//"team";//"gifgiresmo40";//""team";
	  ind = new Indirizzo(indirizzoAz,utente,pass);
	  daoLogin = new SqlDAOLogin(ind);
	}
	
	@Test
	public void testLoginD() {
      //test per verificare il login da parte di un dipendente
		  init();
		  String username = "nick";
		  String password = "pass";
		  Login l = new Login(username,password);
		  assertTrue("non e` stato possibile effettuare il loginD", daoLogin.loginDipendente(l));
	}
	
	@Test
	public void testLoginA() {
      //test per verificare il login da parte di un amministratore
		  init();
		  String username = "amministratoreAz";
		  String password = "pass";
		  Login l = new Login(username,password);
		  assertTrue("non e` stato possibile effettuare il loginA", daoLogin.loginAmministratore(l,true));
	}

}
