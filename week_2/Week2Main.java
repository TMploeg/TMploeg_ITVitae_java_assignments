public class Week2Main{
	public static void main(String[] args){
		String[] options = {
			"calculate minutes",
			"convert Celcius to Fahrenheit",
			"convert Fahrenheit to Celcius"
		};
		
		for(int i = 0; i < options.length; i++){
			System.out.println((i + 1) + ". " + options[i]);
		}
		
		int selectedOption = ConsoleHelper.getPositiveNumberInputInRange("what do you want to do?", 1, options.length);
		
		switch(selectedOption){
			case 1:
				int years = ConsoleHelper.getPositiveNumberInput("Nr. or years:");
				int months = ConsoleHelper.getPositiveNumberInput("Nr. or months:");
				int days = ConsoleHelper.getPositiveNumberInput("Nr. or days:");
				int hours = ConsoleHelper.getPositiveNumberInput("Nr. or hours:");
				
				long nrOfMinutes = TimeConverter.calculateMinutes(years,months,days,hours);
				
				System.out.println("minutes: " + nrOfMinutes);
				break;
			case 2:
				double celcius = ConsoleHelper.getDoubleInput("temperature in Celcius");
				System.out.println("temperature in Fahrenheit: " + TemperatureConverter.convertCelciusToFahrenheit(celcius));
				break;
			case 3:
				double fahrenheit = ConsoleHelper.getDoubleInput("temperature in Fahrenheit");
				System.out.println("temperature in Celcius: " + TemperatureConverter.convertFahrenheitToCelcius(fahrenheit));
				break;
			default: throw new RuntimeException("should not reach");
		}
	}
	
	/*
	int years = getPositiveNumberInput("Nr. or years:");
		int months = getPositiveNumberInput("Nr. or months:");
		int days = getPositiveNumberInput("Nr. or days:");
		int hours = getPositiveNumberInput("Nr. or hours:");
	*/
}