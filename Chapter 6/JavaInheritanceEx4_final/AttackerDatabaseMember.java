package my.pkg;

public class AttackerDatabaseMember extends DatabaseMember implements Cloneable {
    public AttackerDatabaseMember() {
        super();
    }

    public AttackerDatabaseMember(int[] data) {
        super(data);
    }

    @Override
    public DatabaseMember clone() {
        DatabaseMember attacker = null;
        try {
            attacker = (DatabaseMember) super.clone();
        } catch (Exception e) {
            System.out.println("unable to clone");
        }
        return attacker;
    }

    /**
     * @return Deep copy of the {@code EvilTwin} object
     */
    public AttackerDatabaseMember getDeepCopy() {
        return new AttackerDatabaseMember(getData());
    }
}
