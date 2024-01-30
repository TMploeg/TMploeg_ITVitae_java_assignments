import java.util.Scanner;

public class CalculateMinutes{
	public static void run(){
		int years = getPositiveNumberInput("Nr. or years:");
		int months = getPositiveNumberInput("Nr. or months:");
		int days = getPositiveNumberInput("Nr. or days:");
		int hours = getPositiveNumberInput("Nr. or hours:");
		
		int minutes = (hours * 60) + (days * 24 * 60) + (months * 30 * 24 * 60) + (years * 365 * 24 * 60);
		
		System.out.println("minutes: " + minutes);
	}
	
	public static int getPositiveNumberInput(String message){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String numberInput = scanner.nextLine();
			
			if(!isPositiveInteger(numberInput)){
				System.out.println("error: '" + numberInput + "' is not a valid number.");
				continue;
			}
			
			return Integer.parseInt(numberInput);
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