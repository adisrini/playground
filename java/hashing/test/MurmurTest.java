package hashing.test;

import org.junit.Assert;
import org.junit.Test;

import hashing.implementations.Murmur;
import playgroundutils.BaseTest;

public class MurmurTest extends BaseTest {
    
    @Test
    public void testHashUnique() {
        String key1 = "hello123";
        String key2 = "goodbye456";
        
        Assert.assertNotEquals(Murmur.hash32(key1), Murmur.hash32(key2));
    }
    
    @Test
    public void testHashConsistent() {
        String key = "hello123";
        
        Assert.assertEquals(Murmur.hash32(key), Murmur.hash32(key));
    }

}
