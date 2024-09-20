/**
 *
 * @author ziping
 */
public class JavaInheritanceEx1_Animal {
    public static void main(String[] args) {
        // Create a hippo weighing 1500kg, 1.6m tall, running at 30km/h
        Animal hippo = new Animal("hippo", 1500, 1.6, 30);
        System.out.println(hippo.toString());
        System.out.println();

        // Shallow copy (alias) of hippo, pointing to the same heap memory object
        Animal hippoAlias = hippo;
        System.out.printf("hippoAlias and hippo are referentially equal: %b\n", (hippoAlias == hippo));
        System.out.printf("hippoAlias and hippo are structurally equal: %b\n", hippoAlias.equals(hippo));
        hippoAlias.setName("hippoAlias");
        System.out.println(hippo.toString());
        System.out.println();

        // Deep copy (clone) of hippo, pointing to a different heap memory object
        Animal hippoClone = hippo.getClone();
        System.out.printf("hippoClone and hippo are referentially equal: %b\n", (hippoClone == hippo));
        System.out.printf("hippoClone and hippo are structurally equal: %b\n", hippoClone.equals(hippo));
        hippoClone.setName("hippoClone");
        System.out.println(hippo.toString());
        System.out.println();

        // Animal static count field:
        System.out.printf("Animal count: %d\n\n", Animal.getCount());

        // Dynamic dispatch example
        Pet fluffers = new Pet("Fluffers", 2.6, 0.2, 63, "Wanda");
        System.out.println(fluffers.toString());
        fluffers.eat();
        System.out.printf("Pet count: %d\n\n", Pet.getNum());

        // super invokes the Animal constructor
        System.out.printf("Animal count with Animal: %d\n", Animal.getCount());
        System.out.printf("Animal count with Pet: %d\n\n", Pet.getCount());

        Animal rabbit = fluffers;
        rabbit.eat();
        // PROBLEM: "The method getOwner() is undefined for type Animal.
        // rabbit.getOwner();
        // cast rabbit to Pet will solve the problem
        //System.out.println("Animal rabbit's owner: " + ((Pet) rabbit).getOwner());
        System.out.printf("Animal count with Animal: %d\n\n", Animal.getCount());

        // Knowledge check 3d:
        // Suppose we uncommented the following lines of code. What is the result?
        // rabbit = hippoClone;
        // fluffers.setOwner("Ned");
        // System.out.println(hippoClone.getOwner());

        // Knowledge check 3e:
        // Suppose we uncommented the following lines of code. What is the result?
        // fluffers = rabbit;
        // System.out.println(fluffers.getID());

        // Demonstrate polymorphism within an array
        int n = 5;
        Animal[] animalArr = new Animal[n];
        Animal fluffersClone = fluffers.getClone();
        animalArr[0] = fluffers;
        animalArr[1] = rabbit;
        animalArr[2] = fluffersClone;
        animalArr[3] = new Wildlife();
        animalArr[4] = new Pet();
        for (int i = 0; i < n; i++) {
            display(i, animalArr);
            System.out.println();
        }

        System.out.printf("Animal count with Animal: %d\n", Animal.getCount());
        System.out.printf("Pet count: %d\n", Pet.getNum());
        System.out.printf("Wildlife count: %d\n", Wildlife.getNum());
        System.out.println();

        // Fine-tune the equals() method
        System.out.printf("fluffers.equals(rabbit)? %b\n", fluffers.equals(rabbit));
        System.out.printf("rabbit.equals(fluffers)? %b\n", rabbit.equals(fluffers));
        System.out.printf("fluffers.equals(fluffersClone)? %b\n", fluffers.equals(fluffersClone));
        System.out.printf("fluffersClone.equals(fluffers)? %b\n", fluffersClone.equals(fluffers));
        System.out.printf("rabbit.equals(fluffersClone)? %b\n", rabbit.equals(fluffersClone));
        System.out.printf("fluffersClone.equals(rabbit)? %b\n", fluffersClone.equals(rabbit));
        System.out.println();

        // Knowledge check 4:
        // Suppose we uncommented the following lines of code.
        /* Wildlife x1 = new Wildlife();
        Animal x2 = x1.getClone();
        Pet x3 = new Pet();
        Animal x4 = x3;  */

        // For each statement below, will it fail to compile,
        // compile but run with exception, or compile and run without exception?
        /* Animal b1 = (Animal) x1;
        Animal b2 = (Animal) x2;
        Animal b3 = (Animal) x3;
        Animal b4 = (Animal) x4; */

        /* Pet c1 = (Pet) x1;
        Pet c2 = (Pet) x2;
        Pet c3 = (Pet) x3;
        Pet c4 = (Pet) x4; */

        // Demonstration of getClass() method:
        Object o = new Object();
        System.out.printf("Dynamic class of o: %s\n",
                o.getClass().toString());
        System.out.printf("Dynamic class of fluffers: %s\n",
                fluffers.getClass().toString());
        System.out.printf("Dynamic class of rabbit: %s\n",
                rabbit.getClass().toString());
        System.out.printf("Dynamic class of fluffersClone: %s\n",
                fluffersClone.getClass().toString());

        // Rerun Cell A5-1.

        // Knowledge check 5: First, fix the Wildlife equals() method. Then, in the
        // space below, write some code that will produce incorrect output when the
        // Wildlife equals() method is invoked with the incorrect implementation, but
        // the correct output with your revised version.
        Wildlife wolf = new Wildlife("wolf", 50.5, 3.5, 69.9, "forest");
        Animal wolfClone = wolf.getClone();
        System.out.printf("\nwolf.equals(wolfClone)? %b\n", wolf.equals(wolfClone));
        System.out.printf("wolfClone.equals(wolf)? %b\n", wolfClone.equals(wolf));

//
//        //Perform casting if animalArr[0] is an instance of Pet
//        //and check the class it belongs to
//        if(animalArr[0] instanceof Pet){
//            System.out.println("I am a pet and my id is: " + ((Pet)animalArr[0]).getID());
//            System.out.println("my class is: " + animalArr[0].getClass().getName());
//        }
    }

    /**
     * Print the objects of an input array
     * @param currIndex current position in the array
     * @param arr input {@code Object} array
     */
    public static void display(int currIndex, Object[] arr) {
        Object currObject = arr[currIndex];
        System.out.printf("Object %d:\n", currIndex + 1);
        System.out.println(currObject.toString());
    }
}

