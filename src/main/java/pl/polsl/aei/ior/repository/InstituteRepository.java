package pl.polsl.aei.ior.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;
import pl.polsl.aei.ior.model.Institute;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute,Integer> {
    Page<Institute> findAll(Pageable pageable);
    List<Institute> findInstituteByInstituteIdOrInstituteName(@RequestParam int instituteId,@RequestParam String instituteName);
    Institute findInstituteByInstituteNameLikeIgnoreCase(@RequestParam String instituteName);

    @Query("select i from Institute i where i.instituteName like concat(?1,'%')")
    List<Institute> findByQuery(String instituteName);
}
