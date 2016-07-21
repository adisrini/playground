package hashing.test;

import org.junit.Assert;
import org.junit.Test;

import hashing.implementations.Jenkins;
import playgroundutils.BaseTest;

public class JenkinsTest extends BaseTest {

    @Test
    public void testHashUnique() {
        String key1 = "hello123";
        String key2 = "goodbye456";
        
        Assert.assertNotEquals(Jenkins.one_at_a_time_hash32(key1), Jenkins.one_at_a_time_hash32(key2));
    }
    
    @Test
    public void testHashConsistent() {
        String key = "hello123";
        
        Assert.assertEquals(Jenkins.one_at_a_time_hash32(key), Jenkins.one_at_a_time_hash32(key));
    }
    
}
