package primes.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import playgroundutils.BaseTest;
import primes.implementations.Sieve;

public class SieveTest extends BaseTest {
    
    @Test
    public void testEratosthenes() {
        boolean[] flags = Sieve.eratosthenes(50);
        Set<Integer> primes = new HashSet<Integer>();
        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
        for(int i = 0; i < flags.length; i++) {
            if(primes.contains(i)) {
                Assert.assertTrue(flags[i]);
            } else {
                Assert.assertFalse(flags[i]);
            }
        }
    }

}
