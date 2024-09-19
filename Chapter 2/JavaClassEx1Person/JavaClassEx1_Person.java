import java.util.Scanner;
/**
 *
 * @author ziping
 */
public class JavaClassEx1_Person {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create a person object p1 using default constructor
        Person p1 = new Person();
        // instance method toString() is invoked implicitly
        System.out.println(p1);

        // invoke instance methods getName() and getAge()
        System.out.println("p1's name: " + p1.getName());
        System.out.println("p1's age: " + p1.getAge());

        // invoke the instance methods for knowledge check 1
        System.out.println("p1's weight: " + p1.getWeight());
        System.out.println("p1's height: " + p1.getHeight());

        System.out.println("what do you want p1's name to be changed to?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        // invoke instance method setName()
        p1.setName(name);
        // invoke the instance methods for knowledge check 2a
        System.out.println("what do you want p1's age, weight and height to be changed to?");
        int age = sc.nextInt();
        double weight = sc.nextDouble();
        double height = sc.nextDouble();
        p1.setAge(age);
        p1.setWeight(weight);
        p1.setHeight(height);
        System.out.println(p1);

        // knowledge check 3:
        // draw a stack memory and heap memory diagram similar to figure 2-4d
        // after calling setPerson( ) method
        p1.setPerson("xyz", 99, 130.9, 5.5);
        System.out.println("call p1's setPerson() method:\n" + p1);

        // difference between alias and clone
        Person jane = new Person("jane", 10, 82, 5.1);
        Person janeClone = jane.getClone();
        Person janeAlias = jane.getSelf();

        janeClone.setAge(11);
        System.out.println("clone age: " + janeClone.getAge());
        System.out.println("alias age: " + janeAlias.getAge());
        System.out.println("original age: " + jane.getAge() + "\n");

        janeAlias.setAge(12);
        System.out.println("clone age: " + janeClone.getAge());
        System.out.println("alias age: " + janeAlias.getAge());
        System.out.println("original age: " + jane.getAge() + "\n");

        // create Person objects using explicit constructor
        Person bob = new Person("Bob", 16, 150.5, 5.8);
        Person claire = new Person("Claire", 18, 142.0, 5.5);

        // Bob and Claire have a conversation.
        bob.talk("Hi, Claire. How are you?");
        claire.talk(String.format("Hey, Bob. I turned %d today.", (claire.getAge())));
        bob.talk("Wow, I almost forgot your birthday.");
        claire.talk("That's what brothers are for.");

        bob.introduceSelf();

        // testing .equals(Object o) method
        // same setup as before, with the "jane" example
        /*Person jane = new Person("jane", 10, 82, 5.1);
        Person janeClone = jane.getClone();
        Person janeAlias = jane.getSelf();*/

        System.out.println("jane and clone structurally equal? " + jane.equals(janeClone));
        System.out.println("jane and alias structurally equal? " + jane.equals(janeAlias));
        System.out.println("jane and clone referentially equal? " + (jane == janeClone));
        System.out.println("jane and alias referentially equal? " + (jane == janeAlias));

        // make a small change
        janeAlias.setAge(101);
        System.out.println("jane and clone structurally equal? " + jane.equals(janeClone));
        System.out.println("jane and alias structurally equal? " + jane.equals(janeAlias));
        System.out.println("jane and clone referentially equal? " + (jane == janeClone));
        System.out.println("jane and alias referentially equal? " + (jane == janeAlias));

        // make another change
        janeClone.setAge(101);
        System.out.println("jane and clone structurally equal? " + jane.equals(janeClone));
        System.out.println("jane and alias structurally equal? " + jane.equals(janeAlias));
        System.out.println("jane and clone referentially equal? " + (jane == janeClone));
        System.out.println("jane and alias referentially equal? " + (jane == janeAlias));

        // Knowledge check 4
        // create an alias of janeClone and a clone of janeAlias. use mutators to change various fields.
        // predict how structural and referential equality between the pairs of objects will change.
        // output the result.
        Person janeCloneAlias = janeClone;
        Person janeAliasClone = janeAlias.getClone();
        janeCloneAlias.setName("janeCloneAlias");
        janeAliasClone.setName("janeAliasClone");
        System.out.println("janeClone and janeCloneAlias structurally equal? " + janeCloneAlias.equals(janeClone));
        System.out.println("janeAlias and janeAliasClone structurally equal? " + janeAliasClone.equals(janeAlias));
        System.out.println("janeClone and janeCloneAlias referentially equal? " + (janeClone == janeCloneAlias));
        System.out.println("janeAlias and janeAliasClone referentially equal? " + (janeAlias == janeAliasClone));

        // create second person object p2 using explicit constructor
        Person p2 = new Person("Bob", 18, 150.5, 5.8);
        // testing this operator
        p2.setName2("Peter");
        p2.introduceSelf();
        System.out.println("testing if this is object itself with getSelf(): " + (p2 == p2.getSelf()));
        System.out.println("testing if this is object itself with getClone(): " + (p2 == p2.getClone()));
        // Knowledge check 3:
        // draw the stack memory and heap memory diagram after calling the above four methods

        // testing other methods
        System.out.println();
        p2.talk(p2.getName() + " >hello");
        p1.talk(p1.getName() + " >hello, my age is " + p1.getAge());
        System.out.println();
        System.out.println("testing if object equals itself with getSelf(): " + (p2.equals(p2.getSelf())));
        System.out.println("testing if object equals its getClone(): " + (p2.equals(p2.getClone())));
        System.out.println();

        swapPersonCopyVer(p1, p2);
        System.out.printf("p1= " + p1.toString() + "\n");
        System.out.printf("p2= "+ p2.toString() + "\n");

        Person[] pArray1 = new Person[1];
        Person[] pArray2 = new Person[1];
        pArray1[0] = p1;
        pArray2[0] = p2;
        swapPerson(pArray1, pArray2);
        System.out.printf("pArray1= " + pArray1[0].toString() + "\n");
        System.out.printf("pArray2= "+ pArray2[0].toString() + "\n");

        int x = 100;
        checkPassPrimitiveVal(x);
        System.out.println("pass primitive data to function check: " + x);

        // Java is strictly pass-by-value
        checkPassObj(p2); //p2's reference copy will be plugged in, p2 changed
        System.out.printf("After calling checkPassObj: p2 = %s\n", p2.toString());

        checkPassObj2(p2); //p2's reference copy will be plugged in, not p2 will be plugged
        //and p2 won't be changed to "actor"
        System.out.printf("After calling checkPassObj2: p2 = %s\n", p2.toString());

        // Knowledge check 5:
        // draw the stack memory and heap memory diagram after calling the above five methods
    }

    public static void swapPersonCopyVer(Person cp1, Person cp2){
        Person temp = cp1;
        cp1 = cp2;
        cp2 = temp;
    }

    public static void swapPerson(Person[] parr1, Person[] parr2){
        Person temp = parr1[0];
        parr1[0] = parr2[0];
        parr2[0]= temp;
    }

    //pass-by-value for primitive type parameter
    public static void checkPassPrimitiveVal(int i){
        i = -100;
    }

    //pass-by-value for object type parameter
    //method invokes object's "set" method
    public static void checkPassObj(Person p){
        p.setPerson("Perter_changed", 19, 150.8, 5.8);  //setPerson() call occurs at the heap memory of the original object
    }

    //pass-by-value for object type parameter
    //parameter reset to another object
    public static void checkPassObj2(Person p){
        Person temp = new Person("Actor", 35, 160.9, 6.1);  //a new heap memory created
        p = temp; //temp's scope is only inside the function, if it is not returned, it will be disposed
    }
}

