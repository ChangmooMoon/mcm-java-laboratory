package com.example.design_pattern.state_p.context;

import com.example.design_pattern.state_p.state.Draft;
import com.example.design_pattern.state_p.state.State;
import com.example.design_pattern.state_p.vo.Student;
import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {

    private State state = new Draft(this);

    private List<Student> students = new ArrayList<>();

    private List<String> reviews = new ArrayList<>();

    public void addStudent(Student student) {
        this.state.addStudent(student);
    }

    public void addReview(String review, Student student) {
        this.state.addReview(review, student);
    }

    public String getState() {
        return state.getClass().getSimpleName();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void changeState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
            "state=" + state +
            ", students=" + students +
            ", reviews=" + reviews +
            '}';
    }
}
