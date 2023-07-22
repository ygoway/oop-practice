package com.ygoway.oppPractice.dao.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private String title;
    private BigDecimal price;
    private List<Student> studentList;

    public Course() {
    }

    public Course(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
        studentList = new ArrayList<>();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!Objects.equals(title, course.title)) return false;
        if (!Objects.equals(price, course.price)) return false;
        return Objects.equals(studentList, course.studentList);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (studentList != null ? studentList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", studentList=" + studentList +
                '}';
    }
}
