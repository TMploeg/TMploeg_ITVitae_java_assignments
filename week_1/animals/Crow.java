package animals;

public class Crow extends Animal{
	public Crow(String name){
		super(name, AnimalDomain.AIR);
	}
	
	public void makeSound(){
		System.out.println("caw! caw!");
	}
}