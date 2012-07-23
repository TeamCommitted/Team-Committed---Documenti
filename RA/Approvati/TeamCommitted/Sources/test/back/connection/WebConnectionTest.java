/*
 * Name: WebConnectionTest.java
 * Package: com.safetygame.back.connection
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120708 |Alessandro Cornaglia | + modPassDTest
 * |          |Gabriele Facchin     | + getElencoRuoliTest
 * +----------+---------------------+----------------------
 * 
 */ package com.safetyGame.back.connection;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOLogin;
import com.safetyGame.back.access.DAOPunteggi;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAODomande;
import com.safetyGame.back.access.SqlDAOLogin;
import com.safetyGame.back.access.SqlDAOPunteggi;
import com.safetyGame.back.access.UpdateLog;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.controller.*;

public class WebConnectionTest {

	WebConnection webConnection;
	GestioneDati gestioneDati;
	GestioneRecupero gestioneRecupero;
    GestioneLogin gestioneLogin;
    GestioneDomandeD gestioneDomandeD;
    GestioneDomandeAS gestioneDomandeAS;
    GestioneDipendentiD gestioneDipendentiD;
    GestioneDipendentiAA gestioneDipendentiAA;
    GestioneBadgeD gestioneBadgeD;
    GestioneBadgeAS gestioneBadgeAS;
    GestionePunteggiD gestionePunteggiD;
    GestionePunteggiAA gestionePunteggiAA;
    GestioneLog gestioneLog;
    UpdateLog updatelog;
    DAODipendenti daoDipendenti;
    //GestioneDati gestioneDati;
    Indirizzo indirizzoAz;
    Indirizzo indirizzoDom;
	
    private void init() {
	  String indirizzo1 = "127.0.0.1/ingAz";
	  String indirizzo2 = "127.0.0.1/ingDom";
	  String utente = "root";
	  String pass = "root";
	  indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
	  indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
	  daoDipendenti= new SqlDAODipendenti(indirizzoAz);
	  DAOPunteggi daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
	  DAOLogin daoLogin = new SqlDAOLogin(indirizzoAz);
	  DAODomande daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);
	  DAOBadge daoBadge = new SqlDAOBadge(indirizzoAz);
	  
	  gestioneRecupero = new GestioneRecupero(daoDipendenti);
	  gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
	  gestionePunteggiAA = new GestionePunteggiAA(daoPunteggi,daoDipendenti);
	  updatelog = new UpdateLog(indirizzoAz);
	  gestioneLog = new GestioneLog(updatelog,daoDipendenti);
	  gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
	  gestioneBadgeD = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande, gestioneLog, gestioneLogin);
	  gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD, gestioneLog, gestioneBadgeD);
	  gestioneDomandeAS = new GestioneDomandeAS(daoDomande,gestioneLog);
	  gestioneDipendentiD = new GestioneDipendentiD(daoDipendenti, gestioneLog);
	  gestioneDipendentiAA = new GestioneDipendentiAA(daoDipendenti,gestioneLog);
	  gestioneBadgeAS = new GestioneBadgeAS(daoBadge);
	  gestioneDati = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);
	  
	  webConnection = new WebConnection(gestioneDati);
	}
	
    @Test
	public void modPassDTest() {
		init();
		Login l = new Login("giacomo.muriotto","pass");
		Dipendente dip = daoDipendenti.getInfoD(l);
		dip.setNuovaPass("marco_va bene?");
		assertTrue("lista badge non ottenuta", webConnection.modPassD(dip)); 
	}

    @Test
	public void getElencoRuoliTest() {
		init();
		assertTrue("lista ruoli non corrisponde", gestioneDati.getElencoRuoli().size() == 9 ); 
	}
}
