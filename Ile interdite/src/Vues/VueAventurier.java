package Vues;

import Controleur.Message;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;


public class VueAventurier extends Vue {
     
    private final JFrame fenetre;
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger,btnAssecher,btnFinTour,btnvide;
    private JLabel position;
   
   
   
    
    public VueAventurier(String nomJoueur, String nomAventurier, Color couleur, int index){

        this.fenetre = new JFrame();
        fenetre.setSize(500, 300);
        fenetre.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.fenetre.add(mainPanel);
        fenetre.setResizable(false);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;


        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);

        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);


        
        panelCentre.add(new JLabel ("Position actuelle : ", SwingConstants.CENTER));
        position = new  JLabel(); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);

        this.panelBoutons = new JPanel(new GridLayout(2,4));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.EAST);

        this.btnBouger = new JButton("Se déplacer") ;
        this.btnAssecher = new JButton( "Assécher");
        this.btnFinTour = new JButton("Passer son tour") ;
        this.btnvide = new JButton();

        btnBouger.setEnabled(false);
        btnAssecher.setEnabled(false);
        btnFinTour.setEnabled(false);
        btnvide.setEnabled(false);
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnFinTour);
        this.panelBoutons.add(btnvide);


        btnBouger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.DEPLACER);
                clearChanged();
            }
        });

        btnAssecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.ASSECHER);
                clearChanged();
            }
        });


        btnFinTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Message.FINTOUR);
                clearChanged();
            }
        });

    }


    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
    
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnFinTour;
    }

      
    public void setLabel(String label){
        this.getLabel().setText(label);
    }
    
    public JLabel getLabel(){
        return this.position;
    }
    


    @Override
    public void setVisible(Boolean b) {
        fenetre.setVisible(b);
    }
}
