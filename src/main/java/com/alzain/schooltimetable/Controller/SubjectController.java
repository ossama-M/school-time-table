package com.alzain.schooltimetable.Controller;

import com.alzain.schooltimetable.Exception.ErrorModel;
import com.alzain.schooltimetable.Model.Entity.Subject;
import com.alzain.schooltimetable.Service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping()
    public ResponseEntity<List<Subject>> getAllSubject(){
        List<Subject> subjects = subjectService.getSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubject(@PathVariable("id") int id){
        Subject subject =  subjectService.getSubject(id);
        return new ResponseEntity<>(subject,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Subject>saveSubject(@RequestBody Subject subject){
        Subject tempSubject = subjectService.addSubject(subject);
        return new ResponseEntity<>(tempSubject,HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject,@PathVariable int id ) throws Exception{
        subject.setId(id);
        Subject tempSubject = subjectService.updateSubject(subject);
        return new ResponseEntity<>(tempSubject, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject (@PathVariable("id") int id ){
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/countSubject/{schoolName}/{subjectName}/{grade}")
    @ResponseStatus(HttpStatus.OK)
    public int getSubjectsCountForGrade(
            @PathVariable("schoolName") String schoolName,
            @PathVariable("subjectName") String subjectName,
            @PathVariable("grade") int grade
            ){
        log.info("Inside getSubjectsCountForGrade ");
        return  subjectService.getSubjectCountForGrad(schoolName,subjectName,grade);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorModel> handleExcption(RuntimeException ex){
        ErrorModel error = new ErrorModel().builder()
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    }



}
