import java.util.Scanner;

public class ConsoleHelper{
	public static int getPositiveNumberInput(String message){
		return getPositiveNumberInputInRange(message, 0, Integer.MAX_VALUE);
	}
	
	public static int getPositiveNumberInputInRange(String message, int min, int max){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String numberInput = scanner.nextLine();
			
			if(!isPositiveInteger(numberInput)){
				System.out.println("error: '" + numberInput + "' is not a valid number.");
				continue;
			}
			
			int number = Integer.parseInt(numberInput);
			
			if(number < min || number > max){
				System.out.println("error: '" + number + "' is out of range (" + min + " - " + max + ")");
			}
			
			return number;
		}
	}
	
	public static double getDoubleInput(String message){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String doubleInput = scanner.nextLine();
			
			try{
				return Double.parseDouble(doubleInput);
			}
			catch(NumberFormatException e){
				System.out.println("error: '" + doubleInput +"' is not a valid input");
			}
		}
	}
	
	private static boolean isPositiveInteger(String nrString){
		if(nrString == null){
			throw new NullPointerException("nrString cannot be null");
		}
		
		if(nrString.length() == 0){
			return false;
		}
		
		String maxValueString = Integer.toString(Integer.MAX_VALUE);
		
		int lengthDiff = maxValueString.length() - nrString.length();
		
		if(lengthDiff < 0 || !allDigits(nrString)){
			return false;
		}

		return lengthDiff > 0 || !isLarger(nrString, maxValueString);
	}
	
	private static boolean hasMoreThanOneCharacter(String str){
		return str != null && str.length() > 1;
	}
	
	private static boolean allDigits(String str){
		for(char c : str.toCharArray()){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isLarger(String str, String maxValueString){
		if(str.length() != maxValueString.length()){
			return str.length() > maxValueString.length();
		}
	
		for(int i = str.length() - 1; i >=0; i--){
			if(str.charAt(i) != maxValueString.charAt(i)){
				return str.charAt(i) > maxValueString.charAt(i);
			}
		}
		
		return false;
	}
}