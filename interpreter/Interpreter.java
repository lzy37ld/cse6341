package interpreter;

import java.io.*;
import java.util.*;
import parser.ParserWrapper;
import ast.Program;

public class Interpreter {

    // Process return codes
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_PARSING_ERROR = 1;
    public static final int EXIT_STATIC_CHECKING_ERROR = 2;
    public static final int EXIT_UNINITIALIZED_VAR_ERROR = 3;
    public static final int EXIT_DIV_BY_ZERO_ERROR = 4;
    public static final int EXIT_FAILED_STDIN_READ = 5;
    public static void main(String[] args) {
        String filename = args[0];
        Program astRoot = null;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
	    astRoot = ParserWrapper.parse(reader);
        } catch (Exception ex) {
            Interpreter.fatalError("Uncaught parsing error: " + ex, Interpreter.EXIT_PARSING_ERROR);
        }
        HashMap<String, Integer> table = new HashMap<String, Integer>();
        astRoot.check(table);

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Long> intval = new HashMap<String, Long>();
        HashMap<String, Double> floatval = new HashMap<String, Double>();
        astRoot.evaluate(scanner, intval, floatval);
	// for debugging
	astRoot.print(System.out);
    }
    public static void fatalError(String message, int processReturnCode) {
        System.out.println(message);
        System.exit(processReturnCode);
    }
}
