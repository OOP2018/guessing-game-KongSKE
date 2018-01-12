import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		
		// describe the game
		System.out.println( game.toString() );
		// This is just an example.
		System.out.println( game.getMessage() );
		System.out.print("Your answer? ");
		int guess = console.nextInt();
		while(game.guess(guess)!=true){
			System.out.println(game.getMessage());
			System.out.print("Your answer? ");
			guess = console.nextInt();
		}
		System.out.println(game.getMessage());
		System.out.println("Count: "+game.getCount());
		return guess;

	}
	
}
