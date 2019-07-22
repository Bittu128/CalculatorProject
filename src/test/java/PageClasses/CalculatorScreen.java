package PageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CalculatorScreen {
	static boolean bnflag = false;
	static String FileName = "temp.txt";
	public static void openCalc() {
		if (bnflag)
		
		{
			Assert.assertTrue("calculator is launched successfully", bnflag);
		}
		else
		{
			Assert.assertTrue("calculator is not present in your system", bnflag);
		}
		
	}

	public static void checkCalc() {
		
		try {
			Runtime.getRuntime().exec("calc");
	        try {
				TimeUnit.MILLISECONDS.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bnflag = true;
		} catch (IOException e) {
				e.printStackTrace();
				bnflag = false;
		}
	}

	public static void addtwoNumber(String num1) {
		
		int keyCode = 0;
		Double Counter = 0.0;
		String[] numArr = num1.split(",");
		try {
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_2);
			robot.keyRelease(KeyEvent.VK_2);	
			robot.keyRelease(KeyEvent.VK_ALT);	
			TimeUnit.MILLISECONDS.sleep(5000);
			for (int i =0; i<numArr.length;i++)
			{
				Counter = Counter + Integer.parseInt(numArr[i]);
				for (int j =0; j<numArr[i].length();j++)
				{
					keyCode = entervalue(Character.toString(numArr[i].charAt(j)));
					robot.keyPress(keyCode);
					robot.keyRelease(keyCode);
				}
					
			
				TimeUnit.MILLISECONDS.sleep(5000);
				if(i<numArr.length-1) {
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_EQUALS);
				robot.keyRelease(KeyEvent.VK_EQUALS);
				robot.keyRelease(KeyEvent.VK_SHIFT);}
			}
			robot.keyPress(KeyEvent.VK_EQUALS);
			TimeUnit.MILLISECONDS.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			TimeUnit.MILLISECONDS.sleep(5000);
			Assert.assertTrue("Addition Functionality is working Fine", Counter==Double.parseDouble(getClipBoardValue()));		
			robot.keyRelease(KeyEvent.VK_EQUALS);
			robot.keyRelease(KeyEvent.VK_EQUALS);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			bnflag = true;
			
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue("Enter the valid input for addition", false);
			bnflag = false;
		}
		
	}

	private static String getClipBoardValue() {
		Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
        
		try {
			return (String)c.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return null;
		}
	}

	private static int entervalue(String num1) {
		// TODO Auto-generated method stub
		Field field = null;
		int keyCode = 0;
		String variableName =null;
		for (int i =0; i<num1.length(); i++)
		{
			variableName = "VK_" + num1.charAt(i);
			Class clazz = KeyEvent.class;
			
			try {
				field = clazz.getField( variableName );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				keyCode = field.getInt(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}
		return keyCode;
		
	}

	public static void verifyOutput() {
		
		if (bnflag)
			
		{
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_F4);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_F4);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Assert.assertTrue("calculator is working as expected", bnflag);
		}
		else
		{
			Assert.assertTrue("calculator is not working as expected", bnflag);
		}
		
	}

	public static void dividetwoNumber(String num1, String num2) {
		int keyCode = 0;
		double Counter = 0.0;
		try
		{
		Counter= Integer.parseInt(num1)/Integer.parseInt(num2);}
		catch(Exception e)
		{
			Assert.assertTrue("Enter the valid input for division", false);
			e.printStackTrace();
		}
		try {
			
			Robot robot = new Robot();
					
			for (int i =0; i<num1.length();i++)
			{
				
				keyCode = entervalue(Character.toString(num1.charAt(i)));
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
			}
			TimeUnit.MILLISECONDS.sleep(5000);
			robot.keyPress(KeyEvent.VK_SLASH);
			robot.keyRelease(KeyEvent.VK_SLASH);
			for (int i =0; i<num2.length();i++)
			{
				
				keyCode = entervalue(Character.toString(num2.charAt(i)));
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
			}
			robot.keyPress(KeyEvent.VK_EQUALS);
			robot.keyRelease(KeyEvent.VK_EQUALS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			TimeUnit.MILLISECONDS.sleep(5000);
			Assert.assertTrue("Division Functionality is working Fine", Counter==Double.parseDouble(getClipBoardValue()));
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			bnflag = true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bnflag = false;
		}
	
		
	}

	public static void modtwoNumber(String num1, String num2) {
		int keyCode = 0;
		Double Counter = 0.0;
		try
		{
		Counter= (double) (Integer.parseInt(num1) % Integer.parseInt(num2));}
		catch(Exception e)
		{
			Assert.assertTrue("Enter the valid input for mod", false);
			e.printStackTrace();
		}
		try {
			
			Robot robot = new Robot();
			
			TimeUnit.MILLISECONDS.sleep(5000);
			for (int i =0; i<num1.length();i++)
			{
				
				keyCode = entervalue(Character.toString(num1.charAt(i)));
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
			}
			
			TimeUnit.MILLISECONDS.sleep(5000);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_5);
			robot.keyRelease(KeyEvent.VK_5);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			for (int i =0; i<num2.length();i++)
			{
				
				keyCode = entervalue(Character.toString(num2.charAt(i)));
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
			}
			robot.keyPress(KeyEvent.VK_EQUALS);
			robot.keyRelease(KeyEvent.VK_EQUALS);
			robot.keyRelease(KeyEvent.VK_EQUALS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			TimeUnit.MILLISECONDS.sleep(5000);
			System.out.println(Counter);
			Assert.assertTrue("Mod Functionality is working Fine", Counter==Double.parseDouble(getClipBoardValue()));
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			bnflag = true;
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bnflag = false;
		}

		
	}

	public static void squareNumber(String arg1) {
		
		int keyCode = 0;
		double Counter = 0.0;
		try
		{
		Counter = Math.pow(Math.pow(Math.pow(Double.parseDouble(arg1), 2.0),2.0),2.0);}
		catch(Exception e)
		{
			Assert.assertTrue("Enter the valid input for Square", false);
			e.printStackTrace();
		}
		
		try {
			
			Robot robot = new Robot();
				
			TimeUnit.MILLISECONDS.sleep(5000);
			keyCode = entervalue(Character.toString(arg1.charAt(0)));
			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
			TimeUnit.MILLISECONDS.sleep(5000);
			robot.keyPress(KeyEvent.VK_Q);	
			robot.keyRelease(KeyEvent.VK_Q);
			robot.keyPress(KeyEvent.VK_Q);	
			robot.keyRelease(KeyEvent.VK_Q);
			robot.keyPress(KeyEvent.VK_Q);	
			robot.keyRelease(KeyEvent.VK_Q);
			robot.keyPress(KeyEvent.VK_EQUALS);
			robot.keyRelease(KeyEvent.VK_EQUALS);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			TimeUnit.MILLISECONDS.sleep(5000);
			Assert.assertTrue("Square Functionality is working Fine", Counter == Double.parseDouble(getClipBoardValue()));
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			bnflag = true;
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bnflag = false;
		}

		
	}

}
