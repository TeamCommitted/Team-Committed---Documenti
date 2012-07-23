/*
 * Name: GestioneDipendentiD.java
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
 * | 20120531 |Alessandro Cornaglia | * GestioneDipendentiD
 * |          |                     | - getDaoFactory
 * |          |                     | - setDaoFactory
 * |          |                     | + getDaoDipendenti
 * |          |                     | + setDaoDipendenti
 * |          |                     | * getDati
 * |          |                     | * modificaPass
 * |          |                     | + modificaEmail
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + GestioneDipendentiD
 * |          |                     | + getDaoFacory
 * |          |                     | + setDaoFactory
 * |          |                     | + getGestioneLog
 * |          |                     | + setGestioneLog 
 * |          |                     | + getDati
 * |          |                     | + modificaPass
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire le interazioni che un dipendente 
 * puo' avere con il sistema
 * 
 * @author acornagl
 * @version 2.0
 *
 */
public class GestioneDipendentiD{
  private DAODipendenti daoDipendenti;
  private GestioneLog gestioneLog;
  private GestioneRecupero gestioneRecupero;
  
  /**
   * Costruttore con parametri della classe GestioneDipendentiD
   * 
   * @param daoDipendenti riferimento all'iggetto di tipo DAOFactory
   * @param gestioneLog riferimento alla classe di tipo GestioneLog
   */
  public GestioneDipendentiD(DAODipendenti daoDipendenti, GestioneLog gestioneLog) {
    this.daoDipendenti = daoDipendenti;
    this.gestioneLog = gestioneLog;
    this.gestioneRecupero = null;
  }
  
  /**
   * Costruttore senza parametri della classe GestioneDipendentiD
   */
  public GestioneDipendentiD() {
    this.daoDipendenti = null;
    this.gestioneLog = null;
    this.gestioneRecupero = null;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo statico
   * DAODipendenti
   * 
   * @return riferimento all'oggetto statico DAODipendenti
   */
  public DAODipendenti getDaoDipendenti() {
    return daoDipendenti;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di tipo statico 
   * DAODipendenti
   * 
   * @param daoDip riferimento all'oggetto di tipo DAODipendenti
   */
  public void setDaoDipendenti(DAODipendenti daoDip) {
    this.daoDipendenti = daoDip;
  }

  /**
   * metodo che consente di recuperare il riferimento all'oggetto di tipo GestioneLog
   * 
   * @return riferimento all'oggetto GestioneLog
   */
  public GestioneLog getGestioneLog() {
    return gestioneLog;
  }

  /**
   * metodo che consente di impostare il riferimento all'oggetto di GestioneLog 
   * 
   * @param gestioneLog riferimento all'oggetto di tipo GestioneLog
   */
  public void setGestioneLog(GestioneLog gestioneLog) {
    this.gestioneLog = gestioneLog;
  }

  /**
   * Metodo che consente di reperire le informazioni di un dipendente a partire
   * dal suo login
   * 
   * @param login login del dipendente
   * @return informazioni sul dipendente
   */
  public Dipendente getDatiD(Login login) {
    Dipendente ritorno = this.daoDipendenti.getInfoD(login);
	return ritorno;    
  }
  
  /**
   * Metodo che consente la modifica della password da parte di un dipendente
   *
   * @param dip dipendente che chiede di modificare la password
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaPass(Dipendente dip) {
	//dip contiene la nuova password (il web deve controllare che la pass sia ok
	//scrivo la nuova password
	boolean esito =this.daoDipendenti.resetPassD(dip);
	if(esito)
	esito = this.daoDipendenti.passD(dip,dip.getNuovaPass());
    if(esito){// se tutto ok
	  //scrivo il log
      gestioneLog.scriviModPassD(dip);
      GestioneRecupero.sendMail(dip.getEmail(), dip.getNuovaPass());
    }
    return esito;//non sono riuscito a modificare la passwrod
  }
  
  /**
   * Metodo che consente la modifica della mail da parte di un dipendente
   * 
   * @param dip che chiede di modificare la mail
   * @param nEmail nuovo indirizzo mail da inserire
   * 
   * @return true se operazione riuscita con successo, false altrimenti
   */
  public boolean modificaEmail(Dipendente dip, String nEmail) {
    boolean esito = this.daoDipendenti.mailD(dip,nEmail);
    if (esito) {// se tutto ok
      //scrivo il log
      gestioneLog.scriviModEmailD(dip);
      GestioneRecupero.sendMailModMail(nEmail);
      return true;
    }
    return false;
  }
  
}
