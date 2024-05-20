import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                numStudents = scanner.nextInt();
                if (numStudents <= 0) {
                    System.out.println("Please enter a positive number of students.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer for the number of students.");
                scanner.next(); 
            }
        }

        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            boolean validGrade = false;
            while (!validGrade) {
                try {
                    System.out.print("Enter the grade for student " + (i + 1) + ": ");
                    int grade = scanner.nextInt();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Please enter a valid grade between 0 and 100.");
                    } else {
                        grades[i] = grade;
                        validGrade = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid integer for the grade.");
                    scanner.next(); 
                }
            }
        }

        int sum = Arrays.stream(grades).sum();
        double average = (double) sum / numStudents;
        int highest = Arrays.stream(grades).max().getAsInt();
        int lowest = Arrays.stream(grades).min().getAsInt();

        System.out.println("Average grade obtained : " + average);
        System.out.println("Highest grade obtained: " + highest);
        System.out.println("Lowest grade obtained: " + lowest);
        System.out.println("All grades obtained: " + Arrays.toString(grades));

        scanner.close();
    }
}