package machine_learning;

import java.util.Arrays;

public class Perceptron {
    
    public double[] train(double[][] x, int[] y, double[] w) {
        int t = 1;
        while(true) {
            boolean misclassified = false;
            for(int i = 0; i < x.length; i++) {
                if(margin(x[i], y[i], w) <= 0) {
                    misclassified = true;
                    w = update(x[i], y[i], w);
                    break;
                }
            }
            if(!misclassified) {
                break;
            }
            t++;
        }
        System.out.println("Perceptron completed with " + (t-1) + " iterations (mistakes).");
        return w;
    }
    
    private double margin(double[] x, int y, double[] w) {
        double sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum += x[i]*w[i];
        }
        return sum*y;
    }
    
    private double[] update(double[] x, int y, double[] w) {
        double[] w_new = new double[w.length];
        for(int i = 0; i < w.length; i++) {
            w_new[i] = x[i]*y + w[i];
        }
        return w_new;
    }
    
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();
        double[][] x = {{-1, 1}, {0, -1}, {10, 1}};
        int[] y = {1, -1, 1};
        double[] w = {0, 0};
        double[] output = perceptron.train(x, y, w);
        System.out.println(Arrays.toString(output));
    }

}
