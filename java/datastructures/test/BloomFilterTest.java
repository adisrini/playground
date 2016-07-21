package datastructures.test;

import org.junit.Test;

import datastructures.implementations.BloomFilter;

import java.util.Set;

import org.junit.Assert;
import playgroundutils.BaseTest;
import playgroundutils.Reflection;

public class BloomFilterTest extends BaseTest {
    
    private BloomFilter<String> bloom;
    
    @Override
    public void before() {
        bloom = new BloomFilter<String>();
    }
    
    @Override
    public void after() {
        bloom = null;
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testAdd() {
        bloom.add("hello123");
        bloom.add("aditya");
        bloom.add("srinivasan");
        bloom.add("goodbye456");
        Assert.assertEquals(4, ((Set<String>) Reflection.access("elements", bloom)).size());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testAddAll() {
        bloom.addAll("hello123", "aditya", "srinivasan", "goodbye456");
        Assert.assertEquals(4, ((Set<String>) Reflection.access("elements", bloom)).size());
    }
    
    @Test
    public void testMightContainTrue() {
        String key = "hello123";
        bloom.add(key);
        Assert.assertTrue(bloom.mightContain(key));
    }
    
    @Test
    public void testMightContainFalse() {
        String key = "hello123";
        String wrongKey = "goodbye456";
        bloom.add(key);
        Assert.assertFalse(bloom.mightContain(wrongKey));
    }
    
    @Test
    public void testMightContainAllTrue() {
        String key1 = "hello123";
        String key2 = "aditya";
        String key3 = "srinivasan";
        String key4 = "goodbye456";
        bloom.addAll(key1, key2, key3, key4);
        Assert.assertTrue(bloom.mightContainAll(key1, key2, key3, key4));
    }
    
    @Test
    public void testMightContainAllFalse() {
        String key1 = "hello123";
        String key2 = "aditya";
        String key3 = "srinivasan";
        String key4 = "goodbye456";
        String wrongKey1 = "duke";
        String wrongKey2 = "university";
        String wrongKey3 = "computer";
        String wrongKey4 = "science";
        bloom.addAll(key1, key2, key3, key4);
        Assert.assertFalse(bloom.mightContainAll(wrongKey1, wrongKey2, wrongKey3, wrongKey4));
    }

}
