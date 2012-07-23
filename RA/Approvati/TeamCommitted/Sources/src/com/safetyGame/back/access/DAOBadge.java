/*
 * Name: DAOBadge.java
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
 * | 20120712 |Alessandro Cornaglia | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120512 | Gabriele Facchin    |  + badgeD
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire le Badge
 * 
 * @author gfacchin
 * @version 2.0
 */

public interface DAOBadge{
  
  /**
   * Metodo che prende i badge ottenute da un Dipendente dal database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return un ArrayList di Badge che contiene i Badge di quel Dipendente
   * 
   */    
  public ArrayList<Badge> badgeD(Dipendente dip);

  /**
   * Metodo che prende i badge dal database
   * 
   * @return un ArrayList di Badge che contiene i Badge di quell'azienda
   * 
   */  
  public ArrayList<Badge> badgeAS();
  
  /**
   * Metodo che assegna una Badge ad un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param badge Oggetto Badge che deve essere assegnato
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */         
  public boolean assegna(Dipendente dip, Badge badge);
}
