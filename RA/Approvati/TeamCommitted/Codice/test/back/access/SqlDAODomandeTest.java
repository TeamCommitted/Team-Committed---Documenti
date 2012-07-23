/*
* Name: SqlDAODomandeTest.java
* Package: com.safetygame.back.access
* Author: Massimo Dalla Pieta'
 * Date: 2012/07/20
 * Version: 2.0
* Copyright: see COPYRIGHT
*
* Changes:
* +----------+---------------------+---------------------
* |   Date   | Programmer          | Changes
* +----------+---------------------+---------------------
* | 20120602 | Massimo Dalla Pieta'| + prendiCampiDomandaTest
* |          |                     | + getDomandaTest
* |          |                     | + posticipaTest
* |          |                     | + rispondiTest
* |          |                     | + domandeATest
* |          |                     | + addDomandaTest
* |          |                     | + remDomandaTest
* |          |                     | + scriviSottopostaTest
* +----------+---------------------|---------------------
*
*/
package com.safetyGame.back.access;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.safetyGame.back.condivisi.Dipendente;
import com.safetyGame.back.condivisi.Domanda;

public class SqlDAODomandeTest
{

    private DAODomande sqlD;
    private String indirizzoAz;
    private String indirizzoDom;
    private Indirizzo ind1;
    private Indirizzo ind2;
    private String utente;

    private void init(String pass)
    {
        indirizzoAz = "127.0.0.1/ingAz";
        indirizzoDom = "127.0.0.1/ingDom";
        utente = "root";
        ind1 = new Indirizzo(indirizzoAz, utente, pass);
        ind2 = new Indirizzo(indirizzoDom, utente, pass);
        sqlD = new SqlDAODomande(ind1, ind2);
    }

    @Test public void addDomandaTest()
    {
        init("root");
        Domanda d = new Domanda();
        d.setId(1);
        assertTrue("Impossibile aggiungere domanda", sqlD.addDomanda(d));
    }

    @Test public void remDomandaTest()
    {
        init("root");
        Domanda d = new Domanda();
        d.setId(1);
        assertTrue("Impossibile Rimuovere Domanda", sqlD.remDomanda(d));
    }

    @Test public void domandeATest()
    {
        init("root");
        ArrayList < Domanda > d = new ArrayList < Domanda >();
        d = sqlD.domandeA();
        System.out.println(""+d.get(0).isInternaAzienda());
        System.out.println(""+d.get(1).isInternaAzienda());
        assertTrue("Impossibile ottenere domande", !d.isEmpty());
    }

    @Test public void getDomandaTest()
    {
        init("root");
        Dipendente facco = new Dipendente();
        facco.setId(1);
        Domanda d = sqlD.getDomanda(facco);
        System.out.println(""+d.getId());
        assertTrue("Impossibile ottenere campi domanda", true);
    }

    @Test public void prendiCampiDomandaTest()
    {
        init("root");
        //Domanda d = sqlD.prendiCampiDomanda(1);
        assertTrue("Impossibile ottenere campi domanda", true);
    }

    @Test public void scriviSottopostaTest()
    {
        init("root");
        Dipendente facco = new Dipendente();
        facco.setId(1);
        Domanda d = sqlD.getDomanda(facco);
        assertTrue("Impossibile ottenere campi domanda", sqlD.scriviSottoposta(facco, d));
    }

    @Test public void rispondiTest()
    {
        init("root");
        Dipendente facco = new Dipendente();
        facco.setId(1);
        ArrayList < Domanda > a = sqlD.domandeA();
        Domanda d = a.get(0);
        d.setRispostaData(0);
        assertTrue("Impossibile ottenere campi domanda", sqlD.rispondi(facco, d));
    }

    @Test public void posticipaTest()
    {
        init("root");
        Dipendente facco = new Dipendente();
        facco.setId(1);
        ArrayList < Domanda > a = sqlD.domandeA();
        Domanda d = a.get(0);
        assertTrue("Impossibile ottenere campi domanda", sqlD.posticipa(facco, d));
    }

    @Test public void domandeTest()
    {
        init("root");
        Dipendente facco = new Dipendente();
        facco.setId(1);
        ArrayList < Domanda > a = new ArrayList < Domanda >();
        a = sqlD.domande(facco, null);
        Domanda d = a.get(0);
        a = sqlD.domande(facco, d);
        d = a.get(0);
        assertTrue("Impossibile ottenere domande", true);
    }

    @Test public void test()
    {
        fail("Not yet implemented");
    }
}
