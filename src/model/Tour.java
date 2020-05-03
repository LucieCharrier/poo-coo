package model;

public class Tour extends AbstractPiece {

	public Tour(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean ret = false;
		if((this.getX()!=xFinal && this.getY()==yFinal)
				|| (this.getX()==xFinal && this.getY()!=yFinal)){
			ret = true;
		}
		return ret;
	}

}
