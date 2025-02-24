package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogicalExpr extends CondExpr {
    public static final int AND = 1;
    public static final int OR = 2;
    public static final int NOT = 3;
    public final CondExpr expr1, expr2;
    public final int op;
    public LogicalExpr(CondExpr e1, int oper, CondExpr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public LogicalExpr(CondExpr e1, int oper, Location loc) {
	this(e1,oper,null,loc); // used for NOT
    }
    public void print(PrintStream ps) {
	if (op == NOT) {
	    ps.print("!(");
	    expr1.print(ps);
	    ps.print(")");
	    return;
	}
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case AND: ps.print("&&"); break;
	case OR: ps.print("||"); break;
	}
	expr2.print(ps);
	ps.print(")");
    }
	public void check(HashMap<String,Integer> table) {
		expr1.check(table);
		if (expr2 != null) {
			expr2.check(table);
		}
	}
	public Boolean evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
		if(op == NOT) {
			return !expr1.evaluate(scanner, intval, floatval);
		} else if (op == OR) {
			if(expr1.evaluate(scanner, intval, floatval)) {
				return true;
			} else if(expr2.evaluate(scanner, intval, floatval)) {
				return true;
			} else {
				return false;
			}
		} else if (op == AND) {
			if(!expr1.evaluate(scanner, intval, floatval)) {
				return false;
			} else if (expr2.evaluate(scanner, intval, floatval)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
 
	}
}
