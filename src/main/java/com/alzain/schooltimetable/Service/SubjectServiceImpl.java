package com.alzain.schooltimetable.Service;

import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Repo.SubjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepo subjectRepo ;

    @Override
    @Transactional
    public Subject addSubject(Subject subject) {
        return subjectRepo.addSubject(subject);
    }

    @Override
    @Transactional
    public Subject updateSubject(Subject subject) throws Exception {
        return subjectRepo.updateSubject(subject);
    }

    @Override
    @Transactional
    public void deleteSubject(int id) {
        subjectRepo.deleteSubject(id);
    }

    @Override
    @Transactional
    public List<Subject> getSubjects() {
        return subjectRepo.getSubjects();
    }

    @Override
    @Transactional
    public Subject getSubject(int id) {
        return subjectRepo.getSubject(id);
    }

    @Override
    public int getSubjectCountForGrad(String schoolName, String Name, int grade) {
        return subjectRepo.getSubjectCountForGrad(schoolName,Name,grade);
    }
}
