/*
 * Name: DataOra.java
 * Package: com.safetygame.back.condivisi
 * Author: Alessandro Cornaglia
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120607 |Alessandro Cornaglia | + testCostruttoreP
 * |          |                     | + testCostruttoreV
 * |          |                     | + testCostruttoreStringa
 * +----------+---------------------|---------------------
 *
 */ 
package com.safetyGame.back.condivisi;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Classe di test per oggetti di tipo DataOra
 * @author acornagl
 * @version v2.0
 */
public class DataOraTest {
	
  DataOra d; 
  
  /**
   * mettodo che consente di creare on oggetto Data ora con parametri  
   */
  private void init() {
	int giorno = 10;
    int mese = 9;
    int anno = 2012;
    int ora = 9;
    int minuti = 56;
 	int secondi = 49;
   	d = new DataOra(anno,mese,giorno,ora,minuti,secondi);
  }
  
  /**
   * metodo che consente di creare un oggetto DataOra senza parametri
   */
  private void initV() {
	  d = new DataOra();
  }
  
  private void initS() {
	 d = new DataOra("1989/10/11 12:06:58");
  }
	
  @Test 
  public void testCostruttoreP() {
    init();	
    assertTrue("Il giorno non è quello atteso", d.getGiorno() == 10);
  }

  @Test
  public void testCostruttoreV() {
    initV();
    int anno = 2012;//anno attuale
    int mese = 06;//mese attuale
    int giorno = 07;//giorno attuale
    assertTrue("L'anno non è quello atteso", d.getAnno() == anno);
    assertTrue("Il mese non è quello atteso", d.getMese() == mese);
    assertTrue("Il giorno non è quello atteso", d.getGiorno() == giorno);
  }
  
  @Test
  public void testCostruttoreStringa(){
	initS();
	String corretta = "1989/10/11 12:06:58";
	assertTrue("La creazione da stringa non è corretto",d.toString().equals(corretta));
  }
}
