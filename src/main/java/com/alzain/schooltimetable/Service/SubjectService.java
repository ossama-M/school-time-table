package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.Entity.Subject;

import java.util.List;

public interface SubjectService {

    Subject addSubject(Subject subject);
    Subject updateSubject(Subject subject) throws Exception;
    void deleteSubject(int id );
    List<Subject> getSubjects();
    Subject getSubject(int id );
    int getSubjectCountForGrad(String schoolName, String Name, int grade);

}
