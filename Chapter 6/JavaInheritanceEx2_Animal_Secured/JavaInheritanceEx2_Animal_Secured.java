package client;

import animal.*;

/**
 *
 * @author ziping
 */
public class JavaInheritanceEx2_Animal_Secured {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException{
        Pet fluffers = new Pet("Fluffers", 2.6, 0.2, 63, "Wanda");
        System.out.println(fluffers.toString() + "\n");

        // improve fluffers' speed
        // fluffers' owner is not a trainer, hence can not change
        boolean speedChanged = fluffers.setMaxSpeed(73);
        System.out.println("Fluffers' speed changed: authorized? " + speedChanged);

        // malicious coding
        // gainPerformance( ) is not overriden by Pet class,
        // trainer checking for permission is not conducted
        speedChanged = fluffers.gainPerformance();
        // Fluffers's speed shoudn't be changed, since owner Wanda is not a trainer
        System.out.println("Fluffers' speed changed: unauthorized? " + speedChanged + "\n");

        // malicious coding
        // constructor calls another instance method
        Animal ac = new Animal();
        // subclass's constructor invoked an instance method
        // which accesses uninitialized instance variable
        Pet pc = new Pet();

        Animal ac2 = new Animal("hippo", 1500, 1.6, 30);
        Animal ac3 = new Pet("Fluffers2", 2.6, 0.2, 63, "Wanda2");
        System.out.print("\n" + ac2.getName() + " Animal: ");
        ac2.showHidden();
        // malicious code
        // Fluffers2 should be shown in Pet
        // subclass's overriden static method not bound for dynamic invocation
        System.out.print(ac3.getName() + " Pet: ");
        ac3.showHidden();

        System.out.println();
        // doSomething() should only be allowed to access inside eat()
        ac2.eat();
        // doSomething() shouldn't be allowed to be invoked in driver
        //ac3.doSomething(); //compiler reports error
        ((Pet)ac3).doSomething();

        Animal one = new Pet();
        Pet two = (Pet)(one.clone());
        System.out.println();
        System.out.println(one.guests[0]);
        System.out.println(two.guests[0]);
    }

}

