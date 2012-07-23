/*
 * Name: DAODipendenti.java
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
 * | 20130708 | Alessandro Cornaglia| + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120512 | Gabriele Facchin    | + getInfoD
 * |          |                     | + getInfoA
 * |          |                     | + resetPassD                
 * |          |                     | + resetPassA
 * |          |                     | + passD
 * |          |                     | + passA
 * |          |                     | + mailD
 * |          |                     | + elencoDipendenti
 * |          |                     | + aggiungiDipendente
 * |          |                     | + cancellaDipendente
 * |          |                     | + modNome
 * |          |                     | + modCognome
 * |          |                     | + modCodFis
 * |          |                     | + modUsername
 * |          |                     | + modImpiego
 * |          |                     | + setTrofei
 * |          |                     | + resetA
 * |          |                     | + resetD
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interfaccia che contiene i prototipi dei metodi per gestire un dipendente
 * 
 * @author gfacchin
 * @version 2.0
 */

public interface DAODipendenti{
  
  /**
   * Metodo che prende le informazioni di un Dipendente dal database
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @return l'oggetto Dipendente istanziato se presente nel db, altrimenti null
   * 
   */     
  public Dipendente getInfoD(Login login);
  
  /**
   * Metodo che prende le informazioni di un Amministratore dal database
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @return l'oggetto Dipendente (amministratore) istanziato se presente nel db, altrimenti null
   * 
   */   
  public Dipendente getInfoA(Login login);
  
  /**
   * Metodo che resetta il campo password modificata di un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetPassD(Dipendente dip);
  
  /**
   * Metodo che resetta il campo password modificata di un Amministratore
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetPassA(Dipendente dip);
  
  /**
   * Metodo che setta il campo password di un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param pass la stringa della nuova password del Dipendente
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean passD(Dipendente dip, String pass);

  /**
   * Metodo che setta il campo password (e il campo data pass) di un Amministratore
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param pass la stringa della nuova password dell'Amministratore
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean passA(Dipendente dip, String pass);
  
  /**
   * Metodo che setta il campo mail di un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param mail la stringa della nuova email del Dipendente
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean mailD(Dipendente dip, String mail);

  /**
   * Metodo che ritorna l'elenco dei Dipendenti dell'Azienda
   * 
   * @return un ArrayList che contiene tutti i dipendenti
   * 
   */   
  public ArrayList<Dipendente> elencoDipendenti();

  /**
   * Metodo che aggiunge un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean aggiungiDipendente(Dipendente dip);
  
  /**
   * Metodo che cancella un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean cancellaDipendente(Dipendente dip);
  
  /**
   * Metodo che modifica il nome di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param nome stringa contenente il nuovo nome
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modNome(Dipendente dip, String nome);
  
  /**
   * Metodo che modifica il cognome di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param cognome stringa contenente il nuovo cognome
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modCognome(Dipendente dip, String cognome);
  
  /**
   * Metodo che modifica il codice fiscale di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param codfis stringa contenente il nuovo codice fiscale
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modCodFis(Dipendente dip, String codfis);

  /**
   * Metodo che modifica lo username di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param username stringa contenente il nuovo username
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modUsername(Dipendente dip, String username);

  /**
   * Metodo che modifica l'impiego di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param impiego stringa contenente il nuovo impiego
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modImpiego(Dipendente dip, String impiego);
  
  /**
   * Metodo che modifica i trofei di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param numTrofei intero contenente il nuovo ammontare trofei
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean setTrofei(Dipendente dip, int numTrofei);
  
  /**
   * Metodo che resetta la password (casuale) di un Dipendente
   * 
   * @param rec Oggetto Recupero da cui si prendono le informazioni
   * @param pass nuova password da impostare
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetD(Recupero rec, String pass);
  
  /**
   * Metodo che resetta la password (casuale) di un Amministratore
   * 
   * @param rec Oggetto Recupero da cui si prendono le informazioni
   * @param pass nuova password da impostare
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetA(Recupero rec, String pass);
  
  /**
   * Metodo che consente di recuperate l'elenco dei ruoli aziendali
   * 
   * @return lista dei ruoli aziendali
   */
  public ArrayList<String> getElencoRuoli();
}