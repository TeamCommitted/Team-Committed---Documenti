/*
 * Name: Inizializzatore.java
 * Package: com.safetygame.back
 * Author: Gabriele Facchin & Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 *
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120612 |Alessandro Cornaglia | + Inizializzatore
 * +----------+---------------------+----------------------
 * | 20120612 | Gabriele Facchin    | + grafica
 * |          |                     | + getWeb
 * |          |                     | + getApp
 * |          |                     | + main
 * |          |                     | + actionPerformed
 * +----------+---------------------+----------------------
 * | 20120613 | Gabriele Facchin    | + tastiera
 * +----------+---------------------+----------------------
 * | 20120717 | Gabriele Facchin    | - tastiera
 * |          |                     | - grafica
 * |          |                     | - actionPerformed
 * |          |                     | - main
 * |          |                     | + crea
 * +----------+---------------------+----------------------
 *
 */

package com.safetyGame.back;

import com.safetyGame.back.condivisi.*;
import com.safetyGame.back.controller.*;
import com.safetyGame.back.access.*;
import com.safetyGame.back.connection.*;

  /**
   * Classe che si occupa di gestire i log del sistema
   *
   * @author gfacchin
   * @author acornagl
   * @version v2.0
   */

public class Inizializzatore{
  private Indirizzo indirizzoAz;
  private Indirizzo indirizzoDom;
  private DAODipendenti daoDipendenti;
  private DAOPunteggi daoPunteggi;
  private DAOLogin daoLogin;
  private UpdateLog updateLog;
  private DAODomande daoDomande;
  private DAOBadge daoBadge;

  private GestioneRecupero gestioneRecupero;
  private GestionePunteggiD gestionePunteggiD;
  private GestionePunteggiAA gestionePunteggiAA;
  private GestioneLog gestioneLog;
  private GestioneLogin gestioneLogin;
  private GestioneBadgeD gestioneBadgeD;
  private GestioneDomandeD gestioneDomandeD;
  private GestioneDomandeAS gestioneDomandeAS;
  private GestioneDipendentiD gestioneDipendentiD;
  private GestioneDipendentiAA gestioneDipendentiAA;
  private GestioneBadgeAS gestioneBadgeAS;
  private static GestioneDati gestioneDati;
  private static WebConnection webConnection = null;
  private static ApplicazioniConnection appConnection= null;
  private static Inizializzatore inizializzatore=null;


  /**
   * Costruttore della classe Inizializzatore
   *
   */
  private Inizializzatore(){
    indirizzoAz = new Indirizzo("localhost/ingAz","root","");//corretto
    indirizzoDom = new Indirizzo("localhost/ingDom","root","");//corretto
    //indirizzoAz = new Indirizzo("localhost/ingAz","root","root");//per corny
    //indirizzoDom = new Indirizzo("localhost/ingDom","root","root");//per corny
    daoDipendenti = new SqlDAODipendenti(indirizzoAz);
    daoPunteggi = new SqlDAOPunteggi(indirizzoAz,indirizzoDom);
    daoLogin = new SqlDAOLogin(indirizzoAz);
    daoDomande = new SqlDAODomande(indirizzoAz,indirizzoDom);
    daoBadge = new SqlDAOBadge(indirizzoAz);

    gestioneRecupero = new GestioneRecupero(daoDipendenti);
    gestionePunteggiD = new GestionePunteggiD(daoPunteggi,daoDipendenti);
    gestionePunteggiAA = new GestionePunteggiAA(daoPunteggi,daoDipendenti);
    updateLog = new UpdateLog(indirizzoAz);
    gestioneLog = new GestioneLog(updateLog,daoDipendenti);
    gestioneLogin = new GestioneLogin(daoLogin,gestioneLog);
    gestioneBadgeD = new GestioneBadgeD(daoBadge,daoDipendenti,daoDomande, gestioneLog, gestioneLogin);
    gestioneDomandeD = new GestioneDomandeD(daoDomande,daoPunteggi,daoDipendenti,gestionePunteggiD, gestioneLog, gestioneBadgeD);
    gestioneDomandeAS = new GestioneDomandeAS(daoDomande, gestioneLog);
    gestioneDipendentiD = new GestioneDipendentiD(daoDipendenti, gestioneLog);
    gestioneDipendentiAA = new GestioneDipendentiAA(daoDipendenti, gestioneLog);
    gestioneBadgeAS = new GestioneBadgeAS(daoBadge);
    gestioneDati = new GestioneDati(gestioneRecupero,gestioneLogin,gestioneDomandeD,gestioneDomandeAS,gestioneDipendentiD,gestioneDipendentiAA,gestioneBadgeD, gestioneBadgeAS,gestionePunteggiD, gestionePunteggiAA);

    webConnection= new WebConnection(gestioneDati);
    appConnection= new ApplicazioniConnection(gestioneDati);

  }

  /**
   * Metodo statico che ritorna il connettore web
   *
   * @return webConnection riferimento alla classe webConnection
   *
   */
  public static WebConnection getWeb(){
    if (inizializzatore==null)
      crea();
    return webConnection;
  }

  /**
   * Metodo statico che ritorna il connettore applicazioni
   *
   * @return appConnection riferimento alla classe ApplicazioniConnection
   *
   */
  public static ApplicazioniConnection getApp(){
    if (inizializzatore==null)
      crea();
    return appConnection;
  }
  
  /**
   * Metodo statico che crea l'inizializzatore
   *
   */
  private static synchronized void crea(){ 
    if (inizializzatore==null) 
        inizializzatore=new Inizializzatore();
  }
}
