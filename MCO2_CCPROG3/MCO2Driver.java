public class MCO2Driver{
	public static void main(String[] args){
		
		Board board = new Board();
		GUI mco2 = new GUI();
		Controller controller = new Controller(mco2, board);
	}
}