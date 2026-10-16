/* ==========================================================
 * Project: Main File (DCST NIRF Data Management System)
 * Roll No. 2608
 * Author: Amlisha Cardoso
 * Date: October 14, 2026
 * Description: The entry point for the DCST (Discipline of Computer Science
 * and Technology), Goa Business School, Goa University NIRF reporting system.
 * This class creates objects for the main entities of the system, including
 * Member (students, teaching and non-teaching staff), DCSTCoordinator,
 * Activity (Academic and Non-Academic), Course, and the report, address
 * and record classes that support them.
 * Key Operations Handled:
 * - Member initialization (capturing student, teaching staff and non-teaching
 *   staff details, with a static counter tracking total members created)
 * - Activity management covering academic activities (ISA, Midpoint, SEA,
 *   study tour, placements) and non-academic activities (InfoFest,
 *   Plateaunia, Play-On)
 * - Course and programme catalogue handling using List, Queue, Set and Map
 * - Report generation through interfaces (Displayable, Reportable), with
 *   method overloading and overriding for different report types
 * - Validation of activities using custom exception handling
 * - Record keeping through file I/O, object serialization and cloning
 *   (shallow and deep), plus reflection (RTTI) to inspect class details
 * ========================================================== */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // Message passing: accepts any object implementing Displayable
    public static void showAny(Displayable item) {
        item.display();
    }

    public static void main(String[] args) {

        System.out.println("DCST - GOA UNIVERSITY");
        System.out.println("NIRF REPORT: CST DISCIPLINE");
        System.out.println("==========================");

        // OBJECTS, CONSTRUCTORS, AND OBJECT REFERENCES
        Member m1 = new Member(
                101, "Rohan Naik", "Student", "CST");
        Member m2 = new Member(
                102, "Dr. Anjali Kamat", "Teaching Staff", "CST");
        Member m3 = new Member(
                103, "Priya Gaonkar", "Non-Teaching Staff", "CST");

        m1.display();
        m2.display();
        m3.display();

        System.out.println("\n===== OBJECT REFERENCING =====");
        Member reference = m1;
        Member anotherReference = reference;

        System.out.println("Same object: " + (m1 == anotherReference));
        anotherReference.name = "Rohan S. Naik";
        System.out.println("After changing the shared reference:");
        m1.display();
        Member.displayMemberCount();

        // ENUMS
        System.out.println("\n===== ENUMS =====");
        for (ActivityType type : ActivityType.values()) {
            System.out.println("Activity type: " + type);
        }
        for (Department department : Department.values()) {
            System.out.println("Department: " + department);
        }

        // ACCESS MODIFIERS
        System.out.println("\n===== ACCESS MODIFIERS =====");
        AccessDemo access = new AccessDemo();
        access.showInsideClass();
        System.out.println("Outside public: " + access.publicData);
        System.out.println("Private using getter: " + access.getPrivateData());

        AccessChild child = new AccessChild();
        child.showInheritedData();

        // ABSTRACT CLASS AND OVERRIDING
        System.out.println("\n===== ABSTRACT CLASS =====");
        Activity a1 = new AcademicActivity("Mid-point Review");
        Activity a2 = new NonAcademicActivity("InfoFest");
        a1.showDetails();
        a2.showDetails();

        // MULTIPLE INTERFACES
        System.out.println("\n===== MULTIPLE INTERFACES =====");
        DCSTCoordinator coordinator =
                new DCSTCoordinator("Dr. Suresh Fernandes", "CST");
        coordinator.display();
        System.out.println(coordinator.generateReport());

        // MESSAGE PASSING THROUGH AN INTERFACE
        System.out.println("\n===== MESSAGE PASSING =====");
        showAny(m1);
        showAny(coordinator);

        // METHOD OVERLOADING
        System.out.println("\n===== METHOD OVERLOADING =====");
        ReportPrinter printer = new ReportPrinter();
        printer.printReport("DCST Annual Report");
        printer.printReport("Department", "Computer Science and Technology");
        printer.printReport(2026);

        // METHOD OVERRIDING
        System.out.println("\n===== METHOD OVERRIDING =====");
        ActivityReport report = new AcademicReport();
        report.showReport();

        // GENERICS
        System.out.println("\n===== GENERICS =====");
        Box<String> nameBox = new Box<>();
        nameBox.setValue("M.Sc. CST Student");
        System.out.println("Box value: " + nameBox.getValue());

        Box<Integer> numberBox = new Box<>();
        numberBox.setValue(2025);
        System.out.println("Box value: " + numberBox.getValue());

        GenericUtility.displayValue("Goa University");
        GenericUtility.displayValue(2026);

        // COLLECTIONS
        System.out.println("\n===== JAVA COLLECTIONS =====");

        List<String> courses = new ArrayList<>();
        courses.add("Data Structures and Algorithms");
        courses.add("Object Oriented Programming");
        courses.add("Database Management Systems");
        courses.add("Computer Networks");
        System.out.println("List of Courses: " + courses);

        Queue<String> activities = new LinkedList<>();
        activities.offer("Mid-point Review");
        activities.offer("Study Tour");
        activities.offer("Campus Placement Drive");
        System.out.println("Queue: " + activities);
        System.out.println("Next Activity: " + activities.poll());

        Set<String> programmes = new HashSet<>();
        programmes.add("M.Sc. CST");
        programmes.add("Ph.D. CST");
        programmes.add("M.Sc. CST");
        System.out.println("Programmes (unique values): " + programmes);

        Map<Integer, String> members = new HashMap<>();
        members.put(101, "Rohan Naik");
        members.put(102, "Dr. Anjali Kamat");
        members.put(103, "Priya Gaonkar");
        System.out.println("Members: " + members);

        // EXCEPTION HANDLING
        System.out.println("\n===== EXCEPTION HANDLING =====");
        try {
            ActivityValidator.validateActivity("Mid-point Review");
            ActivityValidator.validateActivity("");
        } catch (InvalidActivityException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Activity validation completed.");
        }

        // SHALLOW AND DEEP CLONING
        System.out.println("\n===== OBJECT CLONING =====");
        StudentClone original =
                new StudentClone("Rohan Naik", new Address("Ponda"));
        StudentClone shallow = original.clone();
        StudentClone deep = original.deepClone();

        original.address.city = "Margao";
        System.out.println("Original city: " + original.address.city);
        System.out.println("Shallow copy city: " + shallow.address.city);
        System.out.println("Deep copy city: " + deep.address.city);

        // FILE INPUT/OUTPUT
        System.out.println("\n===== FILE INPUT/OUTPUT =====");
        try {
            String fileReport = "DCST - Goa University\n"
                    + "Academic Activity: Mid-point Review\n"
                    + "Non-Academic Activity: InfoFest";
            FileHandler.writeToFile("dcst_report.txt", fileReport);
            System.out.println("Report saved to dcst_report.txt:");
            FileHandler.readFromFile("dcst_report.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        // SERIALIZATION AND DESERIALIZATION
        System.out.println("\n===== SERIALIZATION =====");
        MemberRecord savedMember =
                new MemberRecord(101, "Rohan Naik", "CST");

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("dcst_member.ser"))) {
            out.writeObject(savedMember);
            System.out.println("Member object saved successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        System.out.println("\n===== DESERIALIZATION =====");
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("dcst_member.ser"))) {
            MemberRecord restoredMember = (MemberRecord) in.readObject();
            System.out.println("Restored member: " + restoredMember);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }

        // REFLECTION / RTTI
        System.out.println("\n===== REFLECTION / RTTI =====");
        ReflectionDemo.showClassDetails(m1);

        // CONSOLE INPUT
        System.out.println("\n===== CONSOLE INPUT =====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String enteredName = scanner.nextLine();
        System.out.println("Welcome, " + enteredName
                + "! Your department is DCST.");
        scanner.close();
    }
}