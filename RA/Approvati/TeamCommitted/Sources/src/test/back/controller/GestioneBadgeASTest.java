/*
 * Name: GestioneBadgeASTest.java
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
 * | 20120604 |Giorgio Maggiolo     | + testGestioneBadgeAS
 * |          |                     | + testgetBadgeAS
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.condivisi.Badge;

public class GestioneBadgeASTest {
	GestioneBadgeAS gb;
	
	private void init() {
		  String indirizzo = "127.0.0.1/ingAz";
		  String utente = "root";
		  String pass = "root";
		  Indirizzo indirizzoAz = new Indirizzo(indirizzo,utente,pass);
		  DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
		  gb = new GestioneBadgeAS(daoBadge);
		}
	
	@Test
	public void testGetBadgeAS(){
		init();
		ArrayList<Badge> listbadge = new ArrayList<Badge>();
		listbadge = gb.getBadgesAS();
		System.out.print(listbadge.get(0).getNome());
		assertTrue("lista badge non ottenuta", !listbadge.isEmpty()); 
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
