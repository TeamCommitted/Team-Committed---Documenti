/*
 * Name: GestioneLogTest.java
 * Package: com.safetygame.back.controller
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120531 |Lorenzo Braghetto    | * scriviLogin
 * |          |                     | * scriviLogout
 * |          |                     | * scriviDomRic
 * |          |                     | * scriviDomProp
 * |          |                     | * scriviDomPost
 * |          |                     | * scriviDomRisp
 * |          |                     | *scriviModPassD
 * |          |                     | *scriviModEmailD
 * |          |                     | *scriviOttenimentoBadge
 * +----------+---------------------+---------------------
 * | 20120527 |Lorenzo Braghetto    | + getLog
 * |          |                     | + getPercorso
 * +----------+---------------------+---------------------
 * | 20120520 |Lorenzo Braghetto    | + GestioneLog
 * |          |                     | + getUpdateLog
 * |          |                     | + setUpdateLog
 * |          |                     | + scriviLogin
 * |          |                     | + scriviLogout
 * |          |                     | + scriviDomRic
 * |          |                     | + scriviDomProp
 * |          |                     | + scriviDomPost
 * |          |                     | + scriviDomRisp
 * |          |                     | + scriviModPassD
 * |          |                     | + scriviModEmailD
 * |          |                     | + scriviOttenimentoBadge
 * |          |                     | + scriviAddDip
 * |          |                     | + scriviDelDip
 * |          |                     | + scriviModDip
 * |          |                     | + scriviAddDomande
 * |          |                     | + scriviDelDomande
 * +----------+---------------------|---------------------
 *
 */ 
package com.safetyGame.back.controller;

import com.safetyGame.back.condivisi.*;

import static org.junit.Assert.*;

import com.safetyGame.back.access.*;

import org.junit.Test;
/**
 * Classe di test per oggetti di tipo GestioneLog
 * 
 * @author lbragh
 * @version v2.0
 */
public class GestioneLogTest {

	private GestioneLog gestioneLog;
 	private Indirizzo indirizzoAz;
 	private DAODipendenti daoDip;
 	private UpdateLog updateLog;
	//metodo per inizializzare l'oggetto

 	private void init() {
		
	    String indAz = "127.0.0.1/ingAz";
	 	String utente = "root";
	    String pass = "";
	    indirizzoAz = new Indirizzo(indAz,utente,pass);
	    updateLog = new UpdateLog(indirizzoAz);
	    
	    daoDip = new SqlDAODipendenti(indirizzoAz);
	    
	    gestioneLog = new GestioneLog(updateLog,daoDip);
		
	}


	@Test
	public void testLoginD() { //verifico cosa succede quando uso scriviLoginD()
		init(); //inizializzo il test

		Login login = new Login();
		login.setUsername("nick");
		login.setPassword("pass");
		
		gestioneLog.scriviLoginD(login);
	/*	//File f = new File(".");
		//System.out.println(f.getAbsolutePath());
		gestioneLog.scriviLogin(login);

		//controllo percorso
		String percorso = gestioneLog.getPercorso();
		String percorsoCorretto = "/log/"+ login.getUsername() + "/login.txt";
		System.out.println(percorsoCorretto);
		System.out.println(percorso);
		assertTrue("percorso errato", percorso.equals(percorsoCorretto));

		//controllo log
		String log = gestioneLog.getLog();
		String logCorretto = "LOGIN "+ this.dataOra.toString()+ " " + login.getUsername();
		assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testLoginA() { //verifico cosa succede quando uso scriviLoginA()
		init(); //inizializzo il test

		Login login = new Login();
		login.setUsername("amministratoreAz");
		login.setPassword("pass");
		
		gestioneLog.scriviLoginA(login);
	/*	//File f = new File(".");
		//System.out.println(f.getAbsolutePath());
		gestioneLog.scriviLogin(login);

		//controllo percorso
		String percorso = gestioneLog.getPercorso();
		String percorsoCorretto = "/log/"+ login.getUsername() + "/login.txt";
		System.out.println(percorsoCorretto);
		System.out.println(percorso);
		assertTrue("percorso errato", percorso.equals(percorsoCorretto));

		//controllo log
		String log = gestioneLog.getLog();
		String logCorretto = "LOGIN "+ this.dataOra.toString()+ " " + login.getUsername();
		assertTrue("log errato", log.equals(logCorretto));*/
	}

	@Test
	public void testLogoutD() { //verifico cosa succede quando uso scriviLogoutD()
		init();//inizializzo il test

		Login login = new Login("nick","pass");
		
		gestioneLog.scriviLogoutD(login);
		/*
		//controllo percorso
		String percorso = gestioneLog.getPercorso();
		String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/logout.txt";
		assertTrue("percorso errato", percorso.equals(percorsoCorretto));
		
		//controllo log
		String log = gestioneLog.getLog();
		String logCorretto = "LOGOUT "+ this.dataOra.toString()+ " " + d.toStringID();
		
		/*assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testLogoutA() { //verifico cosa succede quando uso scriviLogoutA()
		init();//inizializzo il test

		Login login = new Login("amministratoreAz","pass");
		
		gestioneLog.scriviLogoutA(login);
		/*
		//controllo percorso
		String percorso = gestioneLog.getPercorso();
		String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/logout.txt";
		assertTrue("percorso errato", percorso.equals(percorsoCorretto));
		
		//controllo log
		String log = gestioneLog.getLog();
		String logCorretto = "LOGOUT "+ this.dataOra.toString()+ " " + d.toStringID();
		
		/*assertTrue("log errato", log.equals(logCorretto));*/
	}

	@Test
	public void testDomRic() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
	  Login login = new Login("nick","pass");
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  gestioneLog.scriviDomRic(login,dom);
	/*	
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dRic.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA RICEVUTA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();	
	  assertTrue("log errato", log.equals(logCorretto));*/
	}

	@Test
	public void testDomProp() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test;

	  Login login = new Login("nick","pass");
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  gestioneLog.scriviDomProp(login,dom);
	/*	
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dProp.txt";	
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA PROPOSTA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testDomPost() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test

	  Login login = new Login("nick","pass");
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  gestioneLog.scriviDomPost(login,dom);
	/*	
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dPost.txt";	
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA POSTICIPATA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testDomRisp() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test

	  Login login =new Login("nick","pass");
		
	  //inizializzo domanda fittizzia
	  Domanda dom = new Domanda();
	  dom.setId(1);
	  gestioneLog.scriviDomRisp(login,dom);
	/*
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ login.getDipendente().getId() + "/dRisp.txt";	
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "DOMANDA RISPOSTA "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " id dom=" + dom.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}

	@Test
	public void testModPassD() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(1);

	  gestioneLog.scriviModPassD(dip);
	/*
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ dip.getId() + "/modPassD.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "MODIFICA PASS D "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testModEmailD() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(1);

	  gestioneLog.scriviModEmailD(dip);
	/*
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ dip.getId() + "/modEmailD.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "MODIFICA EMAIL D "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testOttenimentoBadge() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(1);
	  
	  //inizializzo badge fittizzio
	  Badge b = new Badge();
	  b.setId(1);

	  gestioneLog.scriviOttenimentoBadge(dip,b);
	/*
	  //controllo percorso
	  String percorso = gestioneLog.getPercorso();
	  String percorsoCorretto = "/log/"+ dip.getId() + "/modOttB.txt";
	  assertTrue("percorso errato", percorso.equals(percorsoCorretto));
	  
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "OTTENIMENTO BADGE "+ this.dataOra.toString()+ " id dip=" + dip.getId() + " badge=" + b.getNome();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testAddDip() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(1);

	  gestioneLog.scriviAddDip(dip);
	  /*
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "AGGIUNTO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testDelDip() { //verifico cosa succede quando uso scriviDomRic()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(1);

	  gestioneLog.scriviDelDip(dip);
	  /*
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "RIMOSSO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));*/
	}
	
	@Test
	public void testModDip() { //verifico cosa succede quando uso scriviModDip()
	  init();//inizializzo il test
		
	  //inizializzo il dipendente fittizzio
      Dipendente dip = new Dipendente();
	  dip.setId(1);

	  gestioneLog.scriviModDip(dip);
	  /*
	  //controllo log
	  String log = gestioneLog.getLog();
	  String logCorretto = "MODIFICATO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
	  assertTrue("log errato", log.equals(logCorretto));
	  */
	}
	
	@Test
	public void testAddDom(){ //verifico cosa succede quando uso scriviAddDomande()
		  init();//inizializzo il test
		  
		  Domanda d = new Domanda();
		  d.setId(1);

		  gestioneLog.scriviAddDomande(d);
		  /*
		  //controllo log
		  String log = gestioneLog.getLog();
		  String logCorretto = "MODIFICATO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
		  assertTrue("log errato", log.equals(logCorretto));
	  */
		
	}
	
	@Test
	public void testDelDom(){ //verifico cosa succede quando uso scriviDelDomande()
		  init();//inizializzo il test
			
		  Domanda d = new Domanda();
		  d.setId(1);

		  gestioneLog.scriviDelDomande(d);
		  /*
		  //controllo log
		  String log = gestioneLog.getLog();
		  String logCorretto = "MODIFICATO DIPENDENTE "+ this.dataOra.toString()+ " id dip=" + dip.getId();
		  assertTrue("log errato", log.equals(logCorretto));
	  */
		
	}
	
}