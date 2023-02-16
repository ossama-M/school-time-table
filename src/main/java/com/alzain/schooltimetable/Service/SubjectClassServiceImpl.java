package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.DTO.SchoolTable;
import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Model.Entity.SubjectClass;
import com.alzain.schooltimetable.Repo.SubjectClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class SubjectClassServiceImpl implements SubjectClassService{

    @Autowired
    SubjectClassRepo subjectClassRepo ;


    @Override
    public SubjectClass addSubjectForClass(SubjectClass subjectClass) {
        return subjectClassRepo.addSubjectForClass(subjectClass);
    }

    @Override
    public SubjectClass updateSubjectForClass(SubjectClass subjectClass) throws Exception {
        return subjectClassRepo.updateSubjectForClass(subjectClass);
    }

    @Override
    public void deleteSubjectForClass(int id) {
        subjectClassRepo.deleteSubjectForClass(id);
    }

    @Override
    public List<Subject> getSubjectSForClass(char className, int grade , int schoolId) {
        return subjectClassRepo.getSubjectSForClass(className,grade,schoolId);
    }


    @Override
    public List<SchoolTable> getTableAtDayForSchool(String dayOfWeek, int schoolId) {
        return subjectClassRepo.getTableAtDayForSchool(dayOfWeek,schoolId);
    }

    @Override
    public List<SchoolTable> getTableForSchool(int schoolId) {
        return subjectClassRepo.getTableForSchool(schoolId);
    }

    @Override
    public List<Subject> getSubjectAtTimeForAllClassAtSchool(String dayOfWeek, String time, int schoolId) {
        return subjectClassRepo.getSubjectAtTimeForAllClassAtSchool(dayOfWeek,time,schoolId);    }
}
