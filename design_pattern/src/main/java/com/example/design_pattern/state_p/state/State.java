package com.example.design_pattern.state_p.state;

import com.example.design_pattern.state_p.vo.Student;

public interface State {

    void addReview(String review, Student student);

    void addStudent(Student student);
}
