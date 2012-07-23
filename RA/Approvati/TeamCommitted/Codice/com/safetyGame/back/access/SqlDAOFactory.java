/*
* Name: SqlDAOFactory.java
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
* | 20120512 | Gabriele Facchin    | + SqlDAOFactory
* |          |                     | + creaDAOLogin
* |          |                     | + creaDAODipendenti
* |          |                     | + creaDAODomande
* |          |                     | + creaDAOBadge
* |          |                     | + creaDAOPunteggi
* +----------+---------------------|---------------------
*
*/

package com.safetyGame.back.access;

/**
* Classe che implementa le sottoclassi per la gestione del database SQL
*
* @author gfacchin
 * @version 2.0
*/
public class SqlDAOFactory extends DAOFactory
{
    /**
     * Costruttore della classe Indirizzo
     *
     */
    public SqlDAOFactory(){}

    /**
     * Metodo ridefinito dalla classe astratta che crea l'oggetto SqlDAOLogin,
     * implementazione della classe interfaccia DAOLogin
     *
     * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
     * @return l'oggetto SqlDAOLogin istanziato
     *
     */
    public DAOLogin creaDAOLogin(Indirizzo azienda)
    {
        return new SqlDAOLogin(azienda);
    }

    /**
     * Metodo ridefinito dalla classe astratta che crea l'oggetto SqlDAODipendenti,
     * implementazione della classe interfaccia DAODipendenti
     *
     * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
     * @return l'oggetto SqlDAODipendenti istanziato
     *
     */
    public DAODipendenti creaDAODipendenti(Indirizzo azienda)
    {
        return new SqlDAODipendenti(azienda);
    }

    /**
     * Metodo ridefinito dalla classe astratta che crea l'oggetto SqlDAODomande,
     * implementazione della classe interfaccia DAODomande
     *
     * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
     * @param domande oggetto Indirizzo contenente i recapiti per il server contenente le domande
     * @return l'oggetto SqlDAODomande istanziato
     *
     */
    public DAODomande creaDAODomande(Indirizzo azienda, Indirizzo domande)
    {
        return new SqlDAODomande(azienda, domande);
    }

    /**
     * Metodo ridefinito dalla classe astratta che crea l'oggetto SqlDAOBadge,
     * implementazione della classe interfaccia DAOBadge
     *
     * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
     * @return l'oggetto SqlDAOBadge istanziato
     *
     */
    public DAOBadge creaDAOBadge(Indirizzo azienda)
    {
        return new SqlDAOBadge(azienda);
    }

    /**
     * Metodo ridefinito dalla classe astratta che crea l'oggetto SqlDAOPunteggi,
     * implementazione della classe interfaccia DAOPunteggi
     *
     * @param azienda oggetto Indirizzo contenente i recapiti per il server dell'azienda
     * @param domande oggetto Indirizzo contenente i recapiti per il server contenente le domande
     * @return l'oggetto SqlDAOPunteggi istanziato
     *
     */
    public DAOPunteggi creaDAOPunteggi(Indirizzo azienda, Indirizzo domande)
    {
        return new SqlDAOPunteggi(azienda, domande);
    }
}
