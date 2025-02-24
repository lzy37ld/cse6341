package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public AssignStmt(String i, Expr e, Location loc) {
	super(loc);
	ident = i;
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    @Override
    public void check(HashMap<String,Integer> table) {
        expr.check(table);
    }
    public void evaluate(Scanner scanner, HashMap<String, Long> intMap, HashMap<String, Double> floatMap) {
        if (expr.type() == 1) {
            intMap.put(ident, expr.valofint(scanner, intMap));
        } else if (expr.type() == 2) {
            floatMap.put(ident, expr.valoffloat(scanner, floatMap));
        }
    }
}
