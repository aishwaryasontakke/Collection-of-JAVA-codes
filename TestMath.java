/* 
 * TestMAth.java 
 * 
 * Version: 
 *       1 
 * 
 * Revisions: 
 *       3
 */

/**
 * This program is used to calculate square root and absolute value of a number
 * and give maximum between two numbers.  
 *
 * @author      Aishwarya Sontakke
 * @author      Soniya Rode
 */

 public class TestMath {

	static double x1;
	static double x0;
 	static double epsilon = 0.00001;
 	static int counter;

/**
  * The main program.
  *
  * @param    args    command line arguments (ignored)
  */
 	
 	public static void main(String args[]) {
 		double ans;

 		ans=Sqrt(16);
 		System.out.println("Square root of 16  : " + ans); 		
 		ans=Sqrt(0);
 		System.out.println("Square root of 0   : " + ans);
 		ans=Sqrt(-9); 
 		System.out.println("Square root of -9  : " + ans);
 		ans=Sqrt(5);
 		System.out.println("Square root of 5   : " + ans);
 		ans=Sqrt(4.5);
 		System.out.println("Square root of 4.5 : " + ans);
 		System.out.println();

 		ans=abs(-5);
 		System.out.println("Absolute of -5   : " + ans);
 		ans=abs(23);
 		System.out.println("Absolute of 23   : " + ans);
 		ans=abs(17.5);
 		System.out.println("Absolute of 17.5 : " + ans);
 		System.out.println();

 		ans=max(-7,10);
 		System.out.println("Maximum of -7 and 10  : " + ans);
 		ans=max(7,-10);
 		System.out.println("Maximum of 7 and -10  : " + ans);
 		ans=max(7, 10);
 		System.out.println("Maximum of 7 and 10   : " + ans);
 		ans=max(-7,-10);
 		System.out.println("Maximum of -7 and -10 : " + ans);
 		ans=max(7,7);
 		System.out.println("Maximum of 7 and 7    : " + ans);
 		ans=max(0,-7);
 		System.out.println("Maximum of 0 and -7   : " + ans);
 		ans=max(0,7);
 		System.out.println("Maximum of 0 and 7    : " + ans);

 		testSqrt();
 	}

/**
 * This method runs the initial condition for the Sqrt method.
 * 
 * @param       n    		This is the double number whose square root has to
 *                          be found.
 *                                    
 * @return      double      This method returns a double value depending on the
 *							specified condition for further computation.
 */

 	public static double initial(double n){

 		//Taking the approximation for the Newton's formula of root finding.
 		x0= abs(n/2);

 		if(n<0){
			return (Double.NaN);
 		}
 		else if (n>0){

 			//Calculating the next approximation using Newton's formula
	 		x1=x0-((x0*x0)-n)/(2*x0);
	 		return(x1);
		}
		else{
			return 0;
		}
 	}

/**
 * This method calculates the square root .
 * 
 * @param       n    		This is the double number whose square root has to
 *                          be found.
 *                                    
 * @return      double      This method returns the square root of n.
 */

 	public static double Sqrt(double n){

 		//Counter set to run initial condition.
		counter++;
		if(counter==1) 
 			x1=initial(n);

 		if(n<0){
 			return (Double.NaN);
 		}
 		else if(n>0){

 			//Calculating the next approximation using Newton's formula
	 		x1=x0-((x0*x0)-n)/(2*x0);

	 		//Condition for checking the error
	 		double t=x1*x1;
	 		if(abs(n-t)<epsilon){
				return(x1);	 		
			}
	 		else{

	 			//Using the Newton's formula again with updated approximation.
	 			x0=x1;
	 			return	Sqrt(n);
	 		}
		}
		else{
			return 0;
		}

	}

/**
 * This method calculates the absolute value of the passed parameter.
 * 
 * @param       n    		This is the double number whose absolute value has
 *                          to be found.
 *                                    
 * @return      double      This method returns absolute value of n.
 */

	public static double abs(double n){
		if(n<0){
			return n*(-1);
		}
		else{
			return n;
		}
	}

/**
 * This method gives the maximum integer of the two passed integers.
 * 
 * @param       n1,n2    	These are the integer numbers to be compared.
 *                                    
 * @return      double      This method returns the greater number between n1
 *							and n2.
 */

	public static int max(int n1, int n2){
		if(n1>n2){
			return n1;
		}
		else{
			return n2;
		}
	}

/**
 * This method tests the Sqrt() method for different cases.
 * 
 * @param       -    	-
 *                                    
 * @return      void    This method does not return any value.
 */

	static void testSqrt(){
    	if ( 0 != Sqrt(0) )
            System.out.println("Test 1: sqrt failed");     
    	if ( 0 != Sqrt(-0) )
            System.out.println("Test 2: sqrt failed");
    	if ( Double.NaN == Sqrt(-1) )
            System.out.println("Test 3: sqrt failed");
    	if ( Double.NaN == Sqrt(Double.NaN) )
        	System.out.println("Test 4: sqrt failed");
    	double result;
    	double aDouble;
    	double theDoubles[] = {1, 2, 3, 4, 5 };
    	for ( int index = 0; index < theDoubles.length; index ++ ){
            result = Sqrt(theDoubles[index]);
            if ( abs( result * result - theDoubles[index] ) > epsilon )
                System.out.println("Test 5: sqrt failed: " + 
                	( result * result - theDoubles[index] ));
    	}
	}
}
