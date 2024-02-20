package fib;

import java.math.BigInteger;

public class Fibonacci {
	//calculate the nth fibonacci number using the selected method
	public static void calculate(int n, CalculateMethod method) {
		long startNanos = System.nanoTime();
		
		if(n < 0){
			throw new IllegalArgumentException("n must be greater than or equal to 0");
		}
		
		BigInteger result = switch(method){
			case RECURSIVE -> calculateRecursive(n);
			case ITERATIVE -> calculateIterative(n);
			default -> throw new RuntimeException("huh?");
		};
		
		long endNanos = System.nanoTime();
		
		System.out.println("EXECUTION TIME");
		System.out.println(convertNanosecondsToMilliseconds(endNanos - startNanos) + "ms");
		System.out.println();
		
		System.out.println("NTH FIBONACCI NUMBER");
		System.out.println(result);
	}
	
	private static BigInteger calculateRecursive(int n){
		return n <= 1
			? BigInteger.valueOf(n)
			: calculateRecursive(n - 1).add(calculateRecursive(n - 2));
	}
	
	private static BigInteger calculateIterative(int n){
		if(n <= 1){
			return BigInteger.valueOf(n);
		}
		
		BigInteger previous = BigInteger.valueOf(0);
		BigInteger current = BigInteger.valueOf(1);
		
		for(int i = 2; i <= n; i++){
			BigInteger temp = current;
			current = current.add(previous);
			previous = temp;
		}
		
		return current;
	}
	
	private static double convertNanosecondsToMilliseconds(long nanoseconds){
		return nanoseconds / 1000000.0;
	}
}