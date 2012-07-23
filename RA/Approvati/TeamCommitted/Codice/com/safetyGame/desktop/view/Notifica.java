/*
 * Name: Notifica.java
 * Package: com.safetygame.desktop.view
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120608 | Gabriele Facchin    | + Notifica
 * |          |                     | + actionPerformed
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ControlNotifica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe che gestisce la grafica per la notifica di una nuova domanda
 * 
 * @author gfacchin
 * @version 0.1
 */
public class Notifica implements ActionListener{

  private JFrame frame;
  private JButton si;
  private JButton posticipa;
  private Label testo;
  private ControlNotifica controller;
  
  /**
   * Costruttore della classe Notifica
   * 
   */
  public Notifica(ControlNotifica controllore){
    controller=controllore;
    frame=new JFrame("Notifica Domanda");
    frame.setSize(300,120);
    frame.setLayout(new GridLayout(4,1));
    testo= new Label();
    testo.setText("Nuova domanda!!!!");
    frame.add(testo);
    Label vuoto=new Label();
    vuoto.setText("Vuoi rispondere?");
    frame.add(vuoto);
    si = new JButton("OK!");
    frame.add(si);
    si.addActionListener(this);
    posticipa = new JButton("no");
    frame.add(posticipa);
    posticipa.addActionListener(this);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);
  }

  /**
   * metodo che gestisce le azioni che i pulsanti devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==si)
      controller.rispondi();
    else //posticipa
      controller.posticipa();
    frame.setVisible(false);
  }
}
