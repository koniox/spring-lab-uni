package pl.polsl.aei.ior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.aei.ior.model.Major;
import pl.polsl.aei.ior.repository.MajorRepository;

import java.util.List;

@RestController
@RequestMapping("/majors")
public class MajorController {
    @Autowired
    MajorRepository majorRepository;

    @GetMapping("/delete")
    void deleteRow(@RequestParam int id){
        majorRepository.deleteById(id);
        System.out.println("Removing: " + id);
    }

    @GetMapping
    Page<Major> getMajors(Pageable pageable){
        return majorRepository.findAll(pageable);
    }

    @GetMapping("/twoAttributesSearch")
    List<Major> getMajorsByMajorNameContainingOrInstitute_InstituteName(@RequestParam String majorName,@RequestParam String instituteName){
        return majorRepository.findMajorsByMajorNameContainingOrInstitute_InstituteName(majorName,instituteName);
    }

    @GetMapping("/LikeAndIgnoreCase")
    List<Major> findMajorsByInstitute_InstituteNameIsLikeIgnoreCase(@RequestParam String instituteName){
        return majorRepository.findMajorsByInstitute_InstituteNameIsLikeIgnoreCase(instituteName);
    }

    @GetMapping("/myQuery")
    List<Major> getMajorsByInstituteId(@RequestParam int instituteId){
        return majorRepository.findByQuery(instituteId);
    }
}
