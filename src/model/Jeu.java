package model;

import java.util.List;

import tools.ChessPiecesFactory;

public class Jeu {
	
	private Couleur couleur;
	private List<Pieces> piecesBlanches;
	private List<Pieces> piecesNoires;
	
	public Jeu (Couleur couleur) {
		// On crée les listes de pieces a l'aide du factory de Jeu
		this.piecesBlanches = ChessPiecesFactory.newPieces(Couleur.BLANC);
		this.piecesNoires = ChessPiecesFactory.newPieces(Couleur.NOIR);
	}
	
	private boolean capture(int xCatch, int yCatch) {
		return true;
	}
	
	private Couleur getCouleur() {
		return null;
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
	
	private boolean isPawnPromotion(int xFinal, int yFinale) {
		return true;
	}
	
	private boolean isPieceHere(int x, int y) {
		return true;
	}
	
	private boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		return true;
	}
	
	private boolean pawnPromotion(int xFinal, int yfinal, String type) {
		return true;
	}
	
	private void setCastling() {
		
	}
	
	private void setPossibleCapture() {
		
	}
	
	public String toString(){
		return null;
	}
	
	private void undoCapture() {
		
	}
	
	private void undoMove() {
		
	}
	
}

