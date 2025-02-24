package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class FloatConstExpr extends Expr {
    public final Double fval; 
    public FloatConstExpr(Double f, Location loc) {
	super(loc);
	fval = f;
    }
    public void print(PrintStream ps) {
	ps.print(fval);
    }
    public void check(HashMap<String, Integer> table) {}
    public int type() {
        return 2;
    }
    public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
        return null;
    }
    public Double valoffloat(Scanner scanner, HashMap<String, Double> floatval) {
        return fval;
    }
}
