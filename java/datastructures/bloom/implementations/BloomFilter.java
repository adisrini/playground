package datastructures.bloom.implementations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import hashing.implementations.Hasher;
import hashing.implementations.Jenkins;
import hashing.implementations.Murmur;

public class BloomFilter<E> implements Bloomable<E> {
    
    private static final int DEFAULT_CAPACITY = 100;
    
    private boolean[] containment;
    private Set<E> elements;
    private Set<Hasher> hashers;
    private int capacity;
    
    public BloomFilter() {
        this(DEFAULT_CAPACITY);
    }
    
    public BloomFilter(int capacity) {
        this.capacity = capacity;
        containment = new boolean[capacity];
        elements = new HashSet<E>();
        hashers = new HashSet<Hasher>();
        hashers.addAll(Arrays.asList(new Jenkins(), new Murmur()));
    }

    @Override
    public void add(E value) {
        for(Hasher hasher : hashers) {
            int index = Math.abs(hasher.hash32(value.toString()) % capacity);
            containment[index] = true;
        }
        elements.add(value);
    }

    @Override
    @SafeVarargs
    public final void addAll(E... values) {
        for(E value : values) {
            add(value);
        }
    }

    @Override
    public boolean mightContain(E value) {
        for(Hasher hasher : hashers) {
            int index = Math.abs(hasher.hash32(value.toString()) % capacity);
            if(!containment[index]) {
                return false;
            }
        }
        return true;
    }

    @Override
    @SafeVarargs
    public final boolean mightContainAll(E... values) {
        for(E value : values) {
            if(!mightContain(value)) {
                return false;
            }
        }
        return true;
    }

}
