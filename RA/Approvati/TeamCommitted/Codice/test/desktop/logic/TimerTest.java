package com.safetyGame.desktop.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerTest {

	private Timer timer;
	private void init() {
	  timer =  new Timer(5000,0);
	}
	@Test
	public void runTest() {
	  init();
	  timer.start();
	  while (!timer.isFinito()){System.out.println("sono dentro");}
	  System.out.println("fatto");
	  assertTrue("il conteggio non e' finito",timer.isFinito()==false);
	}

}
