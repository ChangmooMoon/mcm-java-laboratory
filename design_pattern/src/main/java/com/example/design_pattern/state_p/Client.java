package com.example.design_pattern.state_p;

import com.example.design_pattern.state_p.context.OnlineCourse;
import com.example.design_pattern.state_p.state.Private;
import com.example.design_pattern.state_p.vo.Student;

public class Client {

    public static void main(String[] args) {
        OnlineCourse onlineCourse = new OnlineCourse();
        Student s1 = new Student("mcm");
        Student s2 = new Student("soyoon");

        s2.addPrivate(onlineCourse);

        onlineCourse.addStudent(s1);

        onlineCourse.changeState(new Private(onlineCourse));

        onlineCourse.addReview("좋은 강의였습니다", s1);

        onlineCourse.addStudent(s2);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getReviews());
        System.out.println(onlineCourse.getStudents());
    }
}
