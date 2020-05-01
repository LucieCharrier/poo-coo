package model;

public class Echiquier implements BoardGames {
	
	private String message;

	// Pas de getter si setter sur ces jeux car ils seront g�r�s automatiquement
	private Jeu jeuBlanc;
	private Jeu jeuNoir;
	private Jeu jeuCourant;
	
	public Echiquier() {
		this.jeuBlanc = new Jeu(Couleur.BLANC);
		this.jeuNoir = new Jeu(Couleur.NOIR);
		this.jeuCourant = this.jeuBlanc;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		if(this.isMoveOk(xInit, yInit, xFinal, yFinal)){
			this.jeuCourant.move(xInit, yInit, xFinal, yFinal);
			ret = true;
		}
		return ret;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.jeuCourant.getCouleur();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void switchJoueur() {
		if(getColorCurrentPlayer().equals(Couleur.BLANC)) {
			this.jeuCourant = this.jeuNoir;
		} else {
			this.jeuCourant = this.jeuBlanc;
		}
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		return this.jeuCourant.isMoveOK(xInit, yInit, xFinal, yFinal);
	}

	@Override
	public String toString() {
		return "Echiquier [JEU BLANC=" + jeuBlanc + ",\n JEU NOIR=" + jeuNoir + "]";
	}
	
	public static void main(String[] args) {
		Echiquier monEchiquier = new Echiquier();
		System.out.println(monEchiquier);
	}

}
