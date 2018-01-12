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
		int count = 0;
		int constant = game.getUpperBound() / 2;
		int answer = constant;
		int branch = 2;
		while (!game.guess(answer)) {
			count += 1;
			System.out.println("Count: " + count);
			System.out.println(answer);
			
			if (game.getMessage().contains("too small")) {
				answer = answer + constant / branch;
			} else if (game.getMessage().contains("too large")) {
				answer = answer - constant / branch;
			}
			if(constant / branch >1){
				branch = branch * 2; 
			}
		}
		return answer;
	}
}
