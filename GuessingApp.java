/**
*GuessingApp - Use Case 1: Game Intiialization
*
*This class serves as the application entry point.
*It initializes the game configuration and displays game rules.
*
*No user or gameplay logic is implemented at this stage.
*
*@author Developer
*@version 1.0
*/
import java.util.Scanner;
public class GuessingApp{	
	public static void main(String[] args){
		System.out.println("Welcome to the Guessing App");
		GameConfig gameConfig=new GameConfig();
		gameConfig.showRules();
		Scanner sc=new Scanner(System.in);
		int attempts=0;
		while(attempts<gameConfig.getMaxAttemps()){
			System.out.println("Enter your guess: ");
			int guess=sc.nextInt();
			attempts++;
			String result=GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
			System.out.println(result);
			if("CORRECT".equals(result)){
				break;
			}
        }			
	}
}	
		
		