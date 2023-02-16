package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.Entity.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

@Slf4j
public class SubjectRepoImpl implements SubjectRepo{

    EntityManager entityManager ;

    @Autowired
    public SubjectRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Subject addSubject(Subject subject) {
        Subject dbSubject =entityManager.merge(subject);
        subject.setId(dbSubject.getId());
        return dbSubject ;
    }

    @Override
    public Subject updateSubject(Subject subject) throws Exception {
        if(subject.getId() == 0)
            throw new Exception("enter ID To Update");
        Subject dbSubject = entityManager.merge(subject);
        return dbSubject;
    }

    @Override
    public void deleteSubject(int id) {
        Query query =  entityManager.createNativeQuery("delete from subject where id = '"+id+"'");
        query.executeUpdate();
    }

    @Override
    public List<Subject> getSubjects() {
        Query query = entityManager.createNativeQuery("select id,subject_name,duration from subject ");
        List<Subject> subjects = query.getResultList();
        return subjects ;
    }

    @Override
    public Subject getSubject(int id) {
        return entityManager.find(Subject.class,id);
    }

    @Override
    public int getSubjectCountForGrad(String schoolName ,String subjectName, int grade) {

        log.info(schoolName);
        log.info(subjectName);
        log.info(String.valueOf(grade));

        Query query = entityManager.createNativeQuery("select count(sc.subject_id) from subject_class sc " +
                "                join subject s on s.id  = sc.subject_id " +
                "               where sc.gradeWClasses_id " +
                "                in (select gc.id from gradewclasses gc " +
                "                join school sch on gc.school_id= sch.id  where " +
                "                gc.grade = '"+grade+"' and sch.school_name = '"+schoolName+"')" +
                "                  and s.subject_name  = '"+subjectName+"'");

        int count  = ((Number) query.getSingleResult()).intValue();
        System.out.println(count);
        return count;

    }
}
