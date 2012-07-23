/*
 * Name: DAOBadge.java
 * Package: com.safetygame.back.access
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120719 | Alessandro Cornaglia|  - test
 * |          |                     |  + testCreazioneIniz
 * |          |                     |  + testWebConnection
 * +----------+---------------------+---------------------
 * | 20120512 | Alessandro Cornaglia|  + test
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back;

import static org.junit.Assert.*;
import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.connection.*;
import org.junit.Test;

public class InizializzatoreTest {

	private Inizializzatore iniz;

	private void init() {
	  //iniz = new Inizializzatore();
		//iniz = Inizializzatore.inizializzatore;	
		//iniz.crea();
	}
	@Test
	public void testCreazioneIniz() {
	//test per verificare la corretta creazione di inizializzatore
		init();		
		//se non solleva eccezioni allora l'ha creato correttamente
	}

	@Test
	public void testWebConnection(){
	//test per verificare che il web connection all'interno di inizializzatore
	//funzioni correttamente
		//init();
		WebConnection webConn = iniz.getWeb();

		//testo login dipendente
		String username = "nick";
		String password = "pass";
		boolean esitoLoginDip = webConn.loginDip(username, password);
		assertTrue("Login dipendente non riuscito", esitoLoginDip == true);

		//testo login amministratore
		String usernameA = "amministratoreAz";
		String passwordA = "pass";
		boolean tipo = true;
		boolean esitoLoginAdmin = webConn.loginAdmin(usernameA, passwordA,tipo);
		assertTrue("Login amministratore non riuscito", esitoLoginAdmin == true);

		//testo la modifica della password di un dipendente
		Login login = new Login(username,password);
		Dipendente dip = webConn.getDati(login);
		String nuovaPass ="nuova";
		dip.setNuovaPass(nuovaPass);
		boolean esitoModPass = webConn.modPassD(dip);
		assertTrue("Resetpassword dipendente non riuscito", esitoModPass == true);

		//tutte queste funzionano --->funzioneranno anche le altre
	}

}
