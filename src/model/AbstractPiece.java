package model;

public abstract class AbstractPiece implements Pieces {
	
	private Couleur couleur;
	private Coord coord;
	private String nom;
	

	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur = couleur;
		this.coord = coord;
	}
	
	public int getX() {
		return this.coord.x;
	}
	
	public int getY() {
		return this.coord.y;
	}
	
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	public boolean move(int x, int y) {
		return false; //default
	}
	
	public boolean capture() {
		
	}
	
	public abstract boolean isMoveOk(int xFinal, int yFinal) {
 //default
	}

	@Override 
	public java.lang.String toString(){
		return "Nom de la pièce :" + this.nom + "\n" +
				"Colonne :" + this.getX() + "\n" +
				"Ligne :" + this.getY();
		
	}
	
	public static void main(String[] args) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(0, 0));
		Couleur a = maTour.getCouleur();
		System.out.println(a);
	}
}
