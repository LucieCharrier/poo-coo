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


	@Override //A voir comment se déplacent les pions ?
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if ((xFinal == this.coord.x) && (yFinal == this.coord.y + 1)) {
			ret = true;
		}
		return ret;
	}

	@Override
	public boolean move(int x, int y) {
		boolean ret = false;
		if (this.isMoveOk(x,y) == true) {
			this.coord.x = x;
			this.coord.y = y;
			ret = true;
		}
		return ret; 
	}

}