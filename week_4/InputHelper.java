import java.util.Scanner;
import java.util.LinkedList;

public class InputHelper{
	public static int getSingleIntInput(String message){
		return getMultipleIntInput(message, 1)[0];
	}
	
	public static int[] getMultipleIntInput(String message, int count){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.print(message + " ");
			String[] intInputs = scanner.nextLine().split(" ");
			
			LinkedList<String> errorMessages = new LinkedList<>();
			
			if(intInputs.length != count){
				errorMessages.add(new StringBuilder("exactly '").append(count).append("' numbers required").toString());
			}
			
			boolean anyInputInvalid = false;
			int[] numbers = new int[intInputs.length];
			int index = 0;
			
			for(String intInput : intInputs){
				if(!isPositiveInteger(intInput)){
					errorMessages.add("one or more inputs are not valid integers");
					break;
				}
				
				numbers[index] = Integer.parseInt(intInput);
				index++;
			}
			
			if(errorMessages.size() > 0){
				System.out.println("ERROR: " + String.join(", ", errorMessages));
				continue;
			}
			
			return numbers;
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
		}
		
		return true;
	}
}