/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





//b
package Aventurier;

import Carte.CarteAventurier;
import Carte.CarteRsv;
import java.util.ArrayList;

import Controleur.Message;
import Grille.Grille;
import Grille.Tuile;
import Utils.Utils.Pion;
import Utils.*;

public abstract class Aventurier {

    private String nomJoueur;
    private Tuile tuile;
    private Tuile position;
    private Tuile positionAnterieure;
    private Pion pion;
    private CarteAventurier roleAv;
    private boolean deplaceSpecial;
    private ArrayList<CarteRsv>cartes = new ArrayList<>();

    private final static int nbActionsMax = 3;
    
    public Aventurier(String nomJoueur, Tuile tuile){
        setNomJoueur(nomJoueur);
        setPosition(tuile);
        deplaceSpecial = false;
    }

    public int getNbActionsMax() {return nbActionsMax;}

    public Pion getPion() {return pion;}

    public Tuile getPosition() {return position;}

    public Tuile getPositionAnterieure() {return positionAnterieure;}

    public CarteAventurier getRoleAv() {return roleAv;}
    
    public boolean getDeplacementSpecial() {return deplaceSpecial;}
    
    
    public String getNomJoueur(){return nomJoueur;}
    
    
    public void setNomJoueur(String nomJoueur){
        this.nomJoueur = nomJoueur;
    }

    
    public void setRoleAv(CarteAventurier roleAv){
        this.roleAv = roleAv;
    }

    
    public void setPion(Pion pion) {
        this.pion = pion;
    }

    public void setPosition(Tuile t) {
        positionAnterieure = getPosition();
        position = t;
    }

    public void setDeplacementSpecial(boolean deplaceSpecial) {
        this.deplaceSpecial = deplaceSpecial;
    }



    public ArrayList getCasesPossibles(Grille grille){
        return grille.getCasesAdj(getPosition(), Message.DEPLACER);
    }

    public ArrayList getCasesAssechements(Grille grille){
        return grille.getCasesAdj(getPosition(), Message.ASSECHER);
    }
}
