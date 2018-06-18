/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Grille.Grille;
import Tresor.Tresor;
import static Utils.Utils.EtatTuile.ASSECHEE;
import static Utils.Utils.EtatTuile.INONDEE;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author deangell
 */
public class VueJeu {
    
    private final JFrame window;
    private Tresor tresor;
    
    private HashMap<Integer,JPanel> cases=new HashMap();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public VueJeu(Grille grille) {
        this.window = new JFrame();
        window.setSize(1670, 980);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Grille (gauche)
        JPanel panelGrille = new JPanel(new GridLayout(6, 6));
        mainPanel.add(panelGrille,BorderLayout.WEST);
        
        for (int i=0; i<36; i++) {
             panelGrille.add(createCellule(i, grille));
        }
        
        //Panel droit : 4 joueurs
        JPanel panelJoueurs = new JPanel(new GridLayout(4,1));
        panelJoueurs.add(mainPanel,BorderLayout.EAST);
        
        //Joueur un
        JPanel panelUn = new JPanel(new BorderLayout());
        mainPanel.add(panelUn);
        panelUn.setBorder(BorderFactory.createTitledBorder("Joueur 1"));
        
        
        
        
        
        
        
        /**************************/
        window.add(mainPanel);
        window.setResizable(false);
    }
            public void updateCellules(Grille grilleListe) {

        for (int i=0; i<36; i++) {
            JPanel panel = cases.get(i);
            if (!(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 ||
               i==24 || i==29|| i==30 || i==31 | i==34 || i==35)){
                if (grilleListe.getTuile().get(i).getEtat() == ASSECHEE ) {
                        panel.setBackground(new Color(154,117,69));
                    } else if (grilleListe.getTuile().get(i).getEtat()== INONDEE) {
                        panel.setBackground(new Color(13,98,134));
                    
                    } else {
                        panel.setBackground(new Color(82,87,89));
                    }
                panel.repaint();
            }
        }
    }
 
        
    public JPanel createCellule(int i, Grille grilleListe) {        

        if(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 ||
           i==24 || i==29|| i==30 || i==31 | i==34 || i==35) {   
                JPanel panelCellule = new JPanel();
                panelCellule.setBackground(Color.WHITE);
                panelCellule.setSize(100,100);
                return panelCellule ;
        }
            else {
                JLabel nomCase = new JLabel(grilleListe.getTuile().get(i).getNom().toString(), SwingConstants.CENTER);
                JPanel panelCellule = new JPanel(new BorderLayout());
                panelCellule.setBorder(BorderFactory.createLineBorder(Color.white, 1));
                nomCase.setForeground(new Color(255,255,255));
                 panelCellule.add(nomCase);
            
            
            panelCellule.setSize(100,100);
            cases.put(i, panelCellule);
            return panelCellule ;
        }
    }

    public void setVisible(boolean b) {
        window.setVisible(b);
    }    
        
}
