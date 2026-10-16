public class DCSTCoordinator implements Displayable, Reportable {

    private String coordinatorName;
    private String department;

    public DCSTCoordinator(String coordinatorName, String department) {
        this.coordinatorName = coordinatorName;
        this.department = department;
    }

    @Override
    public void display() {
        System.out.println("Coordinator: " + coordinatorName);
        System.out.println("Department: " + department);
    }

    @Override
    public String generateReport() {
        return "Coordinator: " + coordinatorName
                + ", Department: " + department;
    }
}
