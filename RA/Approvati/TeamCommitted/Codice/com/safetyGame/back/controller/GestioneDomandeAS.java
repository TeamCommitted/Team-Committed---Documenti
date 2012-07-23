/*
 * Name: GestioneDomandeAS.java
 * Package: com.safetygame.back.controller
 * Author: Massimo Dalla Pieta'
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120712 |Massimo Dalla Pieta' | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120607 |Massimo Dalla Pieta' | + getElencoDomande
 * |          |                     | + addDomanda
 * |          |                     | + remDomanda
 * |          |                     | + GestioneDomandeAS
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire tutte le azioni dovute dall'interazione 
 * fra un AmministratoreSicurezza ed una domanda del sistema
 * @author mdallapi 
 * @version v2.0
 */
public class GestioneDomandeAS{ 
   private DAODomande accessDom;
   private GestioneLog gestLog;
   
   /**
    * Costruttore con parametri della classe GestioneDomandeAs
    * 
    * @param accessDom riferimento alla classe che implementa l'interfaccia DAODomande
    * @param gestLog riferimento alla classe GestioneLog      
    */
   public GestioneDomandeAS(DAODomande accessDom, GestioneLog gestLog){
       this.accessDom = accessDom;
       this.gestLog = gestLog;
    }
   
    /**
    * Metodo per ottenere la lista di tutte le domande
    * @return un ArrayList<Domande> contenente tutte le domande
    */
   public ArrayList<Domanda> getElencoDomande(){
      return accessDom.domandeA(); 
   }
   
   /**
    * Metodo per inserire una domanda dal server domande al server dell'azienda
    * 
    * @param dom domanda da aggiungere
    * @return true se l'operazione e` stata completata, altrimenti false   
    */
   public boolean addDomanda(Domanda dom){
      gestLog.scriviAddDomande(dom);
      return accessDom.addDomanda(dom);
   }
   
   /**
    * Metodo per eliminare una domanda dal server dell'azienda
    * @param dom domanda da rimuovere
    * @return true se l'operazione e` stata completata, altrimenti false       
    */
   public boolean remDomanda(Domanda dom){
      gestLog.scriviDelDomande(dom);
      return accessDom.remDomanda(dom);
   }
}
