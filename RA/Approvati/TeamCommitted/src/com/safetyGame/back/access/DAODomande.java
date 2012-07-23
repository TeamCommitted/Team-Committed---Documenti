/*
 * Name: DAODomande.java
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
 * | 20120512 | Gabriele Facchin    | + prendiCampiDomanda
 * |          |                     | + getDomanda
 * |          |                     | + posticipa                
 * |          |                     | + rispondi
 * |          |                     | + domandeA
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + scriviSottoposta
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire le domande
 * 
 * @author gfacchin
 * @version 2.0
 */

public interface DAODomande{

  /**
   * Metodo che preleva una domanda per il Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Domanda che contiene una domanda
   * 
   */   
  public Domanda getDomanda(Dipendente dip);
  
  /**
   * Metodo che posticipa una domanda sottoposta ad un dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean posticipa(Dipendente dip, Domanda dom);
  
  /**
   * Metodo che imposta la risposta di una domanda sottoposta ad un dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean rispondi(Dipendente dip, Domanda dom);

  /**
   * Metodo che ritorna l'elenco di Domande dell'azienda
   * 
   * @return ArrayList che contiene l'elenco di tutte le Domande
   * 
   */   
  public ArrayList<Domanda> domandeA();
  
  /**
   * Metodo che ritorna l'elenco di Domande di un Dipendente 
   * (eventualmente parziali per tipoin caso che venga 
   * specificata una domanda dom)
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda per il controllo del parziale
   * @return ArrayList che contiene l'elenco di tutte le Domande
   * 
   */   
  public ArrayList<Domanda> domande(Dipendente dip, Domanda dom);

  /**
   * Metodo che aggiunge una Domanda al database dell'azienda
   * 
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean addDomanda(Domanda dom);
  
  /**
   * Metodo che rimuove una Domanda dal database dell'azienda
   * 
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean remDomanda(Domanda dom);
  
  /**
   * Metodo che scrive sul database che una domanda e` stata proposta al Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param dom Oggetto Domanda da cui si prendono le informazioni della domanda
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean scriviSottoposta(Dipendente dip, Domanda dom);
}
