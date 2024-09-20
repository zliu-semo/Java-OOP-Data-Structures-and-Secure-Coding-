package my.client;

import my.pkg.*;

public class JavaInheritanceEx4_Final {

    public static void main(String[] args) {
        AttackerDatabaseMember attacker = new AttackerDatabaseMember(new int[] {150, 160, 170, 180});

        // shallow copy of evilTwin1
        DatabaseMember attackerClone = attacker.clone();

        // deep copy of evilTwin1
        DatabaseMember attackerCopy = attacker.getDeepCopy();

        System.out.println("Before updating:");
        System.out.printf("attacker %s\n", attacker.toString());
        System.out.printf("attackerClone %s\n", attackerClone.toString());
        System.out.printf("attackerCopy %s\n", attackerCopy.toString());

        // Add attackerClone and attackerCopy into the database.
        // Why not? They "look like" DatabaseMembers.

        // Unsuspecting database manager toggles the shared field.
        attackerClone.toggleShared();
        attackerClone.updateContents();
        System.out.println("\nAfter updating attackerClone:");
        System.out.printf("attacker %s\n", attacker.toString());
        System.out.printf("attackerClone %s\n", attackerClone.toString());
        System.out.printf("attackerCopy %s\n", attackerCopy.toString());

        // As the database manager expects, attackerClone does not change.

        // The attacker pulls strings from behind the scenes.
        attacker.updateContents();
        System.out.println("\nAfter updating attacker:");
        System.out.printf("attacker %s\n", attacker.toString());
        System.out.printf("attackerClone %s\n", attackerClone.toString());
        System.out.printf("attackerCopy %s\n", attackerCopy.toString());

        // Comment out all of previous code and the entire AttackerDatabaseMember class
        // to run the following:
//        DatabaseMember d = new DatabaseMember();
//        System.out.println(d.toString());
//        d = new DatabaseMember(new int[] {21, 22, 23});
//        System.out.println(d.toString());
    }

}

