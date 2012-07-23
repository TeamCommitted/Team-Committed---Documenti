/*
 * Name: GestioneDipendentiDTest.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120602 |Alessandro Cornaglia | * GestioneDipendentiD
 * |          |                     | - getDaoFactory
 * |          |                     | - setDaoFactory
 * |          |                     | + getDaoDipendenti
 * |          |                     | + setDaoDipendenti
 * |          |                     | * getDati
 * |          |                     | * modificaPass
 * |          |                     | + modificaEmail
 * +----------+---------------------+---------------------
 * | 20120602 |Alessandro Cornaglia | + GestioneDipendentiD
 * |          |                     | + getDaoFacory
 * |          |                     | + setDaoFactory
 * |          |                     | + getGestioneLog
 * |          |                     | + setGestioneLog 
 * |          |                     | + getDati
 * |          |                     | + modificaPass
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.UpdateLog;
import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Login;

public class GestioneDipendentiDTest {

	private GestioneDipendentiD gestDipD;
	private DAODipendenti sqlDip;
	private UpdateLog updlog;
	private GestioneLog gestLog;
	private Indirizzo indirizzoAz;
	private String indAz;
	private String utente;
	private String pass;
	
	private void init() {
	  indAz = "127.0.0.1/ingAz";
	  utente = "root";
	  pass = "root";
	  indirizzoAz = new Indirizzo(indAz,utente,pass);
	  sqlDip = new SqlDAODipendenti(indirizzoAz);
	  
	  updlog = new UpdateLog(indirizzoAz);
	  gestLog = new GestioneLog(updlog,sqlDip);
	  gestDipD = new GestioneDipendentiD(sqlDip,gestLog);
	}
	
	@Test
	public void getDatiTest() {
	//test che verifica il corretto recupero delle informazioni di un dipendente
		init();
		Login l = new Login("nick","pass");
		Dipendente dip = gestDipD.getDatiD(l);
		assertTrue("recupero informazioni dipendente non riuscita",dip.getCodFiscale().equals("sxrYDTCfvg"));
	}
	
	@Test
	public void modPassTest() {
	//test che verifica il corretto cambio della password di un dipendente
		init();
		Login l = new Login("nick","pass");
		Dipendente dip = gestDipD.getDatiD(l);
		dip.setNuovaPass("nuovaPass");
		assertTrue("modifica password non riuscita",gestDipD.modificaPass(dip));
	}
	
	@Test
	public void modEmailTest() {
	//test che verifica il corretto cambio della mail di un dipendente
		init();
		Login l = new Login("nick","pass");
		Dipendente dip = gestDipD.getDatiD(l);
		assertTrue("modifica email non riuscita",gestDipD.modificaEmail(dip, "ale.corny@gmail.com"));
	}

}
