package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class PrintStmt extends Stmt {
    public final Expr expr;
    public PrintStmt(Expr e, Location loc) {
	super(loc);
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "print ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) { 
	print(ps,"");
    }
    public void check(HashMap<String, Integer> table) {
        expr.check(table);
    }
    public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
    }
}
