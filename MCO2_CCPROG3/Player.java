

public class Player{
	/**
	* Constructor of the player class
	*@param turn of the player
	*/
	public Player(int t){
		turn = t;
		pieceCount = 8;
	}
	
	/**
	* deducts the count of the piece the player is currently holding
	*/
	public void minusPiece(){
		pieceCount--;
	}
	
	/**
	* returns the current count of the pieces the player is holding
	*@return number of pieces
	*/
	public int getPieceCount(){
		return pieceCount;
	}
	
	/**
	* returns the turn of the Player
	*@return returns if player is 1 or 2
	*/
	public int getTurn(){
		return turn;
	}
	
	/**
	* Determines whether player is 1 or 2
	*/
	private int turn;
	/**
	* Number of pieces the player holds
	*/
	private int pieceCount;
}