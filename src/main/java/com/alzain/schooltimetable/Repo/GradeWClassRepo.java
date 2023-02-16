package com.alzain.schooltimetable.Repo;


import com.alzain.schooltimetable.Model.Entity.GradeWClasses;

import java.util.List;

public interface GradeWClassRepo {

    GradeWClasses addClass(GradeWClasses gradeWClasses);
    GradeWClasses updateClass(GradeWClasses gradeWClasses) throws Exception;
    void deleteClass(int id );
    List<GradeWClasses> getAllClass();
    GradeWClasses getClass(int id );
    List<GradeWClasses> getClassesForGrade(int id );
    List<GradeWClasses> getClassesForSchool(int id );
    public List<GradeWClasses> getClassUsingTDSS(String time, String dayOfWeek, String school, String subject);

}
