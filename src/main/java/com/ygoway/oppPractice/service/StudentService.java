package com.ygoway.oppPractice.service;

import java.util.OptionalDouble;

public interface StudentService {

    void createNewStudent(String firstName, String lastname);

    void addStudentToCourse(String id, String name);

    OptionalDouble getAVGMark(String id);

    double scholarshipCalculation(String id);

    void removeStudent(String id);
}
