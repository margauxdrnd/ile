/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventurier;

import Carte.CarteAventurier;
import Grille.Grille;
import Grille.Tuile;
import static Utils.Utils.EtatTuile.ASSECHEE;
import static Utils.Utils.EtatTuile.COULEE;
import java.util.ArrayList;

/**
 *
 * @author deangell
 */
public class Plongeur extends Aventurier{

    public Plongeur(String nomJoueur, Tuile tuile) {
        super(nomJoueur, tuile);
        setRoleAv(CarteAventurier.plongeur);
    }
    
        @Override
    public ArrayList getCasesPossibles(Grille grille){
        
        Tuile t;
        ArrayList<Tuile> tuilesPossibles = super.getCasesPossibles(grille);
        
        ArrayList<Tuile> tuilesTrav = new ArrayList();
        tuilesTrav.add(getPosition());
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            t = tuilesTrav.get(i);
            
            for (Tuile tuile : grille.getCasesAdj(t)) {
                if (tuile.getEtat()!= ASSECHEE && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
                if (tuile.getEtat()!= COULEE && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
            }
        }
        
        tuilesPossibles.remove(getPosition());
        return tuilesPossibles;
    
    }
}
