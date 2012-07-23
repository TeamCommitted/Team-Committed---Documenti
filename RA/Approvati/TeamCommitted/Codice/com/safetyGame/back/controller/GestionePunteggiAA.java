/*
 * Name: GestionePunteggiAA.java
 * Package: com.safetygame.back.controller
 * Author: Massimo Dalla Pietà
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120717 |Massimo Dalla Pieta' | Tutti i metodi sono
 * |          |                     | stati aggiornati assegnado
 * |          |                     | a alle variabili 
 * |          |                     | nomi significativi
 * +----------+---------------------+---------------------
 * | 20120531 |Massimo Dalla Pieta' | * GestionePunteggiAA
 * |          |                     | * getPunteggi
 * |          |                     | * setTrofei
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire la visione dei punteggi in un'azienda
 * 
 * @author mdallapi 
 * @version v2.0
 */
public class GestionePunteggiAA{ 
   private DAOPunteggi accessPunti;
   private DAODipendenti accessDip;
   
   /**
    * Costruttore con parametri della classe GestionePunteggiAA
    * 
    * @param accessP riferimento alla classe che implementa l'interfaccia DAOPunteggi
    * @param accessDip riferimento alla classe che implementa l'interfaccia DAODipendenti
    */
   public GestionePunteggiAA(DAOPunteggi accessPunti, DAODipendenti accessDip){
       this.accessPunti = accessPunti;
       this.accessDip = accessDip;
    }
   
    /**
    * Metodo per ottenere i punteggi medi dell'azienda e i punteggi di tutti i dipendenti
    * 
    * @return un ArrayList<Punteggio> contenente in posizione 0 un oggetto Punteggio contenente i dati medi dell'azienda
    * e successivamente la lista dei punteggi di tutti i dipendenti.
    */
   public ArrayList<Dipendente> getPunteggi(){
       ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
       dipendenti.add(new Dipendente());
       dipendenti.addAll(accessDip.elencoDipendenti());
       int risposte = 0;
       int corrette = 0;
       Punteggio p = new Punteggio();
       for(int i=1; i<dipendenti.size(); i++){
           p = accessPunti.getGlobalStat(dipendenti.get(i));
           dipendenti.get(i).setPunteggio(p);
            risposte += p.getnDomRisp();
            corrette += p.getnRispCorr();
       }
       risposte = risposte / dipendenti.size();
       corrette = corrette / dipendenti.size();
       p.setnDomRisp(risposte);
       p.setnRispCorr(corrette);
       p.setMediaPuntiAzienda(dipendenti.get(1).getPunteggio().getMediaPuntiAzienda());
       dipendenti.get(0).setPunteggio(p);
       return dipendenti; 
    }
    
    /**
    * Metodo per modificare i trofei di un dipendente
    * 
    * @param dip il dipendente che si vuole modificare
    * @param num numero di trofei che si vuole assegnare
    * @return true se l'operazione ha successo, altrimenti false  
    */
    public boolean setTrofei(Dipendente dip, int num){
        return accessDip.setTrofei(dip,num);
    }
}
