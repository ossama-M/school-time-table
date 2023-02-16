package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import com.alzain.schooltimetable.Repo.GradeWClassRepo;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class GradeWClassServiceImpl implements GradeWClassService{


    GradeWClassRepo gradeWClassRepo ;

    @Autowired
    public GradeWClassServiceImpl(GradeWClassRepo gradeWClassRepo) {
        this.gradeWClassRepo = gradeWClassRepo;
    }

    @Override
    @Transactional
    public GradeWClasses addClass(GradeWClasses gradeWClasses) {
        return gradeWClassRepo.addClass(gradeWClasses);
    }

    @Override
    @Transactional
    public GradeWClasses updateClass(GradeWClasses gradeWClasses) throws Exception {
        return gradeWClassRepo.updateClass(gradeWClasses);
    }

    @Override
    @Transactional
    public void deleteClass(int id) {
        gradeWClassRepo.deleteClass(id);
    }

    @Override
    @Transactional
    public List<GradeWClasses> getAllClass() {
        return gradeWClassRepo.getAllClass();
    }

    @Override
    @Transactional
    public GradeWClasses getClass(int id) {
        return gradeWClassRepo.getClass(id);
    }

    @Override
    @Transactional
    public List<GradeWClasses> getClassesForGrade(int gradeId) {
        return gradeWClassRepo.getClassesForGrade(gradeId);
    }

    @Override
    @Transactional
    public List<GradeWClasses> getClassesForSchool(int schoolId) {
        return gradeWClassRepo.getClassesForSchool(schoolId);
    }

    @Override
    @Transactional
    public List<GradeWClasses> getClassUsingTDSS(String time, String dayOfWeek, String school, String subject) {
        return gradeWClassRepo.getClassUsingTDSS(time,dayOfWeek,school,subject);
    }


}
