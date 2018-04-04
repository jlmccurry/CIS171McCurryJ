
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jlmcc
 */
public class Ex228 {

    public static void main(String[] args) {
        
        Set<Long> set = new LinkedHashSet<>();
        ArrayList<Long> primeLong = new ArrayList<>();
        
        long startNum;
        long endNum;
        
        for(long n = 2; n < 1000000; n++){
            if(n == 2 || n == 3 || n == 5 || n == 7){
                primeLong.add(n);
            }
            if(n % 2 != 0 && n % 3 != 0 && n % 5 != 0 && n % 7 != 0){
                primeLong.add(n);
            }
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
            System.out.println(primes.get(primes.size() - 1) + " values added to file.");
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
            System.out.println(primes.get(primes.size() - 1) + " values read from file.");
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
