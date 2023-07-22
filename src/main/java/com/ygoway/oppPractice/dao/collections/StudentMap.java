package com.ygoway.oppPractice.dao.collections;

import com.ygoway.oppPractice.dao.pojo.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {

    public Map<Integer, Student> allStudents;

    public StudentMap() {
        allStudents = new HashMap<>();
        allStudents.put(1, new Student("Bobby", "Fisher"));
        allStudents.put(2, new Student("Ivan", "Gayway"));
        allStudents.put(3, new Student("Andriy", "Goddamn"));
        allStudents.put(4, new Student("Karl", "Messy"));
    }

}
