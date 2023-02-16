package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.Entity.School;

import java.util.List;

public interface SchoolService {
    School addSchool(School school);
    School updateSchool(School school) throws Exception;
    void deleteSchool(int id );
    List<School> getSchools();
    School getSchool(int id );
}
