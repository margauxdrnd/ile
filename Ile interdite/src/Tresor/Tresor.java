/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tresor;

import Grille.Grille;
import static Tresor.NomTresor.*;
import static Grille.NomTuile.*;
import Grille.Tuile;

/**
 *
 * @author Nans
 */
public class Tresor {
    private Tuile s1;
    private Tuile s2;
    private NomTresor nomTresor;
    private boolean recuperer;

    public Tresor(NomTresor nom, Grille grille) {
        this.nomTresor = nom;
        this.recuperer = false;
        this.setSanctuaire(grille);
        System.out.println(nom);
        System.out.println("Sanctuaire 1 :" + this.getSanctuaire1().getNom().toString());
        System.out.println("Sanctuaire 2 :" + this.getSanctuaire2().getNom().toString());
        System.out.println("");
        System.out.println("");
    }

    public Tuile getSanctuaire1() {
        return s1;
    }

    public Tuile getSanctuaire2() {
        return s2;
    }

    public NomTresor getNom() {
        return nomTresor;
    }
    
    
    
    public void setSanctuaire(Grille grille){
        this.setSanctuaire1(grille);
        this.setSanctuaire2(grille);
    }

    //Place les différentes statues sur la grille
    public void setSanctuaire1(Grille grille) {
        String nom = this.getNom().toString();
        Tuile t1 = new Tuile();
        if (nom== cristal.toString()) {
            t1=grille.getTuile(LA_CAVERNE_DES_OMBRES);
            
        } else if (nom== zephyr.toString())   {
            t1=grille.getTuile(LE_JARDIN_DES_HURLEMENTS);
            
        } else if (nom== pierre.toString()) {
            t1=grille.getTuile(LE_TEMPLE_DE_LA_LUNE);
            
        } else if (nom== calice.toString()) {
            t1=grille.getTuile(LE_PALAIS_DE_CORAIL);
            
        }
        this.setSanctuaire1(t1);
    }

    //Place les différentes statues sur la grille
    public void setSanctuaire2(Grille grille) {
        String nom=this.getNom().toString();
        Tuile t1 = new Tuile();
        if (nom== cristal.toString()) {
            t1=grille.getTuile(LA_CAVERNE_DU_BRASIER);
        } else if (nom== zephyr.toString())   {
            t1=grille.getTuile(LE_JARDIN_DES_MURMURES);
        } else if (nom== pierre.toString()) {
            t1=grille.getTuile(LE_TEMPLE_DU_SOLEIL);
        } else if (nom== calice.toString()) {
            t1=grille.getTuile(LE_PALAIS_DES_MAREES);
        }
        this.setSanctuaire2(t1);
    }

    public void setSanctuaire1(Tuile Sanctuaire1) {
        this.s1 = Sanctuaire1;
    }

    public void setSanctuaire2(Tuile Sanctuaire2) {
        this.s2 = Sanctuaire2;
    }

    public void setRecuperer(boolean recuperer) {
        this.recuperer = recuperer;
    }
    
    
    
    public boolean getRecuperable(){
        return !(this.getSanctuaire1().estCoulee() &&  this.getSanctuaire2().estCoulee()) ;
    }

    public boolean isRecuperer() {
        return recuperer;
    }
    
    
    
    
    
}