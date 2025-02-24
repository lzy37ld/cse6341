package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


public class Decl extends Unit {
    public final VarDecl varDecl;
    public final Expr expr;
    public Decl(VarDecl d, Location loc) {
	super(loc);
	varDecl = d;
	expr = null;
    }
    public Decl(VarDecl d, Expr e, Location loc) {
	super(loc);
	varDecl = d;
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent);
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    }
    public void print(PrintStream ps) {
	print(ps,"");
    }
	public void check(HashMap<String,Integer> table) {
		varDecl.check(table);
		if (expr != null) {
			expr.check(table);
		}
	}
	public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
		if(varDecl instanceof IntVarDecl) {
			if(expr != null) {
				intval.put(varDecl.ident, expr.valofint(scanner, intval));
			} else {
				intval.put(varDecl.ident, null);
			}
		} else {
			if(expr != null) {
				floatval.put(varDecl.ident, expr.valoffloat(scanner, floatval));
			} else {
				floatval.put(varDecl.ident, null);
			}
		}
	}
}
