/*
 * Name: ControlLogin.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120609 | Gabriele Facchin    | + ControlLogin
 * |          |                     | + tryLogin
 * |          |                     | + Recupera
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.*;

/**
 * Classe che gestisce i controlli sul login
 * 
 * @author gfacchin
 * @version 0.1
 */
public class ControlLogin{
  private Browser browser;
  /**
   * Costruttore della classe ControlLogin
   * 
   */
  public ControlLogin(){
    browser=Browser.getInstance();
  }
  
  /**
   * metodo che prova a fare il login
   * 
   * @param username lo username prelevato dalla grafica
   * @param password la password prelevata dalla grafica
   * 
   * @return boolean che indica il succeso o meno del login
   */
  public boolean tryLogin(String username, String password){
    String url="desklogin.jsp?username="+username.trim()+"&password="+password;
    char c=browser.leggi(url);
    if(c=='s'){
      ConnBack.getInstance().login(username,password);
      return true;
    }
    return false;
  }
  
  /**
   * metodo che prova a generare una password
   * 
   * @param codfis il codice fiscale prelevato dalla grafica
   * @param mail la mail prelevata dalla grafica
   * 
   * @return boolean che indica il succeso o meno della generazione
   */
  public boolean recupera(String codfis, String mail){
    String url="deskrecupero.jsp?email="+mail.trim()+"&codfis="+codfis.trim();
    char c=browser.leggi(url);
    if (c=='s'){
      return true;
    }
    return false;
  }
}
