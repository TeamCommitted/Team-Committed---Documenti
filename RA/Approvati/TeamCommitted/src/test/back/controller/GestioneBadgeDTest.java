/*
 * Name: GestioneBadgeDTest.java
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
 * | 20120607 |Giorgio Maggiolo     | + testGetBadgeD
 * |          |                     | + testassegnaBadgeD
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.condivisi.Domanda;
import com.safetyGame.back.condivisi.Login;

public class GestioneBadgeDTest {
	GestioneBadgeD gb;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  Indirizzo indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
		  DAODipendenti daoDip = new SqlDAODipendenti(indirizzoAz);
		  DAODomande daoDom = new SqlDAODomande(indirizzoAz,indirizzoDom);
		  DAOLogin daoLog = new SqlDAOLogin(indirizzoAz);
		  UpdateLog updlog = new UpdateLog(indirizzoAz);
		  GestioneLog log = new GestioneLog(updlog,daoDip);
		  GestioneLogin login = new GestioneLogin(daoLog,log);
		  gb = new GestioneBadgeD(daoBadge,daoDip,daoDom,log,login);
		}
	
	@Test
	public void testGetBadgeD(){
		init();
		ArrayList<Badge> listbadge = new ArrayList<Badge>();
		Login l = new Login("mario.verdi","pass");
		listbadge = gb.getBadgeD(l,1);
		//System.out.print(listbadge.size());
		for(int i = 0; i < listbadge.size(); i++)
			System.out.println(listbadge.get(i).getNome());
		assertTrue("lista badge non ottenuta", !listbadge.isEmpty()); 
	}
	
	@Test
	public void testAssegnaBadge(){
		init();
		Domanda d = new Domanda();
		d.setId(1);
		d.setAmbito("Pompiere");
		Login l = new Login("andrea.marton","pass");
		assertTrue("badge non assegnata", gb.assegnaBadge(d,l)); 
		//devo verificare se nella tabella OttenimentoBadge e` presente la riga 1 - 1 - 5 - data e ora correnti
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
