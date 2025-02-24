package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class IfStmt extends Stmt {
    public final CondExpr expr; 
    public final Stmt thenstmt, elsestmt;
    public IfStmt(CondExpr e, Stmt s, Location loc) {
	super(loc);
	expr = e;
	thenstmt = s;
	elsestmt = null;
    }
    public IfStmt(CondExpr e, Stmt s1, Stmt s2, Location loc) {
	super(loc);
	expr = e;
	thenstmt = s1;
	elsestmt = s2;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "if (");
	expr.print(ps);
	ps.print(")\n");
	thenstmt.print(ps, indent+"  ");
	if (elsestmt != null) {
	    ps.print("\n" + indent + "else\n");	    
	    elsestmt.print(ps, indent + "  ");
	}
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
	public void check(HashMap<String, Integer> table) {
        expr.check(table);
		thenstmt.check(table);
		if (elsestmt != null) {
			elsestmt.check(table);
		}
    }
	public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
		expr.evaluate(scanner, intval, floatval);
		thenstmt.evaluate(scanner, intval, floatval);
		if(elsestmt != null) {
			elsestmt.evaluate(scanner, intval, floatval);
		}
	}
}
