package pl.polsl.aei.ior.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.aei.ior.model.Major;
import pl.polsl.aei.ior.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
    List<Student>findStudentsByGenderAndMajor(@RequestParam String gender,@RequestParam Major majorId);
    List<Student>findStudentsByMajorInstituteInstituteNameLikeIgnoreCase(@RequestParam String instituteName);


    @Query("select s from Student s where s.major.majorId = ?1")
    List<Student>findByQuery(int majorId);


}
