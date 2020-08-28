# Collection of JAVA codes
This repository consists a collection of java programs addressing various problem statements

## 1. Stick-length-problem: Sticks.java 
Designing, implementing, and testing of an algorithm.</br>
 
This program determines if a combination for given length of sticks is present as the sum of known stick lengths. If such a set is present, it prints out one such set. </br>

Explanation:</br>
Assume given is the following set S = { 1, 2, 3, 4, 6 } and s_new, with length 5. The following combinations would add up to the length of 5:
- 1 + 4 = 5
- 2 + 3 = 5

This program returns one of such combinations.

## 2. Sum-of-Prime-Factors: Prime.java

Compilation of a Java program, designing, implementing, and testing of an algorithm.</br>

This program computes the sum of the prime factorials for n where 2 ≤ n ≤ 10.</br>

Explanation: </br>
The prime factorials of 6 are 2 and 3. The sum of the prime factorials are 2 + 3 = 5. In this way, the program computes such sum for all the numbers from 2 to 10.

## 3. Calculator: Calculator.java 

Program to evaluate the values of expressions so such the numerical expression can include ’(’, ’)’, ’[’, ’]’, ’{’, ’}’. All operations are performed on integers with integer results.</br>
The paranthesis of the numerical exporessions have to match pairwise.</br>

An example of a solution execution:</br>
1 * { 2 + 3 - [ 1 * ( 2 - 1 ) ] + 3 }  =  7.0</br>
2 + [ ( 3 - 6 ) / 5 ]  =  2.0</br>
1 + ( 2 + 3 ) * 3  =  16.0</br>
2 ^ 3 ^ 4  =  2.4178516392292583E24</br>
( 2 ^ 3 ) ^ 4  =  4096.0</br>

## 4. Test-Math-functions: TestMath.java

Design, implementation, and testing of algorithm. </br>

Implementation from the Math class the following methods: </br>
- static double   abs(double a)
- static int      max(int a, int b)
- static double   sqrt(double a)

and a test method for each method. No methods from Math class are used.
