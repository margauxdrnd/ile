package Grille;


import Aventurier.Aventurier;
import Utils.Utils.EtatTuile;
import static Utils.Utils.EtatTuile.*;
import java.util.*;

/**
 *
 * @author deangell
 */
public class Tuile {
    
    private ArrayList<Aventurier> aventuriers = new ArrayList();
    private int y;
    private int x;
    private EtatTuile etat;
    private NomTuile nom;
    
    public Tuile(NomTuile nom, EtatTuile etat,int y, int x){
       setNom(nom);
       this.etat = etat;
       this.setPos(x,y);
    }

    public Tuile(){

    };
    
    // Etats de la tuile
    
    public boolean estSeche(){
        return etat == ASSECHEE;
    }
    
    public boolean estInondee(){
        return etat == INONDEE;
    }
    
    public boolean estCoulee(){
        return etat == COULEE;
    }
    
    
    // Gestion des etats
    


    @Override
    public String toString(){
        return nom.toString();
    }
    
    //Getters

    public int getY(){
        return y;
    }
    
    public int getX(){
        return x;
    }

    public NomTuile getNom(){
        return nom;
    }
    
    public EtatTuile getEtat() {
        return etat;
    }
    

    //Setters
    
    public void setY(int y){
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setNom(NomTuile nom){
        this.nom = nom;
    }

    public void setEtat(EtatTuile etat){
        this.etat = etat;
    }
    
    // Ajout et suppression des aventuriers sur la tuile


    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void addAventurier(Aventurier av){
        getAventuriers().add(av);
    }

    public void removeAventurier(Aventurier av){
        getAventuriers().remove(av);
    }

    public void setPos(int i, int j) {
          this.setX(i);
          this.setY(j);
    }
    
    public void afficheTuile(){
        System.out.println(this.getNom());
        System.out.println(this.getEtat());
    }
    
    public void montéeDesEaux(){
        if (this.estInondee()){
            this.setEtat(COULEE);
        }else if (this.estSeche()){
            this.setEtat(INONDEE);
        }
    }

}
