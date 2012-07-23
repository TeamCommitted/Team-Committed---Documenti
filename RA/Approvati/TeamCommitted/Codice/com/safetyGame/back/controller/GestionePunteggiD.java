/*
 * Name: GestionePunteggiD.java
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
 * | 20120717 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120608 |Alessandro Cornaglia | - gestioneBadgeD
 * | 20120531 |Alessandro Cornaglia | * GestionePunteggiD
 * |          |                     | * getStatisticheD
 * |          |                     | * getBadgeD
 * +----------+---------------------+---------------------
 * | 20120523 |Alessandro Cornaglia | + getStatisticheD
 * |          |                     | + getBadgeD
 * +----------+---------------------+---------------------
 * | 20120521 |Alessandro Cornaglia | + GestionePunteggiD
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che si occupa di gestire i punteggi dei dipendenti
 * @author acornagl
 * @version 2.0
 *
 */
public class GestionePunteggiD{ 

  private DAOPunteggi daoPunteggi;
  private DAODipendenti daoDipendenti;
  
  /**
   * Costruttore con paramentri della classe GestionePunteggiD
   * 
   * @param daoPunt riferimento all'oggetto di tipo DAOPunteggi
   * @param daoDip riferimento all'oggetto di tipo DAODipendenti
   */
  public GestionePunteggiD(DAOPunteggi daoPunt, DAODipendenti daoDip) {
    this.daoPunteggi = daoPunt;
	this.daoDipendenti = daoDip;
  }
  
  /**
   * Costruttore senza parametri della classe GestionePunteggiD
   */
  public GestionePunteggiD() {
    this.daoPunteggi = null;
    this.daoDipendenti = null;
  }
  
  /**
   * Metodo che consente di recuperare le statistiche di un determinato dipendente
   * 
   * @param login login del dipendente che richiede di conoscere le statistiche
   * 
   * @return statistiche del dipendente
   */
  public Punteggio getStatisticheD(Login login) {
	Dipendente dip = this.daoDipendenti.getInfoD(login);
    Punteggio ritorno = this.daoPunteggi.getStat(dip);
    return ritorno;
  }
  
  /**
   * Metodo che consente di recuperare le statistiche globali
   * 
   * @param login login del dipendente che richiede di conoscere le statistiche
   * @return statistiche globali
   */
  public Punteggio getStatisticheGlob(Login login) {
	  Dipendente dip = this.daoDipendenti.getInfoD(login);
	  Punteggio ritorno = this.daoPunteggi.getGlobalStat(dip);
	  return ritorno;
  }
}

