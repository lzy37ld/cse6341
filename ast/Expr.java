package ast;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Expr extends ASTNode {
    public Expr(Location loc) {
	super(loc);
    }
    public abstract int type();
    public abstract Long valofint(Scanner scanner, HashMap<String, Long> intval);
    public abstract Double valoffloat(Scanner scanner, HashMap<String, Double> floatval);
    public abstract void check(HashMap<String, Integer> table);
}
