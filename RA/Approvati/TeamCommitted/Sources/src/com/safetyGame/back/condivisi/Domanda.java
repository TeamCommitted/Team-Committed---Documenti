/*
 * Name: Domanda.java
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
 * | 20120527 |Alessandro Cornaglia | * Domanda
 * |          |                     | + isInternaAzienda
 * |          |                     | + setInternaAzienda
 * +----------+---------------------+---------------------
 * | 20120522 |Alessandro Cornaglia | + Domanda
 * |          |                     | + getId
 * |          |                     | + setId
 * |          |                     | + getPunteggio
 * |          |                     | + setPunteggio
 * |          |                     | + getTipologia
 * |          |                     | + setTipologia
 * |          |                     | + getRisposte
 * |          |                     | + setRisposte
 * |          |                     | + getCorretta
 * |          |                     | + setCorretta
 * |          |                     | + getTesto
 * |          |                     | + setTesto
 * |          |                     | + getRispostaData
 * |          |                     | + setRispostaData
 * |          |                     | + isMobile
 * |          |                     | + setMobile
 * |          |                     | + getTempo
 * |          |                     | + setTempo
 * |          |                     | + getAmbito
 * |          |                     | + setAmbito
 * +----------+---------------------|---------------------
 *
 */ 
package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta una domanda del sistema
 * 
 * @author acornagl 
 * @version v2.0
 */
import java.util.*;

public class Domanda{
  private int id;
  private Punteggio punteggio;
  private String tipologia;
  private ArrayList<String> risposte;
  private int corretta;
  private String testo;
  private int rispostaData;
  private boolean mobile;
  private int tempo; //in secondi
  private String ambito;
  private boolean internaAzienda;//variabile che identifica se una domanda è interna x AS
  
  /**
   * Costruttore con parametri della classe Domanda
   * 
   * @param id id della domanda
   * @param punteggio punteggio della domanda
   * @param tipo tipologia della domanda
   * @param risposte ArrayList di risposte
   * @param corretta numero risposta corretta
   * @param testo testo della domanda
   * @param rispData risposta data dal dipendente alla domanda
   * @param mobile identificativo per domande dispositivi fissi o mobili
   * @param secondi tempo eventuale per la risposta
   * @param ambito ambito della domanda
   * @param internaAz identificativo per domande interne o esterne all'azienda
   */
  public Domanda(int id, Punteggio punteggio, String tipo, ArrayList<String> risposte, int corretta, String testo, int rispData, boolean mobile, int secondi, String ambito, boolean internaAz) {
    this.id = id;
    this.punteggio = punteggio;
    this.tipologia = tipo;
    this.risposte = risposte;
    this.corretta = corretta;
    this.testo = testo;
    this.rispostaData = rispData;
    this.mobile = mobile;
    this.tempo = secondi;//se mi viene passato 0 lo setto a -1 per indicare che la domanda non imposta tempo
    if (this.tempo == 0)
      this.tempo = -1;
    this.ambito = ambito;
    this.internaAzienda = internaAz;
  }
  
  /**
   * Costruttore senza parametri della classe Domanda
   * 
   */
  public Domanda() {
    this.id = -1; //assegno alla nuova domanda un id illegale
    this.punteggio = null;
    this.tipologia = null;
    this.risposte = new ArrayList<String>();
    this.corretta = -1;
    this.testo = null;
    this.rispostaData = -1;
    this.mobile = false; // una domanda per default è per dispositivi fissi
    this.tempo = -1; //di default la domanda non è a tempo
    this.ambito = null;
    this.internaAzienda = false;
  }

/**
   * metodo che consente il recupero dell'id di una domanda
   * 
   * @return id domanda
   */
  public int getId() {
	return id;
  }

  /**
   * metodo che consente di impostare l'id di una domanda
   * 
   * @param id id da impostare
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * metodo che consente di recuperare il punteggio di una domanda
   * 
   * @return punteggio della domanda
   */
  public Punteggio getPunteggio() {
    return punteggio;
  }

  /**
   * metdodo che consente di impostare il punteggio di una domanda
   * 
   * @param punteggio punteggio che si vuole impostare
   */
  public void setPunteggio(Punteggio punteggio) {
    this.punteggio = punteggio;
  }

  /**
   * metodo che consente di recuperare la tipologia di una domanda
   * 
   * @return tipolologia della domanda
   */
  public String getTipologia() {
    return tipologia;
  }

  /**
   * metodo che consente di impostare la tipologia di una domanda
   * 
   * @param tipologia tipologia che si vuole impostare
   */
  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }
  
  /**
   * metodo che consente di recuperare le risposte di una domanda
   * 
   * @return insieme delle risposte
   */
  public ArrayList<String> getRisposte() {
    return risposte;
  }

  /**
   * metodo che consente di impostare l'insieme delle risposte di una domanda
   * 
   * @param risposte insieme delle risposte che si vuole assegnare ad una domanda
   */
  public void setRisposte(ArrayList<String> risposte) {
    this.risposte = risposte;
  }

  /**
   * metodo che consente di recuperare l'indice della risposta corretta
   * 
   * @return indice della risposta corretta
   */
  public int getCorretta() {
    return corretta;
  }

  /**
   * metodo che consente di impostare l'indice della risposta corretta
   * 
   * @param corretta indice della risposta corretta che si vuole assegnare
   */
  public void setCorretta(int corretta) {
    this.corretta = corretta;
  }

  /**
   * metodo che consente di recuperare il testo di una domanda
   * 
   * @return testo della domanda
   */
  public String getTesto() {
    return testo;
  }

  /**
   * metodo che consente di impostare il testo di una domanda
   * 
   * @param testo testo che si vuole assegnare alla domanda
   */
  public void setTesto(String testo) {
    this.testo = testo;
  }

  /**
   * metodo che consente di recuperare l'indice della risposta data da un dipendente alla
   * domanda
   * 
   * @return indice della risposta data alla domanda
   */
  public int getRispostaData() {
    return rispostaData;
  }

  /**
   * metodo che consente di impostare l'indice della risposta data ad una domanda
   * 
   * @param rispostaData indice della risposta data ad una domanda
   */
  public void setRispostaData(int rispostaData) {
    this.rispostaData = rispostaData;
  }

  /**
   * metodo che consente di individuare se una domanda è per dispositivi mobili o fissi
   * 
   * @return true se è per dispositivi mobili, false altrimenti
   */
  public boolean isMobile() {
    return mobile;
  }

  /**
   * metodo che consente di impostare se la domanda è per dispositivi fissi o mobili
   * 
   * @param mobile campo booleano se la domanda è per dispositivi mobili
   */
  public void setMobile(boolean mobile) {
    this.mobile = mobile;
  }

  /**
   * metodo che consente di recuperare il tempo a disposizione di un dipendente per rispondere alla domanda
   * 
   * @return tempo a disposizione per rispondere ad una domanda
   */
  public int getTempo() {
    return tempo;
  }

  /**
   * metodo che consente di impostare il tempo a disposizione per un dipendente di rispondere ad una domanda
   * 
   * @param tempo tempo a disposizione per rispondere ad una domanda
   */
  public void setTempo(int tempo) {
    this.tempo = tempo;
  }

  /**
   * metodo che consente di recuperare l'ambito della domanda
   * 
   * @return ambito della domanda
   */
  public String getAmbito() {
    return ambito;
  }

  /**
   * metodo che consente di impostare l'ambito di una domanda
   * 
   * @param ambito ambito della domanda
   */
  public void setAmbito(String ambito) {
    this.ambito = ambito;
  }

  /**
   * metodo che consente di verificare se la domanda è interna all'azienda
   * 
   * @return valore booleano indicante se domanda è interna all'azienda
   */
  public boolean isInternaAzienda() {
    return internaAzienda;
  }

  /**
   * metodo che consente di impostare se una domanda è interna all'azienda o meno
   * 
   * @param internaAzienda valore booleano da impostare
   */
  public void setInternaAzienda(boolean internaAzienda) {
    this.internaAzienda = internaAzienda;
  }
  
}
