package storyClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import StepClasses.CalculatorStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class calculatorstory{
	
	
	
	@Given("^calculator must be present in the system$")
	public void givenCalcultorMustBePresentInTheSystem() throws IOException, InterruptedException{
		CalculatorStep.checkForCalculator();
		
	}
	
	@Given("^calculator should be launched successfully$")
	public void givenCalculatorShouldBeLaunchedSuccessfully(){
		CalculatorStep.launchCalculator();
	}
	
	@When("^user performs addition of numbers \"([^\"]*)\"$")
	public void whenUserPerformsAdditionOfTwoNumbersNumber1AndNumber2(String num1){
		CalculatorStep.performAddition(num1);
	}
	
	@When("^user performs division of two numbers \"([^\"]*)\" and \"([^\"]*)\"$")
	public void whenUserPerformsDivisionOfTwoNumbersNumber3AndNumber4(String num1,String num2){
		CalculatorStep.performDivision(num1, num2);
	}
	@When("^user performs mod of two numbers \"([^\"]*)\" and \"([^\"]*)\"$")
	public void whenUserPerformsmodOfTwoNumbersNumber5AndNumber6(String num1,String num2){
		CalculatorStep.performModulus(num1, num2);
	}
	@When("^user performs (\\d+) the given operation$")
	public void whenUserPerformsOperationTheGivenOperation(String arg1){
		CalculatorStep.performOperation(arg1);
	}
	@Then("^verify addition is working fine$")
	public void thenVerifyAdditionIsWorkingFine(){
		 CalculatorStep.verifyResult();
	}
	
}