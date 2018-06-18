/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Controleur.Message;
import Grille.NomTuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author deangell
 */
public class VueDeplacement extends Vue {

    private final JFrame windows;
    private final JPanel mainPanel;
    private final JComboBox<Object> listeDep;
    private final JButton btnRetour,btnBouger;
    private final JPanel panelBoutons ;

    public VueDeplacement (){

        windows = new JFrame();
        windows.setSize(450, 200);
        windows.setLocation(530,180);
        windows.setResizable(false);
        windows.setTitle("DEPLACEMENT");
        mainPanel = new JPanel(new GridLayout(3,1));

        windows.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));

        listeDep = new JComboBox<>();
        mainPanel.add(listeDep);

        panelBoutons = new JPanel(new GridLayout(2,2));
        panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        panelBoutons.add(new JLabel());
        panelBoutons.add(new JLabel());
        btnRetour = new JButton("Retour") ;
        panelBoutons.add(btnRetour); 
        btnBouger = new JButton("Se déplacer");
        panelBoutons.add(btnBouger);
       
        

        btnBouger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.VALIDERDEPLACEMENT);
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



    public JButton getBtnretour() {
        return btnRetour;
    }

    @Override
    public void setTuilesDispo(ArrayList<String> tu){
        listeDep.setModel(new DefaultComboBoxModel<>(tu.toArray()));
    }

    @Override
    public NomTuile getTuileSelectionnee(){
        NomTuile tuileTrouvee = null;
        int i  = 0;
        while(tuileTrouvee == null && i < NomTuile.values().length){
            if(NomTuile.values()[i] != null && NomTuile.values()[i].toString().equals(listeDep.getSelectedItem().toString())){
                tuileTrouvee = NomTuile.values()[i];
            }
            i++;
        }
        return tuileTrouvee;
    }

    @Override
    public void setVisible(Boolean b) {
        windows.setVisible(b);
    }

}

