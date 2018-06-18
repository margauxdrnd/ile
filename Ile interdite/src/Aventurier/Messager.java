/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventurier;

import Carte.CarteAventurier;
import Grille.Tuile;


public class Messager extends Aventurier{

    public Messager(String nomJoueur, Tuile tuile) {
        super(nomJoueur, tuile);
        setRoleAv(CarteAventurier.ingenieur);
    }
    
}