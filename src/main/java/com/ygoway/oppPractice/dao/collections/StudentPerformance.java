package com.ygoway.oppPractice.dao.collections;

import com.ygoway.oppPractice.dao.pojo.StudentCourseMark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentPerformance {

    private StudentMap studentMap;
    private CourseMap courseMap;

    public List<StudentCourseMark> performanceList;

    public StudentPerformance(StudentMap studentMap, CourseMap courseMap) {
        this.studentMap = studentMap;
        this.courseMap = courseMap;
        performanceList = new ArrayList<>(Arrays.asList(
                new StudentCourseMark(studentMap.allStudents.get(1), courseMap.allCourses.get("java advanced"), 95),
                new StudentCourseMark(studentMap.allStudents.get(1), courseMap.allCourses.get("driver"), 90),
                new StudentCourseMark(studentMap.allStudents.get(1), courseMap.allCourses.get("medical aid"), 90)
        ));
    }
}
