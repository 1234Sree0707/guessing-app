/**
*GuessingApp - Use Case : Error Handling and input validation
*
*This class coordinates the game execution while ensuring
*all user inputs are safely validated before processing
*
*Responsibilites
*-Initialize game configurations
*-Accept user input
*-Validate input using ValidationService
*Handling game flow without crashing on invalid input
*
*@author Developer
*@version 4.0
*/
import java.util.Scanner;
public class GuessingApp{	
	public static void main(String[] args) throws InvalidInputException{
		System.out.println("Welcome to the Guessing App");
		GameConfig gameConfig=new GameConfig();
		HintService hints=new HintService();
		ValidationService inputvalidate=new ValidationService();
		gameConfig.showRules();
		Scanner sc=new Scanner(System.in);
		int attempts=0;
		int hintc=1;
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
	}
}	
		
		
