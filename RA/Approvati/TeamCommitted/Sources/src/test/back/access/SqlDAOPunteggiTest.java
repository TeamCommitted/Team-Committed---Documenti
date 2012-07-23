/*
 * Name: SqlDAOPunteggiTest.java
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
 * | 20120610 | Massimo Dalla Pieta'| + getStatisticheTest
 * |          |                     | + getStatisticheGlobaliTest
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;

import static org.junit.Assert.*;

import com.safetyGame.back.condivisi.*;
import org.junit.Test;

public class SqlDAOPunteggiTest {

	private DAOPunteggi sqlPunteggi;
	private DAODipendenti sqlDipendenti;
	private String indAz;
	private String indDom;
	private Indirizzo indirizzoAz;
	private Indirizzo indirizzoDom;
	
	private void init() {
	  indAz = "127.0.0.1/ingAz";
	  indDom = "127.0.0.1/ingDom";
	  String utente = "root";
	  String pass = "root";
	  indirizzoAz = new Indirizzo(indAz,utente,pass);
	  indirizzoDom = new Indirizzo(indDom,utente,pass);
	  sqlPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
	  sqlDipendenti = new SqlDAODipendenti(indirizzoAz);
	}
	
	@Test
	public void getStatisticheTest() {
	  //test per verificare che il punteggio ritornato sia corretto
	  init();
	  Login l = new Login("nick","pass");
	  Dipendente dip = sqlDipendenti.getInfoD(l);
	  Punteggio punteggio = sqlPunteggi.getStat(dip);
	  int puntiNelDB = 15;
	  
	  assertTrue("i punti del punteggio non corrispondono a quelli presenti nel DB", (puntiNelDB == punteggio.getPunti()));
	}
	
	@Test
	public void getStatisticheGlobaliTest() {
	  //test per verificare che le statistiche globali
	  init();
	  Login l = new Login("nick","pass");
	  Dipendente dip = sqlDipendenti.getInfoD(l);
	  Punteggio punteggio = sqlPunteggi.getGlobalStat(dip);
	  int puntiNelDB = 15;
	  int nRisp = punteggio.getnDomRisp();
	  double pma = punteggio.getMediaPuntiAzienda();
	  
	  assertTrue("il numero di risposte finale non corrisponde", (nRisp == 1));
	  assertTrue("il numero di punti medi azienda non corrisponde", (pma == 15.0));
	}

}
