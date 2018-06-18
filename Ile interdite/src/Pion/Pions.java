/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pion;

import java.awt.Color;

/**
 *
 * @author duramarg
 */
public enum Pions {
    
    rouge("Ingénieur", new Color(255, 0, 0), "src/images/pions/pionRouge.png"),
    bleu ("Pilote", new Color(55, 194, 198), "src/images/pions/pionBleu.png"),
    vert ("Explorateur", new Color(0, 195, 0), "src/images/pions/pionVert.png"),
    violet ("Messager", new Color(204, 94, 255), "src/images/pions/pionViolet.png"),
    jaune("Navigateur", new Color(255, 255, 0), "src/images/pions/pionJaune.png"),
    noir("Plongeur", new Color(50, 50, 50), "src/images/pions/pionNoir.png");

    private final String nom ;
    private final Color couleur;
    private final String chemin ;


    Pions(String nom, Color couleur, String chemin) {
        this.nom = nom;
        this.couleur = couleur;
        this.chemin = chemin;
    }

    public Color getCouleur() {
        return this.couleur ;
    }

    public String getChemin(){
        return chemin;
    }
    
    @Override
    public String toString() {
        return this.nom ;
    }
    
}
