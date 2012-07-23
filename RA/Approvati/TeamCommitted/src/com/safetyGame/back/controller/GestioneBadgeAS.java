/*
 * Name: GestioneBadgeAS.java
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
 * | 20120611 |Massimo Dalla Pieta' | + GestioneBadgeAS
 * |          |                     | + getBadgeAS
 * +----------+---------------------+----------------------
 * 
 */ 
package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.ArrayList;

/**
 * Classe che si occupa di gestire i badge da parte AS
 * 
 * @author mdallapi 
 * @version v2.0
 */
public class GestioneBadgeAS{ 
    private DAOBadge accessBadge;
    
    /**
    * Costruttore con parametri della classe GestioneBadgeAS
    * 
    * @param accessB riferimento alla classe che implementa l'interfaccia DAOBadge
    *       
    */
    public GestioneBadgeAS(DAOBadge accessBadge){
        this.accessBadge=accessBadge;
    }
    
    /**
    * Metodo per ottenere tutti i badge possibili
    * @return un ArrayList<Badge> contenente tutte le badge nel database
    * 
    */
    public ArrayList<Badge> getBadgesAS(){
        return accessBadge.badgeAS();
    }
}
