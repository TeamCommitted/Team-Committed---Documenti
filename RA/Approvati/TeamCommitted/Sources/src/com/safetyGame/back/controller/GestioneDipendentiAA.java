/*
 * Name: GestioneDipendentiAA.java
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
 * | 20120708 |Alessandro Cornaglia | + getElencoRuoli
 * +----------+---------------------+---------------------
 * | 20120611 |Massimo Dalla Pieta' | + modPassA
 * |          |                     | + GestioneDipendentiAA
 * |          |                     | + getElencoDipendenti
 * |          |                     | + aggiungiDipendente
 * |          |                     | + cancellaDipendente
 * |          |                     | + modDipendente
 * +----------+---------------------+----------------------
 * 
 */ 

package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire le modifiche dati dei Dipendenti da parte di un Amministratore Azienda
 * 
 * @author mdallapi 
 * @version v2.0
 */
public class GestioneDipendentiAA{
   private DAODipendenti accessDip;
   private GestioneLog gestLog;
   
   /**
    * Costruttore con parametri della classe GestioneDipendentiAA
    * 
    * @param accessDip riferimento alla classe che implementa l'interfaccia DAODipendenti
    * @param gestLog iferimento alla classe GestioneLog      
    */
   public GestioneDipendentiAA(DAODipendenti accessDip, GestioneLog gestLog){
       this.accessDip = accessDip;
       this.gestLog = gestLog;
    }
   
    /**
    * Metodo per ottenere i dati dei dipendenti dell'azienda
    * @return un ArrayList<Dipendente> contenente i dipendenti dell'azienda      
    */
   public ArrayList<Dipendente> getElencoDipendenti(){
      return accessDip.elencoDipendenti(); 
   }
   
   /**
    * Metodo per aggiungere un dipendente
    * 
    * @param dip oggetto contenente i dati del nuovo dipendente
    * @return true se l'operazione viene completata con successo, altrimenti false    
    */
   public boolean aggiungiDipendente(Dipendente dip){
      Dipendente supporto = dip;
      String nome = supporto.getNome();
      String cognome = supporto.getCognome();
      String pass = GestioneRecupero.generaPassCasuale();
      String username = nome +"."+ cognome;
      supporto.setNickname(username);
      supporto.setPassword(pass);
      
      boolean inserito = accessDip.aggiungiDipendente(supporto);
      int conta = 0;
      while(!inserito) {
        conta++;
        supporto.setNickname(username+conta);
        inserito =  accessDip.aggiungiDipendente(supporto);
      }
      String messaggio_mail = "Nome: "+ supporto.getNome()+
                      "\n\n "+"Cognome: " + supporto.getCognome() +
                      "\n\n "+"Nickname: " + supporto.getNickname() +
                      "\n\n "+"Password: " + supporto.getPassword() +
                      "\n\n "+"Codice fiscale: " + supporto.getCodFiscale() +
                      "\n\n "+"Ruolo aziendale: " + supporto.getRuolo();
      Login log = new Login(supporto.getNickname(),supporto.getPassword());
      gestLog.scriviAddDip(accessDip.getInfoD(log));
      GestioneRecupero.sendMailInserito(supporto.getEmail(), messaggio_mail);
      return true;
   }
   
   /**
    * Metodo per eliminare un dipendente
    * 
    * @param dip oggetto contenente i dati del dipendente da eliminare
    * @return true se l'operazione viene completata con successo, altrimenti false    
    */
   public boolean cancellaDipendente(Dipendente dip){ 
      gestLog.scriviDelDip(dip); 
      return accessDip.cancellaDipendente(dip);
   }
   
   /**
    * Metodo per modificare i dati di un dipendente
    * 
    * @param newDip oggetto contenente i nuovi dati del dipendente da modificare
    * @param oldDip oggetto contenente i vecchi dati del dipendente da modificare
    * @return true se l'operazione viene completata con successo, altrimenti false
    */
   public boolean modDipendente(Dipendente newDip, Dipendente oldDip){ 
        boolean correct = true;
        if(!(newDip.getNome().equals(oldDip.getNome())))
            correct = accessDip.modNome(newDip, newDip.getNome());
        if((!(newDip.getCognome().equals(oldDip.getCognome()))) && correct)
            correct = accessDip.modCognome(newDip, newDip.getCognome());
        if((!(newDip.getEmail().equals(oldDip.getEmail()))) && correct)
            correct = accessDip.mailD(newDip, newDip.getEmail());
        if((!(newDip.getRuolo().equals(oldDip.getRuolo()))) && correct)
            correct = accessDip.modImpiego(newDip, newDip.getRuolo());
        if((!(newDip.getNickname().equals(oldDip.getNickname()))) && correct)
            correct = accessDip.modUsername(newDip, newDip.getNickname());
        if((!(newDip.getPassword().equals(oldDip.getPassword()))) && correct)
            correct = accessDip.passD(newDip, newDip.getPassword());
        if(correct)
            gestLog.scriviModDip(newDip);
        return correct;
   }
   
   /**
    * Metodo per modificare la password di un amministratore
    * 
    * @param admin oggetto contenente i dati dell'amministratore
    * @return true se l'operazione viene completata con successo, altrimenti false
    */
   public boolean modPassA(Dipendente admin){ 
       boolean risultato = accessDip.resetPassA(admin);
       if(risultato)
       risultato = accessDip.passA(admin,admin.getNuovaPass());
       
       if(risultato){
         GestioneRecupero.sendMail(admin.getEmail(), admin.getNuovaPass());
        }
       return risultato;
    }
    
    /**
   * Metodo che consente di reperire le informazioni di un amministratore a partire
   * dal suo login
   * 
   * @param login login dell'amministratore
   * @return informazioni sull'amministratore
   */
  public Dipendente getDatiA(Login login) {
    Dipendente ritorno = this.accessDip.getInfoA(login);
    return ritorno;    
  }
   
   /**
    * Metodo per recuperare l'elenco dei ruoli di un'azienda
    * 
    * @return elenco dei ruoli di un'azienda
    */
   public ArrayList<String> getElencoRuoli() {
     ArrayList <String> elencoRuoli = accessDip.getElencoRuoli();
     return elencoRuoli;
   }
}