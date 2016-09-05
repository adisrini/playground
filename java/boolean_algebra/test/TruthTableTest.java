package boolean_algebra.test;

import boolean_algebra.implementations.TruthTable;

public class TruthTableTest {
    
    public static void main(String[] args) {
        TruthTable table = new TruthTable(3);
        
        table.evaluateExpression("(x0 || x1 || x2)");
        table.display();
    }

}
