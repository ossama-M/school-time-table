package com.alzain.schooltimetable.Controller;

import com.alzain.schooltimetable.Model.DTO.SchoolTable;
import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Model.Entity.SubjectClass;
import com.alzain.schooltimetable.Service.SubjectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/subject-class")
public class SubjectClassController {
    SubjectClassService subjectClassService;

    @Autowired
    public SubjectClassController(SubjectClassService subjectClassService) {
        this.subjectClassService = subjectClassService;
    }



    @PostMapping()
    public ResponseEntity<SubjectClass>addSubjectForClass(@RequestBody SubjectClass subjectClass){
        SubjectClass tempSubjectForClass = subjectClassService.addSubjectForClass(subjectClass);
        return new ResponseEntity<>(tempSubjectForClass,HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectClass> upateSubjectForClass(@RequestBody SubjectClass subjectClass,@PathVariable int id ) throws Exception{
        subjectClass.setId(id);
        SubjectClass updateSubjectForClass = subjectClassService.updateSubjectForClass(subjectClass);
        return new ResponseEntity<>(updateSubjectForClass, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubjectForClass (@PathVariable("id") int id ){
        subjectClassService.deleteSubjectForClass(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/table/{dayOfWeek}/{schoolId}")
    public ResponseEntity<List<SchoolTable>> getTableForSchoolByDay(
            @PathVariable("dayOfWeek") String dayOfWeek,
            @PathVariable("schoolId") int schoolId){

        List<SchoolTable> schoolTables =  subjectClassService.getTableAtDayForSchool(dayOfWeek,schoolId);
        return new ResponseEntity<>(schoolTables, HttpStatus.OK);
    }

    @GetMapping("/table/{schoolId}")
    public ResponseEntity<List<SchoolTable>> getTableForSchool(

            @PathVariable("schoolId") int schoolId){

        List<SchoolTable> schoolTables =  subjectClassService.getTableForSchool(schoolId);
        return new ResponseEntity<>(schoolTables, HttpStatus.OK);
    }

    @GetMapping("/subject/{class}/{grade}/{schoolId}")
    public ResponseEntity<List<Subject>> getSubjectForClass(
            @PathVariable("class") String className,
            @PathVariable("grade") int grad,
            @PathVariable("schoolId") int schoolId
            ){
        char classLetter = className.toUpperCase().charAt(0);
        List<Subject> subjects =  subjectClassService.getSubjectSForClass(classLetter,grad,schoolId);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/subject-now/{dayOfWeek}/{time}/{schoolId}")
    public ResponseEntity<List<Subject>> getSubjectAtTimeForAllClassAtSchool(

            @PathVariable("dayOfWeek") String dayOfWeek,
            @PathVariable("time") String time,
            @PathVariable("schoolId") int schoolId
    ){
//
        time = time.substring(0,2)+":"+time.substring(2);

        List<Subject> subjects =  subjectClassService.getSubjectAtTimeForAllClassAtSchool(dayOfWeek,time,schoolId);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }





}
