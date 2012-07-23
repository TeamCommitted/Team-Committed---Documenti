package com.safetyGame.mobile.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.safetyGame.mobile.View.DomandaActivity;

public class DomandaActivityTest extends ActivityInstrumentationTestCase2<DomandaActivity> {

	private DomandaActivity mActivity;
	private TextView testo;
	private Button buttonInvia;

	public DomandaActivityTest() {
		super(DomandaActivity.class);
	}

	public void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(false);

		mActivity = getActivity();

		testo = (TextView) mActivity.findViewById(
				com.safetyGame.mobile.R.id.Testo);
		buttonInvia = (Button) mActivity.findViewById(
				com.safetyGame.mobile.R.id.button2);
	}

	public void testUI() {

		mActivity.runOnUiThread(
				new Runnable() {
					public void run() {
						if (testo != null)
						{
							buttonInvia.requestFocus();
							buttonInvia.performClick();
							String testoS = testo.getText().toString();
							assertNotNull(testoS);
						}
					}
				}
				);
	}
}
