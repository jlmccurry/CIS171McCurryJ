
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
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // Generate 1,000,000 random integers and store it in a list
        for(int i = 0; i < 1000000; i++){
            Random rand = new Random();
            int randomNum = rand.nextInt(999);
            list.add(i, randomNum);
        }
        System.out.println(list);
        list = radixSort(list);
        System.out.println(list);
        System.out.println(list.size() + " integers sorted");
        // Not working
        System.out.println("The smallest integer is " + getMin(list));
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
    
    // Not working
    public static int getMin(ArrayList<Integer> list){
        int min = 0;
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == min){
                count += 1;
            }
        }
        if(count > 0){
            min = count;
        }
        return count;
    }
       
}
  
