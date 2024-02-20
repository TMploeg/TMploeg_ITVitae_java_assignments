package fib;

public enum CalculateMethod {
	RECURSIVE,
	ITERATIVE;
	
	public static boolean exists(String value){
		if(value == null || value.length() == 0){
			return false;
		}
		
		for(CalculateMethod method : CalculateMethod.values()){
			if(method.toString().equals(value.replace(' ', '_').toUpperCase())){
				return true;
			}
		}
		
		return false;
	}
	
	public static CalculateMethod getByName(String name){
		if(name == null || name.length() == 0){
			throw new IllegalArgumentException();
		}
		
		for(CalculateMethod method : CalculateMethod.values()){
			if(method.toString().equals(name.replace(' ', '_').toUpperCase())){
				return method;
			}
		}
		
		throw new EnumConstantNotPresentException(CalculateMethod.class, name);
	}
}