public class VelocityCalculator {
  public record VelocityData(double metersPerSec, double kmPerHour, double milesPerHour) {}

  public record TimeData(int hours, int minutes, int seconds) {
    public double totalHours() {
      return hours + (minutes / 60.0) + (seconds / 3600.0);
    }

    public int totalSeconds() {
      return hours * 3600 + minutes * 60 + seconds;
    }
  }

  public static VelocityData calculate(int meters, TimeData timeData) {
    double metersPerSec = (double) meters / timeData.totalSeconds();
    double kmPerHour = (double) meters / (1000.0 * timeData.totalHours());
    double milesPerHour = (double) meters / (1609.0 * timeData.totalHours());

    return new VelocityData(metersPerSec, kmPerHour, milesPerHour);
  }
}
