/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Brandi Nguyen
 * bcn444
 * Slip days used: <1>
 * Fall 2021
 */

//class used to save player history and print guesses
package assignment2;

public class History {
	String[] guessHistory;
	
	public History(int validGuesses) {
		this.guessHistory = new String[validGuesses]; 
		 
	}
	
	public void saveGuess(String guess) {
		for(int i = 0; i < guessHistory.length; i++) {
			if (guessHistory[i] == null) {
				guessHistory[i] = guess;
				break; 
			}
		}
	}
	
	public void printGuesses() {
		for(int i = 0; i < guessHistory.length; i++) {
			if (guessHistory[i] != null) {
				System.out.println(guessHistory[i]);
			}			
		}	
	}
}
