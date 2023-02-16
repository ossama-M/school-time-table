package com.alzain.schooltimetable.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "School")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,nullable = false,updatable = false)
    private int id  ;

    @Column(name = "school_name", unique = true,nullable = false,columnDefinition = "TEXT")
    private String schoolName ;

    @Column(name = "Location",nullable = true,columnDefinition = "TEXT")
    private String location ;

    @JsonManagedReference
    @OneToMany(mappedBy="school")
    @JsonIgnore
    private List<GradeWClasses> gradeWClassesList ;


    public void addClasses(GradeWClasses tempGradeWClasses){
        if (gradeWClassesList ==null)
            gradeWClassesList = new ArrayList<>();
        gradeWClassesList.add(tempGradeWClasses);
    }


}
