package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.Entity.School;
import com.alzain.schooltimetable.Repo.SchoolRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    SchoolRepo schoolRepo ;

    @Override
    @Transactional
    public School addSchool(School school) {
        return schoolRepo.addSchool(school);
    }

    @Override
    @Transactional
    public School updateSchool(School school) throws Exception {
        return schoolRepo.updateSchool(school);
    }

    @Override
    @Transactional
    public void deleteSchool(int id) {
        schoolRepo.deleteSchool(id);
    }

    @Override
    @Transactional
    public List<School> getSchools() {
        return schoolRepo.getSchools();
    }

    @Override
    @Transactional
    public School getSchool(int id) {
        return schoolRepo.getSchool(id);
    }
}
