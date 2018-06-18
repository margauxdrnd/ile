
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import Aventurier.Aventurier;
import Aventurier.Ingenieur;
import Controleur.Message;
import Grille.NomTuile;


public class VueAssechement extends Vue {

    private final JFrame fenetre;
    private final JPanel mainPanel;
    private final JLabel labelAssech,labelAssechIngenieur;
    private final JButton btnRetour;
    private final JButton btnAssecher;
    private final JComboBox<Object> listeAssech,listeAssechIngenieur;

    public VueAssechement (){

        // Création de la fenêtre d'assèchement
        
        this.fenetre = new JFrame();
        fenetre.setTitle("ASSECHEMENT");
        fenetre.setSize(450, 200);
        fenetre.setLocation(530,180);
        
        mainPanel = new JPanel(new GridLayout(3,2));
        fenetre.add(mainPanel);

        //Liste déroulante des assèchements possibles
        labelAssech = new JLabel ("Tuile à assécher :");
        mainPanel.add(labelAssech);
        listeAssech = new JComboBox<>();
        mainPanel.add(listeAssech);
        
        labelAssechIngenieur = new JLabel ("Deuxième tuile à assécher :");
        mainPanel.add(labelAssechIngenieur);
        listeAssechIngenieur = new JComboBox<>();
        mainPanel.add(listeAssechIngenieur);
        

        btnRetour = new JButton("Retour");
        btnRetour.setOpaque(false);
        btnAssecher = new JButton("Assécher");
        btnAssecher.setOpaque(false);

        btnRetour.add(new JLabel());
        btnAssecher.add(new JLabel());
        mainPanel.add(btnRetour);
        mainPanel.add(btnAssecher);

        fenetre.setResizable(false);

        /* ACTION LISTENERS */
        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.VALIDERASSECHEMENT);
                clearChanged();
            }
        });

        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ANNULER);
                clearChanged();
            }
        });

    }
    
    public JButton getBtnRetour() {
        return btnRetour;
    }

    public JButton getBtnAssecher() {
        return btnAssecher;
    }




    public static void main(String [] args) {
        // Instanciation de la fenêtre
        VueAssechement vueass = new VueAssechement();
    }

    @Override
    public void setVisible(Boolean b) {
        fenetre.setVisible(b);
    }

    @Override
    public NomTuile getTuileSelectionnee(){
        if(listeAssech.getSelectedItem() != null) {
            NomTuile nomTuileTrouvee = null;
            int i = 0;
            while (nomTuileTrouvee == null && i < NomTuile.values().length) {
                if (NomTuile.values()[i].toString().equals(listeAssech.getSelectedItem().toString())) {
                    nomTuileTrouvee = NomTuile.values()[i];
                }
                i++;
            }
            return nomTuileTrouvee;
        } else {
            return null;
        }
    }
    
    public NomTuile getTuileSelectionneeIng(){
  
            NomTuile nomTuileTrouvee = null;
            int i = 0;
            while (nomTuileTrouvee == null && i < NomTuile.values().length) {
                if (NomTuile.values()[i].toString().equals(listeAssechIngenieur.getSelectedItem().toString())) {
                    nomTuileTrouvee = NomTuile.values()[i];
                }
                i++;
            }
            return nomTuileTrouvee;
        
    }



    @Override
    public void setTuilesAss(ArrayList<String> tu,Aventurier a){
        listeAssech.setModel(new DefaultComboBoxModel<>(tu.toArray()));
        if(a.getClass() == Ingenieur.class){
            listeAssechIngenieur.setModel(new DefaultComboBoxModel<>(tu.toArray()));
            labelAssechIngenieur.setVisible(true);
            listeAssechIngenieur.setVisible(true);
        }else{
            labelAssechIngenieur.setVisible(false);
            listeAssechIngenieur.setVisible(false);
        }
    }
}
