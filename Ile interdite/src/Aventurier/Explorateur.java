/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventurier;

import Carte.CarteAventurier;
import Controleur.Message;
import Grille.Grille;
import Grille.Tuile;
import java.util.ArrayList;

/**
 *
 * @author deangell
 */
public class Explorateur extends Aventurier{

    public Explorateur(String nomJoueur, Tuile tuile) {
        super(nomJoueur, tuile);
        setRoleAv(CarteAventurier.explorateur);
    }
    
        @Override
    public ArrayList<Tuile> getCasesPossibles(Grille grille){
        ArrayList<Tuile> tuilesAccessibles = grille.getCasesAdj(getPosition(), Message.DEPLACER);
        tuilesAccessibles.addAll(grille.getCasesDiago(getPosition(), Message.DEPLACER));
        return tuilesAccessibles;
    }


    public ArrayList<Tuile> getCasesAssechPossible(Grille grille){
        ArrayList<Tuile> tuilesAssechables = grille.getCasesAdj(getPosition(), Message.ASSECHER);
        tuilesAssechables.addAll(grille.getCasesDiago(getPosition(), Message.ASSECHER));
        return tuilesAssechables;
    }
}
