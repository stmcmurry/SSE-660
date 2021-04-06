package derivativeCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.hws.jcm.data.Expression;
import edu.hws.jcm.data.ExpressionProgram;
import edu.hws.jcm.data.Parser;
import edu.hws.jcm.data.Variable;

public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Variable xvar = new Variable("x");
		String func = "x / x^2";
		Parser parser = new Parser();
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		System.out.println(answer);
	}

}
