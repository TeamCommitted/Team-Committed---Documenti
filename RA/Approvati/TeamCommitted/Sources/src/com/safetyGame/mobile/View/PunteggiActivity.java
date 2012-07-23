/*
 * Name: PunteggiActivity.java
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
 * |          |                  | + PunteggiTask
 * | 20120502 |Lorenzo Braghetto | + onCreate
 * |          |                  | + onOptionsItemSelected
 * +----------+------------------+---------------------
 *
 */
package com.safetyGame.mobile.View;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.safetyGame.mobile.R;
import com.safetyGame.mobile.Utils.ConnectionUtils;
import com.safetyGame.mobile.condivisi.Punteggi;

public class PunteggiActivity extends SherlockActivity {

	private Context context;
	private String serverUrl;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;
		SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

		serverUrl = prefs.getString("server", "");

		new PunteggiTask().execute();
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

	private class PunteggiTask extends AsyncTask<Object, String, Punteggi> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(PunteggiActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Punteggi doInBackground(Object... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

			nameValuePairs.add(new BasicNameValuePair("username",
					prefs.getString("user", "")));
			nameValuePairs.add(new BasicNameValuePair("password",
					prefs.getString("password", "")));
			Punteggi punteggi = (Punteggi) ConnectionUtils
					.HttpCreateClient(
							serverUrl + "/API/punteggi.jsp",
							nameValuePairs);

			return punteggi;
		}

		@Override
		protected void onPostExecute(Punteggi punteggi) {
			dialog.dismiss();
			if (punteggi != null) {
				setContentView(R.layout.punteggi);

				((TextView) findViewById(R.id.Punti)).setText("Risposte date "
						+ punteggi.getRispostedate() + "\nRisposte corrette "
						+ punteggi.getRispostecorrette() + "\nRisposte errate "
						+ punteggi.getRisposteerrate() + "\nPunti "
						+ punteggi.getPunti());
				String[] badges = punteggi.getBadge();
				if (punteggi.getNumeroBadge() > 0)
					((TextView) findViewById(R.id.Badge1)).setText(badges[0]);
				else
					((ImageView) findViewById(R.id.imageView1)).setVisibility(8);
				if (punteggi.getNumeroBadge() > 1)
					((TextView) findViewById(R.id.Badge2)).setText(badges[1]);
				else
					((ImageView) findViewById(R.id.imageView2)).setVisibility(8);
			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Errore");
				builder.setMessage("C'è stato qualche problema nel download della domanda");
				builder.show();
			}
		}

	}

}