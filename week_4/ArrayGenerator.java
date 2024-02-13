public class ArrayGenerator{
	private static final Character GRAPHIC_DISPLAY_CHARACTER = '*';
	
	private final int[] numbers;
	
	public ArrayGenerator(){
		int numItems = InputHelper.getSingleIntInput("How many items does the array have?");
		numbers = InputHelper.getMultipleIntInput("Please enter the numbers to add to the array:", numItems);
	}
	
	public void display(){
		System.out.println("NUMBERS: [" + joinNumbers(", ", numbers) + "]");
		
		StringBuilder builder = new StringBuilder("GRAPHIC DISPLAY:\n");
		
		for(int number : numbers){
			for(int i = 0; i < number; i++){
				builder.append(GRAPHIC_DISPLAY_CHARACTER);
			}
			
			builder.append("\n");
		}
		
		System.out.print(builder.toString());
	}
	
	private static String joinNumbers(String seperator, int[] numbers){
		StringBuilder builder = new StringBuilder();
		
		boolean hasSeperator = seperator != null && seperator.length() > 0;
		boolean first = true;
		
		for(int number : numbers){
			if(!first && hasSeperator){
				builder.append(seperator);
			}
			
			builder.append(number);
			
			first = false;
		}
		
		return builder.toString();
	}
}