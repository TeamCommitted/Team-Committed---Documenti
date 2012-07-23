/*
 * Name: DatiLogin.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120611 | Gabriele Facchin    | + DatiLogin
 * |          |                     | + getUsername
 * |          |                     | + getPassword
 * +----------+---------------------|---------------------
 * | 20120610 | Gabriele Facchin    | + getLogin
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.Login;


/**
 * Classe wrapper della classe condivisa Login che gestisce i dati di login di un Dipendente
 * 
 * @author gfacchin
 * @version 1.0
 */
public class DatiLogin{
  private Login l;
    
  /**
   * Costruttore della classe DatiLogin
   * 
   */
  public DatiLogin(String username, String password){
    l=new Login(username,password);
  }

  /**
   * metodo che consente di recuperare lo username
   * @return username
   */
  public String getUsername(){
    return l.getUsername();
  }
  
  /**
   * metodo che consente di recuperare la password
   * @return password
   */
  public String getPassword(){
    return l.getPassword();
  }
  
  /**
   * metodo che consente di ottenere l'oggetto Login per passarlo al back-end
   * @return login
   */
  public Login getLogin(){
    return l;
  }
}
