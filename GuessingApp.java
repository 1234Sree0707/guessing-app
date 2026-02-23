/**
*GuessingApp - Use Case 5: Game Result Storage
*
*This class coordinates the complete game flow
*and persists the final result after completion
*
*Responsibilites
*-Initialize game configurations
*-Accept and validate user guesses
*-Generate hints when applicable 
*Store game result at the end
*
*@author Developer
*@version 5.0
*/
import java.util.Scanner;
public class GuessingApp{	

	public static void main(String[] args) throws InvalidInputException{
	    System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
	    System.out.println("===========================\n");
		/*
		*Player name is captured once
		*and stored along with game results
		*/
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Player Name: ");
		String player=sc.nextLine();
	    GameConfig gameConfig=new GameConfig();
		HintService hints=new HintService();
		ValidationService inputvalidate=new ValidationService();
		gameConfig.showRules();
		int attempts=0;
		int hintc=0;
		/*
		*Tracks whether the player
		*successfully guessed the number
		*/
		boolean win=false;
		/*
		Game loop runs until the player 
		*exhausts the maximum attempts 
		*/
		while(attempts<gameConfig.getMaxAttemps()){
			System.out.println("Enter your guess: ");
			/*
			*User input is validated before
			*being used in the game logic.
			*/
			int guess=inputvalidate.validateInput(sc.nextLine());
			
			attempts++;
			String result=GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
			/*
			*A hint is generated only after 
			*an incorrect guess and within
			*the allowed hint limit.
			*/
			if(!"CORRECT".equals(result) && hintc<gameConfig.getMaxHints()){
				hintc++;
				System.out.println(hints.generateHint(gameConfig.getTargetNumber(),hintc));
			}	
			System.out.println(result);
			/*
			*Stop the loop immediately
			*if the correct number is guessed.
			*/
			if("CORRECT".equals(result)){
				break;
			}
        }	
        /*
        *Final game result is persisted
        *after the game loop completes/
        */
        StorageService s=new StorageService();
        s.saveResult(player,attempts,win);		
	}
}	
		
		