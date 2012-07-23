 /*
 * Name: Parserer.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 2012/07/20
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120708 | Gabriele Facchin    | + Parser
 * |          |                     | + isOpen
 * |          |                     | + finalize
 * |          |                     | + leggi
 * |          |                     | + apri
 * |          |                     | + scrivi
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;

import java.io.*;

/**
 * Classe che gestisce il file con l'indirizzo per la connessione al Back End
 * 
 * @author gfacchin
 * @version 1.0
 */
public class Parser{
  
  private File file=null;
  private FileReader in=null;
  private boolean aperto;

  /**
   * Costruttore della classe Parser
   * 
   */
  public Parser(){
    file=new File("com/safetyGame/desktop/logic/server.txt");
    apri();
  }

  /**
   * metodo che ritorna lo stato dell'apertura del file in lettura
   * 
   * @return aperto true se e` stato aperto, false altrimenti
   */
  public boolean isOpen(){
    return aperto;
  }
  
  /**
   * metodo che chiude lo stream prima che l'oggetto venga deallocato
   * 
   */
  public void finalize(){
    try{in.close();}
    catch(IOException e){}
  }
  
  /**
   * metodo che legge la stringa contenente l'indirizzo del server
   * 
   * @return percorso stringa che contiene il percorso
   */
  public String leggi(){
    if(!aperto){apri();}
    int carattere;
    try{carattere=in.read();}
    catch(IOException e){carattere =-1;}
    String percorso="";
    while(carattere!=-1){
      char c= (char) carattere;
      percorso+=c;
      try{carattere=in.read();}
      catch(IOException e){carattere=-1;}
    }
    return percorso;
  }

  /**
   * metodo che tenta di aprire lo stream in lettura
   * 
   */
  private void apri(){
    try{
      in= new FileReader(file);
      aperto=true;
    }
    catch (FileNotFoundException e){aperto=false;in=null;}
  }

  /**
   * metodo che crea un file in scrittura e ne scrive una stringa (contenente l'indirizzo del server). al termine apre lo stream in lettura.
   * 
   * @param server la stringa con l'indirizzo del server
   * @return true se l'operazione e` stata effettuata con successo, false altrimenti
   */
  public boolean scrivi(String server){
    if (in==null){
      PrintWriter out=null;
      try{out=new PrintWriter(file);} 
      catch(Exception e){return false;} 
      if(server.charAt(server.length()-1)!='/'){
        server+='/';
      }
      out.print(server);
      out.flush();
      out.close();
      apri();
      return true;
    }
    else {return false;}
  }
}
