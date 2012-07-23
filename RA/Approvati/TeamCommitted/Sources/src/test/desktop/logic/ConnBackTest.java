/*
 * Name: ConnBackTest.java
 * Package: com.safetygame.desktop.logic
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120719 | Alessandro Cornaglia| + getServerTest
 * |          |                     | + loginTest
 * |          |                     | + logoutTest
 * |          |                     | + notificaDomandaTest
 * |          |                     | + mayApplyForNewQuestionTest
 * |          |                     | + isLoggedTest
 * |          |                     | + userLoggatoTest
 * +----------+---------------------|---------------------
 */
package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnBackTest {

	@Test
	public void getServerTest() {
		//test per verificare correttezza indirizzo server
		String server = "localhost";
		assertTrue("Indirizzo server non corrisponde",ConnBack.getInstance().getServer().equals(server));
	}
	
	@Test
	public void loginTest(){
	//test per verificare che un utente del desktop possa effettuare il log al sistema
		String username = "nick";
		String password = "passs";
		ConnBack.getInstance().login(username, password);
		//controllare il log di login se operazione conclusa con successo
	}
	
	@Test
	public void logoutTest(){
	//test per verificare che un utente del desktop possa effettuare il logout al sistema
		ConnBack.getInstance().logout();
		//controllare il log di login se operazione conclusa con successo
	}

	@Test
	public void notificaDomandaTest(){
		//verifico la visualizzazione della proposta di una domanda
		//effettuo login
		String username = "nick";
		String password = "passs";
		ConnBack.getInstance().login(username, password);
		
		ConnBack.getInstance().notificaDomanda();
		while(true){System.out.println("");}
		//visualizzo a video la richiesta di risposta ad una domanda
		//controllare il log di login se operazione conclusa con successo
	}
	
	@Test
	public void mayApplyForNewQuestionTest(){
		
		//effettuo login
		String username = "nick";
		String password = "passs";
		ConnBack.getInstance().login(username, password);
		
		assertTrue("Non corretto possibilita` di rispondere a nuova domanda",ConnBack.getInstance().mayApplyForNewQuestion() == true);
	}
	
	@Test
	public void isLoggedTest(){
		//test per verificare il controllo se un dipendente è loggato
		//effettuo login
		String username = "nick";
		String password = "passs";
		ConnBack.getInstance().login(username, password);
		
		assertTrue("Non corretto possibilita` di verificare se utente e` loggato",ConnBack.getInstance().isLogged() == true);
	}
	
	@Test
	public void userLoggatoTest(){
		//test per verificare la correttezza dello username e password ritornato di un utente loggato
		//effettuo login
		String username = "nick";
		String password = "passs";
		ConnBack.getInstance().login(username, password);
		
		assertTrue("Username non corrisponde",ConnBack.getInstance().userLoggato().equals(username));
		
		assertTrue("Password non corrisponde",ConnBack.getInstance().passUserLoggato().equals(password));
	}
}
