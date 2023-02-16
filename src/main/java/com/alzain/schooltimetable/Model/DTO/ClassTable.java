package com.alzain.schooltimetable.Model.DTO;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import lombok.*;

import java.sql.Time;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassTable {

    GradeWClasses gradeWClasses ;
    String Subject ;
    Time time ;
    String dayOfWeek ;
}
