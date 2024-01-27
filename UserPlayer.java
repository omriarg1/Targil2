//OFEK CASPI - 208895367 Omri argaman - 314772351
package XO2;
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class UserPlayer extends Player implements Runnable {
	private UserGame UserGame;
	public UserPlayer(UserGame Game,XO playerType) {
		super(playerType);
		this.UserGame=Game;
	}
	
	public void run() {
		while(UserGame.checkWinner()==null)
		{
			if(UserGame.getcurrentTurn()!=this.getPlayerType())
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			else {
				  if(UserGame.getTurnCounter()==25) {//0 0 0
					  System.out.println("Board is full");
					  UserGame.EndGame();
					  break;
				  }
				  else {
					  synchronized(UserGame) {//critical code
				  Scanner s = new Scanner(System.in);
				  System.out.println("Your turn");
				  UserGame.printBoard();
				  int row=-1,col=-1;
				  while(!MakeMove(row,col))
				  {  
					    try {
						  System.out.println("Please the number of the row u want to Fill: ");
						  row=s.nextInt();
						  System.out.println("Please the number of the Column u want to Fill: ");
						  col=s.nextInt();	
						  if(!isFree(row,col))
							  System.out.println("Cell not empty Please re enter");
					    }
					    catch(InputMismatchException e) {
					    	System.out.println("Wrong cell entered cell must be a number");
					    	col=row=-1;
					    	s.nextLine();	
					    	}
				  }
				  UserGame.printBoard();
			      UserGame.incturnCounter();
					  }
				  }
			}
		}
	}
	public boolean isFree(int row,int col) {
		if(row<0 || row > 4 || col<0 || col > 4)return false;
		if(UserGame.getCell(row, col)==XO.E)
			return true;
		return false;
	}
	public boolean MakeMove(int row,int col){
		if(!isFree(row,col))
			return false;
    	Point pointToFill=new Point(row,col);
        UserGame.fillPoint(pointToFill, getPlayerType());
        return true;
}
}
