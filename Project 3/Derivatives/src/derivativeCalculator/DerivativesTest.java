package derivativeCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.StringTokenizer;
import edu.hws.jcm.draw.*;
import edu.hws.jcm.data.*;
import edu.hws.jcm.functions.*;
import edu.hws.jcm.awt.*;

class DerivativesTest {

	
	@Test
	void PowerRuleTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "2*x^2 + 3*x";
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		assertEquals("2*2*x + 3", answer);
		System.out.println(answer);
	}
	
	@Test
	void QuotientRuleTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "x / x^2";
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		assertEquals("(x^2 - x*2*x)/(x^2)^2", answer);
		System.out.println(answer);
	}

}
