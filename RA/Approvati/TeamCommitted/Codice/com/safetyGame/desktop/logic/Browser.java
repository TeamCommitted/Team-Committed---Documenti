/*
 * Name: Browser.java
 * Package: com.safetygame.desktop.logic
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120713 | Gabriele Facchin    | + Browser
 * |          |                     | + getInstance
 * |          |                     | + apri
 * |          |                     | + leggi
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.logic;
import java.awt.Desktop;
import java.net.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe che gestisce l'apertura del browser predefinito di sistema
 *
 * @author gfacchin 
 * @version 0.2
 */

public class Browser {
 
  private static Browser singleton = null;
  private Desktop desktop;
  private URI link;
  private String iniziouri;
  
  /**
   * Costrutture della classe Browser
   * 
   */
  private Browser(){
    try{
       desktop = Desktop.getDesktop();
    }     
    catch(UnsupportedOperationException e){System.out.println("Le funzionalita` minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(2);}
    iniziouri="http://"+ConnBack.getInstance().getServer().trim();
    if (ConnBack.getInstance().getServer().trim().toUpperCase().equals("LOCALHOST")){
      iniziouri+="/examples/";
    }
  }
  
  /**
   * Metodo che ritorna l'unica istanza della classe valida
   * 
   * @return unico oggetto Browser
   * 
   */
  public static Browser getInstance(){
    if(singleton == null){
      singleton = new Browser();
    }
    return singleton;
  }
    
  /**
   * Metodo che apre una pagina web
   * 
   * @param stringa contenente il nome della pagina da aprire
   * 
   */
  public void apri(String pagina){
    String user=ConnBack.getInstance().userLoggato().trim();
    String pass=ConnBack.getInstance().passUserLoggato();
    String parametri="forcedLoginDesktop.jsp?nick="+user+"&pass="+pass+"&page="+pagina.trim();
    try{
      desktop.browse(new URI(iniziouri+parametri));
    }
    catch (URISyntaxException e){System.out.println("Errore nella sintassi dell'url. Contattare l'Installatore");}
    catch (SecurityException e){System.out.println("Occorre avere il permesso per aprire il browser. Contattare l'Installatore"); System.exit(3);}
    catch (IOException e){System.out.println("Occorre avere almeno un browser predefinito nel sistema. Contattare l'Installatore"); System.exit(4);}
    catch (UnsupportedOperationException e) {System.out.println("Le funzionalita` minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
  }      
  
  /**
   * Metodo che legge una pagina web
   * 
   * @param stringa contenente l'url della pagina web da leggere
   * @return char che mostra il primo carattere letto, se esistente. se non esiste ritorna 'e'
   * 
   */
  public char leggi(String fineUrl){
    try{
      URL oracle = new URL(iniziouri+fineUrl);
      BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
      String inputLine;
      inputLine = in.readLine();
      while (inputLine.equals("")){
        inputLine = in.readLine();
      }
      in.close();
      return inputLine.charAt(0);
    }
    catch (Exception e){System.out.println("Errore nella lettura delle pagine. Contattare l'Installatore");}    
    return 'e';
  }
}
