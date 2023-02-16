package com.alzain.schooltimetable.Model.DTO;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import lombok.*;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SchoolTable {
    List<GradeWClasses> gradeWClasses ;
    String Subject ;
    Time time ;
    String dayOfWeek ;
}
