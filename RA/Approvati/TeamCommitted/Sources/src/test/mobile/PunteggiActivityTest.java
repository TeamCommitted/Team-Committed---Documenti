package com.safetyGame.mobile.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.safetyGame.mobile.View.DomandaActivity;

public class PunteggiActivityTest extends ActivityInstrumentationTestCase2<DomandaActivity> {

	private DomandaActivity mActivity;
	private TextView testoRisposte;

	public PunteggiActivityTest() {
		super(DomandaActivity.class);
	}

	public void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(false);

		mActivity = getActivity();

		testoRisposte = (TextView) mActivity.findViewById(
				com.safetyGame.mobile.R.id.Punti);

	}

	public void testUI() {

		mActivity.runOnUiThread(
				new Runnable() {
					public void run() {
						String testo = testoRisposte.getText().toString();
						assertNotNull(testo);
					}
				}
				);
	}
}
