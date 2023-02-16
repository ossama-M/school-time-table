package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.Entity.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class SchoolRepoImpl implements SchoolRepo{

    EntityManager entityManager ;

    @Autowired
    public SchoolRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public School addSchool(School school) {
        School dbSchool =entityManager.merge(school);
        school.setId(dbSchool.getId());
        return dbSchool ;
    }

    @Override
    public School updateSchool(School school) throws Exception {
        if(school.getId() == 0)
            throw new Exception("enter ID To Update");
        School dbSchool = entityManager.merge(school);
        return dbSchool;
    }

    @Override
    public void deleteSchool(int id) {
        Query query =  entityManager.createNativeQuery("delete from school where id = '"+id+"'");
        query.executeUpdate();

    }

    @Override
    public List<School> getSchools() {
        Query query = entityManager.createNativeQuery("select id,school_name,Location from school ");
        List<School> schools = query.getResultList();
        return schools ;
    }

    @Override
    public School getSchool(int id) {
        return entityManager.find(School.class,id);
    }
}
