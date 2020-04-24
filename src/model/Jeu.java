package model;

import java.util.LinkedList;
import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> pieces;

	
	public Jeu (Couleur couleur) {
		// On crée les listes de pieces a l'aide du factory de Jeu
		this.pieces = ChessPiecesFactory.newPieces(couleur);
	}
	
	//Ne pas coder dans la premiere iteration
	private boolean capture(int xCatch, int yCatch) { 
		return true;
	}
	
	private Couleur getCouleur() {
		this.couleur = couleur;
		return couleur;
	}
	
	private Coord getKingCoord() { 
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
	
	private Couleur getPieceColor(int x, int y) {
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
	
	
	private String getPieceType(int x, int y) {
		String type ="";
		for(Pieces piece : pieces) {
			if(piece.getX() == x && piece.getY() == y) {
				type = piece.getClass().getSimpleName();
			}
		}
		return type;
	}
	
	//A faire
	private boolean isMoveOK(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		String type = getPieceType(xInit, yInit);
		if(type.class.isMoveOk(xFinal, yFinal)) {
			ret = true;
		}
		return ret;
		
		Pieces mapiece = null;
		for(Pieces piece : pieces) {
			if(piece.getX() == xInit && piece.getY() == yInit) {
				mapiece = piece.getClass().isMoveOk(xFinal, yFinal);
			}
		}
		return mapiece;

	}
	
	//A faire
	private boolean isPawnPromotion(int xFinal, int yFinal) {
		boolean ret = false;
//		Pieces pawn = ;
//		if(pawn.getY() == yFinal) {
//			ret = true;
//		}
		return ret;
	}
	
	//A verifier
	private boolean pawnPromotion(int xFinal, int yFinal, String type) {
		boolean ret = false;
		String name = "";
		if(isPawnPromotion(xFinal, yFinal)) {
			name = type;
			ret = true;
		}
		return ret;
	}
	

	private boolean isPieceHere(int x, int y) {
		boolean ret = false;
		for(Pieces piece : pieces) {
			if(piece.getX() == x && piece.getY() == y) {
				ret = true;
			}
		}
		return ret;
	}
	
	//A verifier
	private boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean ret = false;
		if(isMoveOK(xInit, yInit, xFinal, yFinal)) {
			xInit = xFinal;
			yInit = yFinal;
			ret = true;
		}
		return ret;
	}

	
	private void setCastling() {
		
	}
	
	//Ne pas coder dans la premiere iteration
	private void setPossibleCapture() {
		
	}
	
	public String toString(){
		String ret = "";
		for(Pieces piece : pieces) {
			if(piece.getClass().equals(Roi.class)) {
				ret += piece.toString();
			}
		}
		return ret;
	}
	
	private void undoCapture() {
		
	}
	
	private void undoMove() {
		
	}
	
	private Pieces findPiece(int x, int y) {
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

