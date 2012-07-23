/*
 * Name: GestioneDomandeDTest.java
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
 * | 20120611 |Lorenzo Braghetto    | + posticipaTest
 * |          |                     | * getDomandaTest
 * |          |                     | * setRispostaTest
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;

import static org.junit.Assert.*;
import com.safetyGame.back.access.*;
import org.junit.Test;

import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOPunteggi;
import com.safetyGame.back.access.Indirizzo;

public class GestioneDomandeDTest {

	private DAODomande daoDomande;
    private DAOPunteggi daoPunteggi;
	private DAODipendenti daoDipendenti;
	private DAOBadge daoBadge;
	private GestionePunteggiD gestionePunteggiD;
	private GestioneLog gestioneLog;
	private GestioneBadgeD gestioneBadge;
	private GestioneLogin gestioneLogin;
	private Indirizzo indirizzoAz;
	private Indirizzo indirizzoDom;
	private DAOLogin daoLogin;
	private GestioneDomandeD gestioneDomandeD;
	private UpdateLog updatelog;
	
	private void init() {
	  indirizzoAz = new Indirizzo("127.0.0.1/ingAz","root","");
	  indirizzoDom = new Indirizzo("127.0.0.1/ingDom","root","");
	  daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);  
	  daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
	  daoDipendenti = new SqlDAODipendenti(indirizzoAz);
	  gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
	  updatelog = new UpdateLog(indirizzoAz);
	  gestioneLog = new GestioneLog(updatelog,daoDipendenti);
	  daoBadge = new SqlDAOBadge(indirizzoAz);
	  daoLogin = new SqlDAOLogin(indirizzoAz);
	  gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
	  gestioneBadge = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande,gestioneLog,gestioneLogin);
	  gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD,gestioneLog,gestioneBadge);
	}
	
	@Test
	public void getDomandaDTest(){
	//test che verifica il recupero di una domanda
	  init();
	  Login l = new Login("andrea.marton","pass");
	  Domanda dom = gestioneDomandeD.getDomandaD(l);
	  System.out.println(dom.getId());
	  assertTrue("non viene ritornata una domanda", dom!=null);
	  //devo verificare che nella tabella LogRicevuta ci sia la riga: 1 - 2 - id dell'output - data e ora correnti 
	}
	
	
	@Test
	public void getDomandaTest() {
	//test che verifica il recupero di una domanda
	  init();
	  Login l = new Login("nick","pass");
	  Domanda dom = gestioneDomandeD.getDomandaD(l);
	  assertTrue("non viene ritornata domanda corretta", dom.getId()==2);
	}
	
	@Test
	public void setRispostaTest() {
	//test che verifica la risposta data ad una domanda
	  init();
	  Login l = new Login("andrea.marton","pass");
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  dom.setRispostaData(1);
	  dom.setPunteggio(new Punteggio(50));
	  boolean b = gestioneDomandeD.setRisposta(l, dom);
	  assertTrue("non viene inserita correttamente la risposta", b);
	  //devo verificare che nella tabella LogRisposta sia presente la riga: 1 - 2 - 1 - data e ora correnti
	}
	
	@Test
	public void posticipaTest() {
	//test che verifica il posticipo di una domanda
	  init();
	  Login l = new Login("andrea.marton","pass");
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  boolean b = gestioneDomandeD.posticipa(l, dom);
	  System.out.println(b);
	  assertTrue("non viene posticipata correttamente una domanda", b);
	  //devo verificare che nella tabella LogPosticipa sia presente la riga: 1 - 2 - 1 - data e ora correnti
	}

}
