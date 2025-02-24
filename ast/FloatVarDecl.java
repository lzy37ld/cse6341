package ast;
import java.io.PrintStream;
import java.util.HashMap;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }
    public void check(HashMap<String, Integer> table) {
        table.put(ident, 2);
    }
}
