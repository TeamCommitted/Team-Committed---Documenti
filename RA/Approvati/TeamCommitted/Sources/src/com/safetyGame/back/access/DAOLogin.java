/*
 * Name: DAOLogin.java
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
 * | 20120512 | Gabriele Facchin    | + loginAmministratore
 * |          |                     | + loginDipendente
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire il login
 * 
 * @author gfacchin
 * @version 2.0
 */

public interface DAOLogin{

  /**
   * Metodo che prova il login di un Amministratore
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @param  tipo booleano: 1 se amministratore azienda(AA), 0 se amministratore sicurezza(AS) 
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */  
  public boolean loginAmministratore(Login login, boolean tipo);
  
  /**
   * Metodo che prova il login di un Dipendente
   * 
   * @param l Oggetto Login da cui si prendono le informazioni
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */    
  public boolean loginDipendente(Login login);

}
