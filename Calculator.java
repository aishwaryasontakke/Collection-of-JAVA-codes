/*
 * Calculator.java
 *
 * Version: 
 *        2
 *
 * Revisions:
 *        3
 */

/** 
 * Program to evaluate the expressions with or without parentheses. 
 * 
 * @author      Aishwarya Sontakke
 * @author      Sonia Rode
 */

import java.util.Vector;
import java.util.Stack;

public class Calculator {

    static Stack<Double> numberStack = new Stack<Double>();
    static Stack<String> operatorStack = new Stack<String>();

    static String operators =  "+-%*/^" ; 
    static String openingP[] = { "(", "[", "{" };
    static String closingP[] = { ")", "]", "}" };

/**
  * The main program.
  *
  * @param    args    command line arguments (ignored)
  */

    public static void main (String args []) {
      performCalculation("1", "*", "{", "2", "+", "3", "-","[", "1", "*", "(",
      "2", "-", "1",")", "]", "+", "3", "}");
      performCalculation("2", "+", "[", "(", "3", "-", "6", ")", "/", "5", "]");
      performCalculation("1", "+", "(", "2", "+", "3", ")", "*", "3");
      performCalculation("2", "^", "3","^", "4");
      performCalculation("(", "2", "^", "3", ")", "^", "4");
      performCalculation("9", "+", "4");
    }

/**
 * This method is used to get the entered strings in the form of a Vector and 
 * also prints the final answer.
 *
 * @param       valuesAndOPerators    These are the strings passed by the main
 *                                    function.
 *                                    
 * @return      void                  This method does not return any value.
 */

    public static void performCalculation (String ... valuesAndOperators) {
      Vector<String> aLine = new Vector<String>();
      for ( String valuesAndOperator: valuesAndOperators )  {
          aLine.add(valuesAndOperator);
          System.out.print(valuesAndOperator + " ");
      }

      //Call checkParentheses method calculates the result
      System.out.println(" =  " + checkParentheses(aLine) );
    }

/**
 * This method is used to check the occurence of parentheses and then
 * perform calculations accordingly.
 *
 * @param       aLine     This is the vector passed from the performCalculation
 *                        method.
 *                                                            
 * @return      ans       This is the final result evaluated for the passed 
 *                        vector.
 */

    public static double checkParentheses(Vector<String> aLine) {

      //Declared a loop to check every element of aLine for parentheses
      for (int endIndex=aLine.size()-1;endIndex>=0;endIndex--) {

        //Condition for the opening bracket.
        if (aLine.get(endIndex)=="("){
          Vector<String> bLine = new Vector<String>();

          //Declared currentIndex for the expression inside parentheses
          int currentIndex;

          //Storing the expression inside parentheses in vector bLine
          for(currentIndex=endIndex+1;aLine.get(currentIndex)!=")";
            currentIndex++){
              bLine.add(aLine.get(currentIndex));
          }

          //Calling calculate method on bLine
          double ans=calculate(bLine);

          //Casted ans to string ans1
          String ans1=Double.toString(ans);

          //Loop for removing the evaluated expressing from aLine
          for(int startIndex=endIndex;startIndex<currentIndex+1;startIndex++){
              aLine.removeElementAt(endIndex);
          }

          //Putting the answer of the evaluated expression in the main vector aLine.
          aLine.add(endIndex,ans1);
        }
//end of if for ()

        //Condition for the opening bracket.
        if (aLine.get(endIndex)=="["){
          Vector<String> bLine = new Vector<String>();

          //Declared currentIndex for the expression inside parentheses
          int currentIndex;

          //Storing the expression inside parentheses in vector bLine
          for(currentIndex=endIndex+1;aLine.get(currentIndex)!="]";
            currentIndex++){
              bLine.add(aLine.get(currentIndex));
          }

          //Calling calculate method on bLine
          double ans=calculate(bLine);

          //Casted ans to string ans1
          String ans1=Double.toString(ans);

          //Loop for removing the evaluated expressing from aLine
          for(int startIndex=endIndex;startIndex<currentIndex+1;startIndex++){
              aLine.removeElementAt(endIndex);
          }

          //Putting the answer of the evaluated expression in the main vector aLine.
          aLine.add(endIndex,ans1);
        }
//end of if for []

        //Condition for the opening bracket.
        if (aLine.get(endIndex)=="{"){
          Vector<String> bLine = new Vector<String>();

          //Declared currentIndex for the expression inside parentheses
          int currentIndex;

          //Storing the expression inside parentheses in vector bLine
          for(currentIndex=endIndex+1;aLine.get(currentIndex)!="}";
            currentIndex++){
              bLine.add(aLine.get(currentIndex));
          }

          //Calling calculate method on bLine
          double ans=calculate(bLine);

          //Casted ans to string ans1
          String ans1=Double.toString(ans);

          //Loop for removing the evaluated expressing from aLine
          for(int startIndex=endIndex;startIndex<currentIndex+1;startIndex++){
              aLine.removeElementAt(endIndex);
          }

          //Putting the answer of the evaluated expression in the main vector 
          //aLine.
          aLine.add(endIndex,ans1);
        }
//end of if for {}
      }

      Double ans=0.0;  

      //Condition when no parentheses exist i.e. after solving all parentheses
      //or when there are no parentheses at all.   
      while ( aLine.size() >= 1 ){
        ans=calculate(aLine);
      }
      return ans ;
    } 

/**
 * This method decides whether the element in inputLine is an operator
 * or a number and then performs corresponding operations.
 *
 * @param       inputLine           This is the vector passed from the 
 *                                  checkParentheses method.
 *                                                            
 * @return      numberStack.pop()   The result for inputLine is calculated and 
 *                                  stored in the numberStack which is returned 
 *                                  here.                           
 */

    public static double calculate (Vector<String> inputLine) {
      while ( inputLine.size() >= 1 ) {
        if ( operator( inputLine.firstElement() ) )
          performOperator(inputLine.firstElement());
        else
          performNumber(inputLine.firstElement());
      inputLine.removeElementAt(0);
      }
      while ( !  operatorStack.empty() )  {
        if ( numberStack.size() > 1 )
          evaluate();
        else  {
          System.out.println("dangling operand ....");
          System.out.println(numberStack);
          System.exit(1);
        }
      }
      return numberStack.pop();
    }

/**
 * This method checks whether the passed string is present in the operators 
 * string.
 *
 * @param       op           This is the string passed from calculate method
 *                           to check if it is operator or not.
 *                                                                                    
 * @return      true/false   Depending on the result of the condition,
 *                           the method returns true if the string is an 
 *                           operator(i.e its present in the operators string) 
 *                           else it returns false.                           
 */

    public static boolean operator (String op) {
      return ( operators.indexOf(op) >= 0 );
    }

/**
 * This method determines a precedence level for the operator
 *
 * @param       op                      This is the string passed from 
 *                                      performOperator method to check its 
 *                                      precedence.
 *                                                                              
 * @return      operators.indexOf(op)   It returns the index of the passed 
 *                                      string in the operators string.                           
 */

    public static int precedence (String op) {
      return operators.indexOf(op);
    }

/**
 * This method performs required operation based on precedence on the stack.
 *
 * @param       op       This is the string passed from calculate method
 *                       to evaluate it depending on the precedence.
 *                                                                                    
 * @return      void     This method does not return any value.                          
 */

    public static void performOperator (String op) {
      while (!operatorStack.empty() && 
      (precedence(op)<precedence(operatorStack.peek())))
        evaluate();
      operatorStack.push(op);
    }

/**
 * This method pushes the number on the number stack.
 *
 * @param       number        This is the string passed from calculate method
 *                            to push it into the stack if its a number.
 *                                                                                    
 * @return      void          This method does not return any value.                          
 */

    public static void performNumber (String number) {
      numberStack.push(Double.valueOf(number));
    }

/**
 * This method gets the number of the stack, if a number is available.
 *
 * @param       none                  This method does not take any parameter.
 *                                                                                    
 * @return      numberStack.pop()     This method returns the numberStack-top
 *                                    for evaluation.                          
 */

    public static double  getNumber () {
      if ( numberStack.empty() ){
        System.out.println("not enough numbers ...");
        System.exit(2);
      } 
      return numberStack.pop();
    }

/**
 * This method perform the required operation based on the operator in the stack.
 *
 * @param       none        This method does not take any parameter.
 *                                                                                    
 * @return      void        This method does not return any value.                          
 */

    public static void evaluate () {
      String currentOp = operatorStack.pop();
      double right = getNumber();
      double left = getNumber();
      if ( currentOp.equals("+") )
        numberStack.push( left + right );
      else if ( currentOp.equals("-") )
        numberStack.push( left - right );
      else if ( currentOp.equals("*") )
        numberStack.push( left * right );
      else if ( currentOp.equals("%") )
        numberStack.push( left % right );
      else if ( currentOp.equals("/") )
        numberStack.push( left / right );
      else if ( currentOp.equals("^") )
        numberStack.push( Math.pow(left , right ) );
      else
        System.out.println("Unknow Operator");
    }
}
