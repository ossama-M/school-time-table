package com.alzain.schooltimetable.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "gradeWClasses")
@NamedQuery(name="Gradewclass.findAll", query="SELECT g FROM GradeWClasses g")
public class GradeWClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false, updatable = false)
    private int id ;

    @Column(name = "grade",nullable = false,columnDefinition = "TEXT")
    private int  grade ;

    @Column(name = "class",nullable = false,columnDefinition = "CHAR",length = 1)
    private char classes ;

    @JsonBackReference
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="school_id" ,insertable=false, updatable=false, nullable = false)
    @JsonIgnore
    private School school ;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "subject_class",
//            joinColumns = @JoinColumn(name = "gradeWClasses_id"),
//            inverseJoinColumns = @JoinColumn(name = "subject_id")
//    )
//    private List<Subject> subjectList ;

    @Column(name ="school_id")
    private int schoolId;

    @JsonManagedReference
    @OneToMany(mappedBy="gradeWClasses")
    @JsonIgnore
    private List<SubjectClass> subjectClasses;

}
