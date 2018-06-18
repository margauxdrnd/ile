/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tresor;

/**
 *
 * @author duramarg
 */
public enum NomTresor {
        
    cristal("Cristal", "src/images/tresors/cristal.png"),
    pierre("Pierre", "src/images/tresors/pierre.png"),
    calice("Calice", "src/images/tresors/calice.png"),
    zephyr("Zephyr", "src/images/tresors/zephyr.png");

    String nom,chemin;

    NomTresor(String nom, String chemin){
        this.nom = nom;
        this.chemin = chemin;
    }

    @Override
    public String toString() {
        return this.nom;
    }

    public String getChemin() {
        return chemin;
}
    
}
