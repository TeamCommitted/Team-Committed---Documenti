/*
 * Name: Error.java
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
 * | 20120716 | Gabriele Facchin    | + Error
 * |          |                     | + actionPerformed
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe che fa uscire un popup di errore.
 * 
 * @author gfacchin
 * @version 1.0
 */
public class Error implements ActionListener{
  private JFrame frame;
  private JButton ok;
  private Label err;

  /**
   * Costruttore della classe Error
   * 
   * @param errore descrizione errore
   */
  public Error(String errore){
    frame=new JFrame("Errore");
    frame.setSize(150,70);
    frame.setLayout(new GridLayout(1,2));
    err = new Label();
    err.setText(errore);
    frame.add(err);
    ok = new JButton("OK");
    frame.add(ok);
    ok.addActionListener(this);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);
  }
  
  /**
   * metodo che gestisce le azioni che i pulsanti devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==ok){
      frame.setVisible(false);
    }
  }
}
