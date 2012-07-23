/*
 * Name: Richiesta.java
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
 * | 20120714 | Gabriele Facchin    | + Richiesta
 * |          |                     | + actionPerformed
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ConnBack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe che gestisce la richiesta di un nuovo server
 * 
 * @author gfacchin
 * @version 1.0
 */
public class Richiesta implements ActionListener{

  private JFrame frame;
  private JButton ok;
  private Label testo;
  private TextField server;
  
  /**
   * Costruttore della classe Richiesta
   * 
   */
  public Richiesta(){
    frame=new JFrame("Nuovo Server");
    frame.setSize(675,100);
    frame.setLayout(new GridLayout(2,2));
    testo= new Label();
    testo.setText("Inserire l'indirizzo del server SafetyGame dell' Azienda: ");
    frame.add(testo);
    server=new TextField();
    frame.add(server);
    ok = new JButton("Ok");
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
      if(server.getText().trim().equals("")){
        new Error("Inserire un Server");
      }
      else{
        boolean salva=ConnBack.getInstance().continuaParser(server.getText().trim());
        if (!salva){
          new Error("Server non valido o errore nei files");
        }
        else{
          frame.setVisible(false);
          frame=null;
        }
      }
    }
  }
}
