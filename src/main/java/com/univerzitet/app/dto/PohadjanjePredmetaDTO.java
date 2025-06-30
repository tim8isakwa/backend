package com.univerzitet.app.dto;

public class PohadjanjePredmetaDTO {

    private Long id;
    
    private RealizacijaPredmetaDTO realizacijaPredmeta;
    
    private StudentDTO student;

    public PohadjanjePredmetaDTO() {
        super();
    }

    public PohadjanjePredmetaDTO(Long id, RealizacijaPredmetaDTO realizacijaPredmeta, StudentDTO student) {
        super();
        this.id = id;
        this.realizacijaPredmeta = realizacijaPredmeta;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
        return realizacijaPredmeta;
    }

    public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
        this.realizacijaPredmeta = realizacijaPredmeta;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
