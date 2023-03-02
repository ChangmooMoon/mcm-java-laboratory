package com.example.design_pattern.state_p.state;

import com.example.design_pattern.state_p.context.OnlineCourse;
import com.example.design_pattern.state_p.vo.Student;

public class Published implements State {

    private OnlineCourse onlineCourse;

    public Published(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    @Override
    public void addReview(String review, Student student) {
        this.onlineCourse.getReviews().add(review);
    }

    @Override
    public void addStudent(Student student) {
        this.onlineCourse.getStudents().add(student);
    }
}
