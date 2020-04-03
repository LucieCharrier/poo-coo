package model;

public interface Pieces {
	
	int getX(); 
	/*Retourne l'indice de la colonne o� est positionn� la pi�ce*/
	
	int getY();
	/*Retourne l'indice de la ligne o� est positionn� la pi�ce*/
	
	Couleur getCouleur();
	/*Retourne la couleur de la pi�ce*/
	
	boolean isMoveOk(int xFinal, int yFinal);
	/*Retourne true si d�placement l�gal en fonction des algo de 
	 * d�placement sp�cifique de chaque pi�ce*/
	
	boolean move(int xFinal, int yFinal);
	/*Retourne true si d�placement effectu�*/
	
	boolean capture();
	/*Retourne true si piece effectivement captur�e Positionne x et y � -1*/

}
