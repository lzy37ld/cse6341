package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class Program extends ASTNode {
    public final UnitList unitList;
    public Program(UnitList ul, Location loc) {
        super(loc);
        unitList = ul;
    }
    public void print(PrintStream ps) {
	unitList.print(ps,"");
    }
    public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
        unitList.evaluate(scanner, intval, floatval);
    }
    public void check(HashMap<String, Integer> table) {
        unitList.check(table);
    }
}
