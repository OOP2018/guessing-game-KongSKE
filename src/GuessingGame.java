import java.util.Random;

/**
 * Guess What is secret number between 1 to XX
 * @author Varit Assavavisidchai
 *
 */
public class GuessingGame extends NumberGame {
	private int upperBound;
	private int secret;
	private String message;
	private int counter;

/**
 * 
 * @param upperbound is highest value of random number can be.
 */
	public GuessingGame(int upperbound) {
		this.upperBound = upperbound;
		this.secret = randomNumber(upperbound);
		this.counter = 0;
	}

	/**
	 * 
	 * @param number is answer from user.
	 * @return Check and answer that correct or not
	 */
	public boolean guess(int number){
		this.counter +=1;
		if(number==this.secret){
			super.setMessage("Correct, the secret is "+this.secret);
			return true;
		}else if(number<this.secret){
			super.setMessage("Sorry, too small.");
			return false;
		}else{
			super.setMessage("Sorry, too large.");
			return false;
		}
	}
	
	/**
	 * @return upperBound value
	 */
	public int getUpperBound(){
		return this.upperBound;
	}
	
	/**
	 * @return Description about this game 
	 */
	public String toString(){
		return "Guess a secret number 1 to "+upperBound;
	}
	
	/**
	 * @return Value of count.
	 */
	public int getCount(){
		return this.counter;
	}
	
	/**
	 * 
	 * @param limit is highest value of random number can be.
	 * @return return value of random number.
	 */
	private int randomNumber(int limit){
		// generate an unpredictable seed
		long seed = System.nanoTime( );
		Random rand = new Random( seed );
		// get a random number between 0 and 9. Add 1 so the value is 1 - 10.
		int value = rand.nextInt(limit) + 1;
		return value;
	}
}
