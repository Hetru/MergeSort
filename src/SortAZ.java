
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hetru2942
 */
public class SortAZ {
    /*
    Creates a new list, could temp, and passes temp and the array used in the parameters to mergeSortAZ
    */
    public static void mergeSortAZ(ArrayList<Integer> numbers) 
    {
        //Creates temporary list to help rearrange the values
        Comparable[] temp = new Comparable[numbers.size()];
        //Passes the arraylist listed int he parameters and the newly created temp list
        mergeSortAZ(numbers, temp,  0,  numbers.size() - 1);
    }
    
    /*
    Recurisve method that breaks down the original arraylist into smaller chunks of two and passes the smaller pieces thorough method mergeAZ for the actual sorting
    */
    private static void mergeSortAZ(ArrayList<Integer> numbers, Comparable [ ] temp, int left, int right)
    {
        if( left < right ) //compares the two end value of the chunk
        {
            int center = (left + right) / 2;
            mergeSortAZ(numbers, temp, left, center);
            mergeSortAZ(numbers, temp, center + 1, right);
            mergeAZ(numbers, temp, left, center + 1, right);
        }
    }

    private static void mergeAZ(ArrayList<Integer> numbers, Comparable[ ] temp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int variable = left;
        int num = rightEnd - left + 1;

        
        while(left <= leftEnd && right <= rightEnd)
            if(numbers.get(left).compareTo(numbers.get(right)) <= 0)
                temp[variable++] = numbers.get(left++);
            else
                temp[variable++] = numbers.get(right++);

        while(left <= leftEnd)    // Copy rest of first half
            temp[variable++] = numbers.get(left++);

        while(right <= rightEnd)  // Copy rest of right half
            temp[variable++] = numbers.get(right++);

        
        // Copy temp back into names
        for(int i = 0; i < num; i++, rightEnd--)
            numbers.set(rightEnd,(int)temp[rightEnd]);
    }
}
