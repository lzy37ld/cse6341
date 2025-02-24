package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import interpreter.Interpreter;

public class IdentExpr extends Expr {
    public final String ident; 
    public int type;
    public IdentExpr(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }
    public void check(HashMap<String, Integer> table) {
        if (!table.containsKey(ident)) {
            Interpreter.fatalError("variable not declared", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        type = table.get(ident);
    }

    public int type() {
        return type;
    }

    public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
        if(!intval.containsKey(ident) || intval.get(ident) == null) {
            Interpreter.fatalError("int unintialized variable", Interpreter.EXIT_UNINITIALIZED_VAR_ERROR);
        }
        return intval.get(ident);
    }
    public Double valoffloat(Scanner scanner, HashMap<String, Double> floatval) {
        if(!floatval.containsKey(ident) || floatval.get(ident) == null) {
            Interpreter.fatalError("float uninitialized variable", Interpreter.EXIT_UNINITIALIZED_VAR_ERROR);
        }
        return floatval.get(ident);
    }
}
