package ir.ansar.education.controller;

import ir.ansar.education.model.dto.Lecture;
import ir.ansar.education.model.repository.LectureRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/lecture")
public class LectureController {

    @Autowired
    private LectureRep lectureService;

    @RequestMapping("/register")
    public void registerLecture(@RequestBody Lecture lecture){
        lectureService.registerLecture(lecture);
    }

    @RequestMapping("/list")
    public List<Lecture> getLectureList(){
        List<Lecture> lectures = lectureService.getLectureList();
        System.out.println("lecture 1 is: id: "+lectures.get(0).getLid()
                +" name: "+lectures.get(0).getName()
                +" unit: "+ lectures.get(0).getUnit()
                +" since: "+ lectures.get(0).getSince()
                +" until: "+ lectures.get(0).getUntil());
        return lectures;
    }

    @RequestMapping("/delete/{lid}")
    public void deleteLecture(@PathVariable("lid")String lid){
        lectureService.deleteLecture(lid);
    }

    @RequestMapping("/update")
    public void updateLecture(@RequestBody Lecture lecture){
        lectureService.updateLecture(lecture);
    }

    @RequestMapping("/lec/{lid}")
    public Lecture getLecId(@PathVariable("lid")String id){
        return lectureService.getLectureWithId(id);
    }
}
