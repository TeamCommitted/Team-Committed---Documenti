/*
 * Name: GestioneDipendentiAATest.java
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
 * | 20120708 |Marco Begolo         | + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120611 |Giorgio Maggiolo     | + modPassATest
 * |          |                     | + GestioneDipendentiAATest
 * |          |                     | + getElencoDipendentiTest
 * |          |                     | + aggiungiDipendenteTest
 * |          |                     | + cancellaDipendenteTest
 * |          |                     | + modDipendenteTest
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

import java.util.ArrayList;

public class GestioneDipendentiAATest {
    private GestioneDipendentiAA gDipAA;
    private UpdateLog updLog;
    private GestioneLog gLog;
    private DAODipendenti dDip;
    private Indirizzo indAz;

    private void init(){
      indAz = new Indirizzo("127.0.0.1/ingAz","root","");
      dDip = new SqlDAODipendenti(indAz);
      updLog = new UpdateLog(indAz);
      gLog = new GestioneLog(updLog, dDip);
      gDipAA = new GestioneDipendentiAA(dDip,gLog);
    }
    
    
	@Test
	public void aggiungiDipTest() {
	//test che verifica che venga aggiunto un dipendente al DB
		init();
		Dipendente dip = new Dipendente();
		dip.setNome("pasdfaewrq");
		dip.setCognome("gfadfa");
		dip.setCodFiscale("sfdgsfgsrtgs");
		dip.setEmail("dfgjhkgd@sdfgjhk.it");
		dip.setRuolo("Pompiere");
		dip.setPunteggio(new Punteggio(0));
		boolean risultato = gDipAA.aggiungiDipendente(dip);
		assertTrue("dipendente non aggiunto",risultato == true);
	}
	
	@Test
	public void elencoDipTest() {
	//test che verifica l'elenco dei dipendenti presenti nel DB
		init();
		ArrayList<Dipendente> risultato_elenco = gDipAA.getElencoDipendenti();
		int numero_dip = 1;//nel DB al momento
		assertTrue("il numero di dipendenti in elenco non corrisponde",numero_dip == risultato_elenco.size());
	}
	
	@Test
	public void rimuoviDipTest() {
	//test che verifica la rimozione di un utente dal DB
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		Login l = new Login("nick","pass");
		Dipendente dip = sqlDip.getInfoD(l);
		boolean risultato = gDipAA.cancellaDipendente(dip);
		assertTrue("rimozione dipendente non riuscita",risultato == true);
	}
	
	@Test
	public void modDipTest() {
	//test che verifica la modifica di un dipendente dal DB
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		Login l = new Login("nick","pass");
		Dipendente dip = sqlDip.getInfoD(l);
		Dipendente dipMod = sqlDip.getInfoD(l);//costuisco dipendente da modificare
		dipMod.setNome("nuovoNome");
		boolean risultato = gDipAA.modDipendente(dipMod,dip);
		System.out.println(risultato);
		assertTrue("modifica dipendente non riuscita",risultato == true);
	}
	
	@Test
	public void modPassATest() {
	//test che verifica la modifica della password da parte di un amministratore
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		Login l = new Login("amministratoreAz","pass");
		Dipendente dip = sqlDip.getInfoA(l);
		dip.setNuovaPass("nuovaPass");
		boolean risultato = gDipAA.modPassA(dip);
		assertTrue("modifica password amministratore non riuscita",risultato == true);
	}

	@Test
	public void getElencoRuoliTest() {
	//test che verifica la modifica della password da parte di un amministratore
		init();
		DAODipendenti sqlDip = new SqlDAODipendenti(indAz);
		ArrayList<String> ruoli = sqlDip.getElencoRuoli();
		assertTrue("elenco ruoli non corrisponde",9 == ruoli.size());
	}
}
