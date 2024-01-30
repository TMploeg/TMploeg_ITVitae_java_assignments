public class Week2Main{
	public static void main(String[] args){
		String[] options = {
			"calculate minutes",
			"convert Celcius to Fahrenheit",
			"convert Fahrenheit to Celcius",
			"calculate velocity",
			"caesar encode"
		};
		
		for(int i = 0; i < options.length; i++){
			System.out.println((i + 1) + ". " + options[i]);
		}
		
		int selectedOption = ConsoleHelper.getPositiveNumberInputInRange("what do you want to do?", 1, options.length);
		
		switch(selectedOption){
			case 1:
				runConvertMinutes();
				break;
			case 2:
				double celcius = ConsoleHelper.getDoubleInput("temperature in Celcius");
				System.out.println("temperature in Fahrenheit: " + TemperatureConverter.convertCelciusToFahrenheit(celcius));
				break;
			case 3:
				double fahrenheit = ConsoleHelper.getDoubleInput("temperature in Fahrenheit");
				System.out.println("temperature in Celcius: " + TemperatureConverter.convertFahrenheitToCelcius(fahrenheit));
				break;
			case 4:
				runCalculateVelocity();
				break;
			case 5:
				runCaesarEncode();
				break;
			default: throw new RuntimeException("should not reach");
		}
	}
	
	private static void runConvertMinutes(){
		int years = ConsoleHelper.getPositiveNumberInput("Nr. or years:");
		int months = ConsoleHelper.getPositiveNumberInput("Nr. or months:");
		int days = ConsoleHelper.getPositiveNumberInput("Nr. or days:");
		int hours = ConsoleHelper.getPositiveNumberInput("Nr. or hours:");
		
		long nrOfMinutes = TimeConverter.calculateMinutes(years,months,days,hours);
		
		System.out.println("minutes: " + nrOfMinutes);
	}
	
	private static void runCalculateVelocity(){
		int meters = ConsoleHelper.getPositiveNumberInput("nr of meters");
		int hours = ConsoleHelper.getPositiveNumberInput("nr of hours");
		int minutes = ConsoleHelper.getPositiveNumberInput("nr of minutes");
		int seconds = ConsoleHelper.getPositiveNumberInput("nr of seconds");
		
		VelocityCalculator.VelocityData vData = VelocityCalculator.calculate(meters, new VelocityCalculator.TimeData(hours, minutes, seconds));
		
		System.out.println("speed in meters/second: " + vData.metersPerSec());
		System.out.println("speed in km/hour: " + vData.kmPerHour());
		System.out.println("speed in miles/hour: " + vData.milesPerHour());
	}
	
	private static void runCaesarEncode(){
		String code = ConsoleHelper.getStringInput("what is your code?").toUpperCase();
		System.out.println("encoded: " + Encoder.caesarEncode(code));
	}
}