/*
 * Name: MenuTest.java
 * Package: com.safetygame.desktop.view
 * Author: Gabriele Facchin
 * Date: 2012/07/20
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120716 | Alessandro Cornaglia| + testMenu
 * +----------+---------------------|---------------------
 *
 */
package com.safetyGame.desktop.view;

import static org.junit.Assert.*;

import org.junit.Test;

import com.safetyGame.desktop.logic.ControlMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.SystemTray.*;
import java.awt.TrayIcon.*;

public class MenuTest {

	@Test
	public void testMenu() {
	  ControlMenu controlMenu = new ControlMenu();
	  Menu menu = new Menu(controlMenu);
	  while(true){System.out.println("");}
	}

}
