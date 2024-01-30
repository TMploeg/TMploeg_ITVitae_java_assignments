package animals;

public class Cod extends Animal{
	public Cod(String name){
		super(name, AnimalDomain.SEA);
	}
	
	public void makeSound(){
		System.out.println("blub blub blub...");
	}
}