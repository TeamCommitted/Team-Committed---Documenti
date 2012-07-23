/*
 * Name: GestionePunteggiAA.java
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
 * | 20120531 |Giorgio Maggiolo     | * testGetPunteggi
 * |          |                     | * testSetTrofei
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

public class GestionePunteggiAATest {
	GestionePunteggiAA gP;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  Indirizzo indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAOPunteggi punt = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
		  DAODipendenti dip = new SqlDAODipendenti(indirizzoAz);
		  gP = new GestionePunteggiAA(punt,dip);
	}
	
	@Test
	public void testGetPunteggi(){
		init();
		ArrayList<Dipendente> d = new ArrayList<Dipendente>();
		d = gP.getPunteggi();
		System.out.println(d.size());
		assertTrue("lista punteggi non ottenuta", !d.isEmpty()); 
	}
	
	@Test
	public void testSetTrofei(){
		init();
		Dipendente d = new Dipendente();
		d.setId(1);
		boolean risp =  gP.setTrofei(d, 7);
		assertTrue("login non effettuato", risp);  
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
