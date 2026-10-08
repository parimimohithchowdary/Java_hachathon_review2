import java.util.Scanner;

class StudentDetails {
    String studentName, courseName;
    int rollNumber, courseCredits;
    double marks;

    StudentDetails(String name, int roll, double marks,
                   String course, int credits) {
        studentName = name;
        rollNumber = roll;
        this.marks = marks;
        courseName = course;
        courseCredits = credits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    double calculateScholarship() {
        if (marks >= 85)
            return calculateFee() * 0.20;
        else if (marks >= 70)
            return calculateFee() * 0.10;
        else
            return 0;
    }

    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    void displayDetails() {
        System.out.println("\n--- Student Course Details ---");
        System.out.println("Student Name  : " + studentName);
        System.out.println("Roll Number   : " + rollNumber);
        System.out.println("Marks         : " + marks);
        System.out.println("Course Name   : " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility   : Eligible");
        System.out.println("Total Fee     : Rs. " + calculateFee());
        System.out.println("Scholarship   : Rs. " + calculateScholarship());
        System.out.println("Final Fee     : Rs. " + calculateFinalFee());
    }
}

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        StudentDetails s =
            new StudentDetails(name, roll, marks, course, credits);

        if (s.checkEligibility())
            s.displayDetails();
        else
            System.out.println("\nStudent is not eligible for registration.");

        sc.close();
    }
}