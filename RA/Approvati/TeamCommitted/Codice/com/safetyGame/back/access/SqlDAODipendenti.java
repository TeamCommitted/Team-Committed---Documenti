/*
 * Name: SqlDAODipendenti.java
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
 * | 20130708 | Alessandro Cornaglia| + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120527 | Gabriele Facchin    | + SqlDAODipendenti
 * |          |                     | + getInfoD
 * |          |                     | + getInfoA
 * |          |                     | + resetPassD                
 * |          |                     | + resetPassA
 * |          |                     | + passD
 * |          |                     | + passA
 * |          |                     | + mailD
 * |          |                     | + elencoDipendenti
 * |          |                     | + aggiungiDipendente
 * |          |                     | + cancellaDipendente
 * |          |                     | + modNome
 * |          |                     | + modCognome
 * |          |                     | + modCodFis
 * |          |                     | + modUsername
 * |          |                     | + modImpiego
 * |          |                     | + setTrofei
 * |          |                     | + generaPassCasuale
 * |          |                     | + resetA
 * |          |                     | + resetD
 * +----------+---------------------|---------------------
 * | 20120604 | Gabriele Facchin    | - generaPassCasuale
 * +----------+---------------------|---------------------
 * 
 */

package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe che gestisce i dipendenti, implementa i metodi pubblici dell'interfaccia
 * 
 * @author gfacchin
 * @version 2.0
 */

public class SqlDAODipendenti implements DAODipendenti{
  private Indirizzo serverAzienda;
  
  /**
   * Costruttore della classe SqlDAODipendenti
   * 
   * @param azienda indirizzo del server aziendale
   * 
   */
  public SqlDAODipendenti(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  /**
   * Metodo che prende le informazioni di un Dipendente dal database
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @return l'oggetto Dipendente istanziato se presente nel db, altrimenti null
   * 
   */     
  public Dipendente getInfoD(Login login){
    String username = login.getUsername();
    String password = login.getPassword();
    ResultSet rs = serverAzienda.selezione("Dipendente as dip INNER JOIN Ruolo as r ON dip.ruolo=r.ruolo ","*", "nickname='"+username+"'",""); 
    String nome,cognome,codfis,email,ruolo,passmod;
    int ID,trofeo;
    try{
      ID = rs.getInt("ID");
      nome = rs.getString("nome");
      cognome = rs.getString("cognome");
      codfis = rs.getString("codice_fiscale");
      passmod = rs.getString("passmod");
      email = rs.getString("email");
      ruolo = rs.getString("ruolo");
      trofeo = rs.getInt("trofeo");
    }
    catch (SQLException e){return null;} 
    rs = serverAzienda.selezione("Storico","punteggio","IDDipendente="+ID,"");
    int punti=0;
    boolean finito = false;
    while(!finito){
      try{
        punti+= rs.getInt("punteggio");
        rs.next();
      }
      catch (SQLException e){finito = true;}
    }
    return new Dipendente(ID,codfis, nome,cognome,email,username,password,ruolo,punti, passmod, trofeo);
  }

  /**
   * Metodo che prende le informazioni di un Amministratore dal database
   * 
   * @param login Oggetto Login da cui si prendono le informazioni
   * @return l'oggetto Dipendente (amministratore) istanziato se presente nel db, altrimenti null
   * 
   */   
  public Dipendente getInfoA(Login login){
    String username = login.getUsername();
    String password = login.getPassword();
    ResultSet rs = serverAzienda.selezione("Amministratore","*", "nickname='"+username+"'",""); 
    int ID;
    String email,codfis,data,passmod;
    boolean amm;
    try{
      ID = rs.getInt("ID");
      email = rs.getString("email");
      data = rs.getString("datapass");
      passmod = rs.getString("passmod");
      codfis = rs.getString("codice_fiscale");
      amm=rs.getBoolean("tipo_amministratore");
    }
    catch (SQLException e){return null;}
    DataOra d=new DataOra(data);
    return new Dipendente(amm, d, passmod, email, username, password, codfis, ID);
  }
  
  /**
   * Metodo che resetta il campo password modificata di un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean resetPassD(Dipendente dip){
    return serverAzienda.modificaRiga("Dipendente", "passmod=NULL","ID="+dip.getId());
  }
  
  /**
   * Metodo che resetta il campo password modificata di un Amministratore
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean resetPassA(Dipendente dip){
    return serverAzienda.modificaRiga("Amministratore", "passmod=NULL","ID="+dip.getId());
  }
  
  /**
   * Metodo che setta il campo password di un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param pass la stringa della nuova password del Dipendente
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean passD(Dipendente dip, String pass){
    return serverAzienda.modificaRiga("Dipendente", "password='"+pass+"'","ID="+dip.getId());
  }

  /**
   * Metodo che setta il campo password (e il campo data pass) di un Amministratore
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param pass la stringa della nuova password dell'Amministratore
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean passA(Dipendente dip, String pass){
    DataOra data=new DataOra();
    boolean b = serverAzienda.modificaRiga("Amministratore", "password='"+pass+"'","ID="+dip.getId());
    if (b){
      b=false;
      while (!b){
        b=serverAzienda.modificaRiga("Amministratore", "datapass='"+data.toString()+"'","ID="+dip.getId());
      }
    }
    return b;
  }
  
  /**
   * Metodo che setta il campo mail di un Dipendente
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param mail la stringa della nuova email del Dipendente
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean mailD(Dipendente dip, String mail){
    return serverAzienda.modificaRiga("Dipendente", "email='"+mail+"'","ID="+dip.getId());
  }

  /**
   * Metodo che ritorna l'elenco dei Dipendenti dell'Azienda
   * 
   * @return un ArrayList che contiene tutti i dipendenti
   * 
   */   
  public ArrayList<Dipendente> elencoDipendenti(){
    ResultSet rs=serverAzienda.selezione("Dipendente","*","","");
    ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
    ArrayList<Login> supporto = new ArrayList<Login>();
    boolean trovato = false;
    String username,password;
    while(!trovato){
      try{
        username = rs.getString("nickname");
        password = rs.getString("password");
        supporto.add(new Login(username,password));      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    for (int i=0; i<supporto.size(); i++){
      Dipendente temp = getInfoD(supporto.get(i));
      dipendenti.add(temp);
    }
    if (dipendenti.size()==0){dipendenti=null;}
    return dipendenti;
  }

  /**
   * Metodo che aggiunge un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean aggiungiDipendente(Dipendente dip){
    String param[]=new String[9];
    param[0]="'"+dip.getNome()+"'";
    param[1]="'"+dip.getCognome()+"'";
    param[2]="'"+dip.getCodFiscale()+"'";
    param[3]="'"+dip.getEmail()+"'";
    param[4]="'"+dip.getNickname()+"'";
    param[5]="''";
    param[6]="'"+dip.getPassword()+"'";
    param[7]="'"+dip.getRuolo()+"'";
    param[8]=""+dip.getPunteggio().getPunti();
    return serverAzienda.inserisciRiga("Dipendente","nome, cognome, codice_fiscale, email, nickname, password,  passmod, ruolo, trofeo",param);
  }
  
  /**
   * Metodo che cancella un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @return boolean che indica se l'operazione e' andata o meno a buon fine
   * 
   */   
  public boolean cancellaDipendente(Dipendente dip){
    return serverAzienda.cancellaRiga("Dipendente","ID="+dip.getId()+" AND nickname='"+dip.getNickname()+"' AND password ='"+dip.getPassword()+"';");
  }
  
  /**
   * Metodo che modifica il nome di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param nome stringa contenente il nuovo nome
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modNome(Dipendente dip, String nome){
    return serverAzienda.modificaRiga("Dipendente","nome='"+nome+"'","ID="+dip.getId());
  }
  
  /**
   * Metodo che modifica il cognome di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param cognome stringa contenente il nuovo cognome
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modCognome(Dipendente dip, String cognome){
    return serverAzienda.modificaRiga("Dipendente","cognome='"+cognome+"'","ID="+dip.getId());
  }
  
  /**
   * Metodo che modifica il codice fiscale di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param codfis stringa contenente il nuovo codice fiscale
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modCodFis(Dipendente dip, String codfis){
    return serverAzienda.modificaRiga("Dipendente","codice_fiscale='"+codfis+"'","ID="+dip.getId());
  }

  /**
   * Metodo che modifica lo username di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param username stringa contenente il nuovo username
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modUsername(Dipendente dip, String username){
    return serverAzienda.modificaRiga("Dipendente","nickname='"+username+"'","ID="+dip.getId());
  }

  /**
   * Metodo che modifica l'impiego di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param impiego stringa contenente il nuovo impiego
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean modImpiego(Dipendente dip, String impiego){
    return serverAzienda.modificaRiga("Dipendente","ruolo='"+impiego+"'","ID="+dip.getId());
  }
  
  /**
   * Metodo che modifica i trofei di un Dipendente al database
   * 
   * @param dip Oggetto Dipendente da cui si prendono le informazioni
   * @param numTrofei intero contenente il nuovo ammontare trofei
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean setTrofei(Dipendente dip, int numTrofei){
    return serverAzienda.modificaRiga("Dipendente","trofeo="+numTrofei,"ID="+dip.getId());
  }
  
  /**
   * Metodo che resetta la password (casuale) di un Dipendente
   * 
   * @param rec Oggetto Recupero da cui si prendono le informazioni
   * @param pass nuova password da impostare 
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetD(Recupero rec, String pass){
    boolean ritorno = serverAzienda.modificaRiga("Dipendente","passmod='"+pass+"'","email='"+rec.getEmail()+"'"+" AND codice_fiscale='"+rec.getCodFiscale()+"'");
    if (ritorno){
      ResultSet rs= serverAzienda.selezione("Dipendente","passmod","email='"+rec.getEmail()+"'"+" AND codice_fiscale='"+rec.getCodFiscale()+"'","");
      try{
        String s = rs.getString("passmod");
        if (s!="")
          ritorno=true;
        else
          ritorno=false;
      }
      catch(SQLException e){return false;}
    }
    return ritorno;
  }
  
  /**
   * Metodo che resetta la password (casuale) di un Amministratore
   * 
   * @param rec Oggetto Recupero da cui si prendono le informazioni
   * @param pass nuova password da impostare
   * @return boolean che indica se l'operazione e` andata o meno a buon fine
   * 
   */   
  public boolean resetA(Recupero rec, String pass){
    boolean ritorno =serverAzienda.modificaRiga("Amministratore","passmod='"+pass+"'","email='"+rec.getEmail()+"' AND codice_fiscale='"+rec.getCodFiscale()+"'");
    System.out.println(ritorno); 
    if (ritorno){
      ResultSet rs= serverAzienda.selezione("Amministratore","passmod","email='"+rec.getEmail()+"'"+" AND codice_fiscale='"+rec.getCodFiscale()+"'","");
      try{
        String s = rs.getString("passmod");
        if (s!="")
          ritorno=true;
        else
          ritorno=false;
      }
      catch(SQLException e){return false;}
    }
    return ritorno;
  }
  
  /**
   * Metodo che restituisce la lista dei ruoli aziendali
   * 
   * @return lista dei ruoli aziendali
   */
  public ArrayList<String> getElencoRuoli() {
    ResultSet rs=serverAzienda.selezione("Ruolo","*","","");
    ArrayList<String> ruoli = new ArrayList<String>();
    boolean trovato = false;
    String ruolo = "";
    while(!trovato){
      try{
        ruolo = rs.getString("ruolo");
        ruoli.add(ruolo);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    return ruoli;
  }
}
