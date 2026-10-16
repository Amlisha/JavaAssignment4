
public class Member implements Displayable , Reportable {
    private int id;
    String name;
    String role;
    String department;

    static int memberCount = 0;

    public Member(int id, String name, String role,
                  String department) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        memberCount++;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Department: " + department);
        System.out.println("--------------------");
    }

    public static void displayMemberCount() {
        System.out.println("Total Members: " + memberCount);
    }

    public int getId() {
        return id;
    }
    @Override
public String generateReport() {
    return "Member: " + name
            + ", Role: " + role
            + ", Department: " + department;
}
}

