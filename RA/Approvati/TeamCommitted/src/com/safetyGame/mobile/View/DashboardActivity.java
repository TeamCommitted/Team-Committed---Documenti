/*
 * Name: DashboardActivity.java
 * Package: com.safetygame.android.View
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120502 |Lorenzo Braghetto | + onCreate
 * +----------+------------------+---------------------
 *
 */
package com.safetyGame.mobile.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.safetyGame.mobile.R;

public class DashboardActivity extends SherlockActivity {

	private Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		context = getApplicationContext();

		Intent startServiceIntent = new Intent(context, TimerNotifica.class);
		context.startService(startServiceIntent);

		Button Domanda = (Button) findViewById(R.id.Domanda);
		Button Punteggi = (Button) findViewById(R.id.Punteggi);
		Button Dati = (Button) findViewById(R.id.Dati);

		Domanda.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent domanda = new Intent(context, DomandaActivity.class);
				domanda.putExtra("Domanda", true);
				startActivity(domanda);
			}

		});

		Dati.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent dati = new Intent(context, DatiActivity.class);
				startActivity(dati);
			}

		});

		Punteggi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent punteggi = new Intent(context, PunteggiActivity.class);
				startActivity(punteggi);
			}

		});

	}

}