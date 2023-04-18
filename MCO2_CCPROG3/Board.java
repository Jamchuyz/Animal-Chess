import java.util.*;

public class Board{
	/**
	* Constructor of board class
	*/
	public Board(){
		ROW = 7;
		COL = 9;
		
		tiles = new Tile[ROW][COL];
		player1 = new Player(1);
		player2 = new Player(2);
		exit = true;
		initBoard();
		initRPieces();
		initBPieces();
	}
	
	/**
	* Method initializes board with a 2d array of tile classes
	*/
	public void initBoard(){
		int i, j;
		
		for(i = 0; i < ROW; i++){
			for(j = 0; j < COL; j++){
				if((i == 2 && (j == 0 || j == 8))||
				   (i == 3 && (j == 1 || j == 7))||
				   (i == 4 && (j == 0 || j == 8))){
					tiles[i][j] = new Tile("trap");
				}else if(i == 3 && (j == 0 || j == 8)){
					tiles[i][j] = new Tile("den");
				}else if((i == 1 && (j == 3 || j == 4 || j == 5))||
					     (i == 2 && (j == 3 || j == 4 || j == 5))||
						 (i == 4 && (j == 3 || j == 4 || j == 5))||
						 (i == 5 && (j == 3 || j == 4 || j == 5))){
					tiles[i][j] = new Tile("river");		 
				}else{
					tiles[i][j] = new Tile("normal");
				}
			}
		}
	}
	
	/**
	* method initializes the red pieces along with their position in the board and the occupied status of their respective tile
	*/
	public void initRPieces(){
		rPieces = new Animal[8];
		
		rPieces[0] = new Animal("mouse", 1, 6, 2, "red");
			tiles[6][2].setOccupant(rPieces[0]);
			tiles[6][2].setOccupied();
		rPieces[1] = new Animal("cat", 2, 1, 1, "red");
			tiles[1][1].setOccupant(rPieces[1]);
			tiles[1][1].setOccupied();
		rPieces[2] = new Animal("wolf", 3, 2, 2, "red");
			tiles[2][2].setOccupant(rPieces[2]);
			tiles[2][2].setOccupied();
		rPieces[3] = new Animal("dog", 4, 5, 1, "red");
			tiles[5][1].setOccupant(rPieces[3]);
			tiles[5][1].setOccupied();
		rPieces[4] = new Animal("leopard", 5, 4, 2, "red");
			tiles[4][2].setOccupant(rPieces[4]);
			tiles[4][2].setOccupied();
		rPieces[5] = new Animal("tiger", 6, 0, 0, "red");
			tiles[0][0].setOccupant(rPieces[5]);
			tiles[0][0].setOccupied();
		rPieces[6] = new Animal("lion", 7, 6, 0, "red");
			tiles[6][0].setOccupant(rPieces[6]);
			tiles[6][0].setOccupied();
		rPieces[7] = new Animal("elephant", 8, 0, 2, "red");
			tiles[0][2].setOccupant(rPieces[7]);
			tiles[0][2].setOccupied();
	}
	
	/**
	* method initializes the blue pieces along with their position in the board and the occupied status of their respective tile
	*/
	public void initBPieces(){
		bPieces = new Animal[8];
		
		bPieces[0] = new Animal("mouse", 1, 0, 6, "blue");
			tiles[0][6].setOccupied();
			tiles[0][6].setOccupant(bPieces[0]);
			
		bPieces[1] = new Animal("cat", 2, 6, 8, "blue");
			tiles[6][8].setOccupied();
			tiles[6][8].setOccupant(bPieces[1]);
			
		bPieces[2] = new Animal("wolf", 3, 4, 6, "blue");
			tiles[4][6].setOccupied();
			tiles[4][4].setOccupant(bPieces[2]);
			
		bPieces[3] = new Animal("dog", 4, 1, 7, "blue");
			tiles[1][7].setOccupied();
			tiles[1][7].setOccupant(bPieces[3]);
			
		bPieces[4] = new Animal("leopard", 5, 2, 6, "blue");
			tiles[2][6].setOccupied();
			tiles[2][6].setOccupant(bPieces[4]);
			
		bPieces[5] = new Animal("tiger", 6, 6, 8, "blue");
			tiles[6][8].setOccupied();
			tiles[6][8].setOccupant(bPieces[5]);
			
		bPieces[6] = new Animal("lion", 7, 0, 8, "blue");
			tiles[0][8].setOccupied();
			tiles[0][8].setOccupant(bPieces[6]);
			
		bPieces[7] = new Animal("elephant", 8, 6, 6, "blue");
			tiles[6][6].setOccupied();
			tiles[6][6].setOccupant(bPieces[7]);
	}
	
	
	/** 
	  * Method responsible for the selection of the RED piece the user wants and responsible for moving them in 
	  *	their respective direction(up, down, left, right)	
	  *       
	  * @param a name of piece/animal       
	  * @param c selected move  
	*/
	public void rSelectAndMove(String a, char c){
		int i;
		int x, y;
		
		for(i = 0; i < 8; i++){
			if(a.equals(rPieces[i].getName())){
				
				for(x = 0; x < ROW; x++){
					for(y = 0; y < COL; y++){
						// UP MOVEMENT
						if(c == 'w' && "normal".equals(tiles[x-1][y].getType()) ){
							if(tiles[x-1][y].isOccupied()){
								player2.minusPiece();
								tiles[x-1][y].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x-1][y].setOccupant(rPieces[i]);
							tiles[x-1][y].setOccupied();//calls again for the new occupant
							
							rPieces[i].setPosition(x-1, y);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 'w' && "river".equals(tiles[x-1][y].getType()) ){
							if(tiles[x-3][y].isOccupied()){
								player2.minusPiece();
								tiles[x-3][y].setOccupied();
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x-3][y].setOccupant(rPieces[i]);
							tiles[x-3][y].setOccupied();
							
							rPieces[i].setPosition(x-3, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'w' && "trap".equals(tiles[x-1][y].getType())  ){
							if(tiles[x-1][y].isOccupied()){
								player2.minusPiece();
								tiles[x-1][y].setOccupied();//empties the occupied status
							}
							rPieces[i].trapRank();
							tiles[x-1][y].setOccupant(rPieces[i]);
							tiles[x-1][y].setOccupied();
							
							rPieces[i].setPosition(x-1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'w' && "den".equals(tiles[x-1][y].getType())  ){
							if(tiles[x-1][y].isOccupied()){
								player2.minusPiece();
								tiles[x-1][y].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x-1][y].setOccupant(rPieces[i]);
							tiles[x-1][y].setOccupied();
							
							rPieces[i].setPosition(x-1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
						//DOWN MOVEMENT
						else if(c == 's' && "normal".equals(tiles[x+1][y].getType()) ){
							if(tiles[x+1][y].isOccupied()){
								player2.minusPiece();
								tiles[x+1][y].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x+1][y].setOccupant(rPieces[i]);
							tiles[x+1][y].setOccupied();//calls again for the new occupant
							
							rPieces[i].setPosition(x+1, y);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 's' && "river".equals(tiles[x+1][y].getType()) ){
							if(tiles[x+3][y].isOccupied()){
								player2.minusPiece();
								tiles[x+3][y].setOccupied();
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x+3][y].setOccupant(rPieces[i]);
							tiles[x+3][y].setOccupied();
							
							rPieces[i].setPosition(x+3, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 's' && "trap".equals(tiles[x+1][y].getType())  ){
							if(tiles[x+1][y].isOccupied()){
								player2.minusPiece();
								tiles[x+1][y].setOccupied();//empties the occupied status
							}
							rPieces[i].trapRank();
							tiles[x+1][y].setOccupant(rPieces[i]);
							tiles[x+1][y].setOccupied();
							
							rPieces[i].setPosition(x+1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 's' && "den".equals(tiles[x+1][y].getType())  ){
							if(tiles[x+1][y].isOccupied()){
								player2.minusPiece();
								tiles[x+1][y].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x+1][y].setOccupant(rPieces[i]);
							tiles[x+1][y].setOccupied();
							
							rPieces[i].setPosition(x+1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
						//LEFT MOVEMENT
						else if(c == 'a' && "normal".equals(tiles[x][y-1].getType()) ){
							if(tiles[x][y-1].isOccupied()){
								player2.minusPiece();
								tiles[x][y-1].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x][y-1].setOccupant(rPieces[i]);
							tiles[x][y-1].setOccupied();//calls again for the new occupant
							
							rPieces[i].setPosition(x, y-1);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 'a' && "river".equals(tiles[x][y-1].getType()) ){
							if(tiles[x][y-4].isOccupied()){
								player2.minusPiece();
								tiles[x][y-4].setOccupied();
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x][y-4].setOccupant(rPieces[i]);
							tiles[x][y-4].setOccupied();
							
							rPieces[i].setPosition(x, y-4);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'a' && "trap".equals(tiles[x][y-1].getType())  ){
							if(tiles[x][y-1].isOccupied()){
								player2.minusPiece();
								tiles[x][y-1].setOccupied();//empties the occupied status
							}
							rPieces[i].trapRank();
							tiles[x][y-1].setOccupant(rPieces[i]);
							tiles[x][y-1].setOccupied();
							
							rPieces[i].setPosition(x, y-1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'a' && "den".equals(tiles[x][y-1].getType())  ){
							if(tiles[x][y-1].isOccupied()){
								player2.minusPiece();
								tiles[x][y-1].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x][y-1].setOccupant(rPieces[i]);
							tiles[x][y-1].setOccupied();
							
							rPieces[i].setPosition(x, y-1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
						//RIGHT MOVEMENT
						else if(c == 'd' && "normal".equals(tiles[x][y+1].getType()) ){
							if(tiles[x][y+1].isOccupied()){
								player2.minusPiece();
								tiles[x][y+1].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x][y+1].setOccupant(rPieces[i]);
							tiles[x][y+1].setOccupied();//calls again for the new occupant
							
							rPieces[i].setPosition(x, y+1);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 'd' && "river".equals(tiles[x][y+1].getType()) ){
							if(tiles[x][y+4].isOccupied()){
								player2.minusPiece();
								tiles[x][y+4].setOccupied();
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x][y+4].setOccupant(rPieces[i]);
							tiles[x][y+4].setOccupied();
							
							rPieces[i].setPosition(x, y+4);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'd' && "trap".equals(tiles[x][y+1].getType())  ){
							if(tiles[x][y+1].isOccupied()){
								player2.minusPiece();
								tiles[x][y+1].setOccupied();//empties the occupied status
							}
							rPieces[i].trapRank();
							tiles[x][y+1].setOccupant(rPieces[i]);
							tiles[x][y+1].setOccupied();
							
							rPieces[i].setPosition(x, y+1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'd' && "den".equals(tiles[x][y+1].getType())  ){
							if(tiles[x][y+1].isOccupied()){
								player2.minusPiece();
								tiles[x][y+1].setOccupied();//empties the occupied status
							}
							if(rPieces[i].trapStatus()){
								rPieces[i].trapRank();
							}
							tiles[x][y+1].setOccupant(rPieces[i]);
							tiles[x][y+1].setOccupied();
							
							rPieces[i].setPosition(x, y+1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
					}
				}
			}
		}
	}
	
	/** 
	  * Method responsible for the selection of the BLUE piece the user wants and responsible for moving them in 
	  *	their respective direction(up, down, left, right)	
	  *       
	  * @param a name of piece/animal       
	  * @param c selected move  
	*/
	public void bSelectAndMove(String a, char c){
		int i;
		int x, y;
		
		for(i = 0; i < 8; i++){
			if(a.equals(bPieces[i].getName())){
				
				for(x = 0; x < ROW; x++){
					for(y = 0; y < COL; y++){
						// UP MOVEMENT
						if(c == 'w' && "normal".equals(tiles[x-1][y].getType()) ){
							if(tiles[x-1][y].isOccupied()){
								player2.minusPiece();
								tiles[x-1][y].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x-1][y].setOccupant(bPieces[i]);
							tiles[x-1][y].setOccupied();//calls again for the new occupant
							
							bPieces[i].setPosition(x-1, y);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 'w' && "river".equals(tiles[x-1][y].getType()) ){
							if(tiles[x-3][y].isOccupied()){
								player2.minusPiece();
								tiles[x-3][y].setOccupied();
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x-3][y].setOccupant(bPieces[i]);
							tiles[x-3][y].setOccupied();
							
							bPieces[i].setPosition(x-3, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'w' && "trap".equals(tiles[x-1][y].getType())  ){
							if(tiles[x-1][y].isOccupied()){
								player2.minusPiece();
								tiles[x-1][y].setOccupied();//empties the occupied status
							}
							bPieces[i].trapRank();
							tiles[x-1][y].setOccupant(bPieces[i]);
							tiles[x-1][y].setOccupied();
							
							bPieces[i].setPosition(x-1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'w' && "den".equals(tiles[x-1][y].getType())  ){
							if(tiles[x-1][y].isOccupied()){
								player2.minusPiece();
								tiles[x-1][y].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x-1][y].setOccupant(bPieces[i]);
							tiles[x-1][y].setOccupied();
							
							bPieces[i].setPosition(x-1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
						//DOWN MOVEMENT
						else if(c == 's' && "normal".equals(tiles[x+1][y].getType()) ){
							if(tiles[x+1][y].isOccupied()){
								player2.minusPiece();
								tiles[x+1][y].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x+1][y].setOccupant(bPieces[i]);
							tiles[x+1][y].setOccupied();//calls again for the new occupant
							
							bPieces[i].setPosition(x+1, y);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 's' && "river".equals(tiles[x+1][y].getType()) ){
							if(tiles[x+3][y].isOccupied()){
								player2.minusPiece();
								tiles[x+3][y].setOccupied();
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x+3][y].setOccupant(bPieces[i]);
							tiles[x+3][y].setOccupied();
							
							bPieces[i].setPosition(x+3, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 's' && "trap".equals(tiles[x+1][y].getType())  ){
							if(tiles[x+1][y].isOccupied()){
								player2.minusPiece();
								tiles[x+1][y].setOccupied();//empties the occupied status
							}
							bPieces[i].trapRank();
							tiles[x+1][y].setOccupant(bPieces[i]);
							tiles[x+1][y].setOccupied();
							
							bPieces[i].setPosition(x+1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 's' && "den".equals(tiles[x+1][y].getType())  ){
							if(tiles[x+1][y].isOccupied()){
								player2.minusPiece();
								tiles[x+1][y].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x+1][y].setOccupant(bPieces[i]);
							tiles[x+1][y].setOccupied();
							
							bPieces[i].setPosition(x+1, y);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
						//LEFT MOVEMENT
						else if(c == 'a' && "normal".equals(tiles[x][y-1].getType()) ){
							if(tiles[x][y-1].isOccupied()){
								player2.minusPiece();
								tiles[x][y-1].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x][y-1].setOccupant(bPieces[i]);
							tiles[x][y-1].setOccupied();//calls again for the new occupant
							
							bPieces[i].setPosition(x, y-1);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 'a' && "river".equals(tiles[x][y-1].getType()) ){
							if(tiles[x][y-4].isOccupied()){
								player2.minusPiece();
								tiles[x][y-4].setOccupied();
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x][y-4].setOccupant(bPieces[i]);
							tiles[x][y-4].setOccupied();
							
							bPieces[i].setPosition(x, y-4);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'a' && "trap".equals(tiles[x][y-1].getType())  ){
							if(tiles[x][y-1].isOccupied()){
								player2.minusPiece();
								tiles[x][y-1].setOccupied();//empties the occupied status
							}
							bPieces[i].trapRank();
							tiles[x][y-1].setOccupant(bPieces[i]);
							tiles[x][y-1].setOccupied();
							
							bPieces[i].setPosition(x, y-1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'a' && "den".equals(tiles[x][y-1].getType())  ){
							if(tiles[x][y-1].isOccupied()){
								player2.minusPiece();
								tiles[x][y-1].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							
							tiles[x][y-1].setOccupant(bPieces[i]);
							tiles[x][y-1].setOccupied();
							
							bPieces[i].setPosition(x, y-1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
						//RIGHT MOVEMENT
						else if(c == 'd' && "normal".equals(tiles[x][y+1].getType()) ){
							if(tiles[x][y+1].isOccupied()){
								player2.minusPiece();
								tiles[x][y+1].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x][y+1].setOccupant(bPieces[i]);
							tiles[x][y+1].setOccupied();//calls again for the new occupant
							
							bPieces[i].setPosition(x, y+1);
							
							tiles[x][y].setOccupied();//empties previous tile
							x = ROW;
							y = COL;
						}else if(c == 'd' && "river".equals(tiles[x][y+1].getType()) ){
							if(tiles[x][y+4].isOccupied()){
								player2.minusPiece();
								tiles[x][y+4].setOccupied();
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x][y+4].setOccupant(bPieces[i]);
							tiles[x][y+4].setOccupied();
							
							bPieces[i].setPosition(x, y+4);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'd' && "trap".equals(tiles[x][y+1].getType())  ){
							if(tiles[x][y+1].isOccupied()){
								player2.minusPiece();
								tiles[x][y+1].setOccupied();//empties the occupied status
							}
							bPieces[i].trapRank();
							tiles[x][y+1].setOccupant(bPieces[i]);
							tiles[x][y+1].setOccupied();
							
							bPieces[i].setPosition(x, y+1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}else if(c == 'd' && "den".equals(tiles[x][y+1].getType())  ){
							if(tiles[x][y+1].isOccupied()){
								player2.minusPiece();
								tiles[x][y+1].setOccupied();//empties the occupied status
							}
							if(bPieces[i].trapStatus()){
								bPieces[i].trapRank();
							}
							tiles[x][y+1].setOccupant(bPieces[i]);
							tiles[x][y+1].setOccupied();
							
							bPieces[i].setPosition(x, y+1);
							
							tiles[x][y].setOccupied();
							x = ROW;
							y = COL;
						}
					}
				}
			}
		}
	}
	
	
	/**
	* method is responsible for the deduction of the blue pieces
	*/
	public void redEatsBlue(){
		player2.minusPiece();
	}
	
	/**
	* method is responsible for the deduction of the red pieces
	*/
	public void blueEatsRed(){
		player1.minusPiece();
	}
	
	/**
	* method returns the count of red pieces
	*@return actual count of red pieces
	*/
	public int redPieceCount(){
		return player1.getPieceCount();
	}
	
	/**
	* method returns the count of blue pieces
	*@return actual count of blue pieces
	*/
	public int bluePieceCount(){
		return player2.getPieceCount();
	}
		
	/**
	* 2d array of the tiles of the board
	*/
	private Tile[][] tiles;
	/**
	* number of rows of the board
	*/
	private final int ROW;
	/**
	* number of columns of the board
	*/
	private final int COL;
	/**
	* pieces of the red side
	*/
	private Animal[] rPieces;
	/**
	* pieces of the blue side
	*/
	private Animal[] bPieces;
	/**
	* player 1
	*/
	private Player player1;
	/**
	* player 2
	*/
	private Player player2;
	/**
	* game condition when the game will end
	*/
	private boolean exit;
}