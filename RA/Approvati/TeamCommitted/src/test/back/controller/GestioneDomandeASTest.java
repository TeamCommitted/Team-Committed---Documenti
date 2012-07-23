/*
 * Name: GestioneDomandeAS.java
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
 * | 20120607 |Giorgio Maggiolo     | + testGetElencoDomande
 * |          |                     | + testAddDomanda
 * |          |                     | + testRemDomanda
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOLogin;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAODomande;
import com.safetyGame.back.access.SqlDAOLogin;
import com.safetyGame.back.access.UpdateLog;
import com.safetyGame.back.condivisi.Domanda;

public class GestioneDomandeASTest {
	GestioneDomandeAS as;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  Indirizzo indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAODipendenti daoDip = new SqlDAODipendenti(indirizzoAz);
		  DAODomande daoDom = new SqlDAODomande(indirizzoAz,indirizzoDom);
		  UpdateLog updLog = new UpdateLog(indirizzoAz);
		  GestioneLog gestLog= new GestioneLog(updLog, daoDip);
		  as = new GestioneDomandeAS(daoDom,gestLog);
		}
	
	@Test
	public void testGetElencoDomande(){
		init();
		ArrayList<Domanda> a = new ArrayList<Domanda>();
		a = as.getElencoDomande();
		System.out.println(a.size());
		assertTrue("lista domande non ottenuta", !a.isEmpty()); 
	}
	   
	@Test
	public void testAddDomanda(){
		init();
		Domanda Dom = new Domanda();
		Dom.setId(1);
		assertTrue("aggiunta fallita", as.addDomanda(Dom)); 
	}
	   
	@Test
	public void testRemDomanda(){
		init();
		Domanda Dom = new Domanda();
		Dom.setId(1);
		assertTrue("rimozione fallita", as.remDomanda(Dom)); 
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
