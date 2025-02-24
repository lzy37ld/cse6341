package ast;
import java.io.PrintStream;
import java.util.HashMap;

public class IntVarDecl extends VarDecl {
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }
    public void check(HashMap<String, Integer> table) {
        table.put(ident, 1);
    }
}
