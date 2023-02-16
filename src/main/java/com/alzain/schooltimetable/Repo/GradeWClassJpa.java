package com.alzain.schooltimetable.Repo;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
@Profile("demoOnlyNotUsed")
public interface GradeWClassJpa extends JpaRepository<GradeWClasses,Integer> {
}
