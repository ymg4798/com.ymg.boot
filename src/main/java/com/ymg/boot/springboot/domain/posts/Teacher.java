package com.ymg.boot.springboot.domain.posts;

import lombok.*;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teacher {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String subject;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)//상위 엔터티에서 하위 엔터티로 모든 작업을 전파
    private List<Student> students = new ArrayList<>();

    @Builder
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void addStudent(Student student){
        students.add(student);
        student.setTeacher(this);
    }
}


