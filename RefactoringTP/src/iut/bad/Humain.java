package iut.bad;

import java.util.ArrayList;
import java.util.List;

public class Humain implements Consommation {
    protected String nom;
    protected String prenom;
    protected int age;
    protected List<Humain> amis; 
    
    public Humain(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.amis = new ArrayList<>(); 
    }
    
    public void details() {
        System.out.println(toString());
    }
    
    public String toString() {
        return "nom : " + nom + ", prenom : " + prenom + ", age : " + age;
    }
    
    @Override
    public void manger() {
        System.out.println("Je mange.");
    }
    
    @Override
    public void boire() {
        System.out.println("Je bois.");
    }
    
    public void ami(Humain autreHumain, int dureeAmitie) {
        if (!this.amis.contains(autreHumain)) {
            this.amis.add(autreHumain);
            System.out.println(this.nom + " est maintenant ami avec " + autreHumain.nom + " depuis " + dureeAmitie + " jours.");
        } else {
            System.out.println(this.nom + " est déjà ami avec " + autreHumain.nom);
        }
    }
    
    public void ami(Humain autreHumain) {
        ami(autreHumain, 100); 
    }
}
