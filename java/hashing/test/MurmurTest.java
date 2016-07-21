package hashing.test;

import org.junit.Assert;
import org.junit.Test;

import hashing.implementations.Murmur;

public class MurmurTest extends HasherTest {
    
    public MurmurTest() {
        super(Murmur.class);
    }

    @Test
    public void testHashUnique() {
        String key1 = "hello123";
        String key2 = "goodbye456";
        
        Assert.assertNotEquals(hasher.hash32(key1), hasher.hash32(key2));
    }
    
    @Test
    public void testHashConsistent() {
        String key = "hello123";
        
        Assert.assertEquals(hasher.hash32(key), hasher.hash32(key));
    }

}
