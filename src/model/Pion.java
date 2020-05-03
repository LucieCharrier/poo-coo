package model;

public class Pion extends AbstractPiece implements Pions {

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveDiagOk(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Actuellement pas de gestion du premier déplacement (Le pion ne peut pas avancer de 2)
	 */
	@Override 
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if ((xFinal == this.coord.x) &&
			((this.getCouleur().equals(Couleur.NOIR) && yFinal == this.coord.y + 1) || 
			(this.getCouleur().equals(Couleur.BLANC) && yFinal == this.coord.y - 1))) {
			ret = true;
		}
		return ret;
	}

	/**
	 * On commente le if(isMoveOk) pour permettre un undoMove
	 */
	@Override
	public boolean move(int x, int y) {
		boolean ret = false;
//		if (this.isMoveOk(x,y) == true) {
			this.coord.x = x;
			this.coord.y = y;
			ret = true;
//		}
		return ret; 
	}

}