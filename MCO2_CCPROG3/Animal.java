public class Animal{
	/**
	* name of the piece
	*/
	  private String name;
	/**
	* rank of the piece
	*/
	  private int rank;
	/**
	* row position of the piece
	*/
	  private int row;
	/**
	* column position of the piece
	*/
	  private int col;
	/**
	* attribute to save the rank of the animal when it goes through a trap tile
	*/  
	  private int saveRank;
	/**
	* Color of the piece
	*/
	  private String color;
	  /**
	* status of animal if it is caught in a trap
	*/
	private boolean caught;
	
	/**
	* Constructor of the piece
	*
	*@param n Name of the piece
	*@param r rank of the animal
	*@param row Row position of the piece
	*@param col Column position of the piece
	*@param c Color of the piece
	*/
	public Animal(String n, int r, int row, int col, String c){
      this.name = n;
      this.rank = r;
      this.row = row;
      this.col = col;
      this.color = c;
	  saveRank = 0;
	  caught = false;
  }

	/**
	* Sets the position of the piece in the board
	*@param r row posiiton of piece
	*@param c column position of the piece
	*/
	public void setPosition(int r, int c){
		  row = r;
		  col = c;      
	  }

	/**
	* Returns the name of the piece
	*@return String type of the name of the piece
	*/
	public String getName(){
		return name;
	  }
	  
	/**
	* Method activates when piece encounters a tile that is of type "trap" and updates the caught status
	*/
	public void trapRank(){
			if(caught == true){
				caught = false;
				rank = saveRank;
			}else if(caught == false){
				caught =true;
				saveRank = rank;
				rank = 0;
			}
			
		}
		
	/**
	* Returns the rank of the animal piece
	*@return integer of the rank of the piece
	*/
	public int getRank(){
		return rank;
	  }
	
	/**
	* Returns the caught status
	*@return true or false if it is caught in a trap
	*/
	public boolean trapStatus(){
		  return caught;
	  }
	
	/**
	* returns the current row position of the piece
	*@return current row of the piece
	*/
	public int getRow(){
		return row;
	  }
	
	/**
	* returns the current column position of the piece
	* @return current column position of the piece
	*/	
	public int getCol(){
		return col;
	  }
	
	/**
	* returns the color of the piece
	*@return Color of the piece
	*/
	public String getColor(){
    return color;
  }
}