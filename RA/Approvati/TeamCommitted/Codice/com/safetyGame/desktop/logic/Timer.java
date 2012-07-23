/*
 * Name: Timer.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120713 | Gabriele Facchin    | * Timer
 * |          |                     | * run
 * +----------+---------------------+---------------------
 * | 20120610 | Gabriele Facchin    | + Timer
 * |          |                     | + run
 * |          |                     | + setTempo
 * |          |                     | + getFinito
 * |          |                     | + getTempo
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;

/**
 * Classe che gestisce il timer per le domande
 * 
 * @author gfacchin
 * @version 2.0
 */
public class Timer extends Thread{
  private long tempo;
  private boolean finito;
  private boolean cambiato;
  private int ID;

  /**
   * Costruttore della classe Timer
   * 
   */
  public Timer(long tot_tempo, int id){
    tempo = tot_tempo;
    finito=false;
    cambiato=false;
    ID=id;
  }

  /**
   * metodo che fa partire il thread e quindi il conteggio alla rovescia
   * 
   */
  public void run(){
    while (true){
      while(!finito){
        long tempocopia=tempo;
        long attesa=tempocopia/10;
        while(tempocopia>0){
          try{sleep(attesa);}
          catch(InterruptedException e){tempocopia+=attesa-1;}
          tempocopia-=attesa;
          if (cambiato){ 
            tempocopia=0;
          }
        }
        finito=true; 
        if (cambiato){
          finito=false;
          cambiato=false;
        }
        if (finito){
          if (ID==1){
            ConnBack.getInstance().notificaDomanda();
          }
        }
      }
      //notifica al connback tramite metodo statico? :O
      try{sleep(10000);}
      catch(InterruptedException e){}
    }
  }
  
  /**
   * metodo che consente di reimpostare il tempo d'attesa
   * 
   * @param t nuovo tempo di attesa
   */
  public void setTempo(long t){
    tempo=t;
    cambiato=true;
    finito=false;
  }
  
  /**
   * metodo che consente di recuperare lo stato del conteggio
   * 
   * @return finito
   */
  public boolean isFinito(){
    return finito;
  }
  
  /**
   * metodo che consente di recuperare il tempo con cui e` stato impostato il thread
   * 
   * @return tempo
   */
  public long getTempo(){
    return tempo;
  }
}
