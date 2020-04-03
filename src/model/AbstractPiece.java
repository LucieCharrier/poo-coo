package model;

public abstract class AbstractPiece implements Pieces {
	
	protected Couleur couleur;
	protected Coord coord;
	protected String nom;
	

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
		boolean ret = false;
		this.coord.x = x;
		this.coord.y = y;
		ret = true;
		return ret; //default
	}
	
	public boolean capture() { // --> la pièce sort du plateau à la position (-1,-1)
		return true;
	}
	
	public abstract boolean isMoveOk(int xFinal, int yFinal);
	
	
	@Override 
	public java.lang.String toString(){
		return "Nom de la pièce :" + this.nom + "\n" +
				"Colonne :" + this.getX() + "\n" +
				"Ligne :" + this.getY();
		
	}
	
	public static void main(String[] args) {
		Pieces maTour = new Tour(Couleur.NOIR, new Coord(15, 20));
		Couleur a = maTour.getCouleur();
		maTour.move(20,25);
		int x = maTour.getX();
		int y =maTour.getY();
		System.out.println(a);
		System.out.println(x);
		System.out.println(y);

	}
}
