package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class UnitList extends ASTNode {
    public final Unit unit;
    public final UnitList unitList; 
    public UnitList(Unit u, UnitList ul, Location loc) {
        super(loc);
	unit = u;
	unitList = ul;
    }
    public UnitList(Unit u, Location loc) { 
        super(loc);
	unit = u;
        unitList = null;
    }
    public void print(PrintStream ps, String indent) {
	unit.print(ps,indent);
	ps.println();
	if (unitList != null)
	    unitList.print(ps,indent);
    }
    public void print(PrintStream ps) { 
	print(ps,""); 
    }
    public void check(HashMap<String, Integer> table) {
        unit.check(table);
        if (unitList != null) {
            unitList.check(table);
        }
    }
    public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
        unit.evaluate(scanner, intval, floatval);
        if (unitList != null) {
            unitList.evaluate(scanner, intval, floatval);
        }
    }
}
