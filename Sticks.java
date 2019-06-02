/** 
 * Sticks.java 
 * 
 * Version: 
 *       2 
 * 
 * Revisions: 
 *       2
 */

/**
 * This program can determine if a combination for  given length of sticks 
 * is present as the sum of known stick lengths. If such a set is present,
 * it prints out one such set.  
 *
 * @author      Soniya Rode
 * @author      Aishwarya Sontakke
 */
 
class Sticks {

    //Initalize arrays of stick lengths 
    static int[] stickLengths = { 1, 2, 3, 5, 8 };
    static int flag=0;
    static int[] unknowStickLengths = { 1, 5, 6, 7, 8, 9, 3};
 
    /**
     * getSubset method creates all subsets of  given length. For each, checks 
     * the subset sum, if sum=unknownStick length,it prints out the subset. 
     *
     * @param       stickLengths[]    Array of known stick lengths
     * @param       subsetArray[]     Array used to store current subset
     * @param       startIndex        Start Index for subsetArray    
     * @param       endIndex          End Index for subsetArray
     * @param       currentIndex      To check if Array of given subsetLength is formed
     * @param       subsetSize        Desired size of the subset
     * @param       unknownStick      Stick length to check sum for

     * @return      The method does not return any type.
    */

    public static void getSubset( int stickLengths[],int subsetArray[],int startIndex, int endIndex,int currentIndex,int subsetSize,int unknownStick){
        
        //If current subset size is equal to given size check its sum.
        if (currentIndex == subsetSize)
        {   int sum=0;
            
            //Calculate the sum for current subset.
            for (int j=0; j<subsetSize; j++) {
                sum+=subsetArray[j];
            }
            if(sum==unknownStick){  

                //Flag variable is set when unknown sitck sum is found 
                flag=1;
                System.out.print("Sum present for :"+unknownStick+" Sticks used are : ");
                for(int j=0;j<subsetArray.length;j++)
                {
                    System.out.print(subsetArray[j]+" inch ");
                }
                System.out.println("");
            }
            return;
        }
        for (int i=startIndex;i<=endIndex && endIndex-i+1 >= subsetSize-currentIndex;i++)
        {
            subsetArray[currentIndex] = stickLengths[i];
            getSubset(stickLengths, subsetArray, i+1, endIndex, currentIndex+1, subsetSize,unknownStick);
        }
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments (ignored)
     */
   
    public static void main(String args[]){
        
        //Pass the unknown stick lengths to getSubset Method .
        for ( int index = 0; index < unknowStickLengths.length; index++ ){
            int subsetSize;

            //To get subsets of all sizes  till stickLengths.length 
            for(subsetSize=0;subsetSize<=stickLengths.length;subsetSize++){
                
                //If flag is set, array for unknown stick is alreay found.
                if(flag==1){
                    flag=0;
                    break;
                }
                int subsetArray[]=new int[subsetSize];

                //For all subset size call getsubset  to get subets and store them in subsetArray.
                getSubset(stickLengths, subsetArray, 0,stickLengths.length-1, 0, subsetSize,
                unknowStickLengths[index]);
            }
        }
    }    
}
