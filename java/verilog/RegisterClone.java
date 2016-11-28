package verilog;

public class RegisterClone {

    public static void main(String[] args) {
        for(int i = 0; i < 32; i++) {
            System.out.println(String.format("assign reg%d = allData[%d:%d]", i, (i+1)*32 - 1, i*32));
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < 32; i++) {
            builder.append(i + ": %d, ");
        }
        builder.append("]");
        System.out.println(builder);
    }
    
}
