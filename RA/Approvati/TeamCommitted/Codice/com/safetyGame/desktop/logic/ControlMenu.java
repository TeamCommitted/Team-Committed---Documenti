/*
 * Name: ControlNotifica.java
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
 * | 20120614 | Gabriele Facchin    | + ControlMenu
 * |          |                     | + logout
 * |          |                     | + richiediDomanda
 * |          |                     | + visualizzaPunteggio
 * |          |                     | + visualizzaDati
 * |          |                     | + modificaDati 
 * |          |                     | + isLogged
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import com.safetyGame.desktop.condivisi.*;

/**
 * Classe che gestisce i controlli sul Menu
 * 
 * @author gfacchin
 * @version 0.1
 */
public class ControlMenu{
  private ConnBack connessione;
  private Browser browser;
  
  /**
   * Costruttore della classe ControlMenu
   * 
   */
  public ControlMenu(){
    connessione=ConnBack.getInstance();
    browser=Browser.getInstance();
  }
  
  /**
   * metodo che fa effettuare il logout
   * 
   */
  public void logout(){
    browser.apri("logout.jsp");
    connessione.logout();
  }
  
  /**
   * metodo che fa aprire il browser con una nuova domanda se è passato abbastanza tempo
   * 
   */
  public void richiediDomanda(){
    if (connessione.mayApplyForNewQuestion()){
      browser.apri("nuovaDomanda.jsp");
      connessione.resetTimerRichiesta();
    }
  }
  
  /**
   * metodo che fa visualizzare il punteggio del dipendente
   * 
   */
  public void visualizzaPunteggio(){
    browser.apri("user_page.jsp");
  }
  
  /**
   * metodo che fa visualizzare i dati del dipendente
   * 
   */
  public void visualizzaDati(){
    browser.apri("visualizzaDatiD.jsp");
  }
  
  /**
   * metodo che fa visualizzare la pagina di modifica dei dati personali
   * 
   */
  public void modificaDati(){
    browser.apri("visualizzaDatiD.jsp");
  }
  
  /**
   * metodo che dice se vi è un utente loggato nell'applicazione
   * 
   * @return booleano che indica se un utente è loggato nell'applicativo desktop
   * 
   */
  public boolean isLogged(){
    return connessione.isLogged();
  }
}
