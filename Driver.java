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
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Use this for your testing.  We will not be calling this method.
    	String[] colors= {"B","G","O","P","R","Y"}; 
    	GameConfiguration newGameConfiguration = new GameConfiguration(12, colors, 4); 
    	//SecretCodeGenerator newSecretCodeGenerator = new SecretCodeGeneratorMock(Arrays.asList("OPGB", "RBBY"));
    	SecretCodeGenerator newSecretCodeGenerator = new SecretCodeGenerator(newGameConfiguration); 
    	boolean isTesting = false; 
    	start(isTesting, newGameConfiguration, newSecretCodeGenerator);
 
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
        // TODO: complete this method
		// We will call this method from our JUnit test cases.

    	Scanner s = new Scanner(System.in);
    	
    	//introduction greeting
    	System.out.println("Welcome to Mastermind."); 
    	
    	boolean done = false; 
    	while(!done) {
			System.out.println("Do you want to play a new game? (Y/N):");
			try {
				String answer = s.nextLine();
				
				if(answer.equals("N")) {
					return;
				} else {
					String secretCode = generator.getNewSecretCode();
					Game newGame = new Game(isTesting, secretCode, s, config);
					newGame.startGame(); 
				}
			} catch (NoSuchElementException ex) {
				return;
			}
    	}
    }       

}
