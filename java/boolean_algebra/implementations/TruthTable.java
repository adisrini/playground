package boolean_algebra.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TruthTable {
    
    private static final String FORMAT = "%20s";
    
    private boolean[][] table;
    private Map<String, List<Boolean>> expressions;
    private ScriptEngine engine;
    
    public TruthTable(int n) {
        table = new boolean[(int) Math.pow(2, n)][n];
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++) {
                boolean bit = ((i>>(n - 1 - j)) & 1) == 1;
                table[i][j] = bit;
            }
        }
        expressions = new TreeMap<>();
        ScriptEngineManager mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript"); 
    }
    
    public void evaluateExpression(String expression) {
        List<Boolean> values = new ArrayList<>();
        expressions.put(expression, values);
        for(int i = 0; i < table.length; i++) {
            String output = expression;
            for(int j = 0; j < table[i].length; j++) {
                output = output.replace("x" + j, String.valueOf(table[i][j]));
            }
            try {
                boolean result = (boolean) engine.eval(output);
                values.add(result);
            }
            catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void display() {
        for(int i = 0; i < table[0].length; i++) {
            System.out.print(String.format(FORMAT, "x" + i));
        }
        for(String expression : expressions.keySet()) {
            System.out.print(String.format(FORMAT, expression));
        }
        System.out.println();
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++) {
                System.out.print(String.format(FORMAT, table[i][j]));
            }
            for(String expression : expressions.keySet()) {
                System.out.print(String.format(FORMAT, expressions.get(expression).get(i)));
            }
            System.out.println();
        }
    }

}
