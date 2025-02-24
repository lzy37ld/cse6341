package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class BlockStmt extends Stmt {
    public final UnitList block;
    public BlockStmt(UnitList b, Location loc) {
	super(loc);
	block = b;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "{\n");
	block.print(ps, indent + "  ");
	ps.print(indent + "}");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    @Override
    public void check(HashMap<String,Integer> table) {
        block.check(table);
    }
    @Override
    public void evaluate(Scanner scanner, HashMap<String, Long> intval, HashMap<String, Double> floatval) {
        block.evaluate(scanner, intval, floatval);
    }
}
