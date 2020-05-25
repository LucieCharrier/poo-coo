package vue;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Observable;

import controler.ChessGameControlers;

public class ChessGameGUI extends javax.swing.JFrame implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener, java.util.Observer{
	
	private String name;
	private ChessGameControlers chessGameControler;
	private Dimension boardsize;
	
	public ChessGameGUI(String name, ChessGameControlers chessGameControler, Dimension boardSize) {
		this.name = name;
		this.chessGameControler = chessGameControler;
		this.boardsize = new Dimension(600,600);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
