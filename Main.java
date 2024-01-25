//OFEK CASPI - 208895367 Omri argaman - 314772351
//https://github.com/omriarg1/Targil2
package XO2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
	   System.out.println("Welcome\n1-Play vs Computer\n2-Watch computer play");
	   Scanner s = new Scanner(System.in);
	   int choice =s.nextInt();
	   int Type;
	   switch(choice) {
	   case 1:
	   System.out.println("Okay\n1-Play as X\n2-Play as O");
	   Type=s.nextInt();
	   UserGame newGame2 = new UserGame();
	   if(Type==1) {
	   SelfPlayer Computer = new SelfPlayer(newGame2,XO.O);
	   UserPlayer user = new UserPlayer(newGame2,XO.X);
	   System.out.println("----Starting Game----");
	   newGame2.StartMatch(Computer, user);
	   }
	   else if(Type==2){
		   SelfPlayer Computer = new SelfPlayer(newGame2,XO.X);
		   UserPlayer user = new UserPlayer(newGame2,XO.O);
		   System.out.println("----Starting Game----");
		   newGame2.StartMatch(Computer, user);
	   }
	   else throw new Exception("Must choose between 1 and 2");
	   break;
	   case 2:
		 SelfGame selfGame = new SelfGame();
		 SelfPlayer playerX = new SelfPlayer(selfGame,XO.X);
		 SelfPlayer playerO = new SelfPlayer(selfGame,XO.O);
		 System.out.println("----Starting Game----");
		 selfGame.StartMatch(playerX, playerO);
		 break;
	     default: throw new Exception("Must choose between 1 and 2");
	   }
	   
	}

}
