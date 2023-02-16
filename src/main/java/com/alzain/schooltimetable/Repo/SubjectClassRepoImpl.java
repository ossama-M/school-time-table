package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.DTO.SchoolTable;
import com.alzain.schooltimetable.Model.Entity.School;
import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Model.Entity.SubjectClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public class SubjectClassRepoImpl implements SubjectClassRepo{

    EntityManager entityManager ;

    @Autowired
    public SubjectClassRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SubjectClass addSubjectForClass(SubjectClass subjectClass) {
        SubjectClass dbSubjectClass =entityManager.merge(subjectClass);
        subjectClass.setId(dbSubjectClass.getId());
        return dbSubjectClass ;
    }

    @Override
    public SubjectClass updateSubjectForClass(SubjectClass subjectClass) throws Exception {
        if(subjectClass.getId() == 0)
            throw new Exception("enter ID To Update");
        SubjectClass dbSubjectClass = entityManager.merge(subjectClass);
        return dbSubjectClass;

    }

    @Override
    public void deleteSubjectForClass(int id) {
        Query query =  entityManager.createNativeQuery("delete from subject_class where id = '"+id+"'");
        query.executeUpdate();
    }

    @Override
    public List<SchoolTable> getTableAtDayForSchool(String dayOfWeek, int schoolId) {
        Query query = entityManager.createNativeQuery("select gc.school_id,gc.grade,gc.class," +
                "s.subject_name ,sc.time,sc.day_of_week " +
                "from gradewclasses gc " +
                "join subject_class sc on gc.id = sc.gradeWClasses_id " +
                "join subject s on s.id = sc.subject_id " +
                "where sc.day_of_week = '"+dayOfWeek+"' and school_id = '"+schoolId+"'");
        List<SchoolTable> schoolTables =  query.getResultList();


        return schoolTables;
    }

    @Override
    public List<SchoolTable> getTableForSchool(int schoolId) {
        Query query = entityManager.createNativeQuery("select gc.school_id,gc.grade,gc.class," +
                "s.subject_name ,sc.time,sc.day_of_week " +
                "from gradewclasses gc " +
                "join subject_class sc on gc.id = sc.gradeWClasses_id " +
                "join subject s on s.id = sc.subject_id " +
                "where school_id = '"+schoolId+"'");
        List<SchoolTable> schoolTables =  query.getResultList();

        return schoolTables;
    }

    @Override
    public List<Subject> getSubjectAtTimeForAllClassAtSchool(String dayOfWeek, String time, int schoolId) {
        Query query = entityManager.createNativeQuery("select s.id , s.subject_name, s.duration from subject s" +
                " join subject_class sc on s.id = sc.subject_id " +
                " join gradewclasses gc on gc.id  = sc.gradeWClasses_id " +
                " where sc.time = '"+time+"' and sc.day_of_week = '"+dayOfWeek+"' " +
                " and school_id = '"+schoolId+"'");
        List<Subject> subjects = query.getResultList();
        return subjects ;
    }

    @Override
    public List<Subject> getSubjectSForClass(char className, int grade, int schoolId) {
        Query query = entityManager.createNativeQuery("select s.id , s.subject_name, s.duration from subject s " +
                " join subject_class sc on s.id = sc.subject_id " +
                " join gradewclasses gc on gc.id  = sc.gradeWClasses_id " +
                " where gc.grade = '"+grade+"' and gc.class = '"+className+"' " +
                " and school_id = '"+schoolId+"'");
         List<Subject> subjects = query.getResultList();
        return subjects ;
    }




}
