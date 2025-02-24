package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class IntConstExpr extends Expr {
    public final Long ival; 
    public IntConstExpr(Long i, Location loc) {
	super(loc);
	ival = i;
    }
    public void print(PrintStream ps) {
	ps.print(ival);
    }
    public void check(HashMap<String, Integer> table) {}
    public int type() {
        return 1;
    }
    public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
        return ival;
    }
    public Double valoffloat(Scanner scanner, HashMap<String, Double> floatval) {
        return null;
    }
}
