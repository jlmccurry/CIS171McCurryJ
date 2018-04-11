
package ex2312;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author jlmcc
 */
public class Ex2312 {

    public static void main(String[] args) {
        
        // Create two lists - one to fulfill the requirements of the exercise, and one to demonstrate the sort functions
        ArrayList<Integer> bigList = new ArrayList<>();
        ArrayList<Integer> smallList = new ArrayList<>();
        
        // Populate the big list with 1 million random integers
        for(int i = 0; i < 1000000; i++){
            Random rand = new Random();
            int randomNum = rand.nextInt(999);
            bigList.add(i, randomNum);
        }
        
        // Populate the small list with 100 random integers
        for(int i = 0; i < 100; i++){
            Random rand = new Random();
            int randomNum = rand.nextInt(999);
            smallList.add(i, randomNum);
        }
        
        // Report the bigList before and after sort, and the number of integers sorted
        System.out.println("Radix Sort Demo");
        System.out.println();
        System.out.println(bigList);
        bigList = radixSort(bigList);
        System.out.println(bigList);
        System.out.println(bigList.size() + " integers sorted");
        System.out.println();
        
        // Report the smallList before and after sort, and the number of integers sorted
        System.out.println(smallList);
        smallList = radixSort(smallList);
        System.out.println(smallList);
        System.out.println(smallList.size() + " integers sorted");

    }
    
    public static ArrayList<Integer> radixSort(ArrayList<Integer> list){

        final int modulus = 10;
        
        // Create the buckets, and an ArrayList for each bucket
        List<Integer>[] bucket = new ArrayList[modulus];
        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<Integer>();
        }
        
        // Perform the sort
        int temp = -1, place = 1;
        boolean flag = false;
        while(!flag){
            flag = true;
            for (Integer i : list){
                temp = i / place;
                bucket[temp % modulus].add(i);
                if(flag && temp > 0){
                    flag = false;
                }
            }
            // Empty the buckets
            int a = 0;
            for(int b = 0; b < modulus; b++){
                for(Integer i : bucket[b]){
                    list.set(a++, i);
                }
                bucket[b].clear();
            }
            place *= modulus;
        }
        return list;
    }
       
}
  
