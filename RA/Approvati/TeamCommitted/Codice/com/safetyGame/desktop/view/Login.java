/*
 * Name: Login.java
 * Package: com.safetygame.desktop.view
 * Author: Gabriele Facchin
 * Date: 2012/07/20
 * Version: 2.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120713 | Gabriele Facchin    | * Login
 * |          |                     | * actionPerformed
 * |          |                     | * isVisible
 * |          |                     | * creaSubFrameRecupero
 * +----------+---------------------+---------------------
 * | 20120609 | Gabriele Facchin    | + creaSubFrameRecupero
 * +----------+---------------------|---------------------
 * | 20120608 | Gabriele Facchin    | + Login
 * |          |                     | + actionPerformed
 * |          |                     | + isVisible
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ControlLogin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe che gestisce la grafica per il login
 * 
 * @author gfacchin
 * @version 2.0
 */
public class Login implements ActionListener{
  
  private JFrame frame;
  private JFrame frame_recupero;
  private JButton ok;
  private JButton annulla;
  private JButton okr;
  private JButton annullar;
  private JButton passdim;
  private Label userl;
  private Label passl;
  private Label errore;
  private Label errorer;
  private Label codfisl;
  private Label maill;
  private TextField mail;
  private TextField codfis;
  private TextField username;
  private JPasswordField password;
  private ControlLogin controller;
  
  /**
   * Costruttore della classe Login
   * 
   */
  public Login(ControlLogin controllore){
    controller=controllore;
    frame=new JFrame("Login");
    frame.setSize(750,200);
    frame.setLayout(new GridLayout(4,2));
    userl= new Label();
    userl.setText("Nickname:");
    frame.add(userl);
    username = new TextField();
    frame.add(username);
    passl = new Label();
    passl.setText("Password:");
    frame.add(passl);
    password = new JPasswordField();
    frame.add(password);
    ok = new JButton("OK");
    frame.add(ok);
    ok.addActionListener(this);
    annulla = new JButton("Annulla");
    frame.add(annulla);
    annulla.addActionListener(this);
    errore=new Label();
    errore.setText("");
    frame.add(errore);    
    passdim = new JButton("Password dimenticata");
    passdim.addActionListener(this);
    frame.add(passdim);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);
    
    okr = new JButton("Invia");
    okr.addActionListener(this);
    annullar=new JButton("Annulla");
    annullar.addActionListener(this);
  }

  /**
   * metodo che istanzia la grafica della sottofinestra per la richiesta di una nuova password
   * 
   */  
  private void creaSubFrameRecupero(){
    frame_recupero=new JFrame("Rigenera password");
    frame_recupero.setSize(300,200);
    frame_recupero.setLayout(new GridLayout(4,2));
    codfisl= new Label();
    codfisl.setText("Codice Fiscale:");
    codfis = new TextField();
    maill= new Label();
    maill.setText("E-mail:");
    mail = new TextField();
    errorer= new Label();
    frame_recupero.add(codfisl);
    frame_recupero.add(codfis);
    frame_recupero.add(maill);
    frame_recupero.add(mail);
    frame_recupero.add(okr);
    frame_recupero.add(annullar);
    frame_recupero.add(errorer);
    frame_recupero.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame_recupero.setVisible(true);
  }
  
  /**
   * metodo che gestisce le azioni che i pulsanti devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==ok){
      String pass= new String(password.getPassword());
      if (!username.getText().trim().equals("") && !pass.equals("")){
        boolean login=controller.tryLogin(username.getText().trim(), pass);
        if (login){
          frame.setVisible(false);
          errore.setText("");
        }
        else 
          errore.setText("I dati inseriti non sono corretti!");
      }
      else
        errore.setText("Occorre inserire username e password per accedere al sistema");
    }
    else
      if (e.getSource()==annulla)
        frame.setVisible(false);
      else 
        if (e.getSource()==passdim){
            creaSubFrameRecupero();
        }
        else
          if (e.getSource()==okr){
            if (!mail.getText().trim().equals("") && !codfis.getText().trim().equals("")){
              boolean rigenera=controller.recupera(codfis.getText().trim(), mail.getText().trim());
              frame_recupero.setVisible(false);
              if (rigenera){
                errore.setText("Nuova password generata, si prega di controllare l'email");
              }
              else
                errore.setText("Nuova password non generata, ricontrollare i dati inseriti");              
            }
            else{
              errorer.setText("Inserire entrambe i dati");
            }
          } 
          else{ 
            frame_recupero.setVisible(false);
          }      
  }
  
  /**
   * Metodo che ritorna la visibilita` del frame
   * 
   * @return boolean che indica se il frame e` visibile (true) o non visibile (false)
   */  
  public boolean isVisible(){
    return frame.isVisible();
  }
}
