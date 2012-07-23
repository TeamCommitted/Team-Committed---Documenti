/*
 * Name: GestioneDomandeD.java
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
 * | 20120712 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120531 |Alessandro Cornaglia | + posticipa
 * +----------+---------------------+---------------------
 * | 20120531 |Alessandro Cornaglia | * GestioneDomandeD
 * |          |                     | - getDaoFactory
 * |          |                     | - setDaoFactory
 * |          |                     | - getDaoDomande
 * |          |                     | - setDaoDomande
 * |          |                     | * getDomanda
 * |          |                     | * setRisposta
 * |          |                     | + getDAODipendenti
 * |          |                     | + setDAODipendenti
 * |          |                     | + getDAOPunteggi
 * |          |                     | + setDAOPunteggi
 * +----------+---------------------+---------------------
 * | 20120521 |Alessandro Cornaglia | + GestioneDomandeD
 * |          |                     | + getDaoFactory
 * |          |                     | + setDaoFactory
 * |          |                     | + getGestionePunteggiD
 * |          |                     | + setGestionePunteggiD
 * |          |                     | + getGestioneLog
 * |          |                     | + setGestioneLog
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + setRisposta
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;


/**
 * Classe che si occupa di gestire tutte le azioni dovute dall'interazione 
 * fra un dipendente ed una domanda del sistema
 * @author acornagl
 * @version 2.0
 */
public class GestioneDomandeD{
  private DAODomande daoDomande;
  private DAOPunteggi daoPunteggi;
  private DAODipendenti daoDipendenti;
  private GestionePunteggiD gestionePunteggiD;
  private GestioneLog gestioneLog;
  private GestioneBadgeD gestioneBadge;
  
  
  /**
   * Costruttore con parametri della classe GestioneDomandeD
   * 
   * @param daoDom implementazione daoDomande a seconda del database
   * @param daoPunt implementazione daoPunteggi a seconda del database
   * @param daoDip riferimento alla classe DAODipendenti
   * @param gestPuntD riferimento alla classe GestionePunteggiD
   * @param gestLog riferimento alla classe GestioneLog
   * @param gestBadgeD riferimento alla classe GestioneBadgeD
   */
  public GestioneDomandeD(DAODomande daoDom, DAOPunteggi daoPunt, DAODipendenti daoDip, GestionePunteggiD gestPuntD, GestioneLog gestLog, GestioneBadgeD gestBadgeD) {
    this.daoDomande = daoDom;
    this.daoPunteggi = daoPunt;
    this.daoDipendenti = daoDip;
    this.gestionePunteggiD = gestPuntD;
    this.gestioneLog = gestLog;
    this.gestioneBadge = gestBadgeD;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDomandeD
   */
  public GestioneDomandeD() {
    this.daoDomande = null;
    this.daoPunteggi = null;
    this.daoDipendenti = null;
    this.gestionePunteggiD = null;
    this.gestioneLog = null;
    this.gestioneBadge = null;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto DAODomande
   * 
   * @return daoDomande
   */
  public DAODomande getDaoDomande() {
    return daoDomande;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto DAODomande
   * 
   * @param daoDom oggetto di tipo statico DAODomande
   */
  public void setDaoDomande(DAODomande daoDom) {
    this.daoDomande = daoDom;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto GestionePunteggiD
   * 
   * @return gestionePunteggiD
   */	
  public GestionePunteggiD getGestionePunteggiD() {
    return gestionePunteggiD;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto GestionePunteggiD
   * 
   * @param gestionePunteggiD oggetto di tipo GestionePunteggiD
   */	
  public void setGestionePunteggiD(GestionePunteggiD gestionePunteggiD) {
    this.gestionePunteggiD = gestionePunteggiD;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto GestioneLog
   * 
   * @return gestioneLog
   */
  public GestioneLog getGestioneLog() {
    return gestioneLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto GestioneLog
   * 
   * @param gestioneLog oggetto di tipo GestioneLog
   */
  public void setGestioneLog(GestioneLog gestioneLog) {
    this.gestioneLog = gestioneLog;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo 
   * statico DAOPunteggi
   * 
   * @return riferimento all'oggetto di tipo statico DAOPunteggi
   */
  public DAOPunteggi getDaoPunteggi() {
    return daoPunteggi;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo 
   * statico DAOPunteggi
   * 
   * @param daoPunteggi riferimento da impostare
   */
  public void setDaoPunteggi(DAOPunteggi daoPunteggi) {
    this.daoPunteggi = daoPunteggi;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo 
   * statico DAODipendenti
   * 
   * @return riferimento all'oggetto di tipo statico DAODipendenti
   */
  public DAODipendenti getDaoDipendenti() {
    return daoDipendenti;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo 
   * statico DAODipendenti
   * 
   * @param daoDipendenti riferimento da impostare
   */
  public void setDaoDipendenti(DAODipendenti daoDipendenti) {
    this.daoDipendenti = daoDipendenti;
  }

  /**
   * Metodo che consente di recuperare una domanda 
   * 
   * @param login oggetto Login del dipendente che deve ricevere la domanda
   * @return domanda per il login proposto
   */
  public Domanda getDomandaD(Login login) {
	Dipendente dip = this.daoDipendenti.getInfoD(login);//recupero il dipendente
	if ( dip == null) {
	  return null;  // non sono stato in grado di recuperare il dipendente
	}
	//il dip è stato trovato
	Domanda ritorno = this.daoDomande.getDomanda(dip);//recupero la domanda passandogli il dip così posso scrivere sul db che gli è stata presentata
	if (ritorno == null) {
      return null; //non sono stato in grado di recuperare la domanda
	}
    //scrivo che la domanda è stata sottoposta al dipendente sul DB
    boolean controllo = this.daoDomande.scriviSottoposta(dip,ritorno);
    if (controllo) {
      //è andato tutto bene
      this.gestioneLog.scriviDomRic(login, ritorno); // scrivo il log
      return ritorno;
    }
    return null;//non sono riuscito a scrivere sul DB che la domanda è stata sottoposta
  }
  
  /**
   * Metodo che si occupa di controllare la risposta data da un dipendente ad una
   * domanda e tenta di scrivere tali informazioni sul DB. Se la risposta è corretta
   * assegna il punteggio al dipendente
   * 
   * @param login Login del dipendente che ha risposto
   * @param risposta Domanda posta al dipendente contenente la risposta data
   */
  public boolean setRisposta(Login login,Domanda risposta) {
    //Dal login ricavo il dipendente
	Dipendente dip = this.daoDipendenti.getInfoD(login);

	//scrivo sul DB che utente ha risposto a domanda
	boolean controllo = this.daoDomande.rispondi(dip, risposta);
	if (!controllo) { // non ho scritto sul DB
	  return false; 
	}
	else {
	  if (risposta.getRispostaData() == risposta.getCorretta()) {
		//se risposta esatta controllo se ha ottenuto badge 
	    this.gestioneBadge.assegnaBadge(risposta, login);
	  }
	}
	//scrivoil log che l'utente ha risposto
	gestioneLog.scriviDomRisp(login, risposta);
	return true;//andato tutto correttamente
  }
  
  /**
   * Metodo che si occupa di controllare quando una domanda viene posticipata
   * @param login login del dipendente
   * @param dom domanda posticipata
   * @return true se la domanda è stata posticipata correttamente, false altrimenti
   */
  public boolean posticipa(Login login, Domanda dom) {
	Dipendente dip = this.daoDipendenti.getInfoD(login);
	boolean eseguito = this.daoDomande.posticipa(dip, dom);
	if (eseguito)
      this.gestioneLog.scriviDomPost(login, dom);
	return eseguito;
  }
  
}
