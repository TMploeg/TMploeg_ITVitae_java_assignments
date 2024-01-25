package math;

import java.lang.Math;
import java.math.BigInteger;

public abstract class NumberProcessor{
	
	public static final double PI = 3.141592653589793;
	
	//add 2 decimal numbers together
	public static double sum(double d1, double d2){
		return d1 + d2;
	}
	
	//add all decimal number together
	public static double sumMany(double[] values){
		double total = 0;
		
		for(double d : values){
			total += d;
		}
		
		return total;
	}
	
	//subtract decimal nubmer 'd2' from 'd1'
	public static double subtract(double d1, double d2){
		return d1 - d2;
	}
	
	//multiply 2 decimal numbers
	public static double multiply(double d1, double d2){
		return d1 * d2;
	}
	
	//raise any decimal number 'd1' to the power 'exponent', exponent can be any integer, positive or negative
	public static double power(double d1, int exponent){
		double total = 1;
		int absExponent = exponent;
		boolean isNegativeExponent = exponent < 0;
		
		if(isNegativeExponent){
			absExponent *= -1;
		}
		
		for(int i = 0; i < absExponent; i++){
			total *= d1;
		}
		System.out.println(total);
		if(isNegativeExponent){
			total = 1.0 / total;
		}
		
		return total;
	}
	
	//get 'n'th fibonacci number where n >= 0
	//nr 1.000.000 took 12.077 milliseconds to compute
	public static BigInteger fib(int n){
		if(n < 0){
			throw new IllegalArgumentException("n must be greater than or equal to 0");
		}
		
		if(n <= 1){
			return BigInteger.valueOf(n);
		}
		
		BigInteger[] fibValues = new BigInteger[]{BigInteger.valueOf(0), BigInteger.valueOf(1)};
		
		for(int i = fibValues.length; i <= n; i++){
			fibValues = new BigInteger[]{fibValues[1], fibValues[0].add(fibValues[1])};
			
			if(i % 65536 == 0){
				System.gc();
			}
		}
		return fibValues[1];
	}
	
	//get random 'true' or 'false' value
	public static boolean generateRandomBooleanValue(){
		return ((int)(Math.random() * 2)) == 1;
	}
}