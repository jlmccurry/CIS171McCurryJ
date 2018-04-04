
package ex22.pkg8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author jlmcc
 */
public class Ex228 {

    public static void main(String[] args) {

        ArrayList<Long> primeLong = new ArrayList<>();

        long max = 1000000;
        long count = 0;
        long number = 2;
        long squareRoot = 1;
        
        while (number <= max){
            boolean isPrime = true;
            
            if (squareRoot * squareRoot < number) squareRoot++;
            
            for (int j = 0; j < primeLong.size() && primeLong.get(j) <= squareRoot; j++){
                if(number % primeLong.get(j) == 0){
                    isPrime = false;
                    break;
                }
            }    
            if(isPrime){
                count++;
                primeLong.add(number);
            }
            number++;
        }
        
        writeFile(primeLong);
        readFile();
    }
    
    public static <Long> void writeFile(ArrayList<Long> list){
        ArrayList<Long> primes = list;
        try{
            DataOutputStream file = new DataOutputStream(new FileOutputStream("PrimeNumbers.dat"));
            ObjectOutputStream os = new ObjectOutputStream(file);
            os.writeObject(primes);
            file.close();
            System.out.println(primes.size() + " values added to file.");
        }
        catch (FileNotFoundException e){
            e.getMessage();
        }      
        catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static <Long> ArrayList readFile(){
        ArrayList<Long> primes = new ArrayList<>();
        try{
            DataInputStream file = new DataInputStream(new FileInputStream("PrimeNumbers.dat"));
            ObjectInputStream os = new ObjectInputStream(file);
            primes = (ArrayList<Long>)os.readObject();
            file.close();
            System.out.println(primes.size() + " values read from file.");
        }
        catch (FileNotFoundException e){
            e.getMessage();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return primes;
    }

}
