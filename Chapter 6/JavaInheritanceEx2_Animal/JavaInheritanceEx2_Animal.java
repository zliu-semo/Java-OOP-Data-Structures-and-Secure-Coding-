package client;
import animal.*;

public class JavaInheritanceEx2_Animal {

    public static void main(String[] args) {
        // Create a hippo weighing 1500kg, 1.6m tall, running at 30km/h
        Animal hippo = new Animal("hippo", 1500, 1.6, 30);
        System.out.printf("%s\n\n", hippo.toString());

        Animal hippoClone = hippo.getClone();
        System.out.printf("hippo.equals(hippoClone)? %b\n\n", hippo.equals(hippoClone));
        // not allowed to access setName() outside the animal package
        // hippoClone.setName("hippoClone");

        Pet fluffers = new Pet("Fluffers", 2.6, 0.2, 63, "Wanda");
        fluffers.eat();
        System.out.println();

        Wildlife firstWildlife = new Wildlife();
        System.out.printf("Animal count: %d\n", Animal.getCount());
        System.out.printf("Pet count: %d\n", Pet.getNum());
        System.out.printf("Wildlife count: %d\n\n", Wildlife.getNum());

        System.out.println(firstWildlife.getClass().toString());
        System.out.println();

        // Code to add on (uncomment) for Knowledge Checks 1 and 2:
        /*
         * Animal lion = new Animal("lion", 200, 1.9, 80.5);
         * String s = new String("lion");
         * boolean result = s.equals(lion.getName());
         */
        // Remove the import animal.*; statement.
        // 1) How could you make this code compile?
        // 2) Assuming you made those changes so that the code compiles, what is
        //    the value of 'result'?

        // Secure coding guideline: overriding example
        Animal[] arr = {hippo, fluffers};
        for (Animal a: arr) {
            a.train(100.0);
            // a.setMaxSpeed(100.0 + a.getMaxSpeed());
            System.out.printf("%s: %.2f\n", "max running speed", a.getMaxSpeed());
        }
    }
}

