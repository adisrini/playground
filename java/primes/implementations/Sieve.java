package primes.implementations;

public class Sieve {
    
    public static boolean[] eratosthenes(int max) {
        if(max < 2) return null;
        
        boolean[] flags = new boolean[max + 1];
        init(flags);
        
        int prime = 2;
        
        while(prime <= Math.sqrt(max)) {
            cross(flags, prime);
            prime = nextPrime(flags, prime);
        }
        
        return flags;
    }
    
    private static void init(boolean[] array) {
        array[0] = array[1] = false;
        for(int i = 2; i < array.length; i++) {
            array[i] = true;
        }
    }
    
    private static void cross(boolean[] flags, int prime) {
        for(int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }
    
    private static int nextPrime(boolean[] flags, int prime) {
        int index = prime + 1;
        while(prime < flags.length) {
            if(flags[index]) {
                break;
            }
            index++;
        }
        return index;
    }

}
