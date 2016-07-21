package hashing.implementations;

public class Murmur extends Hasher {
    
    private static final int seed = 0x9747b28c;
    
    @Override
    public int hash32(String key) {
        return hash32(key.getBytes(), key.length(), seed);
    }
    
    private int hash32(byte[] data, int length, int seed) {
        final int m = 0x5bd1e995;
        final int r = 24;
        
        int hash = seed^length;
        int length4 = length/4;

        for (int i=0; i<length4; i++) {
            final int i4 = i*4;
            int k = (data[i4+0]&0xff) +((data[i4+1]&0xff)<<8)
                    +((data[i4+2]&0xff)<<16) +((data[i4+3]&0xff)<<24);
            k *= m;
            k ^= k >>> r;
            k *= m;
            hash *= m;
            hash ^= k;
        }
        
        switch (length%4) {
        case 3: hash ^= (data[(length&~3) +2]&0xff) << 16;
        case 2: hash ^= (data[(length&~3) +1]&0xff) << 8;
        case 1: hash ^= (data[length&~3]&0xff);
                hash *= m;
        }

        hash ^= hash >>> 13;
        hash *= m;
        hash ^= hash >>> 15;

        return hash;
    }

}
