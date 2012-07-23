package com.safetyGame.mobile.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.safetyGame.mobile.View.DatiActivity;

public class DatiActivityTest extends ActivityInstrumentationTestCase2<DatiActivity> {

	private DatiActivity mActivity;
	private EditText nuovaPassw;
	private EditText nuovaPassw2;
	private Button buttonOk;
	private EditText vecchiaPass;
	private TextView testo;

	public DatiActivityTest() {
		super(DatiActivity.class);
	}

	public void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(false);

		mActivity = getActivity();

		nuovaPassw =
				(EditText) mActivity.findViewById(
						com.safetyGame.mobile.R.id.nuovaPassw);
		nuovaPassw2 =
				(EditText) mActivity.findViewById(
						com.safetyGame.mobile.R.id.nuovaPassw2);
		vecchiaPass =
				(EditText) mActivity.findViewById(
						com.safetyGame.mobile.R.id.vecchiaPass);
		buttonOk = (Button) mActivity.findViewById(
				com.safetyGame.mobile.R.id.buttonInvia);

		testo = (TextView) mActivity.findViewById(
				com.safetyGame.mobile.R.id.Nome);

	}

	public void testUI() {

		mActivity.runOnUiThread(
				new Runnable() {

					public void run() {
						nuovaPassw.requestFocus();
						nuovaPassw.setText("nick");
						nuovaPassw2.requestFocus();
						nuovaPassw2.setText("pass");
						vecchiaPass.requestFocus();
						vecchiaPass.setText("pass");
						buttonOk.requestFocus();
						buttonOk.performClick();

						String testoS = testo.getText().toString();
						assertNotNull(testoS);
					}
				}
				);
	}
}
