import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;

public class Controller implements ActionListener, DocumentListener{
	private GUI gui;
	private Board board;
	
	public Controller(GUI gui, Board board){
		this.gui = gui;
		this.board = board;
		
		gui.setListener(this);
		gui.setTextListener(this);
		//gui.initGUI();
	}
	
	@Override
	public void actionPerformed (ActionEvent e){
		//gui.setAnimals();
		String [] a = gui.getAnimalName().split(" ");
		if(a[0].equals("red") && redturn == 1){
			if("up".equals(e.getActionCommand())){
				if(gui.rIsValidMove(gui.getAnimalName(), 'w')){
					redturn = 0;
					gui.moveW(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getBlueDen()){
						gameOver();
					}
					update();
				}
			}else if("down".equals(e.getActionCommand())){
				if(gui.rIsValidMove(gui.getAnimalName(), 's')){
					redturn = 0;
					gui.moveS(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getBlueDen()){
						gameOver();
					}
					update();
				}
			}else if("left".equals(e.getActionCommand())){
				if(gui.rIsValidMove(gui.getAnimalName(), 'a')){
					redturn = 0;
					gui.moveA(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getBlueDen()){
						gameOver();
					}
					update();
				}
			}else if("right".equals(e.getActionCommand())){
				if(gui.rIsValidMove(gui.getAnimalName(), 'd')){
					redturn = 0;
					gui.moveD(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getBlueDen()){
						gameOver();
					}
					update();
				}
			}
		}else if(a[0].equals("blue")&& redturn == 0){			
			//pieces left and den
			if("up".equals(e.getActionCommand())){
				if(gui.bIsValidMove(gui.getAnimalName(), 'w')){
					redturn = 1;
					gui.moveW(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getRedDen()){
						gameOver();
					}
					update();
				}
			}else if("down".equals(e.getActionCommand())){
				if(gui.bIsValidMove(gui.getAnimalName(), 's')){
					redturn = 1;
					gui.moveS(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getRedDen()){
						gameOver();
					}
					update();
				}
			}else if("left".equals(e.getActionCommand())){
				if(gui.bIsValidMove(gui.getAnimalName(), 'a')){
					redturn = 1;
					gui.moveA(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0|| gui.getRedDen()){
						gameOver();
					}
					update();
				}
			}else if("right".equals(e.getActionCommand())){
				if(gui.bIsValidMove(gui.getAnimalName(), 'd')){
					redturn = 1;
					gui.moveD(gui.getTileAnimalRow(gui.getAnimalName()), gui.getTileAnimalCol(gui.getAnimalName()), gui.getAnimalName());
					if(gui.getRedPiece() == 0 || gui.getBluePiece() == 0 || gui.getRedDen()){
						gameOver();
					}
					update();
				}
			}
		}		
	}
	
	public void update(){
		gui.wEnabled(true);
		gui.aEnabled(true);
		gui.sEnabled(true);
		gui.dEnabled(true);
	}
	
	public void gameOver(){
		gui.wEnabled(false);
		gui.aEnabled(false);
		gui.sEnabled(false);
		gui.dEnabled(false);
		
		if(gui.getRedPiece() == 0){
			gui.setAnimalName("GAME OVER BLUE WON");
		}else if(gui.getBluePiece() == 0){
			gui.setAnimalName("GAME OVER RED WON");
		}else if(gui.getRedDen()){
			gui.setAnimalName("GAME OVER BLUE WON");
		}else if(gui.getBlueDen()){
			gui.setAnimalName("GAME OVER RED WON");
		}
	}
	
	public void changedUpdate(DocumentEvent e)
	{
	}
	
	public void insertUpdate(DocumentEvent e)
	{
	}
	
	public void removeUpdate(DocumentEvent e)
	{
	}
	private int redturn = 1;
	
}