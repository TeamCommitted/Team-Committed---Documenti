/*
 * Name: BootReceiver.java
 * Package: com.safetygame.android.Utils
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120506 |Lorenzo Braghetto | + onReceive
 * +----------+------------------+---------------------
 *
 */
package com.safetyGame.mobile.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.safetyGame.mobile.View.TimerNotifica;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		Intent startServiceIntent = new Intent(context, TimerNotifica.class);
		context.startService(startServiceIntent);
	}
}