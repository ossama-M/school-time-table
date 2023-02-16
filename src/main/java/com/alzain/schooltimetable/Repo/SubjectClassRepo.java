package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.DTO.SchoolTable;
import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Model.Entity.SubjectClass;

import java.sql.Time;
import java.util.List;

public interface SubjectClassRepo {

    SubjectClass addSubjectForClass(SubjectClass subjectClass);
    SubjectClass updateSubjectForClass (SubjectClass  subjectClass) throws Exception;
    void deleteSubjectForClass(int id );
    List<Subject> getSubjectSForClass(char className, int grade, int schoolId);

    List<SchoolTable> getTableAtDayForSchool(String dayOfWeek , int schoolId);

    List<SchoolTable> getTableForSchool(int schoolId);

    List<Subject> getSubjectAtTimeForAllClassAtSchool(String dayOfWeek, String time,int schoolId);



}
