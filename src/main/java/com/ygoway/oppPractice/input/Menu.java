package com.ygoway.oppPractice.input;

import java.util.Scanner;

public class Menu {

    public static void studentMenu() {
        Scanner scanner = new Scanner(System.in);
        ClientStudentInput clientInput = new ClientStudentInput(scanner);
        while (true) {
            System.out.println("____________________________________");
            System.out.println("Hello, enter the numeric for info");
            System.out.println("1 Create new student");
            System.out.println("2 To add student to course");
            System.out.println("3 View average mark");
            System.out.println("4 Calculate scholarship");
            System.out.println("5 To delete user");
            System.out.println("0 Exit");
            System.out.println("____________________________________");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch(menu) {
                case 1: clientInput.createNewStudentWithInput();
                    break;
                case 2: clientInput.addStudentToCourseWithInput();
                    break;
                case 3: clientInput.getAVGMarkWithInput();
                    break;
                case 4: clientInput.calculateScholarshipWithInput();
                    break;
                case 5: clientInput.removeStudentWithInput();
                    break;
                case 0:
                    System.out.println("bye");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Wrong number, try again!");
            }
        }
    }
}
