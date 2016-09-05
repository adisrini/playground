package boolean_algebra.test;

import java.util.List;

import org.junit.Test;

import boolean_algebra.implementations.TruthTable;
import org.junit.Assert;

public class TruthTableTest {
    
    @Test
    public void testEvaluation() {
        TruthTable table = new TruthTable(3);
        
        List<Boolean> values1 = table.evaluateExpression("(!x0 && !x1 && x2) || (x0 && !x1 && !x2) || (x0 && !x1 && x2) || (x0 && x1 && !x2)");
        List<Boolean> values2 = table.evaluateExpression("(!x1 && x2) || (x0 && !x2)");
        table.display();
        
        Assert.assertEquals(values1, values2);
    }

}
