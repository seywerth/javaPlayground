package at.seywerth.javaplayground.operator;

import org.junit.Test;

/**
 * visualize boolean operator tables
 *
 */
public class BooleanAlgebraTest {

    @Test
    public void testBooleanAlgebra() {
        BooleanAlgebra booleanAlgebra = new BooleanAlgebra();
        String header = booleanAlgebra.format("OR") + booleanAlgebra.format("bitOR") + booleanAlgebra.format("XOR")
            + booleanAlgebra.format("AND") + booleanAlgebra.format("bitAND") + booleanAlgebra.format("notEqual");
        System.out.println(header);
        String op = booleanAlgebra.format("a || b") + booleanAlgebra.format("a ^ b") + booleanAlgebra.format("a | b")
            + booleanAlgebra.format("a && b") + booleanAlgebra.format("a & b") + booleanAlgebra.format("a != b");
        System.out.println(op);
        printAll(booleanAlgebra, true, true);
        printAll(booleanAlgebra, true, false);
        printAll(booleanAlgebra, false, true);
        printAll(booleanAlgebra, false, false);
    }

    private String printAll(BooleanAlgebra t, boolean a, boolean b) {
        String line = t.or(a, b) + t.bitor(a, b) + t.xor(a, b) + t.and(a, b) + t.bitand(a, b) + t.nequal(a, b);
        System.out.println(line);
        return line;
    }

}