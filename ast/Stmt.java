package ast;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Stmt extends Unit {
    public Stmt(Location loc) {
	super(loc);
    }
    @Override
    public abstract void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval);

}
