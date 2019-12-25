package ir.ansar.education.controller;

import ir.ansar.education.model.dto.SignUp;
import ir.ansar.education.model.dto.Person;
import ir.ansar.education.model.dto.Student;
import ir.ansar.education.model.dto.Teacher;
import ir.ansar.education.model.repository.StudentRep;
import ir.ansar.education.model.repository.TeacherRep;
import ir.ansar.education.service.LoginCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/enterance")
public class loginController {

    @Autowired
    private LoginCheckService loginService;

    @Autowired
    private StudentRep studentRep;

    @Autowired
    private TeacherRep teacherRep;


    @PostMapping("/signup")
    public void signUp(Person person,boolean type) {
        if (type){
            studentRep.registerStudent((Student) person);
        }else {
            teacherRep.registerTeacher((Teacher) person);
        }
    }


    //todo must be create
    @GetMapping("/login")
    public Person login(@RequestBody SignUp signUp) {
        Person person = loginService.signup(signUp);
    }

    @PostMapping("/signupVUP")
    public void signUpVUP(Person person,boolean type) {
        if (type){
            studentRep.registerStudent((Student) person);
        }else {
            teacherRep.registerTeacher((Teacher) person);
        }
    }
}
