package inheritance;

public class Test {
    
    public static void main(String[] args) {
        Subclass sub = new Subclass();
        Interface casted = (Interface) sub;
    }

}
