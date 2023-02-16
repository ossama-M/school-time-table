package com.alzain.schooltimetable.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "subject")
public class Subject  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false, updatable = false)
    private int id ;

    @Column(name = "subject_name",unique = true,nullable = false, columnDefinition = "Text")
    private String subjectName ;

    @Column(name = "duration",length = 5 , columnDefinition = "Text")
    private String duration;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "subject_class",
//            joinColumns = @JoinColumn(name = "subject_id"),
//            inverseJoinColumns = @JoinColumn(name = "gradeWClasses_id")
//    )
//    @JsonIgnore
//    private List<GradeWClasses> gradeWClassesList;

    @JsonManagedReference
    @OneToMany(mappedBy="subject")
    @JsonIgnore
    private List<SubjectClass> subjectClasses;



}
