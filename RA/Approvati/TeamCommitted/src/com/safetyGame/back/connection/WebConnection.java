/*
 * Name: WebConnection.java
 * Package: com.safetygame.back.connection
 * Author: Gabriele Facchin
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120717 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120708 | Alessandro Cornaglia| + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120609 | Gabriele Facchin    | + WebConnection
 * |          |                     | + loginDip
 * |          |                     | + loginAdmin 
 * |          |                     | + getDati 
 * |          |                     | + getPunteggio 
 * |          |                     | + getStat 
 * |          |                     | + getBadge
 * |          |                     | + modPassD 
 * |          |                     | + modPassA 
 * |          |                     | + modMail 
 * |          |                     | + resetPassD 
 * |          |                     | + resetPassA  
 * |          |                     | + mostraDomanda
 * |          |                     | + setRisposta 
 * |          |                     | + posticipa 
 * |          |                     | + logout 
 * |          |                     | + getElencoDomande 
 * |          |                     | + cancellaDomanda 
 * |          |                     | + aggiungiDomanda 
 * |          |                     | + getElencoDipendenti 
 * |          |                     | + setTrofei 
 * |          |                     | + aggiungiDipendente 
 * |          |                     | + cancellaDipendente 
 * |          |                     | + modInfoDipendente 
 * |          |                     | + getBadgesAS 
 * |          |                     | + assegnaBadge 
 * |          |                     | + getPunteggi 
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.connection;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

  /**
   * Classe che si occupa di gestire la connessione da parte del web
   * 
   * @author gfacchin 
   * @version v2.0
   */
public class WebConnection{
  private GestioneDati dati;
  /**
   * Costruttore della classe WebConnection
   * 
   * @param gestDati riferimento al facade GestioneDati 
   */
  public WebConnection(GestioneDati gestDati){dati=gestDati;}
    
  /**
   * Metodo per il login dei dipendenti
   * 
   * @param username username del dipendente che effettua il login
   * @param password password del dipendente che effettua il login
   * @return boolean che conferma il successo o meno dell'operazione
   */
  public boolean loginDip(String username, String password){
    Login l=new Login(username,password);
    return dati.loginUser(l);
  }

  /**
   * Metodo per il login degli utenti amministratori
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   * @param password password dell'amministratore
   * @param tipo boolean che indica il tipo di login amministratore
   * @return boolean che conferma il successo o meno dell'operazione
   */
  public boolean loginAdmin(String username, String password, boolean tipo){
    Login l=new Login(username,password);
    return dati.loginAdmin(l,tipo);
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
   * Metodo che consente di reperire le informazioni di un amministratore a partire
   * dal suo login
   * 
   * @param login login dell'amministratore
   * @return informazioni sull'amministratore
   */
  public Dipendente getDatiA(Login login){
    return dati.getDatiA(login); 
  }
   
   /**
    * Metodo che consente di recuperare le statistiche di un determinato dipendente
    * 
    * @param login login del dipendente che richiede di conoscere le statistiche
    * @return statistiche del dipendente
    */
  public Punteggio getPunteggio(Login login){
    return dati.getStatisticheD(login);
  }

   /**
    * Metodo che consente di recuperare le statistiche globali
    * 
    * @param l login del dipendente che richiede di conoscere le statistiche
    * @return statistiche globali
    */ 
  public Punteggio getStat(Login login){
    return dati.getStatisticheGlob(login);
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

  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modPassD(Dipendente dip){
    return dati.modificaPass(dip);
  }
   
  /**
   * Metodo che consente la modifica della password da parte di un amministratore
   *
   * @param dip Dipendente contenente i dati di un Amministratore che chiede di modificare la password 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modPassA(Dipendente dip){
    return dati.modPassA(dip);
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
   * @param recupero oggetto che contienee le informazioni utli al recupero
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean resetPassD(Recupero recupero){
    return dati.recuperoD(recupero);
  }
   
  /**
   * Metodo che consente la rigenerazione della password per un amministratore
   * 
   * @param recupero oggetto che contiene le informazioni utli al recupero
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean resetPassA(Recupero recupero){
    return dati.recuperoA(recupero);
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
   * Metodo che si occupa di comunicare la risposta del Dipendente
   * 
   * @param login Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   */
  public boolean setRisposta(Login login,Domanda risposta) {
	return dati.setRisposta(login, risposta);
  }
   
   /**
    * Metodo per posticipare una domanda
    * 
    * @param login login del dipendente
    * @param domPost domanda posticipata
    * @return true se la domanda è stata posticipata correttamente, false altrimenti
    */
  public boolean posticipa(Login login, Domanda domPost){
    return dati.posticipa(login, domPost);
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
   * Metodo per ottenere la lista di tutte le domande
   * 
   * @return un ArrayList<Domande> contenente tutte le domande
   */
  public ArrayList<Domanda> getElencoDomande(){
    return dati.getElencoDomande();
  }
  
  /**
   * Metodo per inserire una domanda dal server domande al server dell'azienda
   * 
   * @param dom domanda da aggiungere
   * @return true se l'operazione è stata completata, altrimenti false   
   */
  public boolean aggiungiDomanda(Domanda dom){
    return dati.addDomanda(dom);
  }
  
  /**
   * Metodo per eliminare una domanda dal server dell'azienda
   * 
   * @param dom domanda da rimuovere
   * @return true se l'operazione è stata completata, altrimenti false       
   */   
  public boolean cancellaDomanda(Domanda dom){
    return dati.remDomanda(dom);
  }

  /**
   * Metodo per ottenere i dati dei dipendenti dell'azienda
   * 
   * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
   */
  public ArrayList<Dipendente> getElencoDipendenti(){
    return dati.getElencoDipendenti();
  }
  
  /**
   * Metodo per modificare i trofei di un dipendente
   * 
   * @param dip il dipendente che si vuole modificare
   * @param num numero di trofei che si vuole assegnare
   * @return true se l'operazione ha successo, altrimenti false  
   */
  public boolean setTrofei(Dipendente dip, int num){
    return dati.setTrofei(dip, num);
  }
   
  /**
   * Metodo per aggiungere un dipendente
   * 
   * @param dip oggetto contenente i dati del nuovo dipendente
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean aggiungiDipendente(Dipendente dip){
    return dati.aggiungiDipendente(dip);
  }
   
  /**
   * Metodo per eliminare un Dipendente
   * 
   * @param dip oggetto contenente i dati del dipendente da eliminare
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean cancellaDipendente(Dipendente dip){
    return dati.cancellaDipendente(dip);
  }

  /**
   * Metodo per modificare i dati di un dipendente
   * 
   * @param dipNew oggetto contenente i nuovi dati del dipendente da modificare
   * @param dipOld oggetto contenente i vecchi dati del dipendente da modificare
   * @return true se l'operazione viene completata con successo, altrimenti false
   */
  public boolean modDipendente(Dipendente dipOld, Dipendente dipNew){
    return dati.modDipendente(dipNew, dipOld);
  }
   
  /**
  * Metodo per ottenere tutti i badge possibili
  * @return un ArrayList<Badge> contenente tutti i badge nel database
  * 
  */
  public ArrayList<Badge> getBadgesAS() {
    return dati.getBadgesAS();
  }
  
  /**
   * Metodo per assegnare un badge
   * 
   * @param login dati dell'utente che si deve controllare
   * @param dom domanda risposta dall'utente
   * @return true se l'utente ha ricevuto un badge, altrimenti false    
   */
  public boolean assegnaBadge(Domanda dom, Login login) {
    return dati.assegnaBadge(dom, login);
  }

  /**
   * Metodo per ottenere i punteggi medi dell'azienda e i punteggi di tutti i dipendenti
   * 
   * @return un ArrayList<Punteggio> contenente in posizione 0 un oggetto Punteggio contenente i dati medi dell'azienda
   * e successivamente la lista dei punteggi di tutti i dipendenti.
   */
  public ArrayList<Dipendente> getPunteggi() {
	return dati.getPunteggi();
  }
  
  /**
   * Metodo per recuperare lista dei ruoli aziendali
   * 
   * @return lista ruoli aziendali
   */
  public ArrayList<String> getElencoRuoli() {
    return dati.getElencoRuoli();
  }
  

}