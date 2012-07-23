/*
 * Name: Dati.java
 * Package: com.safetygame.android.condivisi
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120506 |Lorenzo Braghetto | + Dati
 * |          |                  | + getNome
 * |          |                  | + getCognome
 * +----------+------------------+---------------------
 *
 */
 
package com.safetyGame.mobile.condivisi;

public class Dati {

	private String nome;
	private String cognome;

	public Dati(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome()
	{
		return nome;
	}

	public String getCognome()
	{
		return cognome;
	}

}
