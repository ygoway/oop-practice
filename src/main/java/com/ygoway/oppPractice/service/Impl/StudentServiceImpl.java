package com.ygoway.oppPractice.service.Impl;

import com.ygoway.oppPractice.dao.collections.CourseMap;
import com.ygoway.oppPractice.dao.collections.StudentMap;
import com.ygoway.oppPractice.dao.collections.StudentPerformance;
import com.ygoway.oppPractice.dao.pojo.*;
import com.ygoway.oppPractice.service.StudentService;
import com.ygoway.oppPractice.service.exception.NotFoundException;
import com.ygoway.oppPractice.service.validation.CourseValidation;
import com.ygoway.oppPractice.service.validation.StudentValidation;

import java.util.OptionalDouble;

import static com.ygoway.oppPractice.dao.pojo.Scholarship.*;

public class StudentServiceImpl implements StudentService, StudentValidation, CourseValidation {

    public static final String STUDENT_NAME_REGEX = "^[A-Z][a-zA-z ]{1,29}$";

    private StudentMap studentMap;
    private CourseMap courseMap;
    private StudentPerformance studentPerformance;

    public StudentServiceImpl() {
        this.studentMap = new StudentMap();
        this.courseMap = new CourseMap();
        this.studentPerformance = new StudentPerformance(studentMap, courseMap);
    }

    @Override
    public void createNewStudent(String firstName, String lastName) {
        if (newStudentValidation(firstName, lastName)) {
            var newStudent = new Student(firstName, lastName);
            studentMap.allStudents.put(newStudent.getId().getIntId(), newStudent);
            System.out.println(newStudent + " was successfully added");
        }
    }

    @Override
    public void addStudentToCourse(String studentId, String title) { // stack overflow, can`t see reason (is recursion?)
        if (!idValidation(studentId)) return;

        var integerFormatId = Integer.valueOf(studentId);
        Student student = studentMap.allStudents.get(integerFormatId);
        if (student == null) {
            System.out.println(new NotFoundException(studentId));
            return;
        }

        if (courseTitleValidation(title)) {
            var chosenCourse = courseMap.allCourses.get(title);
            var listOfCourses = student.getCourseList();
            if (listOfCourses.size() <= Student.MAX_STUDENT_COURSES) {
                listOfCourses.add(chosenCourse);
                var listOfStudents = chosenCourse.getStudentList();
                listOfStudents.add(student);
                System.out.println(student + " was successfully added to : " + title);
            } else System.out.println("The limit of student courses overcrowded");
        }
    }

    @Override
    public OptionalDouble getAVGMark(String studentId) {
        idValidation(studentId);
        var student = studentMap.allStudents.get(studentId);
        return studentPerformance.performanceList.stream()
                .filter(studentCourseMark -> studentCourseMark.getStudent().equals(student))
                .mapToInt(StudentCourseMark::getMark)
                .average();
    }

    @Override
    public double scholarshipCalculation(String studentId) {
        if (idValidation(studentId)) {
            double avgStudentMark = getAVGMark(studentId).getAsDouble(); // second validation
            if (AVG_MARK_TO_ENHANCED <= avgStudentMark) return ENHANCED_SCHOLARSHIP;
            else if (AVG_MARK_TO_STANDARD <= avgStudentMark) return STANDARD_SCHOLARSHIP;
            else return 0;
        } else return 0;
    }

    @Override
    public void removeStudent(String studentId) {
        if (!idValidation(studentId)) return;
        var removedStudent = studentMap.allStudents.remove(studentId);
        if (removedStudent == null) System.out.println(new NotFoundException(studentId));
        else System.out.println("The student with id : " + studentId + " was removed successfully");
    }

    @Override
    public boolean validation() {
        return false;
    }
}
