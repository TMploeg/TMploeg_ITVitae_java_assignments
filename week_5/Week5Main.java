import fib.*;
import java.util.Scanner;

public class Week5Main {
	public static void main(String[] args){
		int n = getIntegerInput();
		CalculateMethod method = getMethodInput();
		
		Fibonacci.calculate(n, method);
	}
	
	private static int getIntegerInput(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print("Please enter a number: ");
			String input = scanner.nextLine();
			
			if(!isPositiveInteger(input)){
				System.out.println("'" + input + "' is not a number");
				continue;
			}
			
			return Integer.parseInt(input);
		}
	}
	
	private static CalculateMethod getMethodInput(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			displayMethodValues();
			System.out.print("Please select a method by name: ");
			String input = scanner.nextLine();
			
			if(!CalculateMethod.exists(input)){
				System.out.println("'" + input + "' is not a valid method");
				continue;
			}
			
			return CalculateMethod.getByName(input);
		}
	}
	
	private static void displayMethodValues(){
		int counter = 1;
		
		for(CalculateMethod method : CalculateMethod.values()){
			String displayString = method.toString().replace('_', ' ').toLowerCase();
			
			System.out.println(counter + ". " + displayString);
			
			counter++;
		}
	}
	
	private static boolean isPositiveInteger(String value){
		if(value == null || value.length() == 0){
			return false;
		}
		
		String maxValueString = Integer.toString(Integer.MAX_VALUE);
		
		if(maxValueString.length() < value.length()){
			return false;
		}
		
		boolean maybeOutOfRange = maxValueString.length() == value.length();
		
		for(int i = 0; i < value.length(); i++){
			char current = value.charAt(i);
			if(!Character.isDigit(current)){
				return false;
			}
			
			if(maybeOutOfRange){
				int compareResult = Character.compare(current, maxValueString.charAt(i));
				
				if(compareResult < 0){
					maybeOutOfRange = false;
				}
				else if(compareResult > 0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean allDigits(String value){
		if(value == null){
			throw new NullPointerException();
		}
		
		for(char c : value.toCharArray()){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		
		return true;
	}
}