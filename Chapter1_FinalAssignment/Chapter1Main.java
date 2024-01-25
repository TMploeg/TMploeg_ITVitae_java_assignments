import math.NumberProcessor;
import animals.*;
import java.util.Scanner;

public class Chapter1Main{
	public static void main(String[] args){
		showMenu();
	}
	
	public static void showMenu(){
		int selectedOption = getMenuOptionInput(new String[]{
			"open number processor",
			"show animals"
		});
		
		switch(selectedOption){
			case 1:
				showNrProcessorMenu();
				break;
			case 2:
				showAnimals();
				break;
			default: throw new RuntimeException("invalid choice detected");
		}
	}
	
	private static void showNrProcessorMenu(){
		int selectedOption = getMenuOptionInput(new String[]{
			"Sum",
			"Sum Multiple",
			"Subtract",
			"Multiply",
			"Power",
			"Fibonacci"
		});
		
		switch(selectedOption){
			case 1:
				System.out.println("Sum of 2 numbers:");
				double[] sumNumbers = askNumbers(2);
				displaySum(sumNumbers[0], sumNumbers[1]);
				break;
			case 2:
				System.out.println("Sum of n numbers:");
				displaySumMany(askNumbers(getNumberInputInRange("How many numbers do you want to sum?", 2, 10)));
				break;
			case 3:
				System.out.println("Difference of 2 numbers:");
				double[] diffNumbers = askNumbers(2);
				displaySubtract(diffNumbers[0], diffNumbers[1]);
				break;
			case 4:
				System.out.println("Product of 2 numbers:");
				double[] productNumbers = askNumbers(2);
				displayMultiply(productNumbers[0], productNumbers[1]);
				break;
			case 5:
				System.out.println("nr A raised to power B:");
				double base = getDoubleInput("base:");
				int exponent = getNumberInput("exponent:");
				displayPower(base,exponent);
				break;
			case 6:
				System.out.println("Nth number of the fibonacci sequence");
				int n = getNumberInputInRange("n:", 0, Integer.MAX_VALUE);
				displayFib(n);
				break;
			default: throw new RuntimeException("invalid choice detected");
		}
	}
	
	private static void displaySum(double nr1, double nr2){
		System.out.println(nr1 + " + " + nr2 + " = " + NumberProcessor.sum(nr1,nr2));
	}
	
	private static void displaySumMany(double[] numbers){
		boolean first = true;
		
		for(double nr : numbers){
			if(!first){
				System.out.print(" + ");
			}
			
			System.out.print(nr);
			first = false;
		}
		
		System.out.println(" = " + NumberProcessor.sumMany(numbers));
	}
	
	private static void displaySubtract(double nr1, double nr2){
		System.out.println(nr1 + " - " + nr2 + " = " + NumberProcessor.subtract(nr1,nr2));
	}
	
	private static void displayMultiply(double nr1, double nr2){
		System.out.println(nr1 + " * " + nr2 + " = " + NumberProcessor.multiply(nr1,nr2));
	}
	
	private static void displayPower(double base, int exponent){
		System.out.println(base + "^" + exponent + " = " + NumberProcessor.power(base, exponent));
	}
	
	private static void displayFib(int n){
		System.out.println("fib number " + n + ": " + NumberProcessor.fib(n));
	}
	
	private static double[] askNumbers(int count){
		double[] numbers = new double[count];
		
		for(int i = 0; i < count; i++){
			numbers[i] = getDoubleInput("Number " + (i + 1) + ":");
			
			System.out.print("numbers: { ");
			
			for(int ii = 0; ii <= i; ii++){
				System.out.print(numbers[ii]);
				
				if(ii < i){
					System.out.print(", ");
				}
			}
			
			System.out.println(" }");
		}
		
		return numbers;
	}
	
	private static void showAnimals(){
		Animal[] animals = new Animal[]{
			new Cod("john"),
			new Crow("bob"),
			new Snake("in my boot")
		};
		
		System.out.println("Animals:");
		
		for(Animal animal : animals){
			System.out.println(animal.getClass().getSimpleName() + " '" + animal.getName() + "' in " + animal.getDomain());
		}
	}
	
	private static int getMenuOptionInput(String[] options){
		for(int i = 0; i < options.length; i++){
			System.out.println((i + 1) + ". " + options[i]);
		}
		
		int choice = getNumberInputInRange("Please enter the number of the option you want:", 1,options.length);
		
		return choice;
	}
	
	public static int getNumberInput(String message){
		return getNumberInputInRange(message, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static int getNumberInputInRange(String message, int min, int max){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String numberInput = scanner.nextLine();
			
			if(!isNumber(numberInput)){
				System.out.println("error: '" + numberInput + "' is not a number.");
				continue;
			}
			
			boolean isInteger = isInteger(numberInput);
			int number = 0;
			
			if(isInteger){
				number = Integer.parseInt(numberInput);
			}
			
			if(!isInteger || (number < min || number > max)){
				System.out.println("error: '" + number + "' is out of range (min: '" + min + "', max: '" + max + "')");
				continue;
			}
			
			return number;
		}
	}
	
	private static boolean isNumber(String str){
		if(str == null){
			throw new NullPointerException("argument 'str' is null");
		}
		
		if(str.length() == 0){
			return false;
		}
		
		char[] splitChars = str.toCharArray();
		if(str.charAt(0) == '-'){
			if(str.length() == 1){
				return false;
			}
			
			splitChars = str.substring(1).toCharArray();
		}
		
		for(char c : splitChars){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isInteger(String nrString){
		if(nrString == null){
			throw new NullPointerException("nrString cannot be null");
		}
		
		if(!isNumber(nrString)){
			return false;
		}
	
		boolean isPositive = true;
		String maxValueString = Integer.toString(Integer.MAX_VALUE);
		String absNrString = nrString;
		
		if(nrString.charAt(0) == '-'){
			isPositive = false;
			maxValueString = Integer.toString(Integer.MIN_VALUE * -1);
			absNrString = nrString.substring(1);
		}
		
		if(absNrString.length() != maxValueString.length()){
			return absNrString.length() < maxValueString.length();
		}
		
		for(int i = absNrString.length() - 1; i >=0; i--){
			if(absNrString.charAt(i) != maxValueString.charAt(i)){
				return absNrString.charAt(i) < maxValueString.charAt(i);
			}
		}
		
		return true;
	}

	private static double getDoubleInput(String message){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String doubleInput = scanner.nextLine();
			
			try{
				double result = Double.parseDouble(doubleInput);
				return result;
			}
			catch(NumberFormatException e){
				System.out.println("'" + doubleInput + "' is not a valid number.");
			}
		}
	}
}