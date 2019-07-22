@tag
Feature: calculator functionality

  
  Scenario Outline: To verify addition division mod and square functionality of calculator
    
			Given calculator must be present in the system
			And calculator should be launched successfully
			When user performs addition of numbers "<Number1>"
			And user performs division of two numbers "<Number3>" and "<Number4>"
			And user performs mod of two numbers "<Number5>" and "<Number6>"
			And user performs <operation> the given operation
			Then verify addition is working fine

    Examples: 
      |Number1||Number3||Number4||Number5||Number6||operation|
			|1,2,3,4,50||10			||2		 	 ||10     ||3			 ||4		 |
			
