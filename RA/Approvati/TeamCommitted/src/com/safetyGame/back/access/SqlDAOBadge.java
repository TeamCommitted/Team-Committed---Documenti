/*
 * Name: SqlDAOBadge.java
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
 * | 20120520 | Gabriele Facchin    | + SqlDAOBadge
 * |          |                     | + badgeD
 * +----------+---------------------|---------------------
 * | 20120602 | Gabriele Facchin    | + badgeAS
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
 * Classe che gestisce le Badge, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 2.0
 */

public class SqlDAOBadge implements DAOBadge{
  private Indirizzo serverAzienda;
  
  /**
   * Costruttore della classe SqlDAOBadge
   * 
   * @param azienda indirizzo del server aziendale
   * 
   */
  
  public SqlDAOBadge(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  /**
   * Metodo che prende i badge ottenute da un Dipendente dal database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return un ArrayList di Badge che contiene i Badge di quel Dipendente
   * 
   */     
  public ArrayList<Badge> badgeD(Dipendente dip){ 
    ResultSet rs = serverAzienda.selezione("Assegnato INNER JOIN Badge ON IDBadge=ID","ID, il, nome, descrizione, soglia","IDDipendente="+dip.getId(),"");
    ArrayList<Badge> ritorno = new ArrayList<Badge>();
    boolean trovato = false;
    String nomeB="";
    String descr="";
    String data="";
    int punti=0, ID=0;
    while(!trovato){
      try{
    	ID = rs.getInt("ID");  
        data=rs.getString("il");
        nomeB = rs.getString("nome");
        descr = rs.getString("descrizione");
        punti = rs.getInt("soglia");
        DataOra da = new DataOra(data);
        Badge temp=new Badge(nomeB, ID, descr,punti);
        temp.setData(da);
        ritorno.add(temp);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    return ritorno;
  }
  
  /**
   * Metodo che prende i badge dal database
   * 
   * @return un ArrayList di Badge che contiene i Badge di quell'azienda
   * 
   */     
  public ArrayList<Badge> badgeAS(){//
    ResultSet rs = serverAzienda.selezione("Badge","*","","");
    ArrayList<Badge> ritorno = new ArrayList<Badge>();
    boolean trovato = false;
    String nomeB="";
    String descr="";
    int punti=0, ID=0;
    while(!trovato){
      try{
        ID=rs.getInt("ID");  
        nomeB = rs.getString("nome");
        descr = rs.getString("descrizione");
        punti = rs.getInt("soglia");
        Badge temp=new Badge(nomeB, ID, descr,punti);
        ritorno.add(temp);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    if (ritorno.size()==0){ritorno=null;}
    return ritorno;
  }
  
  /**
   * Metodo che assegna una Badge ad un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param badge Oggetto Badge che deve essere assegnato
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */     
  public boolean assegna(Dipendente dip, Badge badge){
    String valori[]=new String [3];
    valori[0]=""+dip.getId();
    valori[1]=""+badge.getId();
    DataOra data=new DataOra();
    valori[2]="'"+data.toString()+"'";
    return serverAzienda.inserisciRiga("Assegnato","IDDipendente, IDBadge, il",valori);
  }
}
