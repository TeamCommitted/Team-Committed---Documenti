/*
 * Name: SqlDAOBadge.java
 * Package: com.safetygame.back.access
 * Author: Massimo Dalla Pieta'
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120610 | Massimo Dalla Pieta'| + testAssegna
 * |          |                     | + testBadgeD
 * +----------+---------------------|---------------------
 * | 20120611 | Massimo Dalla Pieta'| + testBadgeAS
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;

import static org.junit.Assert.*;

import com.safetyGame.back.condivisi.*;

import java.util.ArrayList;
import org.junit.Test;

public class SqlDAOBadgeTest {

	private DAOBadge daoBadge;
	private Indirizzo indirizzoAz;
	
	private void init() {
	  String indirizzo = "127.0.0.1/ingAz";
	  String utente = "root";
	  String pass = "root";
	  indirizzoAz = new Indirizzo(indirizzo,utente,pass);
	  daoBadge = new SqlDAOBadge(indirizzoAz);
	}
	
	@Test
	public void testBadgeD() {
	  init();
	  ArrayList<Badge> lista = new ArrayList<Badge>();
	  Dipendente dip =  new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  lista = daoBadge.badgeD(dip);
	  Badge ottenuto = new Badge("Re dei pompieri",1,"tanti punti su incendio",100);
	  int numero_badge_ottenuti = 2;
	  assertTrue("lista badge ottenuti non corrispondo", (ottenuto.getId()==lista.get(0).getId())); 
	  assertTrue("lista badge ottenuti non corrispondo", (numero_badge_ottenuti == daoBadge.badgeD(dip).size()));
	}
	
	@Test
	public void testBadgeAS() {
	  init();
	  ArrayList<Badge> lista = new ArrayList<Badge>();
	  lista = daoBadge.badgeAS();
	  int numero_badge_ottenuti = 2; 
	  assertTrue("lista badge ottenuti non corrispondo", (numero_badge_ottenuti == lista.size()));
	}
	
	@Test
	public void testAssegna() {
	  init();
	  ArrayList<Badge> lista = new ArrayList<Badge>();
	  Dipendente dip =  new Dipendente(1,"ewdrftygyh","Giacomo","Quadrio","xxx@xxx.xxx","Ted","pass","pompiere",0,"",0);
	  lista = daoBadge.badgeAS();
	  assertTrue("lista badge ottenuti non corrispondo", daoBadge.assegna(dip,lista.get(0))); 
	  assertTrue("lista badge ottenuti non corrispondo", daoBadge.assegna(dip,lista.get(1)));
	}
}
