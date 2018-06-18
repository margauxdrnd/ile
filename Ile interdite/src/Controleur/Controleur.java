/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Grille.Grille;
import Grille.NomTuile;
import Aventurier.Ingenieur;
import Aventurier.Plongeur;
import Aventurier.Explorateur;
import Aventurier.Pilote;
import Aventurier.Aventurier;
import static Tresor.NomTresor.*;
import Tresor.Tresor;
import Utils.Parameters;
import Utils.Utils.*;
import Vues.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import static Utils.Utils.EtatTuile.*;



/**
 *
 * @author deangell
 */
public class Controleur implements Observer {

    private int joueurCourant = 0;
    private int nbActions = 0;
    private boolean finTour = false;
    private boolean finTourPlateau = false;
    private boolean inscriptionFini = false;
    private ArrayList<VueAventurier> vuesAventurier = new ArrayList<>();
    private ArrayList<Aventurier> aventuriers = new ArrayList<>();
    private ArrayList<Vue>vues = new ArrayList<>();
    Grille grille = new Grille();
    private Tresor caliceT = new Tresor(calice,grille);
    private Tresor pierreT = new Tresor(pierre,grille);
    private Tresor zephyrT = new Tresor(zephyr,grille);
    private Tresor cristalT = new Tresor(cristal,grille);
    private VueJeu vueAvTest = new VueJeu(grille);

    
    public Controleur(){
        if (Parameters.LOGS) System.out.println("Le jeu commence");

        //Création des vues
        VueInscription vueInscription = new VueInscription();
        VueDeplacement vueDeplacement = new VueDeplacement();
        VueAssechement vueAssechement = new VueAssechement();

        addView(vueInscription);
        addView(vueDeplacement);
        addView(vueAssechement);
        vueInscription.setVisible(true);


    }

    public void addView(Vue vue){
        vue.abonner(this);
        vues.add(vue);
    }

    public void addViewAventurier(VueAventurier vue){
        vue.abonner(this);
        vuesAventurier.add(vue);
    }

    public void lancerPartie(){

            int jCourantBU = joueurCourant;
            for(int i =0; i<aventuriers.size();i++){
                joueurCourant = i;
            }
            joueurCourant = jCourantBU;
            
        for (int i =0; i < vuesAventurier.size(); i++){
            vuesAventurier.get(i).setVisible(true);
            activerBtn(joueurCourant%aventuriers.size());
            
        }
        vueAvTest.updateCellules(grille);
        vueAvTest.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg){
        
        /* Inscription de joueurs : afin de simplement tester le déplacement et l'assèchement,
        nous avons inscrit automatiquement 4 joueurs
        et nous leur avons attribué une spécificité
        */
        
        if (arg == Message.LANCERPARTIE){
            
            // Ajout d'un explorateur
            Aventurier explorateur = new Explorateur("Seb",this.getGrille().getTuile(NomTuile.LA_PORTE_DE_CUIVRE));
            aventuriers.add(explorateur);
            VueAventurier vueAventurier5 = new VueAventurier("Seb", "Explorateur", Pion.VERT.getCouleur(), aventuriers.size()-1);
            addViewAventurier(vueAventurier5);
            
            // Ajout d'un pilote
            Aventurier pilote = new Pilote("Simon",this.getGrille().getTuile(NomTuile.HELIPORT));
            aventuriers.add(pilote); 
            VueAventurier vueAventurier4 = new VueAventurier("Simon", "Pilote", Pion.BLEU.getCouleur(), aventuriers.size()-1);
            addViewAventurier(vueAventurier4); 
            
            //Ajout d'un plongeur
            Aventurier plongeur = new Plongeur("Loick",this.getGrille().getTuile(NomTuile.LA_PORTE_DE_FER));
            aventuriers.add(plongeur);
            VueAventurier vueAventurier6 = new VueAventurier("Loick", "Plongeur", Pion.VIOLET.getCouleur(), aventuriers.size()-1);
            addViewAventurier(vueAventurier6);     
            
            //Ajout d'un ingénieur
            Aventurier ingenieur = new Ingenieur("Margaux",this.getGrille().getTuile(NomTuile.LA_PORTE_DE_BRONZE));
            aventuriers.add(ingenieur);
            VueAventurier vueAventurier2 = new VueAventurier("Margaux", "Ingenieur", Pion.ROUGE.getCouleur(), aventuriers.size()-1);
            addViewAventurier(vueAventurier2);
            
            ((VueInscription) o).setVisible(false);
            inscriptionFini = true;
            lancerPartie();
        }

        /* ACTIONS DES AVENTURIERS */


        if(arg == Message.DEPLACER){
            vues.get(1).setTuilesDispo(getJoueurCourant().getCasesPossibles(this.grille));
            vues.get(1).setVisible(true);

        }

        //Vue déplacement

        if(arg == Message.VALIDERDEPLACEMENT){
             if(((Vue) o).getTuileSelectionnee() != null){
                getJoueurCourant().setPosition(getGrille().getTuile(((Vue) o).getTuileSelectionnee()));
                if(getJoueurCourant().getClass() == Pilote.class){
                    getJoueurCourant().setDeplacementSpecial(true);
                    if(getJoueurCourant().getCasesPossibles(grille).contains(getJoueurCourant().getPositionAnterieure())){
                        getJoueurCourant().setDeplacementSpecial(false);
                    }
                }
                vues.get(1).setVisible(false);
                nbActions++;
                vuesAventurier.get(joueurCourant%aventuriers.size()).setLabel(getJoueurCourant().getPosition().toString());
                activerBtn(joueurCourant%aventuriers.size());
            }
        }else if(arg == Message.ANNULER){
            ((Vue) o).setVisible(false);
        }

        // Vue Assèchement

        if(arg == Message.ASSECHER){
            vues.get(2).setTuilesAss(getJoueurCourant().getCasesAssechements(this.grille),getJoueurCourant());
            vues.get(2).setVisible(true);
        }

        if(arg == Message.VALIDERASSECHEMENT){
             if(((Vue) o).getTuileSelectionnee() != null){
                getGrille().getTuile(((Vue) o).getTuileSelectionnee()).setEtat(ASSECHEE);
                if(getJoueurCourant().getClass() == Ingenieur.class && getGrille().getTuile(((Vue) o).getTuileSelectionneeIng())!=null){
                    getGrille().getTuile(((Vue) o).getTuileSelectionneeIng()).setEtat(ASSECHEE);
                }
                vues.get(2).setVisible(false);
                vueAvTest.updateCellules(grille);
                nbActions++;
            }
        }else if(arg == Message.ANNULER){
            ((Vue) o).setVisible(false);
        }

        if(arg == Message.FINTOUR){
            finTour = true;
        }
                  
                

   /* Tour de jeu */

  if(inscriptionFini){
            if(getJoueurCourant().getNbActionsMax() == nbActions){
                finTour = true;                                         // Si le joueur a déja effectué 3 actions
             }                                                          // c'est au tour du prochain joueur
          

            if(finTour){
                desactiverBtn(joueurCourant%aventuriers.size());
                getJoueurCourant().setDeplacementSpecial(false);

                        joueurCourant++;
                        nbActions = 0;
                        finTour = false;
                        activerBtn(joueurCourant%aventuriers.size());
                        System.out.println("");
                        System.out.println(getJoueurCourant().getClass().toString());;
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");

        for (int i =0; i < vuesAventurier.size(); i++){
            vuesAventurier.get(i).setVisible(true);
            activerBtn(joueurCourant%aventuriers.size());
            
        }
            }
        }
    }

    public void deplacer(Aventurier joueur){
        joueur.setPosition(getJoueurCourant().getPosition());
    }

    public void desactiverBtn(int vue){
        vuesAventurier.get(joueurCourant%aventuriers.size()).setLabel(getJoueurCourant().getPosition().toString());
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAssecher().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(false);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnTerminerTour().setEnabled(false);        
    }

    public void activerBtn(int vue){
        vuesAventurier.get(joueurCourant%aventuriers.size()).setLabel(getJoueurCourant().getPosition().toString());
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnAssecher().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnBouger().setEnabled(true);
        vuesAventurier.get(joueurCourant%aventuriers.size()).getBtnTerminerTour().setEnabled(true);
    }


    private Grille getGrille(){
        return this.grille;
    }

    public Aventurier getJoueurCourant(){
        return aventuriers.get(joueurCourant%aventuriers.size());
    }
}
