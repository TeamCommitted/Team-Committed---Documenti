/*
 * Name: Dipendente.java
 * Package: com.safetygame.back.condivisi
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
 * | 20120531 |Alessandro Cornaglia | +getTrofei
 * |          |                     | +setTrofei
 * |          |                     | *Dipendente         
 * +----------+---------------------+---------------------
 * | 20120527 |Alessandro Cornaglia | *Dipendente         
 * |          |                     | +isAmmAA
 * |          |                     | +setAmmAA
 * |          |                     | +getDataModPass
 * |          |                     | +setDataModPass
 * |          |                     | +getNuovaPass
 * |          |                     | +setNuovaPass
 * +----------|---------------------+---------------------
 * | 20120521 |Alessandro Cornaglia | +setBadges
 * |          |                     | +toStringID
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + Dipendente
 * |          |                     | + getId
 * |          |                     | + setId
 * |          |                     | + getCodFiscale
 * |          |                     | + setCodFiscale
 * |          |                     | + getBadges
 * |          |                     | + addBadge
 * |          |                     | + getPunteggio
 * |          |                     | + setPunteggio
 * |          |                     | + getNome
 * |          |                     | + setNome
 * |          |                     | + getCognome
 * |          |                     | + setCognome
 * |          |                     | + getEmail
 * |          |                     | + setEmail
 * |          |                     | + getPassword
 * |          |                     | + setPassword
 * |          |                     | + getRuolo
 * |          |                     | + setRuolo
 * +----------+---------------------|---------------------
 *
 */ 

package com.safetyGame.back.condivisi;

import java.util.ArrayList;
/**
 * Classe che rappresenta un dipendente dell'azienda
 * 
 * @author acornagl 
 * @version 2.0
 * 
 */

public class Dipendente {
	
  private int id;
  private String codFiscale;
  private ArrayList<Badge> badges;
  private Punteggio punteggio;
  private String nome;
  private String cognome;
  private String email;
  private String nickname;
  private String password;
  private String ruolo;
  private boolean ammAA;// campo booleano che identifica un AA o un AS
  private DataOra dataModPass; //data e ora di modifica della password
  private String nuovaPass; //nuova password modificata
  private int trofei;

  /**
   * Costruttore della classe Dipendente, senza parametri
   */
  public Dipendente() {
	this.id = -1;
    this.codFiscale = null;
    this.badges = new ArrayList<Badge>();
    this.punteggio = null;
    this.nome = null;
    this.cognome = null;
    this.email = null;
    this.nickname = null;
    this.password = null;
    this.ruolo = null;
    this.ammAA = false; // se non viene settato il DB non dovrebbe cmq accedervi
    this.dataModPass = null;
    this.nuovaPass = null;
    this.trofei = 0;
  }
  
  /**
   * Costruttore della classe Dipendente con parametri
   * 
   * @param id id dipendente
   * @param codFisc codice fiscale
   * @param nome nome
   * @param cognome cognome
   * @param mail email
   * @param nick nickname
   * @param pass password
   * @param ruolo ruolo 
   * @param punti punteggio dipendente
   * @param nuovaPass nuova password impostata
   * @param nTrofei trofei del dipendente
   */
  public Dipendente(int id,String codFisc, String nome, String cognome, String mail, String nick, String pass, String ruolo, int punti, String nuovaPass, int nTrofei) {
	this.id = id;  
    this.codFiscale = codFisc;
    this.nome = nome;
    this.cognome = cognome;
    this.email = mail;
    this.nickname = nick;
    this.password = pass;
    this.ruolo = ruolo;
    this.badges = new ArrayList<Badge>();
    this.punteggio = new Punteggio(punti);
    this.nuovaPass = nuovaPass;
    this.trofei = nTrofei;
    this.ammAA = false;
    this.dataModPass = null;
  }

  /**
   * Costruttore con parametri per costruire Dipendenti-Amministratori
   * 
   * @param ammA identificativo booleano del tipo di amministratore, 0 se  amministratore sicurezza(AS), 1 se amministratore azienda(AA)
   * @param dataModPass data di modifica della password
   * @param nuovaPass nuova password
   * @param mail email dell'amministratore
   * @param nick nickname dell'amministratore
   * @param pass password dell'amministratore
   * @param codfisc codifce fiscale dell'amministratore
   * @param id id dell'amministratore
   */
  public Dipendente(boolean ammA, DataOra dataModPass, String nuovaPass, String mail, String nick, String pass, String codfisc, int id) {
    this.id = id;
    this.codFiscale = codfisc;
    this.nome = null;
    this.cognome = null;
    this.email = mail;
    this.nickname = nick;
    this.password = pass;
    this.ruolo = null;
    this.badges = new ArrayList<Badge>();
    this.punteggio = new Punteggio();
    this.nuovaPass = nuovaPass;
    this.trofei = 0;
    this.ammAA = ammA;
    this.dataModPass = dataModPass;
  }
  
  /**
   * metodo get per ricavare l'id del dipendente
   * 
   * @return id dipendente
   */
  public int getId() {
    return id;
  }

  /**
   * metodo per inserire o modificare l'id del dipendente
   * 
   * @param id id che si vuole impostare
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * metodo get per codice fiscale
   * 
   * @return codice fiscale
   */
  public String getCodFiscale() {
    return codFiscale;
  }

  /**
   * metodo per inserire o modificare il codice fiscale
   * 
   * @param codFiscale codice fiscale da settare
   */
  public void setCodFiscale(String codFiscale) {
    this.codFiscale = codFiscale;
  }

  /**
   * metodo che restituisce la lista di badge di un dipendente
   * 
   * @return lista di badge
   */
  public ArrayList<Badge> getBadges() {
    return this.badges;
  }
  /**
   * metodo che consente di impostare i badges di un dipendente
   * 
   * @param badges da aggiungere
   */
  public void setBadges(ArrayList<Badge> badges) {
    this.badges = badges;
  }
  
  /**
   * metodo che consente di aggiungere un badge ad un dipendente
   *  
   * @param badge badge da aggiungere
   * 
   */
  public void addBadge(Badge badge) {
    this.badges.add(badge);
  }

  /**
   * metodo che consente di recuperare il punteggio di un dipendente
   * 
   * @return punteggio del dipendente
   */
  public Punteggio getPunteggio() {
    return punteggio;
  }

  /**
   * metodo che consente di settare il punteggio di un dipendente
   * 
   * @param punteggio punteggio da settare
   */
  public void setPunteggio(Punteggio punteggio) {
    this.punteggio = punteggio;
  }

  /**
   * metodo che consente di recuperare il nome del dipendente
   * 
   * @return nome dipendente
   */
  public String getNome() {
    return nome;
  }

  /**
   * metodo che consente di settare il nome del dipendente
   * 
   * @param nome da impostare
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * metodo che consente di recuperare il cognome del dipendente
   * 
   * @return cognome dipendente
   */
  public String getCognome() {
    return cognome;
  }

  /**
   * metodo che consente di settare il cognome del dipendente
   * 
   * @param cognome da impostare
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * metodo che consente di recuperare la email del dipendente
   * 
   * @return email dipendente
   */
  public String getEmail() {
    return email;
  }

  /**
   * metodo che consente di impostare l'indirizzo email del dipendente
   *
   * @param email da impostare
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * metodo che consente di recuperare il nickname del dipendente
   * 
   * @return nickname dipendente
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * metodo che consente di impostare il nickname del dipendente
   * 
   * @param nickname da impostare
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * metodo che consente di recuperare la password del dipendente
   * 
   * @return password del dipendente
   */
  public String getPassword() {
    return password;
  }

  /**
   * metodo che consente di impostare la password del dipendente
   * 
   * @param password da impostare
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * metodo che consente di recuperare il ruolo del dipendente
   * 
   * @return ruolo del dipendente
   */
  public String getRuolo() {
    return ruolo;
  }

  /**
   * metodo che consente di impostare il ruolo del dipendente
   * 
   * @param ruolo da impostare
   */
  public void setRuolo(String ruolo) {
    this.ruolo = ruolo;
  }
  
  public String toStringID() {
    String ritorno = "";
    ritorno += "ID:" + this.id + "Cognome Nome:" + this.cognome + " " + this.nome;
    return ritorno;
  }

  /**
   * metodo che consente di recuperare la tipologia di amministratore di un utente
   * 
   * @return 1 se amministratore azienda(AA), 0 se amministratore sicurezza(AS) 
   */
  public boolean isAmmAA() {
    return ammAA;
  }

  /**
   * metodo che consente di impostare la tipologia di amministratore dell'utente
   * 
   * @param ammAA 0 se amministratore sicurezza(AS), 1 se amministratore azienda(AA)
   */
  public void setAmmAA(boolean ammAA) {
    this.ammAA = ammAA;
  }

  /**
   * metodo che consente di recuperare data e ora di modifica della password
   * 
   * @return data e ora di modifica della password
   */
  public DataOra getDataModPass() {
    return dataModPass;
  }

  /**
   * metodo che consente di impostare la data e ora di modifica della password
   * 
   * @param dataModPass data e ora di modifica della password
   */
  public void setDataModPass(DataOra dataModPass) {
    this.dataModPass = dataModPass;
  }

  /**
   * metodo che consente di recuperare la nuova password impostata dal dipendente
   * 
   * @return nuova password impostata dal dipendente
   */
  public String getNuovaPass() {
    return nuovaPass;
  }

  /**
   * metodo che consente di impostare la nuova password scelta dal dipendente
   * 
   * @param nuovaPass nuova password impostata dal dipendente
   */
  public void setNuovaPass(String nuovaPass) {
    this.nuovaPass = nuovaPass;
  }

  /**
   * metodo che consente di recuperare i trofei di un dipendente
   * 
   * @return trofei del dipendente
   */
  public int getTrofei() {
    return trofei;
  }

  /**
   * metodo che consente di impostare i trofei di un dipendente
   * 
   * @param trofei numero di trofei da impostare
   */
  public void setTrofei(int trofei) {
    this.trofei = trofei;
  }

  
}