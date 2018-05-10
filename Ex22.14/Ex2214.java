
package ex2214;

/**
 *
 * @author jlmcc
 */
public class Ex2214 {

    public static void main(String[] args) {
        
        int eight = 8000000;
        int ten = 10000000;
        int twelve = 12000000;
        int fourteen = 14000000;
        int sixteen = 16000000;

        System.out.println("----------------------------------------------------------------");
        System.out.println(" Listing | 8000000 | 10000000 | 12000000 | 14000000 | 16000000  ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("  22.5   | " + methodOne(eight) + " sec   " + "| " + methodOne(ten) + " sec    " + "| " + methodOne(twelve) + " sec    " + "| " + methodOne(fourteen) + " sec    " + "| " + methodOne(sixteen) + " sec   ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("  22.5   | " + methodTwo(eight) + " sec   " + "| " + methodTwo(ten) + " sec    " + "| " + methodTwo(twelve) + " sec    " + "| " + methodTwo(fourteen) + " sec    " + "| " + methodTwo(sixteen) + " sec   ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("  22.5   | " + methodThree(eight) + " sec   " + "| " + methodThree(ten) + " sec    " + "| " + methodThree(twelve) + " sec    " + "| " + methodThree(fourteen) + " sec    " + "| " + methodThree(sixteen) + " sec   ");
        System.out.println("----------------------------------------------------------------");
    }
    
        public static long methodOne(int passVal){
            
            long n = passVal;
            long startTime = System.currentTimeMillis() / 1000;
            
            final int NUMBER_PER_LINE = 10;
            int count = 0;
            int number = 2;

            while (number <= n) {
                boolean isPrime = true;
                for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); 
                    divisor++) {
                  if (number % divisor == 0) {
                    isPrime = false;        
                    break;
                  }
                }
                if (isPrime) {
                  count++;
                }
                number++;
            }           
            long endTime = System.currentTimeMillis() / 1000;
            long elapTime = endTime - startTime;
            return elapTime;
        }
        
        public static long methodTwo(int passVal){
            long n = passVal;
            long startTime = System.currentTimeMillis() / 1000;
            
            java.util.List<Integer> list = new java.util.ArrayList<>(); 
            final int NUMBER_PER_LINE = 10;
            int count = 0;
            int number = 2;
            int squareRoot = 1;
            
                while (number <= n) {
                    boolean isPrime = true;
                    if (squareRoot * squareRoot < number) squareRoot++;
                    for (int k = 0; k < list.size() 
                                      && list.get(k) <= squareRoot; k++) {
                      if (number % list.get(k) == 0) {
                        isPrime = false;         
                        break;
                      }
                    }
                    
                    if (isPrime) {
                      count++;
                      list.add(number);
                    }
                    number++;
                  }
            long endTime = System.currentTimeMillis() / 1000;
            long elapTime = endTime - startTime;
            return elapTime;
        }
        
        public static long methodThree(int passVal){
            int n = passVal;
            boolean[] primes = new boolean[n + 1];
            
            long startTime = System.currentTimeMillis() / 1000;

            for (int i = 0; i < primes.length; i++) {
              primes[i] = true; 
            }

            for (int k = 2; k <= n / k; k++) {
              if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                  primes[k * i] = false;
                }
              }
            }
            
            final int NUMBER_PER_LINE = 10;
            int count = 0;
            for (int i = 2; i < primes.length; i++) {
              if (primes[i]) {
                count++;        
              }
            }
            long endTime = System.currentTimeMillis() / 1000;
            long elapTime = endTime - startTime;
            return elapTime;
        }
   
}
