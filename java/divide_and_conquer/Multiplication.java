package divide_and_conquer;

public class Multiplication {
    
    public int multiply(int x, int y) {
        return multiply(Integer.toString(x), Integer.toString(y));
    }
    
    private int multiply(String x, String y) {
        int n = Math.max(x.length(), y.length());
        
        if(n == 1) {
            return Integer.parseInt(x)*Integer.parseInt(y);
        }
        
        String leftX = x.substring(0, x.length()/2);
        String rightX = x.substring(x.length()/2);

        String leftY = y.substring(0, y.length()/2);
        String rightY = y.substring(y.length()/2);
        
        int p1 = multiply(leftX, leftY);
        int p2 = multiply(rightX, rightY);
        int p3 = multiply(leftX + rightX, leftY + rightY);
        
        return (int) (p1 * Math.pow(2, n) + (p3 -p1 - p2) * Math.pow(2, n/2) + p2);
    }
    
    public static void main(String[] args) {
        Multiplication m = new Multiplication();
        
        System.out.println(m.multiply(12, 50));
    }

}
