
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
public class SortZA {
    public static void mergeSortZA(ArrayList<Integer> numbers)
    {
        Comparable[] temp = new Comparable[numbers.size()];
        mergeSortZA(numbers, temp,  0,  numbers.size() - 1);
    }
    
    private static void mergeSortZA(ArrayList<Integer> numbers, Comparable [ ] temp, int left, int right)
    {
        if( left < right )
        {
            int center = (left + right) / 2;
            mergeSortZA(numbers, temp, left, center);
            mergeSortZA(numbers, temp, center + 1, right);
            mergeZA(numbers, temp, left, center + 1, right);
        }
    }

    private static void mergeZA(ArrayList<Integer> numbers, Comparable[ ] temp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int variable = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(numbers.get(right).compareTo(numbers.get(left)) >= 0)
                temp[variable++] = numbers.get(right++);
            else
                temp[variable++] = numbers.get(left++);

        while(left <= leftEnd)    // Copy rest of first half
            temp[variable++] = numbers.get(left++);

        while(right <= rightEnd)  // Copy rest of right half
            temp[variable++] = numbers.get(right++);

        
        // Copy temp back into names
        for(int i = 0; i < num; i++, rightEnd--)
            numbers.set(rightEnd,(int)temp[rightEnd]);
    }
}
