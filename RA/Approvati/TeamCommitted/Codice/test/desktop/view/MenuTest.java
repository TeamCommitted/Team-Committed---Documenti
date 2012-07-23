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
