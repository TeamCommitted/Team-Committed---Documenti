/*
 * Name: SqlDAOLogin.java
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
 * | 20120526 | Gabriele Facchin    | + SqlDAOLogin
 * |          |                     | + loginAmministratore
 * |          |                     | + loginDipendente
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe che gestisce i login, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 2.0
 */

public class SqlDAOLogin implements DAOLogin{
  private Indirizzo serverAzienda;
  
  /**
   * Costruttore della classe SqlDAOLogin
   * @param azienda indirizzo del server aziendale
   */
  
  public SqlDAOLogin(Indirizzo azienda){
    serverAzienda=azienda;
  }

  /**
   * Metodo che prova il login di un Amministratore
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @param  tipo booleano: 1 se amministratore azienda(AA), 0 se amministratore sicurezza(AS) 
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */    
  public boolean loginAmministratore(Login login, boolean tipo){
    String username = login.getUsername();
    String password = login.getPassword();
    ResultSet rs= serverAzienda.selezione("Amministratore","*", "nickname='"+username+"' AND (password='"+password+"' OR passmod='"+password+"') AND tipo_amministratore="+tipo,""); 
    try{
      int ID = rs.getInt("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
  
  /**
   * Metodo che prova il login di un Dipendente
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @return un boolean che indica se il login e` avvenuto con successo o no
   * 
   */    
  public boolean loginDipendente(Login login){
    String username = login.getUsername();
    String password = login.getPassword();
    ResultSet rs= serverAzienda.selezione("Dipendente","*", "nickname='"+username+"' AND (password='"+password+"' OR passmod='"+password+"')",""); 
    try{
      int ID = rs.getInt("ID");
    }
    catch(SQLException e){return false;} 
    return true;
  }
}
