
package ex198;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jlmcc
 */
public class Ex198 {

    public static void main(String[] args) {
        
        // Create an Integer ArrayList
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        
        // Create a Double ArrayList
        ArrayList<Double> doubleArray = new ArrayList<Double>();
        doubleArray.add(1.1);
        doubleArray.add(2.2);
        doubleArray.add(3.3);
        doubleArray.add(4.4);
        doubleArray.add(5.5);
        
        // Create a Character ArrayList
        ArrayList<Character> charArray = new ArrayList<Character>();
        charArray.add('a');
        charArray.add('b');
        charArray.add('c');
        charArray.add('d');
        charArray.add('e');
              
        // Create a String ArrayList
        ArrayList<String> stringArray = new ArrayList<String>();
        stringArray.add("First");
        stringArray.add("Second");
        stringArray.add("Third");
        stringArray.add("Fourth");
        stringArray.add("Fifth");
        
        // Print the ArrayLists before shuffle        
        System.out.println(intArray);
        System.out.println(doubleArray);
        System.out.println(charArray);
        System.out.println(stringArray);
        
        System.out.println();
        
        // Shuffle each ArrayList
        shuffle(intArray);
        shuffle(doubleArray);
        shuffle(charArray);
        shuffle(stringArray);
        
        // Print the shuffled ArrayList
        System.out.println(intArray);
        System.out.println(doubleArray);
        System.out.println(charArray);
        System.out.println(stringArray);
         
    }
    
    public static <E> void shuffle(ArrayList<E> list){
        
        Collections.shuffle(list);
        
    }
    
    
}
