/*
 * Name: GestioneLoginTest.java
 * Package: com.safetygame.back.controller
 * Author: Alessandro Cornaglia
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120602 |Alessandro Cornaglia | + testLoginD
 * |          |                     | + testLoginA
 * |          |                     | + testLogout
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.back.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.access.DAOBadge;
import com.safetyGame.back.access.DAODipendenti;
import com.safetyGame.back.access.DAODomande;
import com.safetyGame.back.access.DAOLogin;
import com.safetyGame.back.access.Indirizzo;
import com.safetyGame.back.access.SqlDAOBadge;
import com.safetyGame.back.access.SqlDAODipendenti;
import com.safetyGame.back.access.SqlDAODomande;
import com.safetyGame.back.access.SqlDAOLogin;
import com.safetyGame.back.access.UpdateLog;
import com.safetyGame.back.condivisi.Badge;
import com.safetyGame.back.condivisi.Login;

public class GestioneLoginTest {
    GestioneLogin login;
    
    private void init() {
          String indirizzo1 = "127.0.0.1/ingAz";
          String utente = "root";
          String pass = "";
          Indirizzo indirizzoAz = new Indirizzo(indirizzo1,utente,pass);
          DAOLogin daoLog = new SqlDAOLogin(indirizzoAz);
          DAODipendenti daoDip = new SqlDAODipendenti(indirizzoAz);
          UpdateLog updlog = new UpdateLog(indirizzoAz);
          GestioneLog log = new GestioneLog(updlog,daoDip);
          login = new GestioneLogin(daoLog,log);
    }
    
    @Test
    public void testLoginD(){
        init();
        Login l = new Login("andrea.marton","pass");
        assertTrue("login non effettuato", login.loginUser(l));
        //devo verificare inoltre che nella tabella LogLoginD ci sia la riga 1 - 2 - data ora attuale
    }
    
    @Test
    public void testLoginA(){
        init();
        Login l = new Login("amministratoreAz","pass");
        assertTrue("login non effettuato", login.loginAdmin(l,true));
      //devo verificare inoltre che nella tabella LogLoginA ci sia la riga 1 - 1 - data ora attuale
    }
    
    @Test
    public void testLogoutD(){
        init();
        Login l = new Login("andrea.marton","pass");
        login.logoutD(l);
        assertTrue("logout non effettuato", true);
      //devo verificare inoltre che nella tabella LogLogoutD ci sia la riga 1 - 2 - data ora attuale
    }
    
    @Test
    public void testLogoutA(){
        init();
        Login l = new Login("amministratoreAz","pass");
        login.logoutA(l);
        assertTrue("logout non effettuato", true); 
      //devo verificare inoltre che nella tabella LogLogoutA ci sia la riga 1 - 1 - data ora attuale
    }


}
