package model;

public interface Pieces {
	
	int getX(); 
	/*Retourne l'indice de la colonne où est positionné la pièce*/
	
	int getY();
	/*Retourne l'indice de la ligne où est positionné la pièce*/
	
	Couleur getCouleur();
	/*Retourne la couleur de la pièce*/
	
	boolean isMoveOk(int xFinal, int yFinal);
	/*Retourne true si déplacement légal en fonction des algo de 
	 * déplacement spécifique de chaque pièce*/
	
	boolean move(int xFinal, int yFinal);
	/*Retourne true si déplacement effectué*/
	
	boolean capture();
	/*Retourne true si piece effectivement capturée Positionne x et y à -1*/

}
