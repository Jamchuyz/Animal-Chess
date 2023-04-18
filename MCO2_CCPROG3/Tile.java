public class Tile{
	
	/** 
	  * Initializes the attribute of class tile
	  *       
	  * @param s type of tile in board     
	 */
	public Tile(String s){
		type = s;
		space = false;
		row = 0;
		col = 0;
		occupant = null;
	}
	
	/** 
	  * Sets the position of the tile in the board.
	  *       
	  * @param i row of tile       
	  * @param j column of tile
	 */
	public void setCoordinate(int i, int j){
		row = i;
		col = j;
	}
	
	/** 
	  * Returns the row of the tile.
	  *       
	  * @return row position of tile       
	 */
	public int getRow(){
		return row;
	}
	
	/** 
	  * Returns the column of the tile.
	  *       
	  * @return column position of tile       
	 */
	public int getCol(){
		return col;
	}
	
	/** 
	  * Sets the occupied status of the tile. when called it will adjust the occupied status to either false or true       
	 */
	public void setOccupied(){
		if(space == false){
			space = true;
		}else if(space == true){
			space = false;
			occupant = null;
		}
	}
	
	/** 
	*	returns the occupied status of the tile
	 * @return returns true or false if it is occupied or not
	 */
	public boolean isOccupied(){
		return space;
	}
	
	/** 
	  * Sets the animal class in occupant
	 */
	public void setOccupant(Animal a){
		occupant = a;
	}
	
	/** 
	  * returns the rank of the current occupant
	  * @return integer of the rank of the occupant
	 */
	public int getOccupantRank(){
		return occupant.getRank();
	}
	
	/** 
	  * returns the color of the occupant whether it is red or blue
	  * @return String color of the occupant
	 */
	public String getOccupantColor(){
		return occupant.getColor();
	}
	
	/** 
	  * returns the type of the tile
	  * @return String type of the tile
	 */
	public String getType(){
		return type;
	}
	
	/**
	* Animal Piece that occupies the tile class
	*/
	protected Animal occupant;
	/**
	* Determines the type of tile
	*/
	protected String type;
	/**
	* Row position of the tile
	*/
	protected int row;
	/**
	* Column position of the tile
	*/
	protected int col;
	/**
	* Occupied status of the tile
	*/
	protected boolean space;
}