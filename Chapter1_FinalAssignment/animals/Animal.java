package animals;

public abstract class Animal{
	private final String name;
	private final AnimalDomain domain;
	
	protected Animal(String name, AnimalDomain animalDomain){
		this.name = name;
		this.domain = animalDomain;
	}
	
	public abstract void makeSound();
	
	public String getName(){
		return name;
	}
	
	public AnimalDomain getDomain(){
		return domain;
	}
}