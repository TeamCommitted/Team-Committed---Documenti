package com.safetyGame.back.access;
/*
 * Name: DAOFactory.java
 * Package: com.safetygame.back.access
 * Author: Gabriele Facchin
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
 * | 20120512 | Gabriele Facchin    | + creaDAOLogin
 * |          |                     | + creaDAODipendenti
 * |          |                     | + creaDAODomande
 * |          |                     | + creaDAOBadge
 * |          |                     | + creaDAOPunteggi
 * +----------+---------------------|---------------------
 *
 */

/**
 * Classe che definisce i metodi che tutte le implementazioni del Factory dovranno implementare
 * 
 * @author gfacchin
 * @version 2.0
 */
public abstract class DAOFactory{
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAOLogin
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * @return l'oggetto SqlDAOLogin istanziato
   */   
  public abstract DAOLogin creaDAOLogin(Indirizzo azienda);

  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAODipendenti
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * @return l'oggetto SqlDAODipendenti istanziato
   */   
  public abstract DAODipendenti creaDAODipendenti(Indirizzo azienda);
  
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAODomande
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * @param domande oggetto Indirizzo contenente i recapiti per il server contenente le domande
   * @return l'oggetto SqlDAODomande istanziato
   */   
  public abstract DAODomande creaDAODomande(Indirizzo azienda, Indirizzo domande);
  
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAOBadge
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * @return l'oggetto SqlDAOBadge istanziato
   */   
  public abstract DAOBadge creaDAOBadge(Indirizzo azienda);
  
  /**
   * Prototipo del metodo che la Factory implementare per creare l'oggetto DAOPunteggi
   * 
   * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
   * @param domande oggetto Indirizzo contenente i recapiti per il server contenente le domande
   * @return l'oggetto SqlDAOPunteggi istanziato
   */   
  public abstract DAOPunteggi creaDAOPunteggi(Indirizzo azienda, Indirizzo Domande);
}
