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
		
	}
	
	public int getY() {
		
	}
	
	public Couleur getCouleur() {
		
	}
	
	public boolean move(int x, int y) {
		
	}
	
	public boolean capture() {
		
	}
	
	public abstract boolean isMoveOk(int xFinal, int yFinal) {
		
	}

	@Override 
	public java.lang.String toString(){
		
	}
}
