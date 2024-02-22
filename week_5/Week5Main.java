import fib.*;
import input.*;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Optional;

public class Week5Main {
	private enum Flag { 
		FIB,
		INPUT;
		
		private String value;
		
		private Flag(){
			this.value = "-" + this.toString().toLowerCase();
		}
		
		public static Optional<Flag> getByValue(String value){
			for(Flag flag : values()){
				if(flag.value.equals(value)){
					return Optional.of(flag);
				}
			}
			
			return Optional.empty();
		}
	}
	
	public static void main(String[] args){
		if(args.length > 1){
			throw new IllegalArgumentException("no more than one arg allowed");
		}
		
		List<Flag> flags = getFlags(args);
		boolean hasFibFlag = flags.contains(Flag.FIB);
		boolean hasInputFlag = flags.contains(Flag.INPUT);
		
		if(flags.contains(Flag.FIB)){
			int n = getIntegerInput();
			CalculateMethod method = getMethodInput();
			
			Fibonacci.calculate(n, method);
		}
		else if(flags.contains(Flag.INPUT)){
			InputAnalyzer.analyze().display();
		}
	}
	
	private static List<Flag> getFlags(String[] args){
		final List<Flag> flags = new LinkedList<Flag>();
		
		for(String s : args){
			Optional<Flag> flag = Flag.getByValue(s);
			flag.ifPresent(f -> flags.add(f));
		}
		
		return flags;
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