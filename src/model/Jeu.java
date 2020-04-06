package model;

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
		return null;
	}
	
	private Couleur getPieceColor(int x, int y) {
		return null;
	}
	
	private List<PieceIHM> getPieceIHM(){
		return null;
	}
	
	private String getPieceType(int x, int y) {
		return null;
	}
	
	private boolean isMoveOK(int xInit, int yInit, int xFinal, int yFinal) {
		return true;
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
	
	//A verifier
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
			ret += piece.toString();
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

