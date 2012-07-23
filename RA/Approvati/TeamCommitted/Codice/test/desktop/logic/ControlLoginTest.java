package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControlLoginTest {

	ControlLogin controlLogin;
	
	private void init(){
		controlLogin = new ControlLogin();
	}
	
	@Test
	public void tryLoginTest() {
	  //test per verificare il corretto tentativo di effettuare il login
	  String username = "nick";
	  String pass = "pass";
	  
	  assertTrue("Login non riuscito", controlLogin.tryLogin(username, pass));
	}
	
	@Test
	public void recuperaTest() {
	  //test per verificare la corretta generazione di una password
	  String codfis = "sxrYDTCfvg";
	  String mail = "teamcommitted@gmail.com";
	  
	  assertTrue("Generazione non riuscitao", controlLogin.recupera(codfis, mail));
	}

}
