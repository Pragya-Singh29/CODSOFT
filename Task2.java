import java.util.Scanner;

public class Task2 {

    public static void studentGradeCalculator(int[] marks, int subjects) {
        int totalMarks = 0;

        // Calculating the total marks of the student
        for (int i = 0; i < subjects; i++) {
            totalMarks += marks[i];
        }

        // Calculating the average percentage
        float averagePercentage = (float) totalMarks / (subjects * 100) * 100;

        // Determine grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B+";
        } else if (averagePercentage >= 60) {
            grade = "B";
        } else if (averagePercentage >= 50) {
            grade = "C+";
        } else if (averagePercentage >= 40) {
            grade = "C";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("-------------------RESULT-------------------");
        System.out.println("Total Marks: " + totalMarks + " / " + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------STUDENTS GRADE CALCULATOR-------------------");
        System.out.print("Enter the number of subjects: ");
        int subjects = sc.nextInt();

        int[] marks = new int[subjects];
        System.out.println("Enter marks in the following subjects:");
        for (int i = 0; i < subjects; i++) {
            System.out.print("Subject" + (i+1) + ":");
            marks[i] = sc.nextInt();
        }

        studentGradeCalculator(marks, subjects);
        sc.close();
    }
}
