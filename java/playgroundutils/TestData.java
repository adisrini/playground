package playgroundutils;

import java.util.Random;

public class TestData {
    
    private static Random r = new Random();
    
    public static int getInt() {
        return r.nextInt();
    }
    
    public static int getInt(int bound) {
        return r.nextInt(bound);
    }
    
    public static int getScaleCount() {
        return 10 + r.nextInt(90);
    }
    
    public static boolean getBoolean() {
        return r.nextBoolean();
    }

}
