/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Controleur.Message;
import static Grille.NomTuile.HELIPORT;
import static Grille.NomTuile.LA_CAVERNE_DES_OMBRES;
import static Grille.NomTuile.LA_CAVERNE_DU_BRASIER;
import static Grille.NomTuile.LA_FORET_POURPRE;
import static Grille.NomTuile.LA_PORTE_DE_BRONZE;
import static Grille.NomTuile.LA_PORTE_DE_CUIVRE;
import static Grille.NomTuile.LA_PORTE_DE_FER;
import static Grille.NomTuile.LA_PORTE_D_ARGENT;
import static Grille.NomTuile.LA_PORTE_D_OR;
import static Grille.NomTuile.LA_TOUR_DU_GUET;
import static Grille.NomTuile.LES_DUNES_DE_L_ILLUSION;
import static Grille.NomTuile.LES_FALAISES_DE_L_OUBLI;
import static Grille.NomTuile.LE_JARDIN_DES_HURLEMENTS;
import static Grille.NomTuile.LE_JARDIN_DES_MURMURES;
import static Grille.NomTuile.LE_LAGON_PERDU;
import static Grille.NomTuile.LE_MARAIS_BRUMEUX;
import static Grille.NomTuile.LE_PALAIS_DES_MAREES;
import static Grille.NomTuile.LE_PALAIS_DE_CORAIL;
import static Grille.NomTuile.LE_PONT_DES_ABIMES;
import static Grille.NomTuile.LE_ROCHER_FANTOME;
import static Grille.NomTuile.LE_TEMPLE_DE_LA_LUNE;
import static Grille.NomTuile.LE_TEMPLE_DU_SOLEIL;
import static Grille.NomTuile.LE_VAL_DU_CREPUSCULE;
import static Grille.NomTuile.OBSERVATOIRE;
import static Utils.Utils.EtatTuile.ASSECHEE;
import static Utils.Utils.EtatTuile.COULEE;
import static Utils.Utils.EtatTuile.INONDEE;

import java.util.*;


/**
 *
 * @author deangell
 */
public class Grille {

    private Tuile[][] tuiles = new Tuile[6][6];

    public Grille(){
        /*
            On part de la construction d'une grille telle que :
               j
          i | 0.0 | 0.1 | 0.2 | 0.3 | 0.4 | 0.5 |   
            | 1.0 | 1.1 | 1.2 | 1.3 | 1.4 | 1.5 |                   
            | 2.0 | 2.1 | 2.2 | 2.3 | 2.4 | 2.5 |                 
            | 3.0 | 3.1 | 3.2 | 3.3 | 3.4 | 3.5 |                    
            | 4.0 | 4.1 | 4.2 | 4.3 | 4.4 | 4.5 |   
            | 5.0 | 5.1 | 5.2 | 5.3 | 5.4 | 5.5 |  
        
            On souhaite une grille telle que :
              
                        | 0.2 | 0.3 |  
                  | 1.1 | 1.2 | 1.3 | 1.4 |                    
            | 2.0 | 2.1 | 2.2 | 2.3 | 2.4 | 2.5 |                 
            | 3.0 | 3.1 | 3.2 | 3.3 | 3.4 | 3.5 |                    
                  | 4.1 | 4.2 | 4.3 | 4.4 |   
                        | 5.2 | 5.3 |
        
         */
        NomTuile[] nomTuiles = NomTuile.values();
        ArrayList<NomTuile> listTuile = new ArrayList();
        for(NomTuile t : nomTuiles){
            listTuile.add(t);
        }
        
        Collections.shuffle(listTuile);
        int x = 0;
        for (int i = 0; i < 6; i++){       
            for (int j = 0; j < 6; j++){   
                if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 4 && j == 0) || (i == 5 && j == 0) ||     // Suppression de 4 cases de la premiere colonne
                    (i == 0 && j == 1) || (i == 5 && j == 1) ||     // Suppression de 2 cases de la deuxieme colonne
                    (i == 0 && j == 4) || (i == 5 && j == 4) ||     // Suppression de 2 cases de la cinquieme colonne 
                    (i == 0 && j == 5) || (i == 1 & j == 5) || (i == 4 && j == 5) || (i == 5 && j == 5)){      // Suppression de 2 cases de la sixieme colonne
                                                  
                     tuiles[i][j] = null;                                           
                }  
            }
        }
        tuiles[0][2] = new Tuile(LE_PONT_DES_ABIMES,ASSECHEE,0,2);
        tuiles[0][3] = new Tuile(LA_PORTE_DE_BRONZE,INONDEE,0,3);
        tuiles[1][1] = new Tuile(LA_CAVERNE_DES_OMBRES,ASSECHEE,1,1);
        tuiles[1][2] = new Tuile(LA_PORTE_DE_FER,ASSECHEE,1,2);
        tuiles[1][3] = new Tuile(LA_PORTE_D_OR,ASSECHEE,1,3);
        tuiles[1][4] = new Tuile(LES_FALAISES_DE_L_OUBLI,ASSECHEE,1,4);
        tuiles[2][0] = new Tuile(LE_PALAIS_DE_CORAIL,ASSECHEE,2,0);
        tuiles[2][1] = new Tuile(LA_PORTE_D_ARGENT,ASSECHEE,2,1);
        tuiles[2][2] = new Tuile(LES_DUNES_DE_L_ILLUSION,COULEE,2,2);
        tuiles[2][3] = new Tuile(HELIPORT,ASSECHEE,2,3);
        tuiles[2][4] = new Tuile(LA_PORTE_DE_CUIVRE,ASSECHEE,2,4);
        tuiles[2][5] = new Tuile(LE_JARDIN_DES_HURLEMENTS,ASSECHEE,2,5);        
        tuiles[3][0] = new Tuile(LA_FORET_POURPRE,ASSECHEE,3,0);
        tuiles[3][1] = new Tuile(LE_LAGON_PERDU,INONDEE,3,1);
        tuiles[3][2] = new Tuile(LE_MARAIS_BRUMEUX,COULEE,3,2);
        tuiles[3][3] = new Tuile(OBSERVATOIRE,INONDEE,3,3);
        tuiles[3][4] = new Tuile(LE_ROCHER_FANTOME,COULEE,3,4);
        tuiles[3][5] = new Tuile(LA_CAVERNE_DU_BRASIER,INONDEE,3,5);
        tuiles[4][1] = new Tuile(LE_TEMPLE_DU_SOLEIL,ASSECHEE,4,1);
        tuiles[4][2] = new Tuile(LE_TEMPLE_DE_LA_LUNE,COULEE,4,2);
        tuiles[4][3] = new Tuile(LE_PALAIS_DES_MAREES,ASSECHEE,4,3);
        tuiles[4][4] = new Tuile(LE_VAL_DU_CREPUSCULE,ASSECHEE,4,4);
        tuiles[5][2] = new Tuile(LA_TOUR_DU_GUET,ASSECHEE,5,2);
        tuiles[5][3] = new Tuile(LE_JARDIN_DES_MURMURES,INONDEE,5,3);
        
    }
       
    public int[] getCoordonneesTuile(Tuile tuile){
        int[] coord = new int[2];
        for(int i = 0; i < 6 ; i++) {           // Lignes
            for (int j = 0; j < 6; j++) {       // Colonnes
                if (tuiles[i][j] != null && tuile.toString().equals(tuiles[i][j].toString())){
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        return coord;
    }
    
    public ArrayList<Tuile> getCasesAdj(Tuile t){
        ArrayList<Tuile> casesAdj = new ArrayList<>();
        int[] coord = this.getCoordonneesTuile(t);

            if (coord[0] != 0 && tuiles[coord[0] - 1][coord[1]] != null ){  
                casesAdj.add(tuiles[coord[0]-1][coord[1]]);                 
            }
            if (coord[0] != 5 && tuiles[coord[0] +1][coord[1]] != null ){ 
                casesAdj.add(tuiles[coord[0]+1][coord[1]]);                
            }
            if (coord[1] != 0 && tuiles[coord[0]][coord[1] -1] != null){ 
                casesAdj.add(tuiles[coord[0]][coord[1]-1]);               
            }
            if (coord[1] != 5 && tuiles[coord[0]][coord[1] +1] != null ){ 
                casesAdj.add(tuiles[coord[0]][coord[1]+1]);                
            }
            if (t.estInondee()) {                                                             
                casesAdj.add(t);                                                      
            }

        return casesAdj;
    }
    
        public ArrayList<Tuile> getCasesAdj(Tuile tuile, Message message){
        ArrayList<Tuile> tuilesAdjacentes = new ArrayList<>();
        int[] coord = this.getCoordonneesTuile(tuile);
        
        if (message == Message.DEPLACER){
            if (coord[0] != 0 && tuiles[coord[0] - 1][coord[1]] != null && !tuiles[coord[0]-1][coord[1]].estCoulee()){
                tuilesAdjacentes.add(tuiles[coord[0] - 1][coord[1]]);              
            }
            if (coord[0] != 5 && tuiles[coord[0] +1][coord[1]] != null && !tuiles[coord[0]+1][coord[1]].estCoulee()){ 
                tuilesAdjacentes.add(tuiles[coord[0] + 1][coord[1]]);             
            }
            if (coord[1] != 5 && tuiles[coord[0]][coord[1] -1] != null && !tuiles[coord[0]][coord[1]-1].estCoulee()){ 
                tuilesAdjacentes.add(tuiles[coord[0]][coord[1] - 1]);              
            }
            if (coord[1] != 5 && tuiles[coord[0]][coord[1] +1] != null && !tuiles[coord[0]][coord[1]+1].estCoulee()){ 
                tuilesAdjacentes.add(tuiles[coord[0]][coord[1] + 1]);             
            }
        
        }

        if (message == Message.ASSECHER){
            if (coord[0] != 0 && tuiles[coord[0] - 1][coord[1]] != null && tuiles[coord[0]-1][coord[1]].estInondee()){  
                tuilesAdjacentes.add(tuiles[coord[0]-1][coord[1]]);                 
            }
            if (coord[0] != 5 && tuiles[coord[0] +1][coord[1]] != null && tuiles[coord[0]+1][coord[1]].estInondee()){ 
                tuilesAdjacentes.add(tuiles[coord[0]+1][coord[1]]);               
            }
            if (coord[1] != 0 && tuiles[coord[0]][coord[1] -1] != null && tuiles[coord[0]][coord[1]-1].estInondee()){ 
                tuilesAdjacentes.add(tuiles[coord[0]][coord[1]-1]);               
            }
            if (coord[1] != 5 && tuiles[coord[0]][coord[1] +1] != null && tuiles[coord[0]][coord[1]+1].estInondee()){ 
                tuilesAdjacentes.add(tuiles[coord[0]][coord[1]+1]);              
            }
            if (tuile.estInondee()) {                                                            
                tuilesAdjacentes.add(tuile);                                                      
            }
        }

        return tuilesAdjacentes;
        }
    
        public ArrayList<Tuile> getCasesDiago(Tuile tuile, Message message){
        ArrayList<Tuile> casesDiag = new ArrayList<>();
        int[] coord = this.getCoordonneesTuile(tuile);

        if (message == Message.ASSECHER){
            if (message == Message.ASSECHER) {
                if (coord[0] != 0 && coord[1] != 0 && tuiles[coord[0] - 1][coord[1]-1] != null && tuiles[coord[0] - 1][coord[1] - 1].estInondee()) {
                    casesDiag.add(tuiles[coord[0] - 1][coord[1] - 1]);
                }
                if (coord[0] != 0 && coord[1] != 5 && tuiles[coord[0] -1][coord[1] +1] != null && tuiles[coord[0] - 1][coord[1] + 1].estInondee()) {
                    casesDiag.add(tuiles[coord[0] - 1][coord[1] + 1]);
                }
                if (coord[1] != 0 && coord[0] != 5 && tuiles[coord[0] +1][coord[1] -1] != null&& tuiles[coord[0] + 1][coord[1] - 1].estInondee()) {
                    casesDiag.add(tuiles[coord[0] + 1][coord[1] - 1]);
                }
                if (coord[1] != 5 && coord[0] != 5 && tuiles[coord[0] + 1][coord[1] +1] != null&& tuiles[coord[0] + 1][coord[1] + 1].estInondee()) {
                    casesDiag.add(tuiles[coord[0] + 1][coord[1] + 1]);
                }
            }
        }

        if (message == Message.DEPLACER) {
            if (coord[0] != 0 && coord[1] != 0 && tuiles[coord[0] - 1][coord[1] - 1] != null && !tuiles[coord[0] - 1][coord[1] - 1].estCoulee()) {
                casesDiag.add(tuiles[coord[0] - 1][coord[1] - 1]);
            }
            if (coord[0] != 0 && coord[1] != 5 && tuiles[coord[0] - 1][coord[1] + 1] != null && !tuiles[coord[0] - 1][coord[1] + 1].estCoulee()) {
                casesDiag.add(tuiles[coord[0] - 1][coord[1] + 1]);
            }
            if (coord[1] != 0 && coord[0] != 5 && tuiles[coord[0] + 1][coord[1] - 1] != null && !tuiles[coord[0] + 1][coord[1] - 1].estCoulee()) {
                casesDiag.add(tuiles[coord[0] + 1][coord[1] - 1]);
            }
            if (coord[1] != 5 && coord[0] != 5 && tuiles[coord[0] + 1][coord[1] + 1] != null && !tuiles[coord[0] + 1][coord[1] + 1].estCoulee()) {
                casesDiag.add(tuiles[coord[0] + 1][coord[1] + 1]);
            }

        }

        return casesDiag;
    }
        
    
    /* RECUPERER TUILES INONDEES ET JOUABLES */


    public ArrayList getTuilesNonCoulees(Tuile tuile){

        ArrayList<Tuile>tuilesNonCoulees = new ArrayList<>();

        for(int i = 0; i < tuiles.length ; i++) {
            for (int j = 0; j < tuiles.length; j++) {
                if (tuiles[i][j] != null && !(tuiles[i][j].estCoulee())){
                    tuilesNonCoulees.add(tuiles[i][j]);
                }
            }
        }
        tuilesNonCoulees.remove(tuile);
        return tuilesNonCoulees;


    }

   
    public Tuile[][] getTuiles() {
        return tuiles;
    }        
     
    public ArrayList<Tuile> getTuile() {
        ArrayList<Tuile> retourList = new ArrayList();
        for(int i = 0; i < 6 ; i++) { // Ligne
            for (int j = 0; j < 6; j++) { 
                retourList.add(tuiles[i][j]);
            }
         }
        return retourList;
    }

    public Tuile getTuile(NomTuile nomTuile){
        Tuile tuile = new Tuile();
        for(int i = 0; i < tuiles.length ; i++) { // Lignes
            for (int j = 0; j < tuiles.length; j++) { // Colonnes
                if (tuiles[i][j] != null && (nomTuile.toString().equals(tuiles[i][j].toString()))){
                    tuile = tuiles[i][j];
                }
            }
        }
        return tuile;
    }
}