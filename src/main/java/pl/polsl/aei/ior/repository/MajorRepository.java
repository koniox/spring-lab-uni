package pl.polsl.aei.ior.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.aei.ior.model.Major;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major,Integer> {
    Page<Major> findAll(Pageable pageable);
    List<Major> findMajorsByMajorNameContainingOrInstitute_InstituteName(@RequestParam String majorName, @RequestParam String instituteName);
    List<Major> findMajorsByInstitute_InstituteNameIsLikeIgnoreCase(@RequestParam String instituteName);

    @Query("select m from Major m where m.institute.instituteId = ?1")
    List<Major>findByQuery(int instituteId);
}
