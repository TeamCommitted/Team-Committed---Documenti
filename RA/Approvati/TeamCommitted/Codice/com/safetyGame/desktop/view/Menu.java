/*
 * Name: Menu.java
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
 * | 20120715 | Gabriele Facchin    | + Main
 * +----------+---------------------|---------------------
 * | 20120609 | Gabriele Facchin    | + Menu
 * |          |                     | + svuota
 * |          |                     | + creaMenu
 * |          |                     | + finalize
 * |          |                     | + actionPerformed
 * +----------+---------------------|---------------------
 * 
 * 
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ControlMenu;
import com.safetyGame.desktop.logic.ControlLogin;
import com.safetyGame.desktop.logic.ControlNotifica;
import com.safetyGame.desktop.logic.ConnBack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.SystemTray.*;
import java.awt.TrayIcon.*;

/**
 * Classe che gestisce la grafica dell'icona e le interazioni tra le altre componenti grafiche. 
 * 
 * @author gfacchin
 * @version 2.0
 */
public class Menu implements ActionListener{
  private boolean loggato=false;
  private ControlMenu control;
  private SystemTray tray;
  private TrayIcon icon;
  private JPopupMenu menu;
  private JMenuItem login;
  private JMenuItem richiedi_domanda;
  private JMenuItem visualizza_punteggio;
  private JMenuItem visualizza_dati;
  private JMenuItem modifica_dati;
  private JMenuItem logout;
  private JMenuItem nascondi;
  private MouseEvent old;

  /**
   * Costruttore della classe Menu
   * @param controllo riferimento all'oggetto di tipo ControlMenu
   */
  public Menu(ControlMenu controllo){
    control =controllo;
    try{
      tray=SystemTray.getSystemTray();
      Image img=Toolkit.getDefaultToolkit().getImage("com/safetyGame/desktop/view/icona.jpg");
      icon=new TrayIcon(img);
      tray.add(icon);
      richiedi_domanda= new JMenuItem("Chiedi Domanda");
      visualizza_punteggio= new JMenuItem("Visualizza il tuo punteggio");
      visualizza_dati= new JMenuItem("Visualizza i tuoi dati");
      modifica_dati= new JMenuItem("Modifica i tuoi dati");
      logout= new JMenuItem("Logout");
      login = new JMenuItem("Login");
      nascondi= new JMenuItem("nascondi");
      nascondi.addActionListener(this);
      login.addActionListener(this);
      richiedi_domanda.addActionListener(this);
      visualizza_punteggio.addActionListener(this);
      visualizza_dati.addActionListener(this);
      modifica_dati.addActionListener(this);
      logout.addActionListener(this);
      menu= new JPopupMenu();
      icon.addMouseListener(new MouseAdapter()
      
      {
        public void mouseClicked(MouseEvent e){
          creaMenu();
          menu.addFocusListener(new FocusAdapter()
          {
            public void focusLost(FocusEvent e){}
          });
          if (e.getButton()==3){
              menu.show(e.getComponent(), e.getX(), e.getY());
          }
        }
      });
    }
    catch(UnsupportedOperationException e){System.out.println("Le funzionalità minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
    catch(AWTException e){System.out.println("Le funzionalità minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
  }
  
  /**
   * metodo che svuota il menu
   * 
   */
  private void svuota(){
      for (int i=0;i<menu.getComponentCount();i++){
      menu.remove(1); //rimuove il componenete in posizione i
    }
    menu.setVisible(false);
    menu=new JPopupMenu();
  }
 
  /**
   * metodo che istanza correttamente il menu, a seconda che il dipendente sia o meno loggato
   * 
   */
  private void creaMenu(){
    svuota();
    boolean b=control.isLogged();
    if (b){
      menu.add(richiedi_domanda);
      menu.add(visualizza_punteggio);
      menu.add(visualizza_dati);
      menu.add(modifica_dati);
      menu.add(logout);
    }
    else{
      menu.add(login);
    }
    menu.add(nascondi);
  }
  
  /**
   * metodo che dealloca la SystemTray e chiude l'applicazione in modo corretto
   * 
   */
  public void finalize(){
    tray.getSystemTray().remove(icon);
    System.exit(0);
  }
  
  /**
   * metodo che gestisce le azioni che i menu devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==login){
      Login l = new Login(new ControlLogin());
      menu.setVisible(false);
    }
    else
      if (e.getSource()==nascondi){
        menu.setVisible(false);
      }
      else 
        if(e.getSource()==richiedi_domanda){
          control.richiediDomanda();
          menu.setVisible(false);
        }
        else
          if(e.getSource()==visualizza_punteggio){
            control.visualizzaPunteggio();
            menu.setVisible(false);
          }
          else 
            if(e.getSource()==visualizza_dati){
              control.visualizzaDati();
              menu.setVisible(false);
            }
            else
             if(e.getSource()==modifica_dati){
               control.modificaDati();
               menu.setVisible(false);
             }
             else{ //logout
               control.logout();
               menu.setVisible(false);
             }
  }
  
  /**
   * Metodo che inizializza il front end
   * @param args parametri passati dalla JVM all'invocazione del metodo
   */
  public static void main (String args []){
     new Menu(new ControlMenu());
  }
}
