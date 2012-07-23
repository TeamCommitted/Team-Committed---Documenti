/*
 * Name: GestionePunteggiDTest.java
 * Package: com.safetygame.back.controller
 * Author: Lorenzo Braghetto
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120608 |Lorenzo Braghetto    | + testGetStatisticheGlob
 * | 		  |                     | + testGetStatisticheD
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAOPunteggi;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAOPunteggi;
import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Login;
import com.safetyGame.back.condivisi.Punteggio;

public class GestionePunteggiDTest {
	GestionePunteggiD gP;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  Indirizzo indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAOPunteggi punt = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
		  DAODipendenti dip = new SqlDAODipendenti(indirizzoAz);
		  gP = new GestionePunteggiD(punt,dip);
	}
	
	@Test
	public void testGetStatisticheD(){
		init();
		Login l = new Login("nick","pass");
		Punteggio p = gP.getStatisticheD(l);
		System.out.println(p.getPunti());
		assertTrue("punteggio non ottenuto", true); 
	}
	
	@Test
	public void testGetStatisticheGlob(){
		init();
		Login l = new Login("nick","pass");
		Punteggio p = gP.getStatisticheGlob(l);
		System.out.println(p.getMediaPuntiAzienda());
		assertTrue("punteggio non ottenuto", true); 
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
