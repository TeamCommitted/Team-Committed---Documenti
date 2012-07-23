package com.safetyGame.mobile.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import com.safetyGame.mobile.View.LoginActivity;

public class LoginActivtyTest extends ActivityInstrumentationTestCase2<LoginActivity> {

	private LoginActivity mActivity;
	private EditText editUser;
	private EditText editPassw;
	private Button buttonOk;

	public LoginActivtyTest() {
		super(LoginActivity.class);
	}

	public void setUp() throws Exception {
		super.setUp();

		setActivityInitialTouchMode(false);

		mActivity = getActivity();

		editUser =
				(EditText) mActivity.findViewById(
						com.safetyGame.mobile.R.id.userE);
		editPassw =
				(EditText) mActivity.findViewById(
						com.safetyGame.mobile.R.id.passwordE);
		buttonOk = (Button) mActivity.findViewById(
				com.safetyGame.mobile.R.id.button1);

	}

	public void testUI() {

		mActivity.runOnUiThread(
				new Runnable() {
					public void run() {
						editUser.requestFocus();
						editUser.setText("nick");
						editPassw.requestFocus();
						editPassw.setText("pass");
						buttonOk.requestFocus();
						buttonOk.performClick();
					}
				}
				);
	}
}
