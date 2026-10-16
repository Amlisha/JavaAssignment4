import java.io.Serializable;

public class MemberRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    int memberId;
    String name;
    String department;

    public MemberRecord(int memberId, String name, String department) {
        this.memberId = memberId;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "ID: " + memberId
                + ", Name: " + name
                + ", Department: " + department;
    }
    
}
