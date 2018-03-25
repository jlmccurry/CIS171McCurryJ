
package ex199;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jlmcc
 */
public class Ex199 {

    public static void main(String[] args) {
        
        // Create an Integer ArrayList out of order
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        intArray.add(3);
        intArray.add(1);
        intArray.add(4);
        intArray.add(5);
        intArray.add(2);
        
        // Create a Double ArrayList out of order
        ArrayList<Double> doubleArray = new ArrayList<Double>();
        doubleArray.add(5.5);
        doubleArray.add(2.2);
        doubleArray.add(3.3);
        doubleArray.add(1.1);
        doubleArray.add(4.4);
        
        // Create a Character ArrayList out of order
        ArrayList<Character> charArray = new ArrayList<Character>();
        charArray.add('d');
        charArray.add('c');
        charArray.add('a');
        charArray.add('e');
        charArray.add('b');
              
        // Create a String ArrayList out of order
        ArrayList<String> stringArray = new ArrayList<String>();
        stringArray.add("Second");
        stringArray.add("First");
        stringArray.add("Third");
        stringArray.add("Fifth");
        stringArray.add("Fourth");
        
        // Print the ArrayLists before sort        
        System.out.println(intArray);
        System.out.println(doubleArray);
        System.out.println(charArray);
        System.out.println(stringArray);
        
        System.out.println();
        
        // Sort the ArrayLists that are out of order
        sort(intArray);
        sort(doubleArray);
        sort(charArray);
        sort(stringArray);
        
        // Print the sorted ArrayLists
        System.out.println(intArray);
        System.out.println(doubleArray);
        System.out.println(charArray);
        System.out.println(stringArray);
         
    }
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list){
        Collections.sort(list);
    }
}
