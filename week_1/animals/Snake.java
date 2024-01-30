package animals;

public class Snake extends Animal{
	public Snake(String name){
		super(name, AnimalDomain.LAND);
	}
	
	public void makeSound(){
		System.out.println("hissss");
	}
}