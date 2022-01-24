package pl.polsl.aei.ior.model;

import javax.persistence.*;

@Entity
@Table(name = "institutes")
public class Institute {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "institute_id")
    private int instituteId;

    @Column(name = "INSTITUTE_NAME")
    private String instituteName;

    public Institute() {
    }

    public int getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(int instituteId) {
        this.instituteId = instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
}
