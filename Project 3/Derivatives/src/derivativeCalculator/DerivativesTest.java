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
	}
	@Test
	void ChainRuleTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "(x^3 + 2*x)^4";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("4*(x^3 + 2*x)^3*(3*x^2 + 2)", answer);
	}
	@Test
	void ChainRuleTest2() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "(cos(x^2))^2";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("2*cos(x^2)*(-sin(x^2))*2*x", answer); 
	}
	
	@Test
	void ChainRuleTest3() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "e^((2*x^2)+(4*x))";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("e^(2*x^2 + 4*x)*(2*2*x + 4)", answer);
	}
	//this tests that ln(1) returns as 0
	@Test
	void NaturalLogRuleOneTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "ln(1) ";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("0", answer);
	}
	
	@Test
	void NegNaturalLogRuleOneTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "-ln(1) ";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("0", answer);
	}
	//this tests that ln(e) returns as 0
	@Test
	void NaturalLogRuleETest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "(ln(e)) ";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("0", answer);
	}
	
	//tests for ln(x)
	@Test
	void NaturalLogRuleTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "ln(x) ";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("(x > 0) ? (1/x)", answer); 
	}
	
	//tests for ln(-x)
	@Test
	void NegNaturalLogRuleTest() {
		Variable xvar = new Variable("x");
		Parser parser = new Parser();
		String func = "ln(x) ";
		
		parser.add(xvar);
		Expression exp = parser.parse(func);
		String answer = exp.derivative(xvar).toString();
		
		assertEquals("(x > 0) ? (1/x)", answer); 
	}
	
	@Test
	void ProductRuleTest() {
	    Variable xvar = new Variable("x");
	    Parser parser = new Parser();
	    String func = "(x-2)*(x-1)";
	    
	    parser.add(xvar);
	    Expression exp = parser.parse(func);
	    String answer = exp.derivative(xvar).toString();
	    
	    assertEquals("(x - 2)*1 + (x - 1)*1", answer);
	}
	
	@Test
    void ProductRuleTest2() {
        Variable xvar = new Variable("x");
        Parser parser = new Parser();
        String func = "sin(x)*cos(x)";
        
        parser.add(xvar);
        Expression exp = parser.parse(func);
        String answer = exp.derivative(xvar).toString();
        
        assertEquals("sin(x)*(-sin(x)) + cos(x)*cos(x)", answer);
    }
	
	@Test
    void ProductRuleTest3() {
        Variable xvar = new Variable("x");
        Parser parser = new Parser();
        String func = "x*e^x";
        
        parser.add(xvar);
        Expression exp = parser.parse(func);
        String answer = exp.derivative(xvar).toString();
        
        assertEquals("x*e^x + e^x", answer);
    }
	
	@Test
	void ExponentialRuleTest() {
		Variable xvar = new Variable("x");
        Parser parser = new Parser();
        String func = "e^x";
        String func2 = "5^x";
        
        parser.add(xvar);
        Expression exp = parser.parse(func);
        Expression exp2 = parser.parse(func2);
        String answer = exp.derivative(xvar).toString();
        String answer2 = exp2.derivative(xvar).toString();
        
        assertEquals("e^x", answer);
        assertEquals("5^x*ln(5)", answer2);
	}
	
	@Test
	void TrigTest() {
		Variable xvar = new Variable("x");
        Parser parser = new Parser();
        String func = "sin(x)";
        String func2 = "cos(x)";
        String func3 = "tan(x)";
        
        parser.add(xvar);
        Expression exp = parser.parse(func);
        Expression exp2 = parser.parse(func2);
        Expression exp3 = parser.parse(func3);
        String answer = exp.derivative(xvar).toString();
        String answer2 = exp2.derivative(xvar).toString();
        String answer3 = exp3.derivative(xvar).toString();
        
        assertEquals("cos(x)", answer);
        assertEquals("-sin(x)", answer2);
        assertEquals("sec(x)^2", answer3);
	}
	
	@Test
	void InverseTrigTest() {
		Variable xvar = new Variable("x");
        Parser parser = new Parser();
        String func = "sec(x)";
        String func2 = "csc(x)";
        String func3 = "cot(x)";
        
        parser.add(xvar);
        Expression exp = parser.parse(func);
        Expression exp2 = parser.parse(func2);
        Expression exp3 = parser.parse(func3);
        String answer = exp.derivative(xvar).toString();
        String answer2 = exp2.derivative(xvar).toString();
        String answer3 = exp3.derivative(xvar).toString();
        
        assertEquals("sec(x)*tan(x)", answer);
        assertEquals("-csc(x)*cot(x)", answer2);
        assertEquals("-csc(x)^2", answer3);
	}
}
