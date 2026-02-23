class GuessValidator{
	/*
	*Compares guess with target and 
	*returns the comparison result
	*/
	public static String validateGuess(int guess,int target){
		if(guess==target){
			return "CORRECT";
		}else if(guess<target){
            return "LOW";
        }
        return "HIGH";
    }
}	
			