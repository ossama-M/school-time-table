package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import com.alzain.schooltimetable.Repo.GradeWClassRepo;

import java.util.List;

public interface GradeWClassService {

    GradeWClasses addClass(GradeWClasses gradeWClasses);
    GradeWClasses updateClass(GradeWClasses gradeWClasses) throws Exception;
    void deleteClass(int id );
    List<GradeWClasses> getAllClass();
    GradeWClasses getClass(int id );
    List<GradeWClasses> getClassesForGrade(int gradeId );
    List<GradeWClasses> getClassesForSchool(int schoolId );

    public List<GradeWClasses> getClassUsingTDSS(String time, String dayOfWeek, String school, String subject);
}
