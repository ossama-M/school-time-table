package com.alzain.schooltimetable.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.sql.Time;


/**
 * The persistent class for the subject_class database table.
 *
 */
@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subject_class")
@NamedQuery(name="SubjectClass.findAll", query="SELECT s FROM SubjectClass s")
public class SubjectClass implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private int id;

    @Column(name="day_of_week", nullable=false, length=11)
    private String dayOfWeek;

    @Column(nullable=false)
    private Time time;

    //bi-directional many-to-one association to Gradewclass
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="gradeWClasses_id", nullable=false)
    @JsonIgnore
    private GradeWClasses gradeWClasses;

    //bi-directional many-to-one association to Subject
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="subject_id", nullable=false)
    @JsonIgnore
    private Subject subject;



}
