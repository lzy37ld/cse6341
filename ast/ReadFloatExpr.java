package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import interpreter.Interpreter;

public class ReadFloatExpr extends Expr {
    public ReadFloatExpr(Location loc) {
	super(loc);
    }
    public void print(PrintStream ps) {
	ps.print("readfloat");
    }
    public void check(HashMap<String, Integer> table) {}
    public int type() {
        return 2;
    }
    public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
        return null;
    }
    public Double valoffloat(Scanner scanner, HashMap<String, Double> flostval) {
        Double v = 0.0;
        if (scanner.hasNextDouble()) {
            v = scanner.nextDouble();
        } else {
            Interpreter.fatalError("float std error", Interpreter.EXIT_FAILED_STDIN_READ);
        }
        return v;
    }
}
