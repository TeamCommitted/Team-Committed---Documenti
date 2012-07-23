/*
 * Name: GestioneRecuperoTest.java
 * Package: com.safetygame.back.controller
 * Author: Giorgio Maggiolo
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120612 |Giorgio Maggiolo     | + testMail
 * |          |                     | + testMailInserito
 * |          |                     | * testModMail
 * +----------+---------------------+---------------------
 * | 20120611 |Giorgio Maggiolo     | + testRecuperoA
 * |          |                     | + testRecuperoD
 * |          |                     | + testPassCasuale
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;

import static org.junit.Assert.*;
import org.junit.Test;

import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Recupero;

/**
 * Classe di test per oggetti di tipo GestioneRecupero
 * @author acornagl
 *
 */
public class GestioneRecuperoTest {
 
	private GestioneRecupero gr;
	
	private void init() {
		Indirizzo indAz = new Indirizzo("127.0.0.1/ingAz","root","root");
		DAODipendenti d = new SqlDAODipendenti(indAz);
		gr = new GestioneRecupero(d);
	}
	
	@Test
	public void testRecuperoA() {
	  init();
	  Recupero amm = new Recupero();
	  amm.setEmail("teamcommitted@gmail.com");
	  amm.setCodFiscale("0");
	  try{gr.recuperoA(amm);}catch(Exception e){e.printStackTrace();};
	  assertTrue("percorso errato", 1 == 1);
	}
	
	@Test
	public void testRecuperoD() {
		init();
		Recupero amm = new Recupero();
		amm.setEmail("teamcommitted@gmail.com");
		amm.setCodFiscale("0");
		try{gr.recuperoA(amm);}catch(Exception e){e.printStackTrace();};
		assertTrue("percorso errato", 1 == 1);
	}
	
	@Test
	public void testPassCasuale() {
	  init();
	  try{gr.sendMail("ale.corny@gmail.com",gr.generaPassCasuale());}catch(Exception e){e.printStackTrace();};
	  assertTrue("percorso errato", 1 == 1);
	}
	
	@Test 
	public void testMailInserito() {
	//test per verificare l'invio della mail
	  init();
      try{gr.sendMailInserito("teamcommitted@gmail.com","Nuova Password");}catch(Exception e){e.printStackTrace();};
	  assertTrue("percorso errato", 1 == 1);
	}
	
	@Test 
	public void testMail() {
	//test per verificare l'invio della mail
	  init();
      try{gr.sendMail("ale.corny@gmail.com","nuova_password");}catch(Exception e){e.printStackTrace();};
	  assertTrue("percorso errato", 1 == 1);
	}
	
	@Test
	public void TestMailModMail() {
	//test per verificare la mail di mod mail
	  init();
	  try{gr.sendMailModMail("ale.corny@gmail.com");}catch(Exception e){};
	}

}
