
// Class to perform input check function and return true or false.
public class CheckInput
{

	// Define property
	public static long inputNumber;
	
	
	

	// create a function that returns a boolean with parameter -input-.
	public Long checkInputString(String input)
	{
		try
		{
			// if check for integer max and min
			// Try to parse string to integer. This will succeed or trow an exception.
			inputNumber = Long.parseLong(input);
			return inputNumber;
			
		}
		/*
		special exception that recognizes the error in which the string is not in right format to parse into integer.
		*/
		catch(NumberFormatException e)
		{
			System.out.println("Input cannot be converted to long " + e);
			return null;
		}
	}
}