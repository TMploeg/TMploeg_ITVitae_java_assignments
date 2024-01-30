public class TemperatureConverter{
	public static double convertCelciusToFahrenheit(double celcius){
		return celcius * 9.0 / 5.0 + 32;
	}
	
	public static double convertFahrenheitToCelcius(double fahrenheit){
		return (fahrenheit - 32) * 5.0 / 9.0;
	}
}