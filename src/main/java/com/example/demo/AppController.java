package com.example.demo;

import com.example.demo.course_registration.CourseRegistration;
import com.example.demo.course_registration.CourseRegistrationRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    StudentService studentService;
    @Autowired
    CourseRegistrationRepository courseRegistrationRepository;

    @GetMapping(path = "students")
    public List<Student> showAll() {
        List<Student> rs = studentService.getAllStudents();

        return rs;
    }

    @GetMapping(path = "course-registration")
    public List<CourseRegistration> getCourseRegistration() {
        List<CourseRegistration> l = courseRegistrationRepository.findAll();
        return l;
    }

    @PutMapping("student/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Long id) {
        Student updatedStudent = studentService.update(student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedStudent);
        }
    }

    // test
    // curl -XPUT -H "Content-type: application/json" -d '{"id":1,"lastName":"Maria","firstName":"John","email":"maria@gmail.com","age":22,"address":{"id":2,"addressString":"293 Dien Bien Phuuu"},"registrations":[],"items":[{"id":5,"name":"Pen"}]}' 'http://localhost:8080/student/1'

}
