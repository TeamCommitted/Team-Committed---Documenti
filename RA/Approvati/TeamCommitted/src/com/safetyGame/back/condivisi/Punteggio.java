/*
 * Name: Punteggio.java
 * Package: com.safetygame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date: 2012/06/16
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
 * | 20120523 |Alessandro Cornaglia | + setMediaPuntiAzienda
 * |          |                     | + getMediaPuntiAzienda
 * |          |                     | + setPuntiPrec
 * |          |                     | + getPuntiPrec
 * |          |                     | + setPuntiSuc
 * |          |                     | + getPuntiSuc
 * |          |                     | + getnDomRisp
 * |          |                     | + setnDomRisp
 * |          |                     | + getnRispCorr
 * |          |                     | + setnRispCorr
 * |          |                     | * Punteggio
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + Punteggio
 * |          |                     | + getPunti
 * |          |                     | + setPunti
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.condivisi;


/**
 * Classe che rappresenta un generico punteggio. Può essere associata
 * sia ad una domanda che ad un dipendente
 * 
 * @author acornagl 
 * @version 2.0
 */
public class Punteggio {
  private int punti;
  private double mediaPuntiAzienda;
  private int puntiPrec; //punti del precedente
  private int puntiSuc; //punti del successivo
  private int nDomRisp; //numero domande risposte
  private int nRispCorr; //numero risposte corrette
  
  /**
   * Costruttore senza parametri della classe Punteggio
   */
  public Punteggio() {
    this.punti = 0;
    this.mediaPuntiAzienda = -1;
    this.puntiPrec = -1;
    this.puntiSuc = -1;
    this.nDomRisp = -1;
    this.nRispCorr = -1;
  }
  
  /**
   * Costruttore della classe Punteggio
   * 
   * @param punti punti da assegnare al nuovo oggetto 
   */
  public Punteggio( int punti ){
	  this.punti = punti;
	  this.mediaPuntiAzienda = -1;
      this.puntiPrec = -1;
	  this.puntiSuc = -1;
	  this.nDomRisp = -1;
	  this.nRispCorr = -1;
  }

  /**
   * metodo che consente di recuperare i punti
   * @return punti
   */
  public int getPunti() {
    return punti;
  }

  /**
   * metodo che consente di modificare i punti
   * 
   * @param punti punti da assegnare all'oggetto
   */
  public void setPunti(int punti) {
    this.punti = punti;
  }
  
  /**
   * metodo che consente di recuperare il punteggio medio aziendale
   * 
   * @return punteggio medio aziendale
   */
  public double getMediaPuntiAzienda() {
    return mediaPuntiAzienda;
  }
  
  /**
   * metodo che consente di impostare il punteggio medio aziendale
   * 
   * @param mediaPuntiAzienda punteggio medio aziendale da assegnare
   */
  public void setMediaPuntiAzienda(double mediaPuntiAzienda) {
    this.mediaPuntiAzienda = mediaPuntiAzienda;
  }

  /**
   * metodo che consente di recuperare il punteggio del dipendente in posizione
   * precedente
   * 
   * @return punteggio dipendente precedente
   */
  public int getPuntiPrec() {
    return puntiPrec;
  }
  
  /**
   * metodo che consente di impostare i punti del dipendente precedente
   * 
   * @param puntiPrec punti dipendente precedente da impostare 
   */
  public void setPuntiPrec(int puntiPrec) {
    this.puntiPrec = puntiPrec;
  }

  /**
   * metodo che consente di recuperare il punteggio del dipendente in posizione
   * successiva
   * 
   * @return punteggio medio aziendale
   */
  public int getPuntiSuc() {
    return puntiSuc;
  }
  
  /**
   * metodo che consente di impostare i punti del dipendente successivo
   * 
   * @param puntiSuc punti dipendente successivo da impostare 
   */
  public void setPuntiSuc(int puntiSuc) {
    this.puntiSuc = puntiSuc;
  }

  /**
   * metodo che consente di recuperare il numero di risposte date dal dipendente
   * 
   * @return numero risposte date dal dipendente
   */
  public int getnDomRisp() {
    return nDomRisp;
  }
  
  /**
   * metodo che consente di impostare il numero di domande risposte dal dipendente
   * 
   * @param nDomRisp numero domande risposte dal dipendente
   */
  public void setnDomRisp(int nDomRisp) {
    this.nDomRisp = nDomRisp;
  }

  /**
   * metodo che consente di recuperare il numero di risposte corrette date dal 
   * dipendente
   * 
   * @return numero di risposte corrette date dal dipendente
   */
  public int getnRispCorr() {
    return nRispCorr;
  }
  
  /**
   * metodo che consente di impostare il numero di domande risposte corrette
   * date dal dipendente
   * 
   * @param nRispCorr numero domande risposte correttamente dal dipendente
   */
  public void setnRispCorr(int nRispCorr) {
    this.nRispCorr = nRispCorr;
  }

}
