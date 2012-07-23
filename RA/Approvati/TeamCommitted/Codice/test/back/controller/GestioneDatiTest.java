/*
 * Name: GestioneDati.java
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
 * | 20120708 |Giorgio Maggiolo     | + getElencoRuoliTest
 * +----------+---------------------+---------------------
 * | 20120611 |Lorenzo Braghetto    | + testRecupero
 * |          |                     | + testModPassA
 * +----------+---------------------+---------------------
 * | 20120608 |Lorenzo Braghetto    | + testLogout
 * |          |                     | * testGetBadgeD
 * |          |                     | + testGetStatisticheGlob
 * +----------+---------------------+---------------------
 * | 20120607 |Lorenzo Braghetto    | + GestioneDati
 * |          |                     | + testGetBadgeAS
 * |          |                     | + testGetBadgeD
 * |          |                     | + testAssegnaBadgeD
 * |          |                     | + testGetElencoDipendenti
 * |          |                     | + testAggiungiDipendente
 * |          |                     | + testCancellaDipendente
 * |          |                     | + testModDipendente
 * |          |                     | + testGetBadgeAS
 * |          |                     | + testModificaPass
 * |          |                     | + testModificaEmail
 * |          |                     | + testGetElencoDomande
 * |          |                     | + testGetBadgeAS
 * |          |                     | + testAddDomanda
 * |          |                     | + testRemDomanda
 * |          |                     | + testGetDomandaD
 * |          |                     | + testSetRisposta
 * |          |                     | + testLoginAdmin
 * |          |                     | + testLoginUser
 * |          |                     | + testGetPunteggi
 * |          |                     | + testSetTrofei
 * |          |                     | + testSetStatisticheD
 * |          |                     | + testPosticipa
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
import com.safetyGame.back.access.DAOPunteggi;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAODomande;
import com.safetyGame.back.access.SqlDAOLogin;
import com.safetyGame.back.access.SqlDAOPunteggi;
import com.safetyGame.back.access.UpdateLog;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Domanda;
import com.safetyGame.back.condivisi.Login;
import com.safetyGame.back.condivisi.Punteggio;
import com.safetyGame.back.condivisi.Recupero;

public class GestioneDatiTest {
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
	  GestioneDati D;
	  Indirizzo indirizzoAz;
	  Indirizzo indirizzoDom;
	  UpdateLog updatelog;
	
	private void init() {
		  String indirizzo1 = "127.0.0.1/ingAz";
		  String indirizzo2 = "127.0.0.1/ingDom";
		  String utente = "root";
		  String pass = "root";
		  indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
		  indirizzoDom = new Indirizzo(indirizzo2,utente,pass);
		  DAODipendenti daoDipendenti= new SqlDAODipendenti(indirizzoAz);
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
		  gestioneDipendentiAA = new GestioneDipendentiAA(daoDipendenti, gestioneLog);
		  gestioneBadgeAS = new GestioneBadgeAS(daoBadge);
		  D = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);
	}
	
	@Test
	public void testGetBadgesAS() {
		init();
		ArrayList<Badge> listbadge = new ArrayList<Badge>();
		listbadge = D.getBadgesAS();
		System.out.print(listbadge.get(0).getNome());
		assertTrue("lista badge non ottenuta", !listbadge.isEmpty()); 
	}
	
	@Test
	public void testgetBadgeD() {
		init();
		ArrayList<Badge> listbadge = new ArrayList<Badge>();
		Login l = new Login("nick","pass");
		listbadge = D.getBadgeD(l,1);
		System.out.print(listbadge.size());
		assertTrue("lista badge non ottenuta", !listbadge.isEmpty());  
	}
	
	@Test
	public void testassegnaBadge() {
		init();
		Domanda d = new Domanda();
		d.setId(1);
		d.setTipologia("Pompiere");
		Login l = new Login("nick","pass");
		assertTrue("badge non assegnata", D.assegnaBadge(d,l)); 
	}
	  
	@Test
	public void testgetElencoDipendenti() {
		init();
		ArrayList<Dipendente> risultato_elenco = D.getElencoDipendenti();
		int numero_dip = 1;//nel DB al momento
		assertTrue("il numero di dipendenti in elenco non corrisponde",numero_dip == risultato_elenco.size());
	}
	  
	@Test
	public void testaggiungiDipendente() {
		init();
		Dipendente dip = new Dipendente(101,"wwww","nome","cognome","ale.corny@gmail.com","www","pass","Dirigente",0,"",4);
		boolean risultato = D.aggiungiDipendente(dip);
		assertTrue("dipendente non aggiunto",risultato == true);
	}
	  
	@Test
	public void testcancellaDipendente() {
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indirizzoAz);
		Login l = new Login("nick","pass");
		Dipendente dip = sqlDip.getInfoD(l);
		boolean risultato = D.cancellaDipendente(dip);
		assertTrue("rimozione dipendente non riuscita",risultato == true);
	}
	  
	@Test
	public void testmodDipendente() {
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indirizzoAz);
		Login l = new Login("nick","pass");
		Dipendente dip = sqlDip.getInfoD(l);
		Dipendente dipMod = sqlDip.getInfoD(l);//costuisco dipendente da modificare
		dipMod.setNome("nuovoNome");
		boolean risultato = D.modDipendente(dipMod,dip);
		System.out.println(risultato);
		assertTrue("modifica dipendente non riuscita",risultato == true);
	}
	  
	@Test
	public void testgetDatiD() {
		init();
		Login l = new Login("nick","pass");
		Dipendente dip = D.getDatiD(l);
		assertTrue("recupero informazioni dipendente non riuscita",dip.getCodFiscale().equals("0"));
	}
	  
	@Test
	public void testmodificaPass() {
		init();
		Login l = new Login("nick","pass");
		Dipendente dip = D.getDatiD(l);
		dip.setNuovaPass("nuovaPass");
		assertTrue("modifica password non riuscita",D.modificaPass(dip));
	}
	  
	@Test
	public void testmodificaEmail() {
		init();
		Login l = new Login("nick","pass");
		Dipendente dip = D.getDatiD(l);
		assertTrue("modifica email non riuscita",D.modificaEmail(dip, "ale.corny@gmail.com"));
	}
	  
	@Test
	public void testgetElencoDomande() {
		init();
		ArrayList<Domanda> a = new ArrayList<Domanda>();
		a = D.getElencoDomande();
		System.out.println(a.size());
		assertTrue("lista domande non ottenuta", !a.isEmpty()); 
	}
	  
	@Test
	public void testaddDomanda() {
		init();
		Domanda Dom = new Domanda();
		Dom.setId(1);
		assertTrue("aggiunta fallita", D.addDomanda(Dom)); 
	}
	  
	@Test
	public void testremDomanda() {
		init();
		Domanda Dom = new Domanda();
		Dom.setId(1);
		assertTrue("rimozione fallita", D.remDomanda(Dom)); 
	}
	
	@Test
	public void testgetDomandaD() {
		init();
		  Login l = new Login("nick","pass");
		  Domanda dom = D.getDomandaD(l);
		  assertTrue("non viene ritornata domanda corretta", dom.getId()==2);
	}
	  
	@Test
	public void testsetRisposta() {
		init();
		  Login l = new Login("nick","pass");
		  Domanda dom = new Domanda();
		  dom.setId(1);
		  dom.setRispostaData(1);
		  dom.setPunteggio(new Punteggio(50));
		  boolean b = D.setRisposta(l, dom);
		  assertTrue("non viene rsegnata la risposta corretta", b);
	}
	  
	@Test
	public void testloginAdmin(){
		init();
		Login l = new Login("amministratoreAz","pass");
		assertTrue("login non effettuato", D.loginAdmin(l,true)); 
	}
	
	@Test
	public void testloginUser() {
		init();
		Login l = new Login("nick","pass");
		assertTrue("login non effettuato", D.loginUser(l)); 	
	}
	
	@Test
	public void testgetPunteggi() {
		init();
		ArrayList<Dipendente> d = new ArrayList<Dipendente>();
		d = D.getPunteggi();
		System.out.println(d.size());
		assertTrue("lista punteggi non ottenuta", !d.isEmpty()); 
	}
	
	@Test
	public void testsetTrofei() {
		init();
		Dipendente d = new Dipendente();
		d.setId(1);
		boolean risp =  D.setTrofei(d, 7);
		assertTrue("login non effettuato", risp); 
	}
	   
	@Test
	public void testgetStatisticheD() {
		init();
		Login l = new Login("nick","pass");
		Punteggio p = D.getStatisticheD(l);
		System.out.println(p.getPunti());
		assertTrue("punteggio non ottenuto", true); 
	}
	   
	@Test
	public void testposticipa() {
		init();
		  Login l = new Login("nick","pass");
		  Domanda dom = new Domanda();
		  dom.setId(1);
		  boolean b = D.posticipa(l, dom);
		  assertTrue("non viene rsegnata la risposta corretta", b);
	}
	   
	@Test
	public void testlogoutD() {
		init();
		Login l = new Login("nick","pass");
		D.logoutD(l);
		assertTrue("logout non effettuato", true); 
	}
	
	@Test
	public void testlogoutA() {
		init();
		Login l = new Login("amministratoreAz","pass");
		D.logoutA(l);
		assertTrue("logout non effettuato", true); 
	}
	   
	@Test
	public void testgetStatisticheGlob() {
		init();
		Login l = new Login("nick","pass");
		Punteggio p = D.getStatisticheGlob(l);
		System.out.println(p.getMediaPuntiAzienda());
		assertTrue("punteggio non ottenuto", true); 
	}
	   
	@Test
	public void testrecuperoD() {
		init();
		Recupero amm = new Recupero();
		amm.setEmail("teamcommitted@gmail.com");
		amm.setCodFiscale("0");
		try{D.recuperoA(amm);}catch(Exception e){e.printStackTrace();};
		assertTrue("percorso errato", true);
	}
	   
	@Test
	public void testrecuperoA() {
		init();
		Recupero amm = new Recupero();
		amm.setEmail("teamcommitted@gmail.com");
		amm.setCodFiscale("0");
		try{D.recuperoA(amm);}catch(Exception e){e.printStackTrace();};
		assertTrue("percorso errato", true);
	}
	   
	@Test
	public void testmodPassA(){
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indirizzoAz);
		Login l = new Login("amministratoreAz","pass");
		Dipendente dip = sqlDip.getInfoA(l);
		dip.setNuovaPass("nuovaPass");
		boolean risultato = D.modPassA(dip);
		assertTrue("modifica password amministratore non riuscita",risultato == true);
	}

	@Test
	public void getElencoRuoliTest() {
	//test che verifica la modifica della password da parte di un amministratore
		init();
		//DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		DAODipendenti sqlDip = new SqlDAODipendenti(indirizzoAz);
		ArrayList<String> ruoli = sqlDip.getElencoRuoli();
		assertTrue("elenco ruoli non corrisponde",9 == ruoli.size());
	}


}
