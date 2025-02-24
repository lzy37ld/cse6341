package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Unit extends ASTNode {
    public Unit(Location loc) {
	super(loc);
    }
    public abstract void print(PrintStream ps, String ident);

    public abstract void check(HashMap<String, Integer> table);

    public abstract void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval);
}
