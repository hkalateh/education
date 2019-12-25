package ir.ansar.education.controller;

import ir.ansar.education.model.dto.Teacher;
import ir.ansar.education.model.repository.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherRep teacherService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void registerTeacher(@RequestBody Teacher teacher){
        try{
            teacherService.registerTeacher(teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/list")
    public List<Teacher> getTeacherList(){
        List<Teacher> teacherList = teacherService.getTeacherList();
        System.out.println("teacherList.get(0).getName() = " + teacherList.get(0).getName());
        return teacherService.getTeacherList();
    }

   @RequestMapping(value = "/delete/{tid}")
    public void deleteTeacher(@PathVariable("tid") String tid){
        teacherService.deleteTeacher(tid);
    }

    @RequestMapping(value = "/update")
    public void updateTeacher(@RequestBody Teacher teacher){
        teacherService.updateTeacher(teacher);
    }

    @GetMapping(value = "/tea/{id}" )
    public Teacher gettingTeacher(@PathVariable("id") String id){
        return teacherService.getTeacherWithId(id);
    }

}
