/*
 * Name: ApplicazioniConnection.java
 * Package: com.safetygame.back.connection
 * Author: Lorenzo Braghetto
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120718 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120611 | Lorenzo Braghetto   | ApplicazioniConnection
 * |          |                     | login
 * |          |                     | getDati
 * |          |                     | getStat
 * |          |                     | modPass
 * |          |                     | modMail
 * |          |                     | resetPass
 * |          |                     | mostraDomanda
 * |          |                     | posticipa
 * |          |                     | rispondi
 * |          |                     | logout
 * |          |                     | getBadge
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.connection;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

  /**
   * Classe che si occupa di gestire la connessione da parte delle applicazioni
   * 
   * @author lbraghetto 
   * @version v2.0
   */
public class ApplicazioniConnection{
  private GestioneDati dati;
   
  
  /**
   * Costruttore della classe WebConnection
   * 
   * @param gestDati riferimento al facade GestioneDati 
   */
  public ApplicazioniConnection(GestioneDati gestDati){dati = gestDati;}
    
  /**
   * Metodo per il login dei dipendenti
   * 
   * @param username username dell'utente
   * @param password password dell'utente
   * @return boolean che conferma il successo o meno dell'operazione
   */
  public boolean login(String username, String password){
    Login login=new Login(username,password);
    return dati.loginUser(login);
  }
    
  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param login login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDati(Login login){
    return dati.getDatiD(login);
  }
   
   /**
    * Metodo che consente di recuperare le statistiche globali
    * 
    * @param login login del dipendente che richiede di conoscere le statistiche
    * @return statistiche globali
    */ 
  public Punteggio getStat(Login login){
    return dati.getStatisticheGlob(login);
  }
   
  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modPass(Dipendente dip){
    return dati.modificaPass(dip);
  }
   
  /**
   * Metodo che consente la modifica della mail da parte di un dipendente
   * 
   * @param dip Dipendente che chiede di modificare la mail
   * @param mail nuovo indirizzo mail da inserire
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modMail(Dipendente dip, String mail){
    return dati.modificaEmail(dip,mail);
  }
   
  /**
   * Metodo che consente la rigenerazione della password per un dipendente
   * 
   * @param recupero oggetto recupero contentente le informazioni del dipendente utili al recupero password
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean resetPass(Recupero recupero){
    return dati.recuperoD(recupero);
  }
   
  /**
   * Metodo che consente di recuperare una domanda 
   * 
   * @param login oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda mostraDomanda(Login login){
    return dati.getDomandaD(login);
  }
  
   /**
    * Metodo per posticipare una domanda
    * 
    * @param login login del dipendente
    * @param dom domanda posticipata
    * @return true se la domanda è stata posticipata correttamente, false altrimenti
    */
  public boolean posticipa(Login login, Domanda dom){
    return dati.posticipa(login, dom);
  }
   
  /**
   * Metodo che si occupa di comunicare la risposta del Dipendente
   * 
   * @param login Login del dipendente che ha risposto
   * @param domanda Domanda posta al dipendente contenente la risposta data
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   */
  public boolean rispondi(Login login, Domanda domanda){
    return dati.setRisposta(login, domanda);
  }
  
  /**
    * Metodo per segnalare al sistema il logout di un dipendente
    * 
    * @param login login del dipendente che ha effettuato il logout
    */
  public void logoutD(Login login){
    dati.logoutD(login);
  }
  
  /**
    * Metodo per segnalare al sistema il logout di un amministratore
    * 
    * @param login login dell'amministratore che ha effettuato il logout
    */
  public void logoutA(Login login){
    dati.logoutA(login);
  }

  /**
    * Metodo per ottenere i dati dei badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param num numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenuti dall'utente 
  */
  public ArrayList<Badge> getBadge(Login login, int num){
    return dati.getBadgeD(login,num);
  }
}
