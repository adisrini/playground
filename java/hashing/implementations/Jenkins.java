package hashing.implementations;

public class Jenkins {
    
    private static final int s1 = 10;
    private static final int s2 = 6;
    private static final int s3 = 3;
    private static final int s4 = 11;
    private static final int s5 = 15;
    
    public static int one_at_a_time_hash32(String key) {
        int length = key.length();
        int hash, i;
        
        for(hash = i = 0; i < length; ++i) {
            hash += key.charAt(i);
            hash += (hash << s1);
            hash ^= (hash >> s2);
        }
        
        hash += (hash << s3);
        hash ^= (hash >> s4);
        hash += (hash << s5);
        
        return hash;
    }

}
