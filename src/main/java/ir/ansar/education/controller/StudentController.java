package ir.ansar.education.controller;

import ir.ansar.education.model.dto.Student;
import ir.ansar.education.model.repository.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentRep studentService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void registerPerson(@RequestBody Student student)throws Exception
    {
        try {
            studentService.registerStudent(student);
            System.out.println("done");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @RequestMapping (value = "/list")
    public String getStudentList(HttpServletRequest request)throws Exception
    {
        request.setAttribute("list",studentService.getStudentList());
        return "getStudentList";
    }
    @RequestMapping (value = "/deleteStudent/{id}")
    public String deletePerson(@PathVariable String id)throws Exception
    {
        studentService.deleteStudent(id);
        return "redirect:/getStudentList";
    }
    @RequestMapping (value = "/updateStudent")
    public String updatePerson(@RequestBody Student student)throws Exception
    {
        studentService.updateStudent(student);
        return "redirect:/getStudentList";
    }

    @RequestMapping (value = "/tea/{tid}")
    public Student getStuId(@PathVariable("tid")String id){
        return studentService.getStudentWithId(id);
    }
}
