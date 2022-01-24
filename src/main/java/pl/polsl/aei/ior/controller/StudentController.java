package pl.polsl.aei.ior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.aei.ior.model.Major;
import pl.polsl.aei.ior.model.Student;
import pl.polsl.aei.ior.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/delete")
    void deleteRow(@RequestParam int id){
        studentRepository.deleteById(id);
        System.out.println("Removing:  " + id);
    }

    @GetMapping
    Page<Student> getStudents(Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    @GetMapping("/twoAttributesSearch")
    List<Student> getStudentsByGenderAndMajor(@RequestParam String gender,@RequestParam Major majorId){
        return studentRepository.findStudentsByGenderAndMajor(gender,majorId);
    }

    @GetMapping("/LikeAndIgnoreCase")
    List<Student> getStudentsByMajorsInstituteName(@RequestParam String instituteName){
        return studentRepository.findStudentsByMajorInstituteInstituteNameLikeIgnoreCase(instituteName);
    }

    @GetMapping("/myQuery")
    List<Student> getStudentsByMajorId(@RequestParam int majorId){
        return studentRepository.findByQuery(majorId);
    }





}
