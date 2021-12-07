/*
 * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data. 
 * Brandi Nguyen
 * bcn444
 * Slip days used: <1>
 * Fall 2021
 */

package assignment2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {
	
	Scanner s; 
	GameConfiguration config;
	boolean isTesting;
	String secretCode;
	History newHistory; 
		
	public Game(boolean isTesting, String secretCode, Scanner s, GameConfiguration config) {			
		this.s = s; 
		this.config = config; 
		this.isTesting = isTesting;
		this.secretCode = secretCode;
		this.newHistory = new History(config.guessNumber);
	}
	
	public void startGame() {
		//testing is true, print secret code
		if (isTesting) {
			System.out.println("Secret Code: " + secretCode);
		}
		
		int guessesLeft = config.guessNumber; 
		while(guessesLeft > 0) {
			System.out.println();
			System.out.println("You have " + guessesLeft + " guess(es) left."); 
			System.out.println("Enter guess: ");
			try {
				String guess = s.nextLine(); 
				if (guess.equals("HISTORY")) {
					newHistory.printGuesses();
					continue; 
				}
				//if valid check if code guessed correctly
				if(isValid(guess)) {
					if (guess.equals(secretCode)) { 
						System.out.println(guess + " -> " + config.pegNumber + "b_0w");
						System.out.println("You win!");
						System.out.println(); 
						return;  
					} else {
						//else valid guess; process response and decrement guesses
						guessesLeft--;
						processResponse(guess);
						 
					}				
				}
			} catch (NoSuchElementException ex) {
				return;
			}
		}
		
		//else you lose when out of guesses
		System.out.println("You lose! The pattern was " + secretCode);
		System.out.println(); 
					
	}
	
	//check if valid
	public boolean isValid(String guess) {
		if (guess.length() != config.pegNumber) {
			System.out.println("INVALID_GUESS");
			return false; 
		}
		
		for (int i = 0; i < config.pegNumber; i++) {
			if (!Arrays.asList(config.colors).contains(String.valueOf(guess.charAt(i)))) {
				System.out.println("INVALID_GUESS");
				return false; 
			}
					
		}
		
		return true; 
	}
	
	//process response to guess
	public void processResponse(String guess) {
		int blackPegs = 0;
		int whitePegs = 0;
		char[] temp = secretCode.toCharArray();
		List<String> colors = new LinkedList<String>(Arrays.asList(config.colors));
 
		for (int i = 0; i < config.pegNumber; i++) {
			if(secretCode.charAt(i) == guess.charAt(i)) {
				blackPegs++;
				temp[i] = ' ';
			}
		}
		
		for (int i = 0; i < config.pegNumber; i++) {
			if(temp[i] != ' ' && 
					String.valueOf(temp).contains(String.valueOf(guess.charAt(i))) && 
					colors.contains(String.valueOf(guess.charAt(i)))) {
				whitePegs++;
				colors.remove(String.valueOf(guess.charAt(i)));
			}
		}
		
		//print and save history 
		Output.printPegs(blackPegs, whitePegs, guess);
		
		newHistory.saveGuess(guess + " -> " + blackPegs + "b_" + whitePegs + "w");
	}
		
}

