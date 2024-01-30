public class TimeConverter{
	public static long calculateMinutes(int years, int months, int days, int hours){
		return (hours * 60) + (days * 24 * 60) + (months * 30 * 24 * 60) + (years * 365 * 24 * 60);
	}
}