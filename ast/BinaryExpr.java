package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import interpreter.Interpreter;

public class BinaryExpr extends Expr {
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DIV = 4;
    public final Expr expr1, expr2;
    public final int op;
	public int type;
    public BinaryExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) {
	case PLUS: ps.print("+"); break;
	case MINUS: ps.print("-"); break;
	case TIMES: ps.print("*"); break;
	case DIV: ps.print("/"); break;
	}
	expr2.print(ps);
	ps.print(")");
    }

	public void check(HashMap<String, Integer> table) {
		type = expr1.type();
	}
	public int type() {
		return type;
	}

	public Long valofint(Scanner scanner, HashMap<String, Long> intval) {
		Long v1, v2, ret = null;
		v1 = expr1.valofint(scanner, intval);
		v2 = expr2.valofint(scanner, intval);
		switch (op) {
			case PLUS:
				ret = v1 + v2;
				break;
			case MINUS:
				ret = v1 - v2;
				break;
			case TIMES:
				ret = v1 * v2;
				break;
			case DIV:
				if(v2 == 0) {
					Interpreter.fatalError("Division by ZERO", Interpreter.EXIT_DIV_BY_ZERO_ERROR);
				}
				ret = v1 / v2;
				break;
		}
		return ret;
	}
	public Double valoffloat(Scanner scanner, HashMap<String, Double> floatval) {
		Double v1, v2, ret = null;
		v1 = expr1.valoffloat(scanner, floatval);
		v2 = expr2.valoffloat(scanner, floatval);
		switch (op) {
			case PLUS:
				ret = v1 + v2;
				break;
			case MINUS:
				ret = v1 - v2;
				break;
			case TIMES:
				ret = v1 * v2;
				break;
			case DIV:
				if(v2 == 0) {
					Interpreter.fatalError("Division by ZERO", Interpreter.EXIT_DIV_BY_ZERO_ERROR);
				}
				ret = v1 / v2;
				break;
		}
		return ret;
	}
}
