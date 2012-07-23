/*
 * Name: DAOPunteggi.java
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
 * | 20120512 | Gabriele Facchin    | + getStat
 * |          |                     | + getGlobalStat
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire i punteggi
 * 
 * @author gfacchin
 * @version 2.0
 */

public interface DAOPunteggi{

  /**
   * Metodo che prende il punteggio di un Dipendente dal database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Punteggio contenente il totale del punteggio del Dipendente
   * 
   */    
  public Punteggio getStat(Dipendente dip);
  
  /**
   * Metodo che genera le statistiche dato un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Punteggio contenente le statistiche dei dipendenti (e dell'azienda) a lui vicini
   * 
   */    
  public Punteggio getGlobalStat(Dipendente dip);

}
