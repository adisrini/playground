package playgroundutils;

import java.lang.reflect.Field;

public class Reflection {
    
    public static Object access(String fieldName, Object owner) {
        try {
            Field field = owner.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(owner);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
