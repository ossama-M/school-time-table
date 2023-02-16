package com.alzain.schooltimetable.Controller;


import com.alzain.schooltimetable.Model.Entity.School;
import com.alzain.schooltimetable.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping()
    public ResponseEntity<List<School>> getAllSubject(){
        List<School> schools = schoolService.getSchools();
        return new ResponseEntity<>(schools, HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchool(@PathVariable("id") int id){
        School school =  schoolService.getSchool(id);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<School>saveSchool(@RequestBody School school){
        School tempSchool = schoolService.addSchool(school);
        return new ResponseEntity<>(tempSchool,HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@RequestBody School school,@PathVariable int id ) throws Exception{
        school.setId(id);
        School updateSchool = schoolService.updateSchool(school);
        return new ResponseEntity<>(updateSchool, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchool (@PathVariable("id") int id ){
        schoolService.deleteSchool(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
