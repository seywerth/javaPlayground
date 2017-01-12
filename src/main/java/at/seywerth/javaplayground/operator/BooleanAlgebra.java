package at.seywerth.javaplayground.operator;

/**
 * Visualize boolean algebra operators in Java.
 *
 */
public class BooleanAlgebra {

    public static final int DEFAULT_OUTPUT_LENGTH = 10;

    /**
     * Value that shows when it is used
     *
     */
    public class Value {
        boolean val;
        String name;
        String usage;

        public Value(String name, boolean val) {
            this.name = name;
            this.val = val;
            this.usage = "";
        }
        public boolean get() {
            this.usage += this.name;
            return val;
        }
        public String getUsage() {
            return this.usage;
        }
    }

    public String xor(boolean a, boolean b) {
        Value va = new Value("a", a);
        Value vb = new Value("b", b);
        boolean r = va.get() ^ vb.get();
        return toString(va, vb, r);
    }

    public String or(boolean a, boolean b) {
        Value va = new Value("a", a);
        Value vb = new Value("b", b);
        boolean r = va.get() || vb.get();
        return toString(va, vb, r);
    }

    public String bitor(boolean a, boolean b) {
        Value va = new Value("a", a);
        Value vb = new Value("b", b);
        boolean r = va.get() | vb.get();
        return toString(va, vb, r);
    }

    public String and(boolean a, boolean b) {
        Value va = new Value("a", a);
        Value vb = new Value("b", b);
        boolean r = va.get() && vb.get();
        return toString(va, vb, r);
    }

    public String bitand(boolean a, boolean b) {
        Value va = new Value("a", a);
        Value vb = new Value("b", b);
        boolean r = va.get() & vb.get();
        return toString(va, vb, r);
    }

    public String nequal(boolean a, boolean b) {
        Value va = new Value("a", a);
        Value vb = new Value("b", b);
        boolean r = va.get() != vb.get();
        return toString(va, vb, r);
    }

    public String toString(Value va, Value vb, boolean r) {
        return format(va.getUsage(), 2) + format(String.valueOf(r), 6) + format(vb.getUsage(), 2);
    }

    public String format(String str) {
        return format(str, DEFAULT_OUTPUT_LENGTH);
     }

    public String format(String str, int len) {
       return String.format("%-" + len + "s", str);
    }

}