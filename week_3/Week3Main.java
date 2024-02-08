import java.math.BigInteger;
import java.util.Scanner;

public class Week3Main{
	private record Test(String value, boolean expected){}
	
	public static void main(String[] args){
		displayLucasNumbers(askPositiveIntInput("Please enter a number that is greater than or equal to 1:"));
	}
	
	private static void displayLucasNumbers(int n){
		String output = "";
		
		BigInteger previous = BigInteger.valueOf(2);
		output += previous;
		if(n == 1){
			return;
		}
		
		BigInteger current = BigInteger.valueOf(1);
		output += " " + current;
		if(n == 2){
			return;
		}
		
		for(int i = 2; i < n; i++){
			BigInteger temp = current;
			current = current.add(previous);
			previous = temp;
			
			if(!isPositiveInteger(current.toString())){
				System.out.println("cannot show lucasNr(" + n + "), it is too large");
				return;
			}
			
			output += " " + current;
		}
		
		System.out.println(output);
	}
	
	private static int askPositiveIntInput(String message){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String input = scanner.nextLine();
			
			if(isPositiveInteger(input)){
				return Integer.parseInt(input);
			}
			
			System.out.println("invalid input");
		}
	}
	
	private static boolean isPositiveInteger(String s){
		if(s == null || s.length() == 0){
			return false;
		}
		
		String MAX_VALUE = Integer.toString(Integer.MAX_VALUE);
		if(s.length() > MAX_VALUE.length()){
			return false;
		}
		
		boolean possiblyOutOfRange = s.length() == MAX_VALUE.length();
		
		boolean hasNonZeroDigit = false;
		
		for(int i = 0; i < s.length(); i++){
			char current = s.charAt(i);
			
			if(!Character.isDigit(current)){
				return false;
			}
			
			if(possiblyOutOfRange){
				switch(Integer.valueOf(Character.compare(MAX_VALUE.charAt(i), current))){
					case Integer j when j > 0:
						possiblyOutOfRange = false;
						break;
					case Integer j when j < 0:
						return false;
					default:
						break;
				}
			}
			
			if(!hasNonZeroDigit && current != '0'){
				hasNonZeroDigit = true;
			}
		}
		
		return hasNonZeroDigit;
	}
}