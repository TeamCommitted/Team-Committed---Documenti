/*
 * Name: UpdateLog.java
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
 * | 20120720 | Gabriele Facchin    | + scriviLogTre
 * |          |                     | + scriviLogQuattro
 * |          |                     | - finalize
 * |          |                     | - scrivi
 * |          |                     | - scrivichiudi
 * +----------+---------------------|---------------------
 * | 20120422 | Gabriele Facchin    | + UpdateLog
 * |          |                     | + finalize
 * |          |                     | + scrivi
 * |          |                     | + scrivichiudi
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

/**
 * Classe che gestisce l'update dei file di log di ogni utente
 * 
 * @author gfacchin
 * @version 2.0
 */

public class UpdateLog{
  //private PrintWriter out;
	private Indirizzo serverAzienda;
  
  
  /**
  * Costruttore della classe UpdateLog
  * @param azienda indirizzo del server aziendale
  */

  public UpdateLog(Indirizzo azienda){
	serverAzienda=azienda;
  }
  

 /**
   * Metodo che scrive un log di login o logout nelle relative tabelle
   * 
   * @param nomeTabella il nome della tabella su cui scrivere
   * @param dip il dipendente interessato
   * @param dataOra la data in cui e' stata effettuata l'azione
   */  
  public void scriviLogTre(String nomeTabella, Dipendente dip, String dataOra){
	String id = ""+dip.getId();
	String[] values = {id,"'"+dataOra+"'"}; 
    serverAzienda.inserisciRiga(nomeTabella,"IDdipendente,Data",values);
  }
  
  /**
    * Metodo che scrive un log specifico nella tabella data
    * 
    * @param nomeTabella il nome della tabella su cui scrivere
    * @param dip il dipendente interessato
    * @param dataOra la data in cui e' stata effettuata l'azione
    * @param colonna la colonna contenente la descrizione
	* @param descrizione il valore contenuto nella colonna data
    */
  public void scriviLogQuattro(String nomeTabella, Dipendente dip, String dataOra, String colonna, String descrizione){
    String id = ""+dip.getId();
	String[] values = {id,"'"+dataOra+"'",descrizione}; 
    serverAzienda.inserisciRiga(nomeTabella,"IDdipendente,Data,"+colonna,values);
  }
  
  /**
   * Metodo che scrive un log specifico nella tabella data
   * 
   * @param nomeTabella il nome della tabella su cui scrivere
   * @param	dataOra la data in cui e' stata effettuata l'azione
   * @param	colonna1 la colonna contenente la descrizione1
   * @param	descrizione1 il valore contenuto nella colonna1 data
   */
 public void scriviLogDomande(String nomeTabella, String dataOra,String id, String operazione){
	String[] values = {"'"+dataOra+"'",id,operazione}; 
   serverAzienda.inserisciRiga(nomeTabella,"Data,IDdomanda,Operazione",values);
 }
}
