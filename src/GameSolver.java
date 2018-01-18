import java.util.Random;

/**
 * Automatically find the secret to any NumberGame.
 * 
 * @author Varit Assavavisidchai
 *
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution. The NumberGame object must
	 * provide messages (getMessage) containg the phrase "too small" if a guess
	 * is too small and "too large" if a guess is too large, for efficient
	 * solution
	 * 
	 * @param game
	 *            is the NumberGame to solve
	 * @return the secret number.
	 */
	public int play(NumberGame game) {
		int min = 1;
		int max = game.getUpperBound();
		int guess = min + (max - min) / 2;
		while (!game.guess(guess)) {
			System.out.println(guess);
			if (game.getMessage().contains("too large")) {
				max = guess - 1;
				guess = min + (max - min) / 2;
			}
			if (game.getMessage().contains("too small")) {
				min = guess + 1;
				guess = min + (max - min) / 2;
			}
		}
		return guess;
	}
}
