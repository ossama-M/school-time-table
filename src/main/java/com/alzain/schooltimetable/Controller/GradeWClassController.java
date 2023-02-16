package com.alzain.schooltimetable.Controller;

import com.alzain.schooltimetable.Model.Entity.GradeWClasses;
import com.alzain.schooltimetable.Service.GradeWClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradeWclass")

public class GradeWClassController {

    GradeWClassService gradeWClassService ;

    @Autowired
    public GradeWClassController(GradeWClassService gradeWClassService) {
        this.gradeWClassService = gradeWClassService;
    }

    @GetMapping()
    public ResponseEntity<List<GradeWClasses>> getAllGradeWClass(){
        List<GradeWClasses> GradeWClasses = gradeWClassService.getAllClass();
        return new ResponseEntity<>(GradeWClasses, HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeWClasses> getClass(@PathVariable("id") int id){
        GradeWClasses gradeWClasses =  gradeWClassService.getClass(id);
        return new ResponseEntity<>(gradeWClasses, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<GradeWClasses>saveGradeWClass(@RequestBody GradeWClasses gradeWClasses){
        GradeWClasses tempGradeWClasses = gradeWClassService.addClass(gradeWClasses);
        return new ResponseEntity<>(tempGradeWClasses,HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeWClasses> updateGradeWClass(@RequestBody GradeWClasses gradeWClasses,@PathVariable int id ) throws Exception{
        gradeWClasses.setId(id);
        GradeWClasses updateClass = gradeWClassService.updateClass(gradeWClasses);
        return new ResponseEntity<>(updateClass, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGradeWClass (@PathVariable("id") int id ){
        gradeWClassService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/classes-grade/{id}")
    public ResponseEntity<List<GradeWClasses>> getClassForGrade(@PathVariable("id") int id){
        List<GradeWClasses> gradeWClasses =  gradeWClassService.getClassesForGrade(id);
        return new ResponseEntity<>(gradeWClasses, HttpStatus.OK);
    }

    @GetMapping("/classes-school/{id}")
    public ResponseEntity<List<GradeWClasses>> getClassForSchool(@PathVariable("id") int id){
        List<GradeWClasses> gradeWClasses =  gradeWClassService.getClassesForSchool(id);
        return new ResponseEntity<>(gradeWClasses, HttpStatus.OK);
    }


    @GetMapping("/{time}/{dayOfWeek}/{school}/{subject}")
    @ResponseStatus(HttpStatus.OK)
    public List<GradeWClasses> getCustomClass(
            @PathVariable("time") String time,
            @PathVariable("dayOfWeek") String dayOfWeek,
            @PathVariable("school") String school,
            @PathVariable("subject") String subject){

        List<GradeWClasses> gradeWClasses = gradeWClassService.getClassUsingTDSS(time,dayOfWeek,school,subject);
        return  gradeWClasses;
    }


}
