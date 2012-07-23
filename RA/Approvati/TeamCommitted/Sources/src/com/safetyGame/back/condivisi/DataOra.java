/*
 * Name: DataOra.java
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
 * | 20120607 |Alessandro Cornaglia | *DataOra
 * +----------+---------------------+---------------------
 * | 20120520 |Alessandro Cornaglia | +aggiusta
 * |          |                     | +toString
 * +----------+---------------------+---------------------
 * | 20120519 |Alessandro Cornaglia | + DataOra
 * |          |                     | + Badge
 * |          |                     | + getAnno
 * |          |                     | + setAnno
 * |          |                     | + getMese
 * |          |                     | + setMese
 * |          |                     | + getGiorno
 * |          |                     | + setGiorno
 * |          |                     | + getOra
 * |          |                     | + setOra
 * |          |                     | + getMinuti
 * |          |                     | + setMinuti
 * |          |                     | + getSecondi
 * |          |                     | + setSecondi
 * +----------+---------------------|---------------------
 *
 */ 
 package com.safetyGame.back.condivisi;

 import java.util.*;
/**
 * Classe che rappresenta una data ed un'orario nella seguente formato: aaaa/mm/gg hh:mm:ss
 * 
 * @author TeamCommitted
 * @version 2.0
 * 
 */
public class DataOra {
   private int anno;
   private int mese;
   private int giorno;
   private int ora;
   private int minuti;
   private int secondi;   
   
   /**
    * deve prendere l'orario di oggi dall'orologio di sistema
    */
   public DataOra() {     
     GregorianCalendar gc = new GregorianCalendar();
     this.giorno = gc.get(Calendar.DAY_OF_MONTH);
     this.mese = gc.get(Calendar.MONTH)+1;//i mesi partono dallo 0
     this.anno = gc.get(Calendar.YEAR);
     this.ora = gc.get(Calendar.HOUR_OF_DAY);
     this.minuti = gc.get(Calendar.MINUTE);
     this.secondi = gc.get(Calendar.SECOND);
   }
   
   /**
    * Costruttore della classe DataOra
    * @param anno anno
    * @param mese mese
    * @param giorno giorno
    * @param ora ora
    * @param minuti minuti
    * @param secondi secondi
    * 
    */
   public DataOra(int anno,int mese,int giorno,int ora,int minuti,int secondi){
      this.anno = anno;
      this.mese = mese;
      this.giorno = giorno;
      this.ora = ora;
      this.minuti = minuti;
      this.secondi = secondi;
   }

   //da fare costruttore che da una stringa costruisca un dataOra
   /**
    * Costruttore della classe DataOra che crea l'oggetto a partire da una stringa
    * @param stringa DataOra in formato stringa
    * 
    */
   public DataOra(String stringa) {
	   //aaaa/mm/gg hh:mm:ss
	 this.anno = Integer.parseInt(stringa.substring(0,4));
	 this.mese = Integer.parseInt(stringa.substring(5,7));
	 this.giorno = Integer.parseInt(stringa.substring(8,10));
	 this.ora = Integer.parseInt(stringa.substring(11,13));
	 this.minuti = Integer.parseInt(stringa.substring(14,16));
	 this.secondi = Integer.parseInt(stringa.substring(17,19));
   }
   
   
   /**
    * metodo get per ottenere l'anno
    * @return anno 
    */
   public int getAnno() {
      return anno;
   }
   /**
    * metodo per impostare l'anno
    * @param anno anno da impostare
    * 
    */
   public void setAnno(int anno) {
      this.anno = anno;
   }
   /**
    * metodo get per ottenere il mese
    * @return mese 
    */
   public int getMese() {
      return mese;
   }
   /**
    * metodo per impostare il mese
    * @param mese mese da impostare 
    */
   public void setMese(int mese) {
      this.mese = mese;
   }
   /**
    * metodo get per ottenere il giorno
    * @return giorno
    */
   public int getGiorno() {
      return giorno;
   }
   /**
    * metodo per impostare il giorno
    * @param giorno giorno da impostare
    *  
    */
   public void setGiorno(int giorno) {
      this.giorno = giorno;
   }
   /**
    * metodo get per ottenere l'ora
    * @return ora
    */
   public int getOra() {
      return ora;
   }
   /**
    * metodo per impostare l'ora
    * @param ora da impostare
    */
   public void setOra(int ora) {
      this.ora = ora;
   }
   /**
    * metodo get per ottenere i minuti
    * @return minuti
    */
   public int getMinuti() {
      return minuti;
   }
   /**
    * metodo per impostare i minuti
    * @param minuti minuti da impostare
    */
   public void setMinuti(int minuti) {
      this.minuti = minuti;
   }
   /**
    * metodo get per ottenere i secondi
    * @return secondi
    */
   public int getSecondi() {
      return secondi;
   }
   /**
    * metodo per impostare i secondi
    * @param secondi secondi da impostare
    */
   public void setSecondi(int secondi) {
      this.secondi = secondi;
   }
   
   /**
    * Metodo che aggiusta un elemento che compone la data per far si che tutti i 
    * numeri siano composti da due cifre
    * 
    * @param parteData numero da controllare
    * @return risultato numero come stringa formato da due cifre
    */
   public static String aggiusta(int parteData){
     if ( parteData < 10 ) {
	   return "0"+parteData;
     }
     return ""+parteData;
   }
   
   @Override
   public String toString() { 
     String sMese = null;
     String sGiorno = null;
     String sOra = null;
     String sMinuti = null;
     String sSecondi = null;
	 
     sMese = aggiusta(this.mese);
     sGiorno = aggiusta(this.giorno);
     sOra = aggiusta(this.ora);
     sMinuti = aggiusta(this.minuti);
     sSecondi = aggiusta(this.secondi);
	 //formato: aaaa/mm/gg hh:mm:ss
     return ""+anno+"/"+sMese+"/"+sGiorno+" "+sOra+":"+sMinuti+":"+sSecondi;
   }   
}
