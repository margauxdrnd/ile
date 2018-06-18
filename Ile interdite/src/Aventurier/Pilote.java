/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventurier;

import Carte.CarteAventurier;
import Grille.Grille;
import Grille.Tuile;
import java.util.ArrayList;

public class Pilote extends Aventurier{

    public Pilote(String nomJoueur, Tuile tuile) {
        super(nomJoueur, tuile);
        setRoleAv(CarteAventurier.pilote);
    }
    
    public ArrayList getCasesAdj(Grille grille){
        return super.getCasesPossibles(grille);    
    }
    

    @Override
    public ArrayList getCasesPossibles(Grille grille){
        if(this.getDeplacementSpecial() == false ){
            return grille.getTuilesNonCoulees(getPosition());
        }
        else {
            return super.getCasesPossibles(grille);
        }
    
    }
    
}
