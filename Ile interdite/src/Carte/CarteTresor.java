/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carte;
/**
 *
 * @author duramarg
 */

import Tresor.Tresor;


public class CarteTresor extends CarteRsv {
    
    Tresor tresor;
    public CarteTresor(String nomCarte, Tresor tresor){
        super(nomCarte);
        this.tresor = tresor;
    }

    public Tresor getTresor() {
        return tresor;
    }
    
}
