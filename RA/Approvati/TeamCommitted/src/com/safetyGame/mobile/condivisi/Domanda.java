/*
 * Name: Domanda.java
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
 * | 20120506 |Lorenzo Braghetto | + Domanda
 * |          |                  | + getType
 * |          |                  | + getTitle
 * |          |                  | + getTesto
 * |          |                  | + getRisposte
 * +----------+------------------+---------------------
 *
 */
 
package com.safetyGame.mobile.condivisi;

public class Domanda {

	private int id;
	private String type;
	private String testo;
	private String[] risposte;
	private int punteggio;
	private int corretta;
	private int numeroRisposte;
	private int tempo;
	private boolean mobile;
	private String ambito;

	public Domanda(int id, String type, String testo, int punteggio, int corretta)
	{
		this.id = id;
		this.type = type;
		this.testo = testo;
		this.punteggio = punteggio;
		risposte = new String[3];
		risposte[0] = "si";
		risposte[1] = "no";
		risposte[1] = "-1";
		this.corretta = corretta;
	}

	public Domanda(int id, String type, String testo, String[] risposte, int numeroRisposte, int punteggio, int corretta, int tempo, boolean mobile, String ambito)
	{
		this.id = id;
		this.type = type;
		this.testo = testo;
		this.numeroRisposte = numeroRisposte;
		this.risposte = new String[numeroRisposte];
		for (int i = 0; i < numeroRisposte; i++)
		{
			this.risposte[i] = risposte[i];
		}
		this.punteggio = punteggio;
		this.corretta = corretta;
		this.mobile = mobile;
		this.tempo = tempo;
		this.ambito = ambito;
	}

	public int getId()
	{
		return id;
	}

	public String getType()
	{
		return type;
	}

	public String getTesto()
	{
		return testo;
	}

	public String[] getRisposte()
	{
		return risposte;
	}

	public int getPunteggio()
	{
		return punteggio;
	}

	public int getCorretta()
	{
		return corretta;
	}

	public int getNumR()
	{
		return numeroRisposte;
	}

	public boolean isMobile() {
		return mobile;
	}

	public int getTempo() {
		return tempo;
	}

	public String getAmbito()
	{
		return ambito;
	}
}
