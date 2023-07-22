package com.ygoway.oppPractice.input;

import com.ygoway.oppPractice.service.Impl.StudentServiceImpl;
import com.ygoway.oppPractice.service.StudentService;
import com.ygoway.oppPractice.service.validation.CourseValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientStudentInput {

    private Scanner scanner;
    private StudentService studentService;
    /*private CourseValidation courseValidation;*/

    public ClientStudentInput(Scanner menuScanner) {
        this.scanner = menuScanner;
        this.studentService = new StudentServiceImpl();
        /*this.courseValidation = new CourseValidation() {
            @Override
            public boolean validation() {
                return false;
            }
        };*/
    }

    public void createNewStudentWithInput() {
        System.out.println("Enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("Enter lastname");
        String lastName = scanner.nextLine();

        studentService.createNewStudent(firstName, lastName);
    }

    public void addStudentToCourseWithInput() {
        /*var studentId = inputAndReturnStudentId();
        var title = inputAndReturnCourseTitle();

        if(courseValidation.courseTitleValidation(title)) {
            studentService.addStudentToCourse(studentId, title);
        }
        else System.out.println("Invalid course title. Please try again.");*/
        studentService.addStudentToCourse(inputAndReturnStudentId(), inputAndReturnCourseTitle());
    }

    public void getAVGMarkWithInput() {
        System.out.println(studentService.getAVGMark(inputAndReturnStudentId()));
    }

    public void calculateScholarshipWithInput() {
        System.out.println(studentService.scholarshipCalculation(inputAndReturnStudentId()));
    }

    public void removeStudentWithInput() {
        studentService.removeStudent(inputAndReturnStudentId());
    }

    private String inputAndReturnStudentId() {
        System.out.println("Enter the student id");
        return scanner.nextLine();
    }

    /*private Integer inputAndReturnStudentId() {
        System.out.println("Enter student id");
        Integer id = 0;
        try {
            id = scanner.nextInt();
            scanner.nextLine();
            return id;
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Your input data must be in integer numeric format");
            scanner.nextLine();
            return id;
        }
    }*/

    private String inputAndReturnCourseTitle() {
        System.out.println("Enter course title");
        return scanner.nextLine();
    }
}
