/*
 * Prime.java
 *
 * Version: 
 *        1
 *
 * Revisions:
 *        2
 */

/** 
 * This program calculates the sum of prime factors of numbers from 2 to 10. 
 * 
 * @author      Aishwarya Sontakke
 * @author      Sonia Rode
 */

public class Prime {

  //Declare index j to store prime numbers in array aPrime
  static int  j=0; 

  //Declare array aPrime to store all the prime numbers
  static int aPrime[]=new int[100]; 

/**
 * This method is used to determine whether the passed number is prime or not.
 *
 * @param       n                 This is the number passed from the main function
 *                                that has to be checked as prime or non-prime.
 *
 * @return      true/false        Depending on the result of the condition,
 *                                the method returns true if the number is Prime
 *                                else it returns false.
 *
 */
  
  public static boolean isPrime(int n) {

      //Condition for prime numbers.
      for ( int index = 2; index < n; index ++ ){
          if ( n % index  == 0 )
            return false;
      }

      //Storing all the prime numbers in array aPrime.
      aPrime[j]=n; 
      j++;
      return true;
  }

/**
 * This method finds and stores the sum of prime factors of a not prime number.
 *
 * @param       NPrime            This is the number passed from the main function
 *                                which is qualified as not prime 
 *
 * @return      void              This method does not return any value.
 *
 */

  public static void notPrime(int NPrime){ 
      int NFinal=NPrime;

      //Declare array to store the factorials of non-prime numbers.
      int aFact[]=new int[100];

      //Declare index q to store prime factors in array aFact.
      int q=0;
      for(int p=0;p<NPrime;p++){

          //Condition to find prime factors of the non-prime number 
          //from the primes stored in array aPrime.
          while(NPrime % aPrime[p]==0){

            //Storing the factors in aFact array.
            aFact[q]=aPrime[p];
            q++;

            //Dividing Nprime by the same prime number to find the next factor.
            NPrime=NPrime/aPrime[p];
          }
      }
      int sum=0;
      System.out.print("All primes for "+NFinal+" are \t");

      //Finding the sum of all the factors
      for(int k=0;k<q;k++){ 
          sum=sum+aFact[k];
          System.out.print(aFact[k]+" ");
      }
      System.out.print("\t"+", their sum is "+sum);
      System.out.println();
  }

  /**
   * The main program.
   *
   * @param    args    command line arguments (ignored)
   */

  public static void main( String args[] ){
      for ( int index = 2; index <= 10; index ++ ){
          if ( isPrime(index) ){
            System.out.println("All primes for "+index+" are \t"+index
              +"\t"+", their sum is "+index);
          }
          else{
            notPrime(index);            
          }
      }
  }
}
