package ir.ansar.education.service;

import ir.ansar.education.model.dto.SignUp;
import ir.ansar.education.model.dto.Person;
import ir.ansar.education.model.dto.Student;
import ir.ansar.education.model.dto.Teacher;
import ir.ansar.education.model.repository.StudentRep;
import ir.ansar.education.model.repository.TeacherRep;
import ir.ansar.education.model.type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginCheckService {

    @Autowired
    private StudentRep studentRep;

    @Autowired
    private TeacherRep teacherRep;

    public void signUp(Person person,boolean type){
        if (type){
            studentRep.registerStudent((Student) person);
        }else {
            teacherRep.registerTeacher((Teacher) person);
        }
    }


    public void signUpVerificated(){

    }

    public Person signup(SignUp signUp){
        return signUp.getType().equals(type.student)?studentRep.loginCheck(signUp):teacherRep.loginCheck(signUp);
    }

}
