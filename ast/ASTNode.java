package ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

abstract class ASTNode {
    public final Location loc;
    ASTNode(Location loc) { this.loc = loc; }
    public abstract void print(PrintStream ps);
    public String toString() { 
	ByteArrayOutputStream b = new ByteArrayOutputStream();
	print(new PrintStream(b));
	return new String(b.toByteArray(),java.nio.charset.StandardCharsets.UTF_8);
    }
    public abstract void check(HashMap<String, Integer> table);
}
