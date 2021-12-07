/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Brandi Nguyen
 * bcn444
 * Slip days used: <1>
 * Fall 2021
 */

//class used to hold the output pegs and string to print out 
package assignment2;

public class Output {
	int blackPegs;
	int whitePegs; 
	String guess; 
	
	public Output(int blackPegs, int whitePegs, String guess) {
		this.blackPegs = blackPegs; 
		this.whitePegs = whitePegs; 
		this.guess = guess; 
	}

	//print method
	public static void printPegs(int blackPegs, int whitePegs, String guess) {
		System.out.println(guess + " -> " + blackPegs + "b_" + whitePegs + "w"); 
		//System.out.println();
	
	}
}