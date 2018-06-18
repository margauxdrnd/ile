/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carte;

/**
 *
 * @author deangell
 */
public enum CarteAventurier {
    
    pilote("Pilote"),
    explorateur("Explorateur"),
    navigateur("Navigateur"),
    ingenieur("Ingénieur"),
    plongeur("Plongeur"),
    messager("Messager");
    private String nomRole;

    CarteAventurier(String nomRole){
        this.nomRole = nomRole;
    }

    @Override
    public String toString(){
        return nomRole;
    }

}
