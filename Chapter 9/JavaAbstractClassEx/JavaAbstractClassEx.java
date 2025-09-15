package client;
import res.*;

public class JavaAbstractClassEx {

    public static void main(String[] args) {
        // Instantiating Pet object will invoke the Animal constructor
        Pet rufus = new Pet("Rufus", 30.9, 0.89, 50.5, "Peter"); 
        System.out.println(rufus.toString());        
        rufus.eat();
        
        // Assign a subclass object to an abstract superclass variable
        Animal rufusAsAnAnimal = rufus;
        // Dynamic dispatch: subclass version of method toString() is executed
        System.out.printf("\nDynamic dispatch with abstract static type:\n%s", 
                rufusAsAnAnimal.toString());
        
        Pet rufusPetClone = new Pet("Rufus", 30.9, 0.89, 50.5, "Peter"); 
        System.out.printf("\n\nrufusAsAnAnimal == rufusPetClone? %b", 
                rufusAsAnAnimal == rufusPetClone);
        System.out.printf("\nrufusAsAnAnimal.equals(rufusPetClone)? %b", 
                rufusAsAnAnimal.equals(rufusPetClone));
        
        System.out.println("\n\nPolymorphism and dynamic dispatch:");
        Animal[] animals = new Animal[3];
        animals[0] = rufus;
        animals[1] = new Pet("Fluffers", 9.9, 0.59, 10.5, "Jenny");
        animals[2] = new Wildlife("wolf", 20.9, 1.15, 51.5, "forests");
        for (Animal animal: animals) {
            System.out.println("**********");
            System.out.println(animal.toString());
            animal.eat();
        }
    }
}
