package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class GradeWClassRepoImpl implements GradeWClassRepo{

    EntityManager entityManager ;


    @Autowired
    public GradeWClassRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public GradeWClasses addClass(GradeWClasses gradeWClasses) {
        GradeWClasses dbGradeWClasses =entityManager.merge(gradeWClasses);
        gradeWClasses.setId(dbGradeWClasses.getId());
        return dbGradeWClasses;
    }

    @Override
    public GradeWClasses updateClass(GradeWClasses gradeWClasses) throws Exception {
        if(gradeWClasses.getId() == 0)
            throw new Exception("enter ID To Update");
        GradeWClasses dbGradeWClasses = entityManager.merge(gradeWClasses);
        return dbGradeWClasses;
    }

    @Override
    public void deleteClass(int id) {
        Query query =  entityManager.createNativeQuery("delete from gradeWClasses where id = '"+id+"'");
        query.executeUpdate();

    }

    @Override
    public List<GradeWClasses> getAllClass() {
        Query query = entityManager.createNativeQuery("select id,grade,class,school_id from gradeWClasses order by school_id ASC, grade ");
        List<GradeWClasses> gradeWClassesList = query.getResultList();
        return gradeWClassesList ;
    }

    @Override
    public GradeWClasses getClass(int id) {
        return entityManager.find(GradeWClasses.class,id);
    }

    @Override
    public List<GradeWClasses> getClassesForGrade(int id) {
        Query query = entityManager.createNativeQuery("select grade, class,school_id from gradeWClasses where grade = '"+id
                +"' order by school_id ASC");
        List<GradeWClasses> gradeWClassesList = query.getResultList();
        return gradeWClassesList;
    }

    @Override
    public List<GradeWClasses> getClassesForSchool(int schoolId) {
        Query query = entityManager.createNativeQuery("select grade, class, school_id from gradeWClasses where school_id = '"
                +schoolId+"");
        List<GradeWClasses> gradeWClassesList = query.getResultList();
        return gradeWClassesList ;
    }

    @Override
    public List<GradeWClasses> getClassUsingTDSS(String time, String dayOfWeek, String school, String subject) {
        Query query = entityManager.createNativeQuery("select g.grade, g.class, g.school_id from gradeWClasses g " +
                "join subject_class sc on g.id=sc.gradeWClasses_id " +
                "join school s on g.school_id=s.id  " +
                "join subject sj on sc.subject_id = sj.id " +
                "where sc.time = '"+time+"' and sc.dayOfWeek = '"+dayOfWeek+"' " +
                "and s.school_name  = '"+school+"' and  sj.subject_name = '"+subject+"' ");

        List<GradeWClasses> gradeWClassRepoList = query.getResultList();
        return gradeWClassRepoList;


    }
}
