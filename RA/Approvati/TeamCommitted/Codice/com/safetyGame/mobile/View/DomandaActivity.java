/*
 * Name: DomandaActivity.java
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
 * | 20120506 |Lorenzo Braghetto | * onCreate
 * |          |                  | + DomandaTask
 * | 20120502 |Lorenzo Braghetto | + onCreate
 * |          |                  | + onOptionsItemSelected
 * +----------+------------------+---------------------
 *
 */
package com.safetyGame.mobile.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.safetyGame.mobile.R;
import com.safetyGame.mobile.Utils.ConnectionUtils;
import com.safetyGame.mobile.Utils.IntentIntegrator;
import com.safetyGame.mobile.Utils.IntentResult;
import com.safetyGame.mobile.condivisi.Domanda;

public class DomandaActivity extends SherlockActivity {

	private Context context;
	private Domanda domanda;
	private Timer myTimer;
	private int i;
	public TextView timer;
	private String serverUrl;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;
		SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

		serverUrl = prefs.getString("server", "");
		long data = prefs.getLong("data", 0);
		long time = System.currentTimeMillis();
		if (time - data > 30000)
		{
			i = 0;
			new DomandaTask().execute();
			prefs.edit().putLong("data", time).commit();
		} else
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setTitle("Errore");
			builder.setMessage("Devi aspettare prima di richiedere una nuova domanda");
			builder.show();
		}

	}

	private class DomandaTask extends AsyncTask<Object, String, Domanda> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DomandaActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Domanda doInBackground(Object... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

			nameValuePairs.add(new BasicNameValuePair("username",
					prefs.getString("user", "")));
			nameValuePairs.add(new BasicNameValuePair("password",
					prefs.getString("password", "")));
			domanda = (Domanda) ConnectionUtils
					.HttpCreateClient(
							serverUrl + "/API/domanda.jsp",
							nameValuePairs);

			return domanda;
		}

		@Override
		protected void onPostExecute(final Domanda domanda) {
			dialog.dismiss();
			if (domanda != null) {
				if (domanda.getType().equals("sino")) {
					setContentView(R.layout.domanda_sino);
					((TextView) findViewById(R.id.Testo)).setText(domanda
							.getTesto());

					Button invia = (Button) findViewById(R.id.buttonsi);
					invia.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							String[] params = { "0" };
							new RispostaTask().execute(params);
						}

					});
					Button inviaNo = (Button) findViewById(R.id.buttonno);
					inviaNo.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							String[] params = { "1" };

							new RispostaTask().execute(params);
						}

					});
				} else if (domanda.isMobile())
				{
					setContentView(R.layout.quest);
					timer = (TextView) findViewById(R.id.timer);
					Button scan = (Button) findViewById(R.id.scanna);
					scan.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							IntentIntegrator integrator = new IntentIntegrator(
									DomandaActivity.this);
							integrator.initiateScan();
						}
					});
					((TextView) findViewById(R.id.Titolo))
							.setText(domanda.getTesto());

					myTimer = new Timer();
					myTimer.schedule(new TimerTask() {
						@Override
						public void run() {
							TimerMethod();
						}

					}, 0, 1000);

				} else {

					setContentView(R.layout.domanda_rispostamultipla);
					((TextView) findViewById(R.id.Testo)).setText(domanda
							.getTesto());
					final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
					String[] risposte = domanda.getRisposte();
					((RadioButton) findViewById(R.id.radio0))
							.setText(risposte[0]);
					((RadioButton) findViewById(R.id.radio1))
							.setText(risposte[1]);
					if (domanda.getNumR() > 2)
						((RadioButton) findViewById(R.id.radio2))
								.setText(risposte[2]);
					else
						((RadioButton) findViewById(R.id.radio2)).setVisibility(8);

					Button invia = (Button) findViewById(R.id.button2);
					invia.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							int checked = -1;
							int checkeId = rg.getCheckedRadioButtonId();
							if (checkeId == R.id.radio0)
								checked = 0;
							else if (checkeId == R.id.radio1)
								checked = 1;
							else
								checked = 2;
							String[] params = { checked + "" };
							new RispostaTask().execute(params);
						}

					});
				}

			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Errore");
				builder.setMessage("C'è stato qualche problema nel download della domanda");
				builder.show();
			}
		}
	}

	private void TimerMethod()
	{
		this.runOnUiThread(Timer_Tick);
	}

	private Runnable Timer_Tick = new Runnable() {
		public void run() {

			timer.setText(i++ + "");
		}
	};

	private class RispostaTask extends AsyncTask<String, String, Void> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DomandaActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Void doInBackground(String... arg0) {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

			nameValuePairs.add(new BasicNameValuePair("username",
					prefs.getString("user", "")));
			nameValuePairs.add(new BasicNameValuePair("password",
					prefs.getString("password", "")));
			nameValuePairs.add(new BasicNameValuePair("id", domanda.getId() + ""));
			nameValuePairs.add(new BasicNameValuePair("punti", domanda.getPunteggio() + ""));

			nameValuePairs.add(new BasicNameValuePair("corretta", domanda.getCorretta() + ""));
			if (domanda.isMobile())
			{
				if (arg0[0].equals(domanda.getRisposte()[0]) && i < domanda.getTempo())
					nameValuePairs.add(new BasicNameValuePair("rispostaData", domanda.getCorretta() + ""));
				else
					nameValuePairs.add(new BasicNameValuePair("rispostaData", "-1"));
			}
			else
				nameValuePairs.add(new BasicNameValuePair("rispostaData", arg0[0]));
			nameValuePairs.add(new BasicNameValuePair("ambito", domanda.getAmbito()));
			ConnectionUtils
					.HttpCreateClient(
							serverUrl + "/API/rispondi.jsp",
							nameValuePairs);
			return null;
		}

		@Override
		protected void onPostExecute(Void arg0) {
			dialog.dismiss();
			finish();
		}
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult scanResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
		if (scanResult != null) {
			String[] params = { scanResult.getContents() };

			new RispostaTask().execute(params);
		}
		// else continue with any other code you need in the method
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// app icon in action bar clicked; go home
			Intent intent = new Intent(this, DashboardActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}