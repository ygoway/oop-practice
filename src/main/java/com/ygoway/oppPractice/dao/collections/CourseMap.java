package com.ygoway.oppPractice.dao.collections;

import com.ygoway.oppPractice.dao.pojo.Course;

import java.math.BigDecimal;
import java.util.*;

public class CourseMap implements Cloneable{

    public Map<String, Course> allCourses;

    public CourseMap() {
        allCourses = new HashMap<>(Map.of(
                "Java advanced", new Course ("Java advanced", BigDecimal.valueOf(20000)),
                "Medical aid", new Course("Medical aid", BigDecimal.valueOf(13000)),
                "Machine`s engineer", new Course("Machine`s engineer", BigDecimal.valueOf(18000)),
                "Fullstack dev", new Course("Fullstack dev", BigDecimal.valueOf(25500)),
                "Driver", new Course("Driver", BigDecimal.valueOf(13500))
        ));
    }
}