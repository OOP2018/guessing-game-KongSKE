package guessingGame;
/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new VaritGame(upperBound);
//		GameConsole ui = new GameConsole( );
//		int solution = ui.play( game );

//		System.out.println("The answer is "+solution);

		GameSolver ai = new GameSolver();
		int bot = ai.play(game);
		System.out.println("Count: " + game.getCount());
		System.out.println("The answer is " + bot);
		
	}
}
