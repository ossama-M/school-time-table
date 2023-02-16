package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.Entity.School;


import java.util.List;

public interface SchoolRepo {

    School addSchool(School school);
    School updateSchool(School school) throws Exception;
    void deleteSchool(int id );
    List<School> getSchools();
    School getSchool(int id );
}
