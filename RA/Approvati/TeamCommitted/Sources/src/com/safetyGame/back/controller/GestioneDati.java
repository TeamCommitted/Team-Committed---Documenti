/*
 * Name: GestioneDati.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120711 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120708 |Alessandro Cornaglia | + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120611 |Alessandro Cornaglia | + recupero
 * |          |                     | + modPassA
 * +----------+---------------------+---------------------
 * | 20120608 |Alessandro Cornaglia | + logout
 * |          |                     | * getBadgeD
 * |          |                     | + getStatisticheGlob
 * +----------+---------------------+---------------------
 * | 20120607 |Alessandro Cornaglia | + GestioneDati
 * |          |                     | + getBadgeAS
 * |          |                     | + getBadgeD
 * |          |                     | + assegnaBadgeD
 * |          |                     | + getElencoDipendenti
 * |          |                     | + aggiungiDipendente
 * |          |                     | + cancellaDipendente
 * |          |                     | + modDipendente
 * |          |                     | + getBadgeASgetDati
 * |          |                     | + modificaPass
 * |          |                     | + modificaEmail
 * |          |                     | + getElencoDomande
 * |          |                     | + getBadgeAS
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + getDomandaD
 * |          |                     | + setRisposta
 * |          |                     | + loginAdmin
 * |          |                     | + loginUser
 * |          |                     | + getPunteggi
 * |          |                     | + setTrofei
 * |          |                     | + getStatisticheD
 * |          |                     | + posticipa
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.controller;

import java.util.ArrayList;

import com.safetyGame.back.condivisi.*;
/**
 * Classe GestioneDati, facade del package controller del back-end
 * @author acornagl
 * @version v2.0
 */
public class GestioneDati{
   
  private GestioneRecupero gestioneRecupero;
  private GestioneLogin gestioneLogin;
  private GestioneDomandeD gestioneDomandeD;
  private GestioneDomandeAS gestioneDomandeAS;
  private GestioneDipendentiD gestioneDipendentiD;
  private GestioneDipendentiAA gestioneDipendentiAA;
  private GestioneBadgeD gestioneBadgeD;
  private GestioneBadgeAS gestioneBadgeAS;
  private GestionePunteggiD gestionePunteggiD;
  private GestionePunteggiAA gestionePunteggiAA;

  /**
   * Costruttore, con parametri, della classe GestioneDati 
   * 
   * @param gestRec riferimento ad oggetto di tipo GestioneRecupero
   * @param gestLogin riferimento ad oggetto di tipo GestioneLogin
   * @param gestDomD riferimento ad oggetto di tipo GestioneDomandeD
   * @param gestDomAS riferimento ad oggetto di tipo GestioneDomandeAS
   * @param gestDipD riferimento ad oggetto di tipo GestioneDipendentiD
   * @param gestDipAA riferimento ad oggetto di tipo GestioneDipendentiAA
   * @param gestBadgeD riferimento ad oggetto di tipo GestioneBadgeD
   * @param gestBadgeAS riferimento ad oggetto di tipo GestioneBadgeAS
   * @param gestPuntD riferimento ad oggetto di tipo GestionePunteggiD
   * @param gestPuntAA riferimento ad oggetto di tipo GestionePunteggiAA
   */
  public GestioneDati(GestioneRecupero gestRec,GestioneLogin gestLogin, GestioneDomandeD gestDomD, GestioneDomandeAS gestDomAS, GestioneDipendentiD gestDipD, GestioneDipendentiAA gestDipAA, GestioneBadgeD gestBadgeD, GestioneBadgeAS gestBadgeAS, GestionePunteggiD gestPuntD, GestionePunteggiAA gestPuntAA) {
	this.gestioneRecupero = gestRec;
	this.gestioneLogin = gestLogin;
	this.gestioneDomandeD = gestDomD;
	this.gestioneDomandeAS = gestDomAS;
	this.gestioneDipendentiD = gestDipD;
	this.gestioneDipendentiAA = gestDipAA;
	this.gestioneBadgeD = gestBadgeD;
	this.gestioneBadgeAS = gestBadgeAS;
	this.gestionePunteggiD = gestPuntD;
	this.gestionePunteggiAA = gestPuntAA;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDati
   */
  public GestioneDati() {
	this.gestioneRecupero = null;
	this.gestioneLogin = null;
	this.gestioneDomandeD = null;
	this.gestioneDomandeAS = null;
	this.gestioneDipendentiD = null;
	this.gestioneDipendentiAA = null;
	this.gestioneBadgeD = null;
	this.gestioneBadgeAS = null;
	this.gestionePunteggiD = null;
	this.gestionePunteggiAA = null;  
  }
  /**
  * Metodo per ottenere tutti i badge possibili
  * @return un ArrayList<Badge> contenente tutte le badge nel database
  * 
  */
  public ArrayList<Badge> getBadgesAS() {
    return this.gestioneBadgeAS.getBadgesAS();
  }
  
  /**
    * Metodo per ottenere i dati delle badge per un dato utente
    * 
    * @param login dati dell'utente che effettua la richiesta
    * @param numeroBadge numero di badge che si vuole selezionare
    * @return un ArrayList<Badge> contenente n badge ottenute dall'utente 
   */
  public ArrayList<Badge> getBadgeD(Login login, int numeroBadge) {
    return this.gestioneBadgeD.getBadgeD(login, numeroBadge);  
  }
  
  /**
   * Metodo per controllare se l'utente ha soddisfatto dei requisiti per ottenere un badge
   * 
   * @param login dati dell'utente che si deve controllare
   * @param domanda domanda risposta dall'utente
   * @return true se l'utente ha ricevuto un badge, altrimenti false    
   */
  public boolean assegnaBadge(Domanda domanda, Login login) {
    return this.gestioneBadgeD.assegnaBadge(domanda, login);
  }
  
  /**
   * Metodo per ottenere i dati dei dipendenti dell'azienda
   * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
   */
  public ArrayList<Dipendente> getElencoDipendenti() {
    return this.gestioneDipendentiAA.getElencoDipendenti();
  }
  
  /**
   * Metodo per aggiungere un dipendente
   * 
   * @param dip oggetto contenente i dati del nuovo dipendente
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean aggiungiDipendente(Dipendente dip) {
    return this.gestioneDipendentiAA.aggiungiDipendente(dip);
  }
  
  /**
   * Metodo per eliminare
   * 
   * @param dip oggetto contenente i dati del dipendente da eliminare
   * @return true se l'operazione viene completata con successo, altrimenti false    
   */
  public boolean cancellaDipendente(Dipendente dip) {
	return this.gestioneDipendentiAA.cancellaDipendente(dip);
  }
  
  /**
   * Metodo per modificare i dati di un dipendente
   * 
   * @param newDip oggetto contenente i nuovi dati del dipendente da modificare
   * @param oldDip oggetto contenente i vecchi dati del dipendente da modificare
   * @return true se l'operazione viene completata con successo, altrimenti false
   */
  public boolean modDipendente(Dipendente newDip, Dipendente oldDip) {
	return this.gestioneDipendentiAA.modDipendente(newDip, oldDip);
  }
  
  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param login login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDatiD(Login login) {
    return this.gestioneDipendentiD.getDatiD(login);
  }
  
  /**
   * Metodo che consente di reperire le informazioni di un amministratore a partire
   * dal suo login
   * 
   * @param login login dell'amministratore
   * @return informazioni sull'amministratore
   */
  public Dipendente getDatiA(Login login) {
    return this.gestioneDipendentiAA.getDatiA(login);
  }
  
  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaPass(Dipendente dip) {
	return this.gestioneDipendentiD.modificaPass(dip);
  }
  
  /**
   * Metodo che consente la modifica della mail da parte di un dipendente
   * 
   * @param dip che chiede di modificare la mail
   * @param newEmail nuovo indirizzo mail da inserire
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaEmail(Dipendente dip, String newEmail) {
	return this.gestioneDipendentiD.modificaEmail(dip, newEmail);
  }
  
  /**
   * Metodo per ottenere la lista di tutte le domande
   * @return un ArrayList<Domande> contenente tutte le domande
   */
  public ArrayList<Domanda> getElencoDomande() {
	return this.gestioneDomandeAS.getElencoDomande();
  }
  
  /**
   * Metodo per inserire una domanda dal server domande al server dell'azienda
   * @param dom domanda da aggiungere
   * @return true se l'operazione è stata completata, altrimenti false   
   */
  public boolean addDomanda(Domanda dom) {
    return this.gestioneDomandeAS.addDomanda(dom);
  }
  
  /**
   * Metodo per eliminare una domanda dal server dell'azienda
   * 
   * @param dom domanda da rimuovere
   * @return true se l'operazione è stata completata, altrimenti false       
   */
  public boolean remDomanda(Domanda dom) {
	return this.gestioneDomandeAS.remDomanda(dom);
  }
  
  /**
   * Metodo che consente di recuperare una domanda 
   * 
   * @param login oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda getDomandaD(Login login) {
	return this.gestioneDomandeD.getDomandaD(login);
  }
  
  /**
   * Metodo che si occupa di controllare la risposta data da un dipendente ad una
   * domanda e tenta di scrivere tali informazioni sul DB. Se la risposta è corretta
   * assegna il punteggio al dipendente
   * 
   * @param login Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   * @return booleano che indica l'esito operazione
   */
  public boolean setRisposta(Login login,Domanda risposta) {
	return this.gestioneDomandeD.setRisposta(login, risposta);
  }
  
  /**
   * Metodo per il login degli utenti amministratori
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   * @param tipo tipo di amministratore che effettua il login
   * 
   * @return booleano che indica l'esito dell'operazione
   */
  public boolean loginAdmin(Login login, boolean tipo){
	return this.gestioneLogin.loginAdmin(login,tipo);
  }
  
  /**
   * Metodo per il login dei dipendenti
   * 
   * @param login oggetto contenente i dati di login inseriti dall'utente
   * 
   * @return booleano che indica se l'utente e` loggato
   */
  public boolean loginUser(Login login) {
	return this.gestioneLogin.loginUser(login);		
  }
  
  /**
   * Metodo per ottenere i punteggi medi dell'azienda e i punteggi di tutti i dipendenti
   * 
   * @return un ArrayList<Punteggio> contenente in posizione 0 un oggetto Punteggio contenente i dati medi dell'azienda
   * e successivamente la lista dei punteggi di tutti i dipendenti.
   */
  public ArrayList<Dipendente> getPunteggi() {
	return this.gestionePunteggiAA.getPunteggi();
  }
  
  /**
   * Metodo per modificare i trofei di un dipendente
   * 
   * @param dip il dipendente che si vuole modificare
   * @param numTrofei numero di trofei che si vuole assegnare
   * @return true se l'operazione ha successo, altrimenti false  
   */
   public boolean setTrofei(Dipendente dip, int numTrofei) {
	 return this.gestionePunteggiAA.setTrofei(dip, numTrofei);
   }
   
   /**
    * Metodo che consente di recuperare le statistiche di un determinato dipendente
    * 
    * @param login login del dipendente che richiede di conoscere le statistiche
    * 
    * @return statistiche del dipendente
    */
   public Punteggio getStatisticheD(Login login) {
	 return this.gestionePunteggiD.getStatisticheD(login);
   }
   
  
   /**
    * Metodo che si occupa di controllare quando una domanda viene posticipata
    * @param login login del dipendente
    * @param dom domanda posticipata
    * @return true se la domanda è stata posticipata correttamente, false altrimenti
    */
   public boolean posticipa(Login login, Domanda dom) {
	 return this.gestioneDomandeD.posticipa(login, dom);
   }
   
   /**
    * Metodo per segnalare al sistema il logout di un utente
    * 
    * @param login login del dipendente che ha effettuato il logout
    */
   public void logoutD(Login login) {
	 this.gestioneLogin.logoutD(login);
   }
   
   /**
    * Metodo per segnalare al sistema il logout di un utente
    * 
    * @param login login del dipendente che ha effettuato il logout
    */
   public void logoutA(Login login) {
	 this.gestioneLogin.logoutA(login);
   }
   
   /**
    * Metodo che consente di recuperare le statistiche globali
    * 
    * @param login login del dipendente che richiede di conoscere le statistiche
    * @return statistiche globali
    */
   public Punteggio getStatisticheGlob(Login login) {
	 return this.gestionePunteggiD.getStatisticheGlob(login);
   }
   
   /**
    * Metodo che consente ad un dipendente di resettare la propria password
    * @param dip dipendente che chiede il resete della password
    * @return true se l'operazione è andata a buon fine, false altrimenti
    */
   public boolean recuperoD(Recupero dip) {
	 return this.gestioneRecupero.recuperoD(dip);
   }
   
   /**
    * Metodo che consente ad un amministratore di resettare la propria password
    * @param amm amministratore che chiede il resete della password
    * @return true se l'operazione è andata a buon fine, false altrimenti
    */
   public boolean recuperoA(Recupero amm) {
	 return this.gestioneRecupero.recuperoA(amm);
   }
   
   /**
    * Metodo per modificare la password di un amministratore
    * 
    * @param admin oggetto contenente i dati dell'amministratore
    * @return true se l'operazione viene completata con successo, altrimenti false
    */
   public boolean modPassA(Dipendente admin){
       return this.gestioneDipendentiAA.modPassA(admin);
    }
   
   /**
    * Metodo che consente di recuperare la lista dei ruoli aziendali
    * 
    * @return lista dei ruoli aziendali
    */
   public ArrayList<String> getElencoRuoli() {
     return this.gestioneDipendentiAA.getElencoRuoli();
   }
   
}