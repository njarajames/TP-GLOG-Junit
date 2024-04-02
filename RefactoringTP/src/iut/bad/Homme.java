package iut.bad;

public class Homme extends Humain{

	   public Homme(String nom, String prenom, int age) {
	        super(nom, prenom, age);
	    }
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return this.nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}	
	public String getPrenom() {
		return this.prenom;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
}
