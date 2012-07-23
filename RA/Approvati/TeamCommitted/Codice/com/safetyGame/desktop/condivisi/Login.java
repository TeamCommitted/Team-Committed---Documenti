/*
 * Name: Login.java
 * Package: com.safetygame.desktop.condivisi
 * Author: Alessandro Cornaglia & Gabriele Facchin
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120717 | Gabriele Facchin    | + tutti i metodi 
 * |          | Alessandro Cornaglia| + sono stati copiati
 * |          |                     | + dall'omonima 
 * |          |                     | + classe nel 
 * |          |                     | + Back End
 * +----------+---------------------|---------------------
 * | 20120610 | Gabriele Facchin    | + propagati gli 
 * |          |                     | + aggiornamenti del 
 * |          |                     | + backend 
 * +----------+---------------------|---------------------
 *
 */
 package com.safetyGame.desktop.condivisi;

/**
 * Classe contenitrice dei dati di autenticazione di un utente
 * 
 * @author acornagl 
 * @author gfacchin
 * @version 2.0
 * 
 */
 public class Login {
		
	  private String username;
	  private String password;
	  
	  /**
	   * Costruttore con parametri della classe Login
	   * 
	   * @param user username utente
	   * @param pass password utente
	   */
	  public Login(String user, String pass) {
	    this.username = user;
	    this.password = pass;
	  }
	  
	  /**
	   * Costruttore senza parametri della classe Login
	   */
	  public Login() {
	    this.username = null;
	    this.password = null;
	  }
	  
	  /**
	   * metodo che consente di recuperare lo username del login
	   * 
	   * @return username del login
	   */
	  public String getUsername() {
	    return username;
	  }

	  /**
	   * metodo che consente di impostare lo username del login
	   * 
	   * @param username username del login da impostare
	   */
	  public void setUsername(String username) {
	    this.username = username;
	  }

	  /**
	   * metodo che consente di recuperare la password del login
	   * 
	   * @return password del login
	   */
	  public String getPassword() {
	    return password;
	  }

	  /**
	   * metodo che consente di impostare la password del login
	   * 
	   * @param password password del login da impostare
	   */
	  public void setPassword(String password) {
	    this.password = password;
	  }

	}