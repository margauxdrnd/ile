package Vues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import Controleur.Message;


public class VueInscription extends Vue {

    private final JFrame window;

    private JLabel labelTitre, labelpseudoJ1, labelpseudoJ2, labelpseudoJ3, labelpseudoJ4;
    private JRadioButton deuxJoueurs, troisJoueurs, quatreJoueurs;
    private HashMap<Integer, JRadioButton> btnsJoueurs;
    private JButton btnValider, btnAnnuler;
    private ButtonGroup groupeJoueurs;

    private JPanel mainPanel, panelHaut, panelPied, panelCentre, panelCentreHaut, panelCentreCentre;
    private JTextField pseudoJoueurs[];


    public VueInscription(){

        /* INITIALISATION DE L'IHM */

        window = new JFrame();
        window.setTitle("ÎLE INTERDITE");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocationRelativeTo(null);
        mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);
        window.setResizable(false);

        panelHaut = new JPanel();
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        labelTitre = new JLabel("INSCRIPTION", SwingConstants.CENTER);
        panelHaut.add(labelTitre);

        panelCentre=new JPanel(new GridLayout(3,1,0,20));
        panelCentreHaut=new JPanel(new GridLayout(1,3));
        panelCentreCentre=new JPanel(new GridLayout(4,1));

        TitledBorder borderNombreJoueurs= BorderFactory.createTitledBorder("Nombre de Joueurs");
        panelCentreHaut.setBorder(borderNombreJoueurs);

        TitledBorder borderNomsJoueurs= BorderFactory.createTitledBorder("Pseudo des Joueurs");
        panelCentreCentre.setBorder(borderNomsJoueurs);

        mainPanel.add(panelCentre,BorderLayout.CENTER);
        panelCentre.add(panelCentreHaut);
        panelCentre.add(panelCentreCentre);

        groupeJoueurs = new ButtonGroup();
        btnsJoueurs = new HashMap<>();

        deuxJoueurs = new JRadioButton("2");
        panelCentreHaut.add(deuxJoueurs);
        btnsJoueurs.put(btnsJoueurs.size(), deuxJoueurs);
        groupeJoueurs.add(deuxJoueurs);

        troisJoueurs = new JRadioButton("3");
        panelCentreHaut.add(troisJoueurs);
        btnsJoueurs.put(btnsJoueurs.size(), troisJoueurs);
        groupeJoueurs.add(troisJoueurs);

        quatreJoueurs = new JRadioButton("4");
        panelCentreHaut.add(quatreJoueurs);
        btnsJoueurs.put(btnsJoueurs.size(), quatreJoueurs);
        groupeJoueurs.add(quatreJoueurs);


        labelpseudoJ1 = new JLabel("Joueur 1");
        labelpseudoJ2 = new JLabel("Joueur 2");
        labelpseudoJ3 = new JLabel("Joueur 3");
        labelpseudoJ4 = new JLabel("Joueur 4");

        pseudoJoueurs = new JTextField[4];
        for(int i = 0; i < 4; i++){
            pseudoJoueurs[i] = new JTextField();
        }

        panelCentreCentre.add(labelpseudoJ1);
        panelCentreCentre.add(pseudoJoueurs[0]);


        panelCentreCentre.add(labelpseudoJ2);
        panelCentreCentre.add(pseudoJoueurs[1]);

        panelCentreCentre.add(labelpseudoJ3);
        panelCentreCentre.add(pseudoJoueurs[2]);

        panelCentreCentre.add(labelpseudoJ4);
        panelCentreCentre.add(pseudoJoueurs[3]);

        /* PANEL BAS */
        panelPied=new JPanel();
        mainPanel.add(panelPied, BorderLayout.SOUTH);

        btnAnnuler=new JButton("Annuler");
        panelPied.add(btnAnnuler);
        btnAnnuler.addActionListener(new ActionListener() {         // Creation du bouton pour fermer le jeu
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ANNULER);                   // Action réalisée par ce bouton : fermer la fenêtre
                clearChanged();
            }
        });
   
        btnValider=new JButton("Jouer");
        panelPied.add(btnValider);
        btnValider.addActionListener(new ActionListener() {     //Creation du bouton pour jouer
            @Override
            public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Message.LANCERPARTIE);      // Action réalisée par ce bouton : ouvrir les noouvelles fenêtres
                    clearChanged();                             // --> grille + 1 fenêtre d'actions par joueur
            }
        });

    }
        
    @Override
    public void setVisible(Boolean b) {
        window.setVisible(b);
    }

    

}