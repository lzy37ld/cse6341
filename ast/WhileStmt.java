package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class WhileStmt extends Stmt {
    public final CondExpr expr;
    public final Stmt body;
    public WhileStmt(CondExpr e, Stmt s, Location loc) {
	super(loc);
	expr = e;
	body = s;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "while (");
	expr.print(ps);
	ps.print(")\n");
	body.print(ps, indent + "  ");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    public void check(HashMap<String, Integer> table) {
        expr.check(table);
        body.check(table);
    }
    public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
        while(expr.evaluate(scanner, intval, floatval)) {
            body.evaluate(scanner, intval, floatval);
        }
    }
}
