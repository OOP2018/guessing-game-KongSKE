import java.util.Random;
/**
 * Automatically find the secret to any NumberGame.
 * @author Varit Assavavisidchai
 *
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGame object must provide messages (getMessage)
	 * containg the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient solution
	 * 
	 * @param game is the NumberGame to solve
	 * @return the secret number.
	 */
	public int play(NumberGame game){
		
		long seed = System.nanoTime( );
		Random rand = new Random( seed );
		// get a random number between 0 and 9. Add 1 so the value is 1 - 10.
		int answer = rand.nextInt(game.getUpperBound()) + 1;
		while(!game.guess(answer)){
			if(game.getMessage().contains("small")){
				answer = rand.nextInt(game.getUpperBound()) + answer;
			}else if(game.getMessage().contains("large")){
				answer = rand.nextInt(answer);
			}
		}
		return answer;
	}
}
