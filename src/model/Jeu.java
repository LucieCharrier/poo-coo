package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> pieces;
	private boolean isRoque;
	private Move lastMove;
	
	private class Move {
		
		private int xInit;
		private int yInit;
		private int xFinal;
		private int yFinal;
		
		public Move(int xInit, int yInit, int xFinal, int yFinal) {
			this.xInit = xInit;
			this.yInit = yInit;
			this.xFinal = xFinal;
			this.yFinal = yFinal;
		}

		@Override
		public String toString() {
			return "Move [xInit=" + xInit + ", yInit=" + yInit + ", xFinal=" + xFinal + ", yFinal=" + yFinal + "]";
		}
		
	}

	
	public Jeu (Couleur couleur) {
		// On crée les listes de pieces a l'aide du factory de Jeu
		this.pieces = ChessPiecesFactory.newPieces(couleur);
	}
	
	//Ne pas coder dans la premiere iteration
	public boolean capture(int xCatch, int yCatch) { 
		return true;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public Coord getKingCoord() { 
		Coord ret = null;
		for(Pieces piece : pieces) {
			if(piece.getClass().equals(Roi.class)) {
				int x = piece.getX();
				int y = piece.getY();
				ret = new Coord(x,y);
			}
		}
		return ret;
	}
	
	public Couleur getPieceColor(int x, int y) {
		Couleur couleur = null;
		for(Pieces piece : pieces) {
			if(piece.getX() == x && piece.getY() == y) {
				couleur = piece.getCouleur();
			}
		}
		return couleur;
	}
	
	
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		
		for (Pieces piece : pieces){
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			
			// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
							piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}
	
	
	public String getPieceType(int x, int y) {
		String type ="";
		for(Pieces piece : pieces) {
			if(piece.getX() == x && piece.getY() == y) {
				type = piece.getClass().getSimpleName();
			}
		}
		return type;
	}
	
	
	public boolean isMoveOK(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;	
		if(isPieceHere(xInit, yInit) && (xInit!=xFinal && yInit!=yFinal)) {
			for(Pieces piece : pieces) {
				if(piece.getX() == xInit && piece.getY() == yInit) {
					ret = piece.isMoveOk(xFinal, yFinal);
				}
			}
		}
		return ret;
	}
	
	
	public boolean isPawnPromotion(int xFinal, int yFinal) {
		return yFinal == 0 || yFinal == 7;
	}
	

	public boolean pawnPromotion(int xFinal, int yFinal, String type) {
		boolean ret = false;
		if(isPawnPromotion(xFinal, yFinal) && type.equals(Pion.class.getName())) {
			ret = true;
		}
		return ret;
	}
	

	public boolean isPieceHere(int x, int y) {
		boolean ret = false;
		for(Pieces piece : pieces) {
			if(piece.getX() == x && piece.getY() == y) {
				ret = true;
			}
		}
		return ret;
	}
	
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		if(isMoveOK(xInit, yInit, xFinal, yFinal)) {
			Pieces currentPiece = this.findPiece(xInit, yInit);
			currentPiece.move(xFinal, yFinal);
			this.lastMove = new Move(xInit, yInit, xFinal, yFinal);
			ret = true;
		}
		return ret;
	}

	
	public void setCastling() {
		this.isRoque = false;
		Coord posRoi = getKingCoord();
		//On rentre dans la boucle uniquement si le roi est sur sa ligne de départ
		if((getCouleur().equals(Couleur.BLANC) && posRoi.y == 7) 
				|| (getCouleur().equals(Couleur.NOIR) && posRoi.y == 0)) {
			for(Pieces piece : pieces) {
				if(piece.getClass().equals(Tour.class) && piece.getY()==posRoi.y) {
					this.isRoque = true;
					//Cas Tour 1
					if(piece.getX()<posRoi.x) {
						for(int xCase=piece.getX()+1; xCase<posRoi.x; xCase++) {
							if(isPieceHere(xCase, posRoi.y)) {
								this.isRoque=false;
							}
						}
					}
					//Cas Tour 2
					else {
						for(int xCase=piece.getX()-1; xCase>posRoi.x; xCase--) {
							if(isPieceHere(xCase, posRoi.y)) {
								this.isRoque=false;
							}
						}
					}
				}
			}
		}
	}
	
	//Ne pas coder dans la premiere iteration
	public void setPossibleCapture() {
		
	}
	
	public String toString(){
		String ret = "";
		for(Pieces piece : pieces) {
			ret += piece.toString();
		}
		return ret;
	}
	
	public void undoCapture() {
		
	}
	
	public void undoMove() {
		Pieces currentPiece = this.findPiece(this.lastMove.xFinal, this.lastMove.yFinal);
		currentPiece.move(this.lastMove.xInit, this.lastMove.yInit);
		this.lastMove = null;
	}
	
	public Pieces findPiece(int x, int y) {
		Pieces piecefound = null;
		for(Pieces piece : pieces) {
			if((piece.getX()==x) && (piece.getY()==y)) {
				piecefound = piece;
			}
		}
		return piecefound;
	}
	
	public static void main(String[] args) {
		Jeu monJeu = new Jeu(Couleur.BLANC);
		System.out.println(monJeu);
	}
	
}

