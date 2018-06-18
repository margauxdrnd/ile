/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carte;

import Grille.Tuile;

/**
 *
 * @author duramarg
 */
public class CarteInond {
    
    private Tuile tuile;

    public CarteInond(Tuile tuile){
        this.tuile = tuile;
    }

    public Tuile getTuile(){
        return tuile;
    }
    
}
