package model;

public class Fou extends AbstractPiece {

	public Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if(Math.abs(this.getX()-xFinal) == Math.abs(this.getY()-yFinal)) {
			ret = true;
		}
		return ret;
	}


}
