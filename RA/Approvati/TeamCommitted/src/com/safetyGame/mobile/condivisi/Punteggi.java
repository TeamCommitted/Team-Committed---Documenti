/*
 * Name: Punteggi.java
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
 * | 20120506 |Lorenzo Braghetto | + Punteggi
 * |          |                  | + getRispostedate
 * |          |                  | + getRispostecorrette
 * |          |                  | + getRisposteerrate
 * |          |                  | + getPunti
 * |          |                  | + getBadge
 * +----------+------------------+---------------------
 *
 */

package com.safetyGame.mobile.condivisi;
public class Punteggi {

	private String rispostedate;
	private String rispostecorrette;
	private String risposteerrate;
	private String punti;
	private String[] badges;
	private int numeroBadge;

	public Punteggi(String rispostedate, String rispostecorrette, String risposteerrate, String punti, String[] badge, int numeroBadge)
	{
		this.rispostedate = rispostedate;
		this.rispostecorrette = rispostecorrette;
		this.risposteerrate = risposteerrate;
		this.punti = punti;
		this.numeroBadge = numeroBadge;
		this.badges = new String[numeroBadge];
		for (int i = 0; i < numeroBadge; i++)
		{
			this.badges[i] = badge[i];
		}
	}

	public String getRispostedate()
	{
		return rispostedate;
	}

	public String getRispostecorrette()
	{
		return rispostecorrette;
	}

	public String getRisposteerrate()
	{
		return risposteerrate;
	}

	public String getPunti()
	{
		return punti;
	}

	public String[] getBadge()
	{
		return badges;
	}

	public int getNumeroBadge()
	{
		return numeroBadge;
	}
}
