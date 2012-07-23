/*
 * Name: GestioneLog.java
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
 * | 20120531 |Alessandro Cornaglia | * scriviLogin
 * |          |                     | * scriviLogout
 * |          |                     | * scriviDomRic
 * |          |                     | * scriviDomProp
 * |          |                     | * scriviDomPost
 * |          |                     | * scriviDomRisp
 * |          |                     | *scriviModPassD
 * |          |                     | *scriviModEmailD
 * |          |                     | *scriviOttenimentoBadge
 * +----------+---------------------+---------------------
 * | 20120525 |Alessandro Cornaglia | + getLog
 * |          |                     | + getPercorso
 * +----------+---------------------+---------------------
 * | 20120517 |Alessandro Cornaglia | + GestioneLog
 * |          |                     | + getUpdateLog
 * |          |                     | + setUpdateLog
 * |          |                     | + scriviLogin
 * |          |                     | + scriviLogout
 * |          |                     | + scriviDomRic
 * |          |                     | + scriviDomProp
 * |          |                     | + scriviDomPost
 * |          |                     | + scriviDomRisp
 * |          |                     | + scriviModPassD
 * |          |                     | + scriviModEmailD
 * |          |                     | + scriviOttenimentoBadge
 * |          |                     | + scriviAddDip
 * |          |                     | + scriviDelDip
 * |          |                     | + scriviModDip
 * |          |                     | + scriviAddDomande
 * |          |                     | + scriviDelDomande
 * +----------+---------------------|---------------------
 *
 */ 
package com.safetyGame.back.controller;

import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i log del sistema
 * 
 * @author acornagl 
 * @version v2.0
 */
public class GestioneLog{

  private UpdateLog updateLog;
  private DAODipendenti daoDipendenti;
    
  /**
   * Costruttore della classe GestioneLog
   * @param upLog riferimento alla classe UpdateLog
   * @param daoDip riferimento all'oggetto di tipo statico DAODipendenti
   */
  public GestioneLog(UpdateLog upLog, DAODipendenti daoDip) {
   updateLog= upLog;
   daoDipendenti = daoDip;
  }
  
  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo UpdateLog
   * @return riferimento all'oggetto di tipo UpdateLog
   */
  public UpdateLog getUpdateLog() {
    return updateLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo UpdateLog
   * @param updateLog riferimento all'oggetto di tipo UpdateLog
   */
  public void setUpdateLog(UpdateLog updateLog) {
    this.updateLog = updateLog;
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un login
   * 
   * @param login oggetto Login dovuto dall'effettuazione del login da parte di un dipendente
   */
  public void scriviLoginD(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLoginD";
	Dipendente dip = daoDipendenti.getInfoD(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un login amministratore
   * 
   * @param login oggetto Login dovuto dall'effettuazione del login da parte di un dipendente
   */
  public void scriviLoginA(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLoginA";
	Dipendente dip = daoDipendenti.getInfoA(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un logout
   * 
   * @param login oggetto Login del dipendente che ha effettuato il logout
   */
  public void scriviLogoutD(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLogoutD";
	Dipendente dip = daoDipendenti.getInfoD(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo un logout amministratore
   * 
   * @param login oggetto Login dell'amministratore che ha effettuato il logout
   */
  public void scriviLogoutA(Login login) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogLogoutA";
	Dipendente dip = daoDipendenti.getInfoA(login);
    this.updateLog.scriviLogTre(nomeTabella,dip,dataOra.toString());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene ricevuta da un dipendente
   * 
   * @param login oggetto Login del dipendente che riceve la domanda
   * @param dom domanda che viene ricevuta dall'utente
   */
  public void scriviDomRic(Login login, Domanda dom) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogRicevuta";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene proposta ad un dipendente 
   *
   * @param login oggetto Login del dipendente che riceve la proposta di domanda
   * @param dom domanda che viene proposta all'utente
   */
  public void scriviDomProp(Login login, Domanda dom) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogProposta";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());  
  }

  /**
   *metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene posticipata da un dipendente 
   *
   * @param login oggetto Login del dipendente che posticipa una domanda
   * @param dom domanda che viene posticipata dall'utente
   */
  public void scriviDomPost(Login login, Domanda dom) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "LogPosticipa";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());
  }
  
  /**
   *metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che una domanda viene posticipata da un dipendente 
   *
   * @param login oggetto Login del dipendente che posticipa una domanda
   * @param dom domanda che viene posticipata dall'utente
   */
  public void scriviDomRisp(Login login, Domanda dom) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogRisposta";
	Dipendente dip = daoDipendenti.getInfoD(login);
	String colonna = "IDdomanda";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+dom.getId());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente modifica la propria password 
   * 
   * @param dip dipendente che ha modificato la propria password
   */
  public void scriviModPassD(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogModificaDip";
	String operazione = "pass";
	String colonna = "TipoModifica";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente modifica la propria email 
   * 
   * @param dip dipendente che ha modificato la propria email
   */
  public void scriviModEmailD(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "LogModificaDip";
	String operazione = "mail";
	String colonna = "TipoModifica";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");

  }

  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che un dipendente ottiene un badge
   * 
   * @param dip dipendente che ha ottenuto un badge
   * @param badge badge ottenuto
   */
  public void scriviOttenimentoBadge(Dipendente dip, Badge badge) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "OttenimentoBadge";
	String colonna = "IdBadge";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,""+badge.getId());
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA aggiunge un dipendente
   * 
   * @param dip dipendente aggiunto
   */
  public void scriviAddDip(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "ModDipendente";
	String operazione = "aggiungi";
	String colonna = "Operazione";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA rimuove un dipendente
   * 
   * @param dip dipendente rimosso
   */
  public void scriviDelDip(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "ModDipendente";
	String operazione = "elimina";
	String colonna = "Operazione";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AA modifica un dipendente
   * 
   * @param dip dipendente modificato
   */
  public void scriviModDip(Dipendente dip) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "ModDipendente";
	String operazione = "modifica";
	String colonna = "Operazione";
    this.updateLog.scriviLogQuattro(nomeTabella,dip,dataOra.toString(),colonna,"'"+operazione+"'");
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AS aggiunge una o più domande
   * 
   * @param dom domande aggiunte
   */
  public void scriviAddDomande(Domanda dom) {
    DataOra dataOra = new DataOra();
	String nomeTabella = "AddRemDomanda";
	String operazione = "add";
    this.updateLog.scriviLogDomande(nomeTabella,dataOra.toString(),""+dom.getId(),"'"+operazione+"'");
  }
  
  /**
   * metodo che si occupa di inviare alla classe UpdateLog la stringa da inserire
   * nel file di log dopo che l'AS rimuove una o più domande
   * 
   * @param dom domande rimosse
   */
  public void scriviDelDomande(Domanda dom) {
	DataOra dataOra = new DataOra();
	String nomeTabella = "AddRemDomanda";
	String operazione = "del";
	this.updateLog.scriviLogDomande(nomeTabella,dataOra.toString(),""+dom.getId(),"'"+operazione+"'");
  }

}