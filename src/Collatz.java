


public class Collatz
{
	
	// Define property
	long n;
	String nString = "";
	//Define startValue
	Long startValue = n;
	
	
	// Create method
	public Collatz(long n)
	{

		
		
		// do while we do not reach 1
		do
		{
			// create nString var and paste loop results -integers- one after the other with space in between.
	        nString += (n + " "); 
	        
	        // If n is odd 
	        if ((n % 2) != 0)
	        {
	            n = 3 * n + 1; 
	        }
	  
	        // If even 
	        else
	        {
 	            n = n / 2;
	        }
		}
		// conditions are necessary to stop endless loops. 
		// startValue condition is necessary to recognize the end of the cycle when the startValue returns
		while( n != 1 && n != -1 && n != -5 && n != -17 && n != startValue);

		
		// nString results are converted to a String value.
		// You can also use nString = nString.concat(...);
		nString += Long.toString(n); 
		
	
	}
	
	
}





