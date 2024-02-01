public class EvenOddSumCalculator {
  public static int calculateSumOfEvenNumbers(int n) {
    int total = 0;

    for (int i = 1; i <= n; i++) {
      if (isEven(i)) {
        total += i;
      }
    }

    return total;
  }

  public static int calculateSumOfOddNumbers(int n) {
    int total = 0;

    for (int i = 1; i <= n; i++) {
      if (!isEven(i)) {
        total += i;
      }
    }

    return total;
  }

  private static boolean isEven(int n) {
    return n % 2 == 0;
  }
}
