package StepClasses;

import org.testng.annotations.Test;

import PageClasses.CalculatorScreen;


public class CalculatorStep {

	
	@Test
	public static void launchCalculator() {
		
		CalculatorScreen.openCalc();
	}
	
	@Test
	public static void checkForCalculator() {
		
		CalculatorScreen.checkCalc();
	}
	
	@Test
	public static void performAddition(String num1) {
		
		CalculatorScreen.addtwoNumber(num1);
	}
	
	@Test
	public static void verifyResult() {
		CalculatorScreen.verifyOutput();
		
		
	}

	public static void performDivision(String num1, String num2) {
		CalculatorScreen.dividetwoNumber(num1, num2);
		
	}

	public static void performModulus(String num1, String num2) {
		CalculatorScreen.modtwoNumber(num1, num2);

		
	}

	public static void performOperation(String arg1) {
		CalculatorScreen.squareNumber(arg1);
		
	}

}
