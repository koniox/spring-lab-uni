package pl.polsl.aei.ior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.aei.ior.model.Institute;
import pl.polsl.aei.ior.repository.InstituteRepository;

import java.util.List;

@RestController
@RequestMapping("/institutes")
public class InstituteController {
    @Autowired
    InstituteRepository instituteRepository;

    @GetMapping("/delete")
    void deleteRow(@RequestParam int id){
        instituteRepository.deleteById(id);
        System.out.println("Removing: " + id);
    }

    @GetMapping
    Page<Institute> getInstitutes(Pageable pageable){
        return instituteRepository.findAll(pageable);
    }

    @GetMapping("/twoAttributesSearch")
    List<Institute> getInstituteByInstituteIdOrInstituteName(@RequestParam int id, @RequestParam String instituteName){
        return instituteRepository.findInstituteByInstituteIdOrInstituteName(id,instituteName);
    }

    @GetMapping("/LikeAndIgnoreCase")
    Institute getInstituteByInstituteNameLikeIgnoreCase(@RequestParam String instituteName){
        return instituteRepository.findInstituteByInstituteNameLikeIgnoreCase(instituteName);
    }

    @GetMapping("/myQuery")
    List<Institute> getInstituteByMatching(@RequestParam String instituteName){
        return instituteRepository.findByQuery(instituteName);
    }
}
