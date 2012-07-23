/*
 * Name: SqlDAOPunteggi.java
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
 * | 20120519 | Gabriele Facchin    | + SqlDAOPunteggi
 * |          |                     | + getStat
 * +----------+---------------------|---------------------
 * | 20120529 | Gabriele Facchin    | + getGlobalStat
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che gestisce i Punteggi, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 2.0
 */

public class SqlDAOPunteggi implements DAOPunteggi{
  private Indirizzo serverAzienda;
  private Indirizzo serverDomande;
  
  /**
   * Costruttore della classe SqlDAOPunteggi
   * @param azienda indirizzo del server aziendale
   * @param domade indirizzo del server domande
   * 
   */
  public SqlDAOPunteggi(Indirizzo azienda, Indirizzo domande){
    serverAzienda=azienda;
    serverDomande=domande;
  }
  
  /**
   * Metodo che prende il punteggio di un Dipendente dal database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Punteggio contenente il totale del punteggio del Dipendente
   * 
   */    
  public Punteggio getStat(Dipendente dip){//
    ResultSet rs = serverAzienda.selezione("Storico","punteggio","IDDipendente="+dip.getId(),"");
    int totale=0;
    boolean finito = false;
    while(!finito){
      try{
        totale+= rs.getInt("punteggio");
        rs.next();
      }
      catch (SQLException e){finito = true;}
    }
    return new Punteggio(totale);
  }
  
  /**
   * Metodo che genera le statistiche dato un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return l'oggetto Punteggio contenente le statistiche dei dipendenti (e dell'azienda) a lui vicini
   * 
   */    
  public Punteggio getGlobalStat(Dipendente dip){//
    int punteggio=dip.getPunteggio().getPunti();
    ResultSet rs = serverAzienda.selezione("Dipendente","ID","","");
    boolean finito = false;
    int totDipendenti=0;
    int ID=0;
    int totPunti=0;
    int contatoreDipendente=0;
    ArrayList <Punteggio> punti=new ArrayList<Punteggio>();
    while(!finito){
      try{
        ID=rs.getInt("ID");
        if (ID==dip.getId()){
          contatoreDipendente=totDipendenti;
        }
        Dipendente d=new Dipendente();
        d.setId(ID);
        Punteggio p = getStat(d);
        punti.add(p);
        totPunti+= p.getPunti();
        totDipendenti++;
        rs.next();
      }
      catch (SQLException e){finito = true;}
    }
    double media=totPunti/totDipendenti; //calcolata la media
    rs = serverAzienda.selezione("Storico","count(risposta) as tot","IDdipendente="+dip.getId()+ " AND punteggio>0","");
    int totRisposte=0;
    try{
      totRisposte=rs.getInt("tot");
    }
    catch (SQLException e){}
    //calcolate le risposte totali del dipendente
    rs = serverDomande.selezione("Domanda","min(punteggio) as min","","");
    int min=0;
    try{
      min=rs.getInt("min");
    }
    catch (SQLException e){}
    min=min/2;
    rs = serverAzienda.selezione("Storico","count(risposta) as tot","IDdipendente="+dip.getId()+ " AND punteggio>"+min,"");
    int totCorrette=0;
    try{
      totCorrette=rs.getInt("tot");
    }
    catch (SQLException e){}
    //calcolate le risposte corrette del dipendente
    int puntiDip=punti.get(contatoreDipendente).getPunti();
    punti.remove(contatoreDipendente);
    int puntiMin=-1,puntiMax=-1;
    for (int i=0;i<punti.size();i++){
      int temp=punti.get(i).getPunti();
      if (temp<puntiDip && temp>puntiMin){
        puntiMin=temp;
      }
      if (temp>puntiDip && temp<puntiMax){
        puntiMax=temp;
      }
    }
    //calcolati minimo e massimo successivi al dipendente
    Punteggio p=new Punteggio();
    p.setMediaPuntiAzienda(media);
    p.setPuntiPrec(puntiMin);
    p.setPuntiSuc(puntiMax);
    p.setnRispCorr(totCorrette);
    p.setnDomRisp(totRisposte);
    return p;
  }
}

