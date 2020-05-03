package model;

public class Roi extends AbstractPiece {

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if(Math.abs(this.getX()-xFinal)==1 || Math.abs(this.getY()-yFinal)==1) {
			ret = true;
		}
		return ret;
	}

	@Override
	public boolean move(int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}


}
