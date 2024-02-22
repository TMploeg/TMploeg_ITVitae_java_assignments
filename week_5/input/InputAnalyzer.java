package input;

import java.util.Scanner;

public class InputAnalyzer {
	public static InputData analyze(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();
		
		return new InputData(input);
	}
}